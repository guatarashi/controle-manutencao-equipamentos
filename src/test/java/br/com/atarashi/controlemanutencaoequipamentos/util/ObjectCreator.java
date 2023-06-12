package br.com.atarashi.controlemanutencaoequipamentos.util;

import br.com.atarashi.controlemanutencaoequipamentos.controller.acompanhamentoOrdemServico.request.AcompanhamentoRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.acompanhamentoOrdemServico.response.AcompanhamentoResponse;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.EquipamentoRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.OrdemServicoRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.cliente.ClienteRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.cliente.EnderecoRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response.EquipamentoResponse;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response.OrdemServicoResponse;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response.cliente.ClienteResponse;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response.cliente.EnderecoResponse;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Acompanhamento;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Cliente;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Endereco;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.Equipamento;
import br.com.atarashi.controlemanutencaoequipamentos.repository.model.OrdemServico;

import java.time.LocalDate;

public class ObjectCreator {

    public static OrdemServicoRequest createOrdemServicoRequest() {
        return OrdemServicoRequest.builder()
                .descricao("Problema na impressora")
                .responsavel("João")
                .cliente(ClienteRequest.builder()
                        .nome("Cliente 1")
                        .endereco(EnderecoRequest.builder()
                                .cidade("São Paulo")
                                .logradouro("Avenida tiete")
                                .numero("1")
                                .complemento("")
                                .bairro("logo ali")
                                .cep("15.997-000")
                                .build())
                        .email("cliente@test.com.br")
                        .telefone("11 2222-4567")
                        .build())
                .equipamento(EquipamentoRequest.builder()
                        .tipo("impressora")
                        .marca("epson")
                        .problema("não imprime")
                        .build())
                .build();
    }

    public static OrdemServico createOrdemServico() {
        return OrdemServico.builder()
                .descricao("Problema na impressora")
                .cliente(Cliente.builder()
                        .nome("Cliente 1")
                        .endereco(Endereco.builder()
                                .cidade("São Paulo")
                                .logradouro("Avenida tiete")
                                .numero("1")
                                .complemento("")
                                .bairro("logo ali")
                                .cep("15.997-000")
                                .build())
                        .email("cliente@test.com.br")
                        .telefone("11 2222-4567")
                        .build())
                .equipamento(Equipamento.builder()
                        .tipo("impressora")
                        .marca("epson")
                        .problema("não imprime")
                        .build())
                .build();
    }

    public static OrdemServicoResponse createOrdemServicoResponse() {
        return OrdemServicoResponse.builder()
                .descricao("Problema na impressora")
                .cliente(ClienteResponse.builder()
                        .nome("Cliente 1")
                        .endereco(EnderecoResponse.builder()
                                .cidade("São Paulo")
                                .logradouro("Avenida tiete")
                                .numero("1")
                                .complemento("")
                                .bairro("logo ali")
                                .cep("15.997-000")
                                .build())
                        .email("cliente@test.com.br")
                        .telefone("11 2222-4567")
                        .build())
                .equipamento(EquipamentoResponse.builder()
                        .tipo("impressora")
                        .marca("epson")
                        .problema("não imprime")
                        .build())
                .build();
    }

    public static AcompanhamentoRequest createAcompanhamentoRequest() {
        return AcompanhamentoRequest.builder()
                .descricao("Inicio do atendimento")
                .termino(false)
                .build();
    }

    public static AcompanhamentoRequest createAcompanhamentoRequestIsTermino() {
        return AcompanhamentoRequest.builder()
                .descricao("Inicio do atendimento")
                .termino(true)
                .build();
    }

    public static AcompanhamentoResponse createAcompanhamentoResponse(){
        return AcompanhamentoResponse.builder()
                .descricao("Inicio do atendimento")
                .data(LocalDate.now())
                .build();
    }

    public static Acompanhamento createAcompanhamento(){
        return Acompanhamento.builder()
                .descricao("Inicio do atendimento")
                .data(LocalDate.now())
                .build();
    }

    public static ClienteRequest createClienteRequest() {
        return ClienteRequest.builder()
                .nome("Cliente 1")
                .endereco(EnderecoRequest.builder()
                        .cidade("São Paulo")
                        .logradouro("Avenida tiete")
                        .numero("1")
                        .complemento("")
                        .bairro("logo ali")
                        .cep("15.997-000")
                        .build())
                .email("cliente@test.com.br")
                .telefone("11 2222-4567")
                .build();
    }

    public static Cliente createCliente() {
        return Cliente.builder()
                .nome("Cliente 1")
                .endereco(Endereco.builder()
                        .cidade("São Paulo")
                        .logradouro("Avenida tiete")
                        .numero("1")
                        .complemento("")
                        .bairro("logo ali")
                        .cep("15.997-000")
                        .build())
                .email("cliente@test.com.br")
                .telefone("11 2222-4567")
                .build();
    }

    public static EnderecoRequest createEnderecoRequest() {
        return EnderecoRequest.builder()
                .cidade("São Paulo")
                .logradouro("Avenida tiete")
                .numero("1")
                .complemento("")
                .bairro("logo ali")
                .cep("15.997-000")
                .build();
    }

    public static Endereco createEndereco() {
        return Endereco.builder()
                .cidade("São Paulo")
                .logradouro("Avenida tiete")
                .numero("1")
                .complemento("")
                .bairro("logo ali")
                .cep("15.997-000")
                .build();
    }

    public static Equipamento createEquipamento() {
        return Equipamento.builder()
                .tipo("impressora")
                .marca("epson")
                .problema("não imprime")
                .build();
    }
}
