package br.com.afzdev.algamoneyapi.resource;

import br.com.afzdev.algamoneyapi.model.Lancamento;
import br.com.afzdev.algamoneyapi.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lancamento")
public class LancamentoResource {

    @Autowired
    LancamentoService service;

    @GetMapping
    public ResponseEntity<List<Lancamento>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> buscarPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.buscarLancamentoPorId(id));
    }


}
