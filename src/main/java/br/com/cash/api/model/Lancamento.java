package br.com.cash.api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "lancamento")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codigo;

    @NotNull
    @Size(min = 3, max = 20)
    String descricao;

    @NotNull
    @Column(name = "DATA_VENCIMENTO")
    LocalDate dataVencimento;

    @Column(name = "DATA_PAGAMENTO")
    LocalDate dataPagamento;

    BigDecimal valor;

    String observacao;

    @NotNull
    @Enumerated(EnumType.STRING)
    TipoLancamento tipo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CODIGO_CATEGORIA")
    Categoria categoria;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CODIGO_PESSOA")
    Pessoa pessoa;

}