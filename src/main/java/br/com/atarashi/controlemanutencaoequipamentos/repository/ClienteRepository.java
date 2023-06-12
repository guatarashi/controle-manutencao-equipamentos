package br.com.atarashi.controlemanutencaoequipamentos.repository;

import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Cliente;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ClienteRepository extends ReactiveCrudRepository<Cliente, Long> {

}
