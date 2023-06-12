package br.com.atarashi.controlemanutencaoequipamentos.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Acompanhamento {

    @Id
    private long id;
    private String descricao;
    private String responsavel;
    private LocalDate data = LocalDate.now();
    @Column("idordemservico")
    private long idOrdemServico;
    private boolean termino;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("descricao", descricao)
                .append("responsavel", responsavel)
                .append("data", data)
                .append("idOrdemServico", idOrdemServico)
                .append("termino", termino)
                .toString();
    }
}
