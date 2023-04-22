package br.com.afzdev.algamoneyapi.resource;

import br.com.afzdev.algamoneyapi.event.RecursoCriadoEvent;
import br.com.afzdev.algamoneyapi.model.Pessoa;
import br.com.afzdev.algamoneyapi.services.PessoaService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

    @Autowired
    PessoaService service;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping(value = "/{codigo}")
    public ResponseEntity<Pessoa> buscarPessoa(@PathVariable("codigo") Long codigo){
        return ResponseEntity.ok(service.buscarPorCodigo(codigo));
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas(){
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<Pessoa> salvarPessoa(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response){
        Pessoa pessoaSalva = service.criarPessoa(pessoa);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }


   /* @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remover(@PathVariable Long codigo){
        service.deletar(codigo);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }*/
}
