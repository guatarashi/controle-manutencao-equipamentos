package br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico;

import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.RelatorioRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response.OrdemServicoResponse;
import br.com.atarashi.controlemanutencaoequipamentos.facade.OrdemServicoFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("ordem-servicos")
public class OrdemServicoFetchController {

    private final OrdemServicoFacade ordemServicoFacade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<OrdemServicoResponse> findByOrdensServicoCompletaRelatorio(@RequestBody final RelatorioRequest relatorioRequest) {
        return ordemServicoFacade.findByOrdensServicoCompletaRelatorio(relatorioRequest);
    }

    @GetMapping("{idOrdemServico}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<OrdemServicoResponse> findByOrdemServicoCompleta(@PathVariable final long idOrdemServico) {
        return ordemServicoFacade.findByOrdemServicoCompleta(idOrdemServico)
                .doFirst(() -> log.info("=== Inicio da busca da ordem de serviço {} ===", idOrdemServico))
                .doFinally(signalType -> log.info("=== Fim da busca da ordem de serviço {} ===", idOrdemServico));
    }


    @GetMapping("pendentes")
    @ResponseStatus(HttpStatus.OK)
    public Flux<OrdemServicoResponse> findPendentes(@RequestParam final String responsavel) {
        return ordemServicoFacade.findByOrdensServicoPendetesCompleta(responsavel)
                .doFirst(() -> log.info("=== Inicio da busca da ordem de serviço pendentes ==="))
                .doFinally(signalType -> log.info("=== Fim da busca da ordem de serviço pendentes ==="));
    }
}
