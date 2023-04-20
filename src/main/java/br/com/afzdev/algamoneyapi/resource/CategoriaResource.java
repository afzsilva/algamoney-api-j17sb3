package br.com.afzdev.algamoneyapi.resource;

import br.com.afzdev.algamoneyapi.model.Categoria;
import br.com.afzdev.algamoneyapi.services.CategoriaService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public List<Categoria> listar(){
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria, HttpServletResponse response){
        Categoria categoriaSalva = service.criar(categoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(categoriaSalva.getCodigo()).toUri();

        return ResponseEntity.created(uri).body(categoriaSalva);
    }


    @GetMapping("/{codigo}")
    public ResponseEntity<Categoria> buscarCategoria(@PathVariable ("codigo") Long codigo){
        return ResponseEntity.ok(service.buscar(codigo));
    }



}
