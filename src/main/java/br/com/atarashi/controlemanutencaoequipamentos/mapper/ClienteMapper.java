package br.com.atarashi.controlemanutencaoequipamentos.mapper;

import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.cliente.ClienteRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response.cliente.ClienteResponse;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente clienteRequestToCliente(ClienteRequest clienteRequest);
    ClienteResponse clienteToClienteResponse(Cliente cliente);
}
