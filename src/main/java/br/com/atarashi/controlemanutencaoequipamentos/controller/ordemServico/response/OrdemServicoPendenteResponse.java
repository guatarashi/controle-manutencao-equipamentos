package br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrdemServicoPendenteResponse {

    private long id;
    private String descricao;
    private String responsavel;
    private LocalDate dataCadastro;
    private LocalDate dataInicio;
    private LocalDate dataTermino;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("descricao", descricao)
                .append("responsavel", responsavel)
                .append("dataCadastro", dataCadastro)
                .append("dataInicio", dataInicio)
                .append("dataTermino", dataTermino)
                .toString();
    }
}
