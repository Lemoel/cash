package br.com.cash.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@Table(name = "categoria")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codigo;

    String nome;
}