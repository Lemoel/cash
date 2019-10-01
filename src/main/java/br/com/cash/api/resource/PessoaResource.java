package br.com.cash.api.resource;

import br.com.cash.api.event.RecursoCriadoEvent;
import br.com.cash.api.model.Pessoa;
import br.com.cash.api.repository.PessoaRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PessoaResource {

    @Autowired
    PessoaRepository repository;

    @Autowired
    ApplicationEventPublisher publisher;

    @GetMapping
    public ResponseEntity<?> lista() {
        List<Pessoa> pessoas = this.repository.findAll();
        return ResponseEntity.ok(pessoas);
    }

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
        val pessoaSalva = repository.save(pessoa);
        publisher.publishEvent(new RecursoCriadoEvent(this,response,pessoaSalva.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Pessoa> buscarPeloCodigo(@PathVariable Long codigo) {
        Optional<Pessoa> pessoa = repository.findById(codigo);
        if (pessoa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pessoa.get());
    }

}
