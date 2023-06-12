package br.com.atarashi.controlemanutencaoequipamentos.facade.impl;

import br.com.atarashi.controlemanutencaoequipamentos.controller.acompanhamentoOrdemServico.request.AcompanhamentoRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.acompanhamentoOrdemServico.response.AcompanhamentoResponse;
import br.com.atarashi.controlemanutencaoequipamentos.facade.AcompanhamentoOrdemServicoFacade;
import br.com.atarashi.controlemanutencaoequipamentos.mapper.AcompanhamentoMapper;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.OrdemServico;
import br.com.atarashi.controlemanutencaoequipamentos.service.AcompanhamentoService;
import br.com.atarashi.controlemanutencaoequipamentos.service.OrdemServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AcompanhamentoOrdemServicoFacadeImpl implements AcompanhamentoOrdemServicoFacade {

    private final AcompanhamentoMapper acompanhamentoMapper;
    private final OrdemServicoService ordemServicoService;
    private final AcompanhamentoService acompanhamentoService;

    @Override
    public Mono<AcompanhamentoResponse> save(final Long id, final AcompanhamentoRequest acompanhamentoRequest) {
        return ordemServicoService.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem de serviço não encontrado")))
                .doOnNext(ordemServico -> preenchendoDataInicioOrdemServico(ordemServico, acompanhamentoRequest))
                .flatMap(ordemServico -> preenchendoDataTerminoOrdemServico(ordemServico, acompanhamentoRequest))
                .flatMap(ordemServicoService::save)
                .doOnNext(ordemServico -> acompanhamentoRequest.setIdOrdemServico(ordemServico.getId()))
                .flatMap(ordemServico -> acompanhamentoService.save(acompanhamentoMapper.acompanhamentoRequestToAcompanhamento(acompanhamentoRequest)))
                .map(acompanhamentoMapper::acompanhamentoToAcompanhamentoResponse);
    }

    private void preenchendoDataInicioOrdemServico(OrdemServico ordemServico, final AcompanhamentoRequest acompanhamentoRequest) {
        if (ordemServico.getDataInicio() == null && !acompanhamentoRequest.isTermino()) {
            ordemServico.setDataInicio(LocalDate.now());
        }
    }

    private Mono<OrdemServico> preenchendoDataTerminoOrdemServico(final OrdemServico ordemServico, final AcompanhamentoRequest acompanhamentoRequest) {
        if (ordemServico.getDataTermino() == null && acompanhamentoRequest.isTermino() && ordemServico.getDataInicio() != null) {
            ordemServico.setDataTermino(LocalDate.now());
        }

        if (ordemServico.getDataInicio() == null && acompanhamentoRequest.isTermino()) {
            return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ordem de serviço não pode ser finalizada porque ainda não foi iniciada"));
        }

        return Mono.just(ordemServico);
    }
}
