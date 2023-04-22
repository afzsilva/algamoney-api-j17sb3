package br.com.afzdev.algamoneyapi.resource;

import br.com.afzdev.algamoneyapi.model.Pessoa;
import br.com.afzdev.algamoneyapi.services.PessoaService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

    @Autowired
    PessoaService service;

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

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(pessoaSalva.getCodigo()).toUri();

        return ResponseEntity.created(uri).body(pessoaSalva);
    }
}
