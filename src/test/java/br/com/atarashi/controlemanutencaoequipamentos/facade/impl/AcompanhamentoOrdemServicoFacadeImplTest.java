package br.com.atarashi.controlemanutencaoequipamentos.facade.impl;

import br.com.atarashi.controlemanutencaoequipamentos.controller.acompanhamentoOrdemServico.request.AcompanhamentoRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.acompanhamentoOrdemServico.response.AcompanhamentoResponse;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response.OrdemServicoResponse;
import br.com.atarashi.controlemanutencaoequipamentos.mapper.AcompanhamentoMapper;
import br.com.atarashi.controlemanutencaoequipamentos.mapper.OrdemServicoMapper;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Acompanhamento;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.OrdemServico;
import br.com.atarashi.controlemanutencaoequipamentos.service.AcompanhamentoService;
import br.com.atarashi.controlemanutencaoequipamentos.service.OrdemServicoService;
import br.com.atarashi.controlemanutencaoequipamentos.util.ObjectCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class AcompanhamentoOrdemServicoFacadeImplTest {

    @InjectMocks
    private AcompanhamentoOrdemServicoFacadeImpl acompanhamentoOrdemServicoFacadeImpl;

    @Mock
    private OrdemServicoService ordemServicoService;
    @Mock
    private AcompanhamentoService acompanhamentoService;
    @Mock
    private AcompanhamentoMapper acompanhamentoMapper;
    @Mock
    private OrdemServicoMapper ordemServicoMapper;

    private AcompanhamentoRequest acompanhamentoRequest;
    private AcompanhamentoResponse acompanhamentoResponse;

    @BeforeEach
    public void setUp() {
        acompanhamentoRequest = ObjectCreator.createAcompanhamentoRequest();
        acompanhamentoResponse = ObjectCreator.createAcompanhamentoResponse();
        Acompanhamento acompanhamento = ObjectCreator.createAcompanhamento();
        OrdemServicoResponse ordemServicoResponse = ObjectCreator.createOrdemServicoResponse();
        OrdemServico ordemServico = ObjectCreator.createOrdemServico();

        when(acompanhamentoMapper.acompanhamentoRequestToAcompanhamento(acompanhamentoRequest))
                .thenReturn(acompanhamento);

        when(acompanhamentoMapper.acompanhamentoToAcompanhamentoResponse(acompanhamento))
                .thenReturn(acompanhamentoResponse);

        when(ordemServicoMapper.ordemServicoResponseToOrdemServico(ordemServicoResponse))
                .thenReturn(ordemServico);

        when(ordemServicoService.save(ordemServico))
                .thenReturn(Mono.just(ordemServico));

        when(ordemServicoService.findById(1L))
                .thenReturn(Mono.just(ordemServico));

        when(ordemServicoService.save(ordemServico))
                .thenReturn(Mono.just(ordemServico));

        when(acompanhamentoService.save(acompanhamento))
                .thenReturn(Mono.just(acompanhamento));
    }

    @Test
    void acompanhamentoOrdemServicoNotFoundTest() {
        when(ordemServicoService.findById(1L))
                .thenReturn(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem de serviço não encontrado")));

        StepVerifier.create(acompanhamentoOrdemServicoFacadeImpl.save(1L, acompanhamentoRequest))
                .expectError(HttpClientErrorException.NotFound.class);
    }

    @Test
    void acompanhamentoOrdemServicoOkTest() {
        StepVerifier.create(acompanhamentoOrdemServicoFacadeImpl.save(1L, acompanhamentoRequest))
                .expectSubscription()
                .expectNext(acompanhamentoResponse)
                .verifyComplete();
    }

    @Test
    void acompanhamentoOrdemServicoBadRequestTest() {
        AcompanhamentoRequest acompanhamentoRequest = ObjectCreator.createAcompanhamentoRequestIsTermino();
        StepVerifier.create(acompanhamentoOrdemServicoFacadeImpl.save(1L, acompanhamentoRequest))
                .expectError(HttpClientErrorException.BadRequest.class);
    }

}