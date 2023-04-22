package br.com.afzdev.algamoneyapi.repositories;

import br.com.afzdev.algamoneyapi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
