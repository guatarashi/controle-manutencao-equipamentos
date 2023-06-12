package br.com.atarashi.controlemanutencaoequipamentos.facade;

import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.cliente.ClienteRequest;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Cliente;
import reactor.core.publisher.Mono;

public interface ClienteFacade {

    Mono<Cliente> save(ClienteRequest clienteRequest);
    Mono<Cliente> findById(Long id);
}
