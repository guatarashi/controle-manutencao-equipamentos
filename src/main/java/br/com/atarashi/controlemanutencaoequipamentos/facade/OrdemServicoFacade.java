package br.com.atarashi.controlemanutencaoequipamentos.facade;

import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.OrdemServicoRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.RelatorioRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response.OrdemServicoResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrdemServicoFacade {

    Mono<OrdemServicoResponse> save(OrdemServicoRequest ordemServicoRequest);
    Mono<OrdemServicoResponse> findByOrdemServicoCompleta(Long id);
    Flux<OrdemServicoResponse> findByOrdensServicoCompleta();
    Flux<OrdemServicoResponse> findByOrdensServicoCompletaRelatorio(RelatorioRequest relatorioRequest);
    Flux<OrdemServicoResponse> findByOrdensServicoPendetesCompleta(String responsavel);
}
