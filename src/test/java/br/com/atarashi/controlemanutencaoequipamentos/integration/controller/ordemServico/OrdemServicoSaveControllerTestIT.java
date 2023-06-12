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

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class OrdemServicoSaveControllerTestIT {

    @Value("${server.context-path}")
    private String context;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private OrdemServicoRequest ordemServicoRequest = ObjectCreator.createOrdemServicoRequest();

    @Test
    public void saveOrdemServicoSucessTest() {
        HttpEntity<OrdemServicoRequest> httpEntityOrdemServico = new HttpEntity<>(ordemServicoRequest);

        ResponseEntity<AcompanhamentoResponse> responseOrdemServico = this.testRestTemplate.exchange(context + "/ordem-servicos",
                HttpMethod.POST, httpEntityOrdemServico, AcompanhamentoResponse.class);

        assertEquals(responseOrdemServico.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void saveOrdemServicoDescricaoBadRequestTest() {
        OrdemServicoRequest ordemServicoRequest = ObjectCreator.createOrdemServicoRequest();
        ordemServicoRequest.setDescricao("");
        HttpEntity<OrdemServicoRequest> httpEntityOrdemServico = new HttpEntity<>(ordemServicoRequest);

        ResponseEntity<AcompanhamentoResponse> responseOrdemServico = this.testRestTemplate.exchange(context + "/ordem-servicos",
                HttpMethod.POST, httpEntityOrdemServico, AcompanhamentoResponse.class);

        assertEquals(responseOrdemServico.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void saveOrdemServicoClienteBadRequestTest() {
        OrdemServicoRequest ordemServicoRequest = ObjectCreator.createOrdemServicoRequest();
        ordemServicoRequest.setCliente(null);
        HttpEntity<OrdemServicoRequest> httpEntityOrdemServico = new HttpEntity<>(ordemServicoRequest);

        ResponseEntity<AcompanhamentoResponse> responseOrdemServico = this.testRestTemplate.exchange(context + "/ordem-servicos",
                HttpMethod.POST, httpEntityOrdemServico, AcompanhamentoResponse.class);

        assertEquals(responseOrdemServico.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void saveOrdemServicoEquipamentoBadRequestTest() {
        OrdemServicoRequest ordemServicoRequest = ObjectCreator.createOrdemServicoRequest();
        ordemServicoRequest.setEquipamento(null);
        HttpEntity<OrdemServicoRequest> httpEntityOrdemServico = new HttpEntity<>(ordemServicoRequest);

        ResponseEntity<AcompanhamentoResponse> responseOrdemServico = this.testRestTemplate.exchange(context + "/ordem-servicos",
                HttpMethod.POST, httpEntityOrdemServico, AcompanhamentoResponse.class);

        assertEquals(responseOrdemServico.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

}