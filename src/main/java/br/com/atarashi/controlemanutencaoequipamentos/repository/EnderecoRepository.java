package br.com.atarashi.controlemanutencaoequipamentos.repository;

import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Endereco;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EnderecoRepository extends ReactiveCrudRepository<Endereco, Long> {
}
