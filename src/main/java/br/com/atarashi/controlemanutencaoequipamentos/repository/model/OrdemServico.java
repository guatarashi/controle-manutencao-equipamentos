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
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("ordemservico")
@Builder(toBuilder = true)
public class OrdemServico {

    @Id
    private long id;
    private String descricao;
    private String responsavel;
    @Column("datacadastro")
    private LocalDate dataCadastro = LocalDate.now();
    @Column("datainicio")
    private LocalDate dataInicio;
    @Column("datatermino")
    private LocalDate dataTermino;
    @Column("idcliente")
    private long idCliente;
    @Transient
    private Cliente cliente;
    @Column("idequipamento")
    private long idEquipamento;
    @Transient
    private Equipamento equipamento;
    @Transient
    private List<Acompanhamento> acompanhamento;

    public List<Acompanhamento> getAcompanhamento() {
        if (acompanhamento == null) {
            acompanhamento = new ArrayList<>();
        }
        return acompanhamento;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("id", id)
                .append("descricao", descricao)
                .append("dataCadastro", dataCadastro)
                .append("dataInicio", dataInicio)
                .append("dataTermino", dataTermino)
                .append("idCliente", idCliente)
                .append("cliente", cliente)
                .append("idEquipamento", idEquipamento)
                .append("equipamento", equipamento)
                .append("acompanhamento", acompanhamento)
                .toString();
    }
}
