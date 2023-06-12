package br.com.atarashi.controlemanutencaoequipamentos.repository;

import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Equipamento;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EquipamentoRepository extends ReactiveCrudRepository<Equipamento, Long> {

}
