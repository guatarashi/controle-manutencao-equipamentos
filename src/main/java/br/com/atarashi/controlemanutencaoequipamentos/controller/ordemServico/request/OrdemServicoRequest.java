package br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request;

import br.com.atarashi.controlemanutencaoequipamentos.controller.acompanhamentoOrdemServico.request.AcompanhamentoRequest;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.cliente.ClienteRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
public class OrdemServicoRequest {

    @NotEmpty
    private String descricao;
    @NotEmpty
    private String responsavel;
    @JsonIgnore
    private long idEquipamento;
    @JsonIgnore
    private long idCliente;
    @Valid
    @NotNull
    private ClienteRequest cliente;
    @Valid
    @NotNull
    private EquipamentoRequest equipamento;
    @Valid
    private List<AcompanhamentoRequest> acompanhamento;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("descricao", descricao)
                .append("responsavel", responsavel)
                .append("idEquipamento", idEquipamento)
                .append("idCliente", idCliente)
                .append("cliente", cliente)
                .append("equipamento", equipamento)
                .append("acompanhamento", acompanhamento)
                .toString();
    }
}
