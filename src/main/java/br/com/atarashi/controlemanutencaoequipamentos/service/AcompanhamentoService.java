package br.com.atarashi.controlemanutencaoequipamentos.service;

import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Acompanhamento;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AcompanhamentoService {

    Flux<Acompanhamento> saveAll(Flux<Acompanhamento> acompanhamento);
    Mono<Acompanhamento> save(Acompanhamento acompanhamento);
    Flux<Acompanhamento> findAcompanhamentosByIdOrdemServico(Long id);
}
