package br.com.atarashi.controlemanutencaoequipamentos.service;

import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response.OrdemServicoPendenteResponse;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response.OrdemServicoResponse;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.OrdemServico;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrdemServicoService {

    Mono<OrdemServico> save(OrdemServico ordemServico);
    Flux<OrdemServicoPendenteResponse> findPendentes(String responsavel);
    Flux<OrdemServicoResponse> findOrdensServico();
    Flux<OrdemServico> findAll();
    Mono<OrdemServicoResponse> findId(Long id);
    Mono<OrdemServico> findById(Long id);
}
