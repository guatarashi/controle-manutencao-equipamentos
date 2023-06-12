package br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class EquipamentoRequest {

    @NotEmpty
    private String tipo;
    @NotEmpty
    private String marca;
    @NotEmpty
    private String problema;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("tipo", tipo)
                .append("marca", marca)
                .append("problema", problema)
                .toString();
    }
}
