package br.com.afzdev.algamoneyapi.services;

import br.com.afzdev.algamoneyapi.model.Categoria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoriaService {

    @Transactional(readOnly = true)
    List<Categoria> listar();

    @Transactional
    Categoria criar(Categoria categoria);

    @Transactional(readOnly = true)
    Categoria buscar(Long codigo);
}
