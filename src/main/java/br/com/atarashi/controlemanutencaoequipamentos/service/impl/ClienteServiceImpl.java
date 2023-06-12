package br.com.atarashi.controlemanutencaoequipamentos.service.impl;

import br.com.atarashi.controlemanutencaoequipamentos.repository.ClienteRepository;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Cliente;
import br.com.atarashi.controlemanutencaoequipamentos.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Mono<Cliente> save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Mono<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }
}
