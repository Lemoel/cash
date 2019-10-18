package br.com.cash.api.repository;

import br.com.cash.api.model.Lancamento;
import br.com.cash.api.repository.lancamento.LancamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento,Long>, LancamentoRepositoryQuery {

}
