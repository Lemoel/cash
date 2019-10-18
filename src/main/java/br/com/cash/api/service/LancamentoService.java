package br.com.cash.api.service;

import br.com.cash.api.model.Lancamento;
import br.com.cash.api.repository.LancamentoRepository;
import br.com.cash.api.repository.PessoaRepository;
import br.com.cash.api.repository.filter.LancamentoFilter;
import br.com.cash.api.service.exception.PessoaInexistenteOuInativaException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LancamentoService {

    @Autowired
    LancamentoRepository lancamentoRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    public Lancamento atualizar(Long codigo, Lancamento lancamento) {
        var lancamentoSalvo = getLancamentoSalvo(codigo);
        BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");
        lancamentoRepository.save(lancamentoSalvo);
        return lancamentoSalvo;
    }

    private Lancamento getLancamentoSalvo(Long codigo) {
        Optional<Lancamento> lancamentoSalvo = lancamentoRepository.findById(codigo);
        if (lancamentoSalvo.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return lancamentoSalvo.get();
    }

    public void deleteById(Long codigo) {
        lancamentoRepository.deleteById(codigo);
    }

    public Optional<Lancamento> findById(Long codigo) {
        return lancamentoRepository.findById(codigo);
    }

    public List<Lancamento> findAll() {
        return lancamentoRepository.findAll();
    }

    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable) {
        return lancamentoRepository.filtrar(lancamentoFilter,pageable);
    }

    public Lancamento salvar(Lancamento lancamento) {
        val pessoaPeloCodigo = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
        if(pessoaPeloCodigo.isPresent()) {
            if(pessoaPeloCodigo.get().isAtivo()) {
                return lancamentoRepository.save(lancamento);
            }
        }
        throw new PessoaInexistenteOuInativaException();
    }
}
