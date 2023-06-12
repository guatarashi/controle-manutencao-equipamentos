package br.com.atarashi.controlemanutencaoequipamentos.facade.impl;

import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.OrdemServicoRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response.OrdemServicoResponse;
import br.com.atarashi.controlemanutencaoequipamentos.facade.ClienteFacade;
import br.com.atarashi.controlemanutencaoequipamentos.mapper.EquipamentoMapper;
import br.com.atarashi.controlemanutencaoequipamentos.mapper.OrdemServicoMapper;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Cliente;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Equipamento;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.OrdemServico;
import br.com.atarashi.controlemanutencaoequipamentos.service.EquipamentoService;
import br.com.atarashi.controlemanutencaoequipamentos.service.OrdemServicoService;
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
class OrdemServicoFacadeImplTest {

    @InjectMocks
    private OrdemServicoFacadeImpl ordemServicoFacade;
    @Mock
    private EquipamentoMapper equipamentoMapper;
    @Mock
    private OrdemServicoMapper ordemServicoMapper;
    @Mock
    private EquipamentoService equipamentoService;
    @Mock
    private OrdemServicoService ordemServicoService;
    @Mock
    private ClienteFacade clienteFacade;

    private OrdemServicoRequest ordemServicoRequest;
    private OrdemServicoResponse ordemServicoResponse;
    private OrdemServico ordemServico;

    @BeforeEach
    public void setUp() {
        ordemServicoRequest = ObjectCreator.createOrdemServicoRequest();
        ordemServicoResponse = ObjectCreator.createOrdemServicoResponse();
        ordemServico = ObjectCreator.createOrdemServico();
        Equipamento equipamento = ObjectCreator.createEquipamento();
        Cliente cliente = ObjectCreator.createCliente();

        when(equipamentoMapper.equipamentoRequestToEquipamento(ordemServicoRequest.getEquipamento()))
                .thenReturn(equipamento);

        when(equipamentoService.save(equipamento))
                .thenReturn(Mono.just(equipamento));

        when(clienteFacade.save(ordemServicoRequest.getCliente()))
                .thenReturn(Mono.just(cliente));

        when(ordemServicoMapper.ordemServicoRequestToOrdemServico(ordemServicoRequest))
                .thenReturn(ordemServico);

        when(ordemServicoService.save(ordemServico))
                .thenReturn(Mono.just(ordemServico));

        when(ordemServicoMapper.ordemServicoToOrdemServicoResponse(ordemServico))
                .thenReturn(ordemServicoResponse);
    }

    @Test
    void ordemServicoOkTest() {
        StepVerifier.create(ordemServicoFacade.save(ordemServicoRequest))
                .expectSubscription()
                .expectNext(ordemServicoResponse)
                .verifyComplete();
    }

}