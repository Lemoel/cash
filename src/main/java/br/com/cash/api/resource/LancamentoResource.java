package br.com.cash.api.resource;

import br.com.cash.api.event.RecursoCriadoEvent;
import br.com.cash.api.model.Lancamento;
import br.com.cash.api.service.LancamentoService;
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
@RequestMapping("/lancamentos")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LancamentoResource {

    @Autowired
    LancamentoService lancamentoService;

    @Autowired
    ApplicationEventPublisher publisher;

    @GetMapping
    public ResponseEntity<?> lista() {
        List<Lancamento> lancamentos = this.lancamentoService.findAll();
        return ResponseEntity.ok(lancamentos);
    }

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response) {
        Lancamento lancamentoSalvo = lancamentoService.save(lancamento);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Lancamento> buscarPeloCodigo(@PathVariable Long codigo) {
        val lancamento = lancamentoService.findById(codigo);
        if (lancamento.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lancamento.get());
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long codigo) {
        lancamentoService.deleteById(codigo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Lancamento> atualizar(@PathVariable Long codigo, @Valid @RequestBody Lancamento lancamento) {
        val pessoaSalva = lancamentoService.atualizar(codigo, lancamento);
        return ResponseEntity.ok(pessoaSalva);
    }

}
