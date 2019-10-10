package br.com.cash.api.service;

import br.com.cash.api.model.Lancamento;
import br.com.cash.api.repository.LancamentoRepository;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    LancamentoRepository repository;

    @Autowired
    PessoaService pessoaService;

    public Lancamento atualizar(Long codigo, Lancamento lancamento) {
        var lancamentoSalvo = getLancamentoSalvo(codigo);
        BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");
        repository.save(lancamentoSalvo);
        return lancamentoSalvo;
    }

    private Lancamento getLancamentoSalvo(Long codigo) {
        Optional<Lancamento> lancamentoSalvo = repository.findById(codigo);
        if (lancamentoSalvo.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return lancamentoSalvo.get();
    }

    public void deleteById(Long codigo) {
        repository.deleteById(codigo);
    }

    public Optional<Lancamento> findById(Long codigo) {
        return repository.findById(codigo);
    }

    public List<Lancamento> findAll() {
        return repository.findAll();
    }

    public Lancamento save(Lancamento lancamento) {
        val pessoaPeloCodigo = pessoaService.findById(lancamento.getPessoa().getCodigo());
        if(pessoaPeloCodigo.isPresent()) {
            if(pessoaPeloCodigo.get().isInativo()) {
                return repository.save(lancamento);
            }
        }
        return null;
    }
}
