package br.com.atarashi.controlemanutencaoequipamentos.controller.acompanhamentoOrdemServico;

import br.com.atarashi.controlemanutencaoequipamentos.controller.acompanhamentoOrdemServico.request.AcompanhamentoRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.acompanhamentoOrdemServico.response.AcompanhamentoResponse;
import br.com.atarashi.controlemanutencaoequipamentos.facade.AcompanhamentoOrdemServicoFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("ordem-servicos")
@RequiredArgsConstructor
public class AcompanhamentoOrdemServicoController {

    private final AcompanhamentoOrdemServicoFacade acompanhamentoOrdemServicoFacade;

    @PostMapping("{idOrdemServico}/acompanhamento")
    @ResponseStatus(HttpStatus.OK)
    public Mono<AcompanhamentoResponse> save(@PathVariable final long idOrdemServico, @RequestBody final AcompanhamentoRequest acompanhamentoRequest) {
        return acompanhamentoOrdemServicoFacade.save(idOrdemServico, acompanhamentoRequest)
                .doFirst(() -> log.info("=== Inicio da inserção de acompanhamento {} ===", acompanhamentoRequest))
                .doFinally(signalType -> log.info("=== Fim da inserção de acompanhamento {} ===", acompanhamentoRequest));
    }
}
