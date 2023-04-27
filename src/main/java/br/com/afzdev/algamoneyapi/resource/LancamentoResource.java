package br.com.afzdev.algamoneyapi.resource;

import br.com.afzdev.algamoneyapi.model.Lancamento;
import br.com.afzdev.algamoneyapi.repositories.filter.LancamentoFilter;
import br.com.afzdev.algamoneyapi.services.LancamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/lancamento")
public class LancamentoResource {

    @Autowired
    LancamentoService service;

    @GetMapping
    public ResponseEntity<Page<Lancamento>> pesquisar(LancamentoFilter filter, Pageable pageable){
        return ResponseEntity.ok(service.filtrar(filter, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> buscarPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.buscarLancamentoPorId(id));
    }

    @PostMapping
    public ResponseEntity<Lancamento> salvar(@Valid @RequestBody Lancamento lancamento){
        Lancamento lancamentoSalvo = service.salvarLancamento(lancamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Lancamento> delete(@PathVariable Long id){
        service.deletePorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
