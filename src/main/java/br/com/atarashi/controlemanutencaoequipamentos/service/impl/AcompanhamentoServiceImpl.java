package br.com.atarashi.controlemanutencaoequipamentos.service.impl;

import br.com.atarashi.controlemanutencaoequipamentos.repository.AcompanhamentoRepository;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Acompanhamento;
import br.com.atarashi.controlemanutencaoequipamentos.service.AcompanhamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AcompanhamentoServiceImpl implements AcompanhamentoService {

    private final AcompanhamentoRepository acompanhamentoRepository;

    @Override
    public Flux<Acompanhamento> saveAll(Flux<Acompanhamento> acompanhamento) {
        return acompanhamentoRepository.saveAll(acompanhamento);
    }

    @Override
    public Mono<Acompanhamento> save(final Acompanhamento acompanhamento) {
        return acompanhamentoRepository.save(acompanhamento);
    }

    @Override
    public Flux<Acompanhamento> findAcompanhamentosByIdOrdemServico(Long idOrdemServico) {
        return acompanhamentoRepository.findAcompanhamentosByIdOrdemServico(idOrdemServico);
    }
}
