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
        Optional<Pessoa> pessoaSalva = repository.findById(codigo);
        if (pessoaSalva.isPresent()) {
            BeanUtils.copyProperties(pessoa, pessoaSalva.get(), "codigo");
            repository.save(pessoaSalva.get());
            return pessoaSalva.get();
        }
        throw new EmptyResultDataAccessException(1);
    }

    public void deleteById(Long codigo) {
        repository.deleteById(codigo);
    }

    public Optional<Pessoa> findById(Long codigo) {
        return repository.findById(codigo);
    }
}
