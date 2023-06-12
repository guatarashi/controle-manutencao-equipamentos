package br.com.atarashi.controlemanutencaoequipamentos.controller.acompanhamentoOrdemServico.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
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
public class AcompanhamentoRequest {

    @NotEmpty
    private String descricao;
    @JsonIgnore
    private LocalDate data;
    @JsonIgnore
    private long idOrdemServico;
    @NotEmpty
    private boolean termino;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("descricao", descricao)
                .append("data", data)
                .append("idOrdemServico", idOrdemServico)
                .append("termino", termino)
                .toString();
    }
}
