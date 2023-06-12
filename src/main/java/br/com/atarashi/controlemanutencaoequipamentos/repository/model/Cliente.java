package br.com.atarashi.controlemanutencaoequipamentos.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Cliente {

    @Id
    private long id;
    private String nome;
    @Column("idendereco")
    private long idendereco;
    @Transient
    private Endereco endereco;
    private String email;
    private String telefone;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("nome", nome)
                .append("idendereco", idendereco)
                .append("endereco", endereco)
                .append("email", email)
                .append("telefone", telefone)
                .toString();
    }
}
