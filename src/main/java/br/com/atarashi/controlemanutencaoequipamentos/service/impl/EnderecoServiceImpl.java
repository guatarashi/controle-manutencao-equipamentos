package br.com.atarashi.controlemanutencaoequipamentos.service.impl;

import br.com.atarashi.controlemanutencaoequipamentos.repository.EnderecoRepository;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Endereco;
import br.com.atarashi.controlemanutencaoequipamentos.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Override
    public Mono<Endereco> save(final Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Mono<Endereco> findById(Long id) {
        return enderecoRepository.findById(id);
    }
}
