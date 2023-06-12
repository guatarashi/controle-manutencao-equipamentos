package br.com.atarashi.controlemanutencaoequipamentos.facade.impl;

import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.cliente.ClienteRequest;
import br.com.atarashi.controlemanutencaoequipamentos.facade.ClienteFacade;
import br.com.atarashi.controlemanutencaoequipamentos.mapper.ClienteMapper;
import br.com.atarashi.controlemanutencaoequipamentos.mapper.EnderecoMapper;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Cliente;
import br.com.atarashi.controlemanutencaoequipamentos.service.ClienteService;
import br.com.atarashi.controlemanutencaoequipamentos.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClienteFacadeImpl implements ClienteFacade {

    private final ClienteMapper clienteMapper;
    private final EnderecoMapper enderecoMapper;
    private final ClienteService clienteService;
    private final EnderecoService enderecoService;

    @Override
    public Mono<Cliente> save(ClienteRequest clienteRequest) {
        return enderecoService.save(enderecoMapper.enderecoRequestToEndereco(clienteRequest.getEndereco()))
                .doOnNext(endereco -> clienteRequest.setIdendereco(endereco.getId()))
                .flatMap(endereco -> clienteService.save(clienteMapper.clienteRequestToCliente(clienteRequest)));
    }

    @Override
    public Mono<Cliente> findById(Long id) {
        return clienteService.findById(id)
                .flatMap(cliente -> enderecoService.findById(cliente.getIdendereco())
                        .doOnNext(cliente::setEndereco)
                        .thenReturn(cliente));
    }
}