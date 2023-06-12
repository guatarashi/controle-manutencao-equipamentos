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
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ClienteResponse {

    private String nome;
    private EnderecoResponse endereco;
    private String email;
    private String telefone;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("nome", nome)
                .append("endereco", endereco)
                .append("email", email)
                .append("telefone", telefone)
                .toString();
    }
}
