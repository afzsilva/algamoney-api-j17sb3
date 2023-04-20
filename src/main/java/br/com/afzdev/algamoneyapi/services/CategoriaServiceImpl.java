package br.com.afzdev.algamoneyapi.services;

import br.com.afzdev.algamoneyapi.model.Categoria;
import br.com.afzdev.algamoneyapi.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    @Autowired
    private CategoriaRepository repository;

    @Override
    public List<Categoria> listar() {
        return repository.findAll();
    }

    @Override
    public Categoria criar(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public Categoria buscar(Long codigo) {
        return repository.findById(codigo).orElse(null);
    }
}
