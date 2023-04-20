package br.com.afzdev.algamoneyapi.services;

import br.com.afzdev.algamoneyapi.model.Categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> listar();

    Categoria criar(Categoria categoria);

    Categoria buscar(Long codigo);
}
