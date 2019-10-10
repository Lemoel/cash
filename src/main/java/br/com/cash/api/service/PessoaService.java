package br.com.cash.api.service;

import br.com.cash.api.model.Pessoa;
import br.com.cash.api.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public Pessoa atualizar(Long codigo, Pessoa pessoa) {

        var pessoaSalva = getPessoaPeloCodigo(codigo);
        BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
        repository.save(pessoaSalva);
        return pessoaSalva;

    }

    public Pessoa getPessoaPeloCodigo(Long codigo) {
        Optional<Pessoa> pessoaSalva = repository.findById(codigo);
        if (pessoaSalva.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return pessoaSalva.get();
    }

    public void deleteById(Long codigo) {
        repository.deleteById(codigo);
    }

    public Optional<Pessoa> findById(Long codigo) {
        return repository.findById(codigo);
    }

    public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
        var pessoaSalva = getPessoaPeloCodigo(codigo);
        pessoaSalva.setAtivo(ativo);
        repository.save(pessoaSalva);
    }
}
