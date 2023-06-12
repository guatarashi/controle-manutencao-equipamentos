package br.com.atarashi.controlemanutencaoequipamentos.service;

import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Equipamento;
import reactor.core.publisher.Mono;

public interface EquipamentoService {

    Mono<Equipamento> save(Equipamento equipamento);
    Mono<Equipamento> findById(Long id);
}
