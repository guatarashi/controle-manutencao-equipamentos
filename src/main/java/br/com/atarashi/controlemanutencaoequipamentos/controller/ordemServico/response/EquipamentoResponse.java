package br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response;

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
public class EquipamentoResponse {

    private String tipo;
    private String marca;
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
