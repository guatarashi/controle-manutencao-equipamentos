package br.com.atarashi.controlemanutencaoequipamentos.service.impl;

import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response.OrdemServicoPendenteResponse;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response.OrdemServicoResponse;
import br.com.atarashi.controlemanutencaoequipamentos.mapper.OrdemServicoMapper;
import br.com.atarashi.controlemanutencaoequipamentos.repository.OrdemServicoRepository;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.OrdemServico;
import br.com.atarashi.controlemanutencaoequipamentos.service.OrdemServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrdemServicoServiceImpl implements OrdemServicoService {

    private final OrdemServicoMapper ordemServicoMapper;
    private final OrdemServicoRepository ordemServicoRepository;

    @Override
    public Mono<OrdemServico> save(final OrdemServico ordemServico) {
        return ordemServicoRepository.save(ordemServico);
    }

    @Override
    public Flux<OrdemServicoPendenteResponse> findPendentes(final String responsavel) {
        return ordemServicoRepository.findAll()
                .filter(ordemServico -> ordemServico.getDataTermino() == null && ordemServico.getResponsavel().equals(responsavel))
                .map(ordemServicoMapper::ordemServicoToOrdemOrdemServicoPendenteResponse);
    }

    @Override
    public Flux<OrdemServicoResponse> findOrdensServico() {
        return findAll()
                .map(ordemServicoMapper::ordemServicoToOrdemServicoResponse);
    }

    @Override
    public Flux<OrdemServico> findAll() {
        return ordemServicoRepository.findAll();
    }

    @Override
    public Mono<OrdemServicoResponse> findId(Long id) {
        return findById(id)
                .map(ordemServicoMapper::ordemServicoToOrdemServicoResponse);
    }

    @Override
    public Mono<OrdemServico> findById(Long id) {
        return ordemServicoRepository.findById(id);
    }
}
