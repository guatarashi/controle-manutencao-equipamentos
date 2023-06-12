package br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response;

import br.com.atarashi.controlemanutencaoequipamentos.controller.acompanhamentoOrdemServico.response.AcompanhamentoResponse;
import br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response.cliente.ClienteResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrdemServicoResponse {

    private long id;
    private String descricao;
    private String responsavel;
    private LocalDate dataCadastro;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private ClienteResponse cliente;
    private EquipamentoResponse equipamento;
    private List<AcompanhamentoResponse> acompanhamento;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("descricao", descricao)
                .append("responsavel", responsavel)
                .append("dataCadastro", dataCadastro)
                .append("dataInicio", dataInicio)
                .append("dataTermino", dataTermino)
                .append("cliente", cliente)
                .append("equipamento", equipamento)
                .append("acompanhamento", acompanhamento)
                .toString();
    }
}
