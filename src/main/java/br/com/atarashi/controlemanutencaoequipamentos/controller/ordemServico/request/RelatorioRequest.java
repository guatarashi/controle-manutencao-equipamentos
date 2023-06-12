package br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
@Setter
public class RelatorioRequest {

    private String cliente;
    private String responsavel;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("cliente", cliente)
                .append("responsavel", responsavel)
                .toString();
    }
}
