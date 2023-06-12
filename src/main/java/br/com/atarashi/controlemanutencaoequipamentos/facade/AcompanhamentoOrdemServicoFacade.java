package br.com.atarashi.controlemanutencaoequipamentos.facade;

import br.com.atarashi.controlemanutencaoequipamentos.controller.acompanhamentoOrdemServico.request.AcompanhamentoRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.acompanhamentoOrdemServico.response.AcompanhamentoResponse;
import reactor.core.publisher.Mono;

public interface AcompanhamentoOrdemServicoFacade {

    Mono<AcompanhamentoResponse> save(Long id, AcompanhamentoRequest acompanhamentoRequest);
}
