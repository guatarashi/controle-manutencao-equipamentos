package br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico;

import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.OrdemServicoRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response.OrdemServicoResponse;
import br.com.atarashi.controlemanutencaoequipamentos.facade.OrdemServicoFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("ordem-servicos")
public class OrdemServicoSaveController {

    private final OrdemServicoFacade ordemServicoFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<OrdemServicoResponse> save(@RequestBody @Valid final OrdemServicoRequest ordemServicoRequest) {
        return ordemServicoFacade.save(ordemServicoRequest)
                .doFirst(() -> log.info("=== Inicio da criação da ordem de serviço {} ===", ordemServicoRequest))
                .doFinally(signalType -> log.info("=== Fim da criação da ordem de serviço {} ===", ordemServicoRequest));
    }
}
