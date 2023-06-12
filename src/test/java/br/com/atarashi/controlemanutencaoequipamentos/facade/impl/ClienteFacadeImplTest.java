package br.com.atarashi.controlemanutencaoequipamentos.facade.impl;

import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.cliente.ClienteRequest;
import br.com.atarashi.controlemanutencaoequipamentos.mapper.ClienteMapper;
import br.com.atarashi.controlemanutencaoequipamentos.mapper.EnderecoMapper;
import br.com.atarashi.controlemanutencaoequipamentos.repository.EnderecoRepository;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Cliente;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Endereco;
import br.com.atarashi.controlemanutencaoequipamentos.service.ClienteService;
import br.com.atarashi.controlemanutencaoequipamentos.service.EnderecoService;
import br.com.atarashi.controlemanutencaoequipamentos.util.ObjectCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ClienteFacadeImplTest {

    @InjectMocks
    private ClienteFacadeImpl clienteFacade;
    @Mock
    private ClienteService clienteService;
    @Mock
    private EnderecoService enderecoService;
    @Mock
    private EnderecoRepository enderecoRepository;
    @Mock
    private ClienteMapper clienteMapper;
    @Mock
    private EnderecoMapper enderecoMapper;

    private ClienteRequest clienteRequest;
    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        clienteRequest = ObjectCreator.createClienteRequest();
        cliente = ObjectCreator.createCliente();
        Endereco endereco = ObjectCreator.createEndereco();

        when(enderecoMapper.enderecoRequestToEndereco(clienteRequest.getEndereco()))
                .thenReturn(endereco);

        when(enderecoService.save(endereco))
                .thenReturn(Mono.just(endereco));

        when(enderecoRepository.save(endereco))
                .thenReturn(Mono.just(endereco));

        when(clienteMapper.clienteRequestToCliente(clienteRequest))
                .thenReturn(cliente);

        when(clienteService.save(cliente))
                .thenReturn(Mono.just(cliente));
    }

    @Test
    void acompanhamentoOrdemServicoOkTest() {
        StepVerifier.create(clienteFacade.save(clienteRequest))
                .expectSubscription()
                .expectNext(cliente)
                .verifyComplete();
    }
}