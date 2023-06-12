package br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.response.cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoResponse {

    private String cidade;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("cidade", cidade)
                .append("logradouro", logradouro)
                .append("numero", numero)
                .append("complemento", complemento)
                .append("bairro", bairro)
                .append("cep", cep)
                .toString();
    }
}
