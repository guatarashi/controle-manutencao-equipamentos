package br.com.atarashi.controlemanutencaoequipamentos.service.impl;

import br.com.atarashi.controlemanutencaoequipamentos.repository.EquipamentoRepository;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Equipamento;
import br.com.atarashi.controlemanutencaoequipamentos.service.EquipamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EquipamentoServiceImpl implements EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;

    @Override
    public Mono<Equipamento> save(Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    @Override
    public Mono<Equipamento> findById(Long id) {
        return equipamentoRepository.findById(id);
    }
}
