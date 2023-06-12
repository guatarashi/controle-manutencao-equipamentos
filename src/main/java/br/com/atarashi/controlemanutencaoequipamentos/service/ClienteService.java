package br.com.atarashi.controlemanutencaoequipamentos.service;

import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Cliente;
import reactor.core.publisher.Mono;

public interface ClienteService {

    Mono<Cliente> save(Cliente cliente);
    Mono<Cliente> findById(Long id);
}
