package br.com.cash.api.resource;

import br.com.cash.api.event.RecursoCriadoEvent;
import br.com.cash.api.repository.CaterogiaRepository;
import br.com.cash.api.model.Categoria;
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
@RequestMapping("/categorias")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoriaResource {

    @Autowired
    CaterogiaRepository categorias;

    @Autowired
    ApplicationEventPublisher publisher;

    @GetMapping
    public ResponseEntity<?> lista() {
        List<Categoria> categorias = this.categorias.findAll();
        return ResponseEntity.ok(categorias);
    }

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
        val categoriaSalva = categorias.save(categoria);
        publisher.publishEvent(new RecursoCriadoEvent(this,response,categoriaSalva.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo) {
        Optional<Categoria> categoria = categorias.findById(codigo);
        if (categoria.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoria.get());
    }

}
