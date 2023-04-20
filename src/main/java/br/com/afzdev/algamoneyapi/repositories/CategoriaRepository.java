package br.com.afzdev.algamoneyapi.repositories;

import br.com.afzdev.algamoneyapi.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
