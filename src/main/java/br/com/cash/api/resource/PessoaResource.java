package br.com.cash.api.resource;

import br.com.cash.api.event.RecursoCriadoEvent;
import br.com.cash.api.model.Pessoa;
import br.com.cash.api.repository.PessoaRepository;
import br.com.cash.api.service.PessoaService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PessoaResource {

    @Autowired
    PessoaRepository repository;

    @Autowired
    PessoaService pessoaService;

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
        publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Pessoa> buscarPeloCodigo(@PathVariable Long codigo) {
        val pessoa = pessoaService.findById(codigo);
        if (pessoa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pessoa.get());
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long codigo) {
        pessoaService.deleteById(codigo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long codigo, @Valid @RequestBody Pessoa pessoa) {
        val pessoaSalva = pessoaService.atualizar(codigo, pessoa);
        return ResponseEntity.ok(pessoaSalva);
    }

}
