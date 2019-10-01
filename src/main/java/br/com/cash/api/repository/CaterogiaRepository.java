package br.com.cash.api.repository;

import br.com.cash.api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaterogiaRepository extends JpaRepository<Categoria, Long> {

}
