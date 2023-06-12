package br.com.atarashi.controlemanutencaoequipamentos.integration.controller.ordemServico;

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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class OrdemServicoFetchControllerTestIT {

    @Value("${server.context-path}")
    private String context;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private OrdemServicoRequest ordemServicoRequest = ObjectCreator.createOrdemServicoRequest();

    @Test
    public void ordemServicoFindAllTest() {
        HttpEntity<OrdemServicoRequest> httpEntityOrdemServico = new HttpEntity<>(ordemServicoRequest);

        ResponseEntity<AcompanhamentoResponse> responseOrdemServicoPOST = this.testRestTemplate.exchange(context + "/ordem-servicos",
                HttpMethod.POST, httpEntityOrdemServico, AcompanhamentoResponse.class);

        ResponseEntity<List> responseOrdemServicoGET = this.testRestTemplate.exchange(context + "/ordem-servicos",
                HttpMethod.GET, null, List.class);

        assertEquals(responseOrdemServicoPOST.getStatusCode(), HttpStatus.OK);
        assertEquals(responseOrdemServicoGET.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void ordemServicoFindPendentesTest() {
        HttpEntity<OrdemServicoRequest> httpEntityOrdemServico = new HttpEntity<>(ordemServicoRequest);

        ResponseEntity<AcompanhamentoResponse> responseOrdemServicoPOST = this.testRestTemplate.exchange(context + "/ordem-servicos",
                HttpMethod.POST, httpEntityOrdemServico, AcompanhamentoResponse.class);

        ResponseEntity<List> responseOrdemServicoGET = this.testRestTemplate.exchange(context + "/ordem-servicos/pendentes?responsavel=João",
                HttpMethod.GET, null, List.class);

        assertEquals(responseOrdemServicoPOST.getStatusCode(), HttpStatus.OK);
        assertEquals(responseOrdemServicoGET.getStatusCode(), HttpStatus.OK);
    }
}