package br.com.atarashi.controlemanutencaoequipamentos.mapper;

import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.OrdemServicoRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response.OrdemServicoPendenteResponse;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response.OrdemServicoResponse;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.OrdemServico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrdemServicoMapper {

    OrdemServico ordemServicoRequestToOrdemServico (OrdemServicoRequest ordemServicoRequest);
    OrdemServico ordemServicoResponseToOrdemServico (OrdemServicoResponse ordemServicoResponse);
    OrdemServicoResponse ordemServicoToOrdemServicoResponse (OrdemServico ordemServico);
    OrdemServicoPendenteResponse ordemServicoToOrdemOrdemServicoPendenteResponse (OrdemServico ordemServico);
}
