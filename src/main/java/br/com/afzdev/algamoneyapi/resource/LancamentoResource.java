package br.com.afzdev.algamoneyapi.resource;

import br.com.afzdev.algamoneyapi.model.Lancamento;
import br.com.afzdev.algamoneyapi.model.Pessoa;
import br.com.afzdev.algamoneyapi.projection.ResumoLancamento;
import br.com.afzdev.algamoneyapi.repositories.filter.LancamentoFilter;
import br.com.afzdev.algamoneyapi.services.LancamentoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/lancamento")
public class LancamentoResource {

    @Autowired
    LancamentoService service;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and hasAuthority('SCOPE_read')")
    public ResponseEntity<Page<Lancamento>> pesquisar(LancamentoFilter filter, Pageable pageable){
        return ResponseEntity.ok(service.filtrar(filter, pageable));
    }

    @GetMapping(params = "resumo")
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and hasAuthority('SCOPE_read')")
    public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable) {
        return service.resumir(lancamentoFilter, pageable);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_LANCAMENTO') and hasAuthority('SCOPE_read')")
    public ResponseEntity<Lancamento> buscarPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.buscarLancamentoPorId(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_LANCAMENTO') and hasAuthority('SCOPE_write')")
    public ResponseEntity<Lancamento> salvar(@Valid @RequestBody Lancamento lancamento){
        Lancamento lancamentoSalvo = service.salvarLancamento(lancamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_REMOVER_LANCAMENTO') and hasAuthority('SCOPE_write')")
    public ResponseEntity<Lancamento> delete(@PathVariable Long id){
        service.deletePorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{codigo}")
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_LANCAMENTO') and hasAuthority('SCOPE_write')")
    public ResponseEntity<Lancamento> atualizar(@PathVariable Long codigo, @Valid @RequestBody Lancamento lancamento){
        Lancamento ps = service.atualizar(codigo, lancamento);
        return ResponseEntity.ok(ps);
    }

}
