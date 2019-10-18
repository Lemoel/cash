package br.com.cash.api.repository.filter;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LancamentoFilter {

    String descricao;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dataVencimentoDe;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dataVencimentoAte;

}
