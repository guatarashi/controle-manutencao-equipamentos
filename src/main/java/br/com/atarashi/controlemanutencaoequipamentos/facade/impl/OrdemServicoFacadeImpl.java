package br.com.atarashi.controlemanutencaoequipamentos.facade.impl;

import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.OrdemServicoRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.RelatorioRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response.OrdemServicoResponse;
import br.com.atarashi.controlemanutencaoequipamentos.facade.ClienteFacade;
import br.com.atarashi.controlemanutencaoequipamentos.facade.OrdemServicoFacade;
import br.com.atarashi.controlemanutencaoequipamentos.mapper.EquipamentoMapper;
import br.com.atarashi.controlemanutencaoequipamentos.mapper.OrdemServicoMapper;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.OrdemServico;
import br.com.atarashi.controlemanutencaoequipamentos.service.AcompanhamentoService;
import br.com.atarashi.controlemanutencaoequipamentos.service.EquipamentoService;
import br.com.atarashi.controlemanutencaoequipamentos.service.OrdemServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrdemServicoFacadeImpl implements OrdemServicoFacade {

    private final EquipamentoMapper equipamentoMapper;
    private final OrdemServicoMapper ordemServicoMapper;
    private final EquipamentoService equipamentoService;
    private final OrdemServicoService ordemServicoService;
    private final ClienteFacade clienteFacade;
    private final AcompanhamentoService acompanhamentoService;

    @Override
    public Mono<OrdemServicoResponse> save(OrdemServicoRequest ordemServicoRequest) {
        return equipamentoService.save(equipamentoMapper.equipamentoRequestToEquipamento(ordemServicoRequest.getEquipamento()))
                .doOnNext(equipamento -> ordemServicoRequest.setIdEquipamento(equipamento.getId()))
                .flatMap(equipamento -> clienteFacade.save(ordemServicoRequest.getCliente()))
                .doOnNext(cliente -> ordemServicoRequest.setIdCliente(cliente.getId()))
                .flatMap(cliente -> ordemServicoService.save(ordemServicoMapper.ordemServicoRequestToOrdemServico(ordemServicoRequest)))
                .map(ordemServicoMapper::ordemServicoToOrdemServicoResponse);
    }

    @Override
    public Mono<OrdemServicoResponse> findByOrdemServicoCompleta(Long idOrdemServico) {
        return ordemServicoService.findById(idOrdemServico)
                .flatMap(this::entidadesOrdemServico);
    }

    @Override
    public Flux<OrdemServicoResponse> findByOrdensServicoCompleta() {
        return ordemServicoService.findAll()
                .flatMap(this::entidadesOrdemServico);
    }

    @Override
    public Flux<OrdemServicoResponse> findByOrdensServicoPendetesCompleta(final String responsavel) {
        return findByOrdensServicoCompleta()
                .filter(ordemServicoResponse -> ordemServicoResponse.getDataTermino() == null && ordemServicoResponse.getResponsavel().equals(responsavel));
    }

    public Flux<OrdemServicoResponse> findByOrdensServicoCompletaRelatorio(RelatorioRequest relatorioRequest) {
        if (!relatorioRequest.getResponsavel().isEmpty() && !relatorioRequest.getCliente().isEmpty()) {
            return findByOrdensServicoCompleta()
                    .filter(ordemServicoResponse -> ordemServicoResponse.getResponsavel().equals(relatorioRequest.getResponsavel()) && ordemServicoResponse.getCliente().getNome().equals(relatorioRequest.getCliente()));
        }

        if (!relatorioRequest.getResponsavel().isEmpty()) {
            return findByOrdensServicoCompleta()
                    .filter(ordemServicoResponse -> ordemServicoResponse.getResponsavel().equals(relatorioRequest.getResponsavel()));
        }

        if (!relatorioRequest.getCliente().isEmpty()) {
            return findByOrdensServicoCompleta()
                    .filter(ordemServicoResponse -> ordemServicoResponse.getCliente().getNome().equals(relatorioRequest.getCliente()));
        }

        return findByOrdensServicoCompleta();
    }

    private Mono<OrdemServicoResponse> entidadesOrdemServico(OrdemServico ordemServico) {
        return clienteFacade.findById(ordemServico.getIdCliente())
                .doOnNext(ordemServico::setCliente)
                .flatMap(cliente -> equipamentoService.findById(ordemServico.getIdEquipamento())
                        .doOnNext(ordemServico::setEquipamento))
                .flatMap(equipamento -> acompanhamentoService.findAcompanhamentosByIdOrdemServico(ordemServico.getId())
                        .map(acompanhamento -> ordemServico.getAcompanhamento().add(acompanhamento))
                        .then(Mono.just(ordemServico)))
                .map(ordemServicoMapper::ordemServicoToOrdemServicoResponse);
    }
}
