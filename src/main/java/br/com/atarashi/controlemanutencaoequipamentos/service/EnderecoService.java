package br.com.atarashi.controlemanutencaoequipamentos.service;

import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Endereco;
import reactor.core.publisher.Mono;

public interface EnderecoService {

    Mono<Endereco> save(Endereco endereco);
    Mono<Endereco> findById(Long id);
}
