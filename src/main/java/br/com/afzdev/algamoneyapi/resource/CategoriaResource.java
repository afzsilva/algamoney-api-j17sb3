package br.com.afzdev.algamoneyapi.resource;

import br.com.afzdev.algamoneyapi.event.RecursoCriadoEvent;
import br.com.afzdev.algamoneyapi.model.Categoria;
import br.com.afzdev.algamoneyapi.services.CategoriaService;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public List<Categoria> listar(){
        return service.listar();
    }

    @Autowired
    private ApplicationEventPublisher publisher;
    @PostMapping
    public ResponseEntity<Categoria> salvar(@Valid @RequestBody Categoria categoria, HttpServletResponse response){
        Categoria categoriaSalva = service.criar(categoria);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }


    @GetMapping("/{codigo}")
    public ResponseEntity<Categoria> buscarCategoria(@PathVariable ("codigo") Long codigo){
        Categoria retornada =  service.buscar(codigo);
        if (Objects.isNull(retornada)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.buscar(codigo));
    }



}
