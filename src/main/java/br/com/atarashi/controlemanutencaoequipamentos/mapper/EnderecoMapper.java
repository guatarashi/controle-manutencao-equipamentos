package br.com.atarashi.controlemanutencaoequipamentos.mapper;

import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.cliente.EnderecoRequest;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    Endereco enderecoRequestToEndereco(EnderecoRequest enderecoRequest);
}
