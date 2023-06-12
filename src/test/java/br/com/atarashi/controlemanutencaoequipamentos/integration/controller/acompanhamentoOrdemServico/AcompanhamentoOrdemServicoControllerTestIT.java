package br.com.atarashi.controlemanutencaoequipamentos.integration.controller.acompanhamentoOrdemServico;

import br.com.atarashi.controlemanutencaoequipamentos.controller.acompanhamentoOrdemServico.request.AcompanhamentoRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.acompanhamentoOrdemServico.response.AcompanhamentoResponse;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.OrdemServicoRequest;
import br.com.atarashi.controlemanutencaoequipamentos.util.ObjectCreator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class AcompanhamentoOrdemServicoControllerTestIT {

    @Value("${server.context-path}")
    private String context;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private OrdemServicoRequest ordemServicoRequest = ObjectCreator.createOrdemServicoRequest();

    @Test
    public void acompanhamentoOrdemServicoNotFoundTest() {

        AcompanhamentoRequest acompanhamentoRequest = AcompanhamentoRequest.builder()
                .descricao("Inicio do atendimento")
                .termino(false)
                .build();

        HttpEntity<AcompanhamentoRequest> httpEntity = new HttpEntity<>(acompanhamentoRequest);

        ResponseEntity<AcompanhamentoResponse> response = this.testRestTemplate.exchange(context + "/ordem-servicos/3/acompanhamento",
                HttpMethod.POST, httpEntity, AcompanhamentoResponse.class);

        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    public void acompanhamentoOrdemServicoOkTest() {

        AcompanhamentoRequest acompanhamentoRequest = AcompanhamentoRequest.builder()
                .descricao("Inicio do atendimento")
                .termino(false)
                .build();

        HttpEntity<OrdemServicoRequest> httpEntityOrdemServico = new HttpEntity<>(ordemServicoRequest);

        ResponseEntity<AcompanhamentoResponse> responseOrdemServico = this.testRestTemplate.exchange(context + "/ordem-servicos",
                HttpMethod.POST, httpEntityOrdemServico, AcompanhamentoResponse.class);

        HttpEntity<AcompanhamentoRequest> httpEntity = new HttpEntity<>(acompanhamentoRequest);

        ResponseEntity<AcompanhamentoResponse> responseAcompanhamento = this.testRestTemplate.exchange(context + "/ordem-servicos/1/acompanhamento",
                HttpMethod.POST, httpEntity, AcompanhamentoResponse.class);

        assertEquals(responseOrdemServico.getStatusCode(), HttpStatus.OK);
        assertEquals(responseAcompanhamento.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void acompanhamentoOrdemServicoBadRequestTest() {

        AcompanhamentoRequest acompanhamentoRequest = AcompanhamentoRequest.builder()
                .descricao("Finalizando do atendimento")
                .termino(true)
                .build();

        HttpEntity<OrdemServicoRequest> httpEntityOrdemServico = new HttpEntity<>(ordemServicoRequest);

        ResponseEntity<AcompanhamentoResponse> responseOrdemServico = this.testRestTemplate.exchange(context + "/ordem-servicos",
                HttpMethod.POST, httpEntityOrdemServico, AcompanhamentoResponse.class);

        HttpEntity<AcompanhamentoRequest> httpEntity = new HttpEntity<>(acompanhamentoRequest);

        ResponseEntity<AcompanhamentoResponse> response = this.testRestTemplate.exchange(context + "/ordem-servicos/1/acompanhamento",
                HttpMethod.POST, httpEntity, AcompanhamentoResponse.class);

        assertEquals(responseOrdemServico.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
    }
}