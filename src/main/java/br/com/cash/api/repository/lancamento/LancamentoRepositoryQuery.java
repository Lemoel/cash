package br.com.cash.api.repository.lancamento;

import br.com.cash.api.model.Lancamento;
import br.com.cash.api.repository.filter.LancamentoFilter;

import java.util.List;

public interface LancamentoRepositoryQuery  {

    public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);

}
