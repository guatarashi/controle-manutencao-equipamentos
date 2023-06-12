package br.com.atarashi.controlemanutencaoequipamentos.mapper;

import br.com.atarashi.controlemanutencaoequipamentos.controller.acompanhamentoOrdemServico.request.AcompanhamentoRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.acompanhamentoOrdemServico.response.AcompanhamentoResponse;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Acompanhamento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcompanhamentoMapper {

    Acompanhamento acompanhamentoRequestToAcompanhamento(AcompanhamentoRequest acompanhamentoRequest);
    AcompanhamentoResponse acompanhamentoToAcompanhamentoResponse(Acompanhamento acompanhamento);
}
