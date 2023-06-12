package br.com.atarashi.controlemanutencaoequipamentos.controller.ordemServico.request.cliente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
@Setter
@Builder(toBuilder = true)
public class ClienteRequest {

    @NotEmpty
    private String nome;
    @JsonIgnore
    private long idendereco;
    @Valid
    @NotNull
    private EnderecoRequest endereco;
    @NotEmpty
    private String email;
    @NotEmpty
    private String telefone;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("nome", nome)
                .append("idendereco", idendereco)
                .append("endereco", endereco)
                .append("email", email)
                .append("telefone", telefone)
                .toString();
    }
}
