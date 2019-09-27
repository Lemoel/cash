package br.com.cash.repository;

import br.com.cash.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaterogiaRepository extends JpaRepository<Categoria, Long> {

}
