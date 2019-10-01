package br.com.cash.api.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "pessoa")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codigo;

    @NotNull
    String nome;

    @NotNull
    Boolean ativo;

    @Embedded
    Endereco endereco;

}