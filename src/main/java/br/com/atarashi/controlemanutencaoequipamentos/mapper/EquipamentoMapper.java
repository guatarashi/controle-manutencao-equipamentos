package br.com.atarashi.controlemanutencaoequipamentos.mapper;

import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.EquipamentoRequest;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Equipamento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EquipamentoMapper {

    Equipamento equipamentoRequestToEquipamento(EquipamentoRequest equipamentoRequest);
}
