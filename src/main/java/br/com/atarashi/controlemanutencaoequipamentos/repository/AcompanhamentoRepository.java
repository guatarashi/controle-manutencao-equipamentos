package br.com.atarashi.controlemanutencaoequipamentos.repository;

import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Acompanhamento;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface AcompanhamentoRepository extends ReactiveCrudRepository<Acompanhamento, Long> {

    @Query("select * from acompanhamento where idordemservico = :idOrdemServico")
    Flux<Acompanhamento> findAcompanhamentosByIdOrdemServico(Long idOrdemServico);

}
