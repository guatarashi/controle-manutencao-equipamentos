package br.com.atarashi.controlemanutencaoequipamentos.controller.acompanhamentoOrdemServico.response;

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
public class AcompanhamentoResponse {

    private String descricao;
    private LocalDate data;
    private boolean termino;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("descricao", descricao)
                .append("data", data)
                .append("termino", termino)
                .toString();
    }
}
