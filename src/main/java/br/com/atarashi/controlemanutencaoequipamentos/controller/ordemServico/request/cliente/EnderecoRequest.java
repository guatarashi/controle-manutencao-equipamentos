package br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.cliente;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
@Setter
@Builder(toBuilder = true)
public class EnderecoRequest {

    @NotEmpty
    private String cidade;
    @NotEmpty
    private String logradouro;
    @NotEmpty
    private String numero;
    private String complemento;
    @NotEmpty
    private String bairro;
    @NotEmpty
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
