package br.com.afzdev.algamoneyapi.repositories;

import br.com.afzdev.algamoneyapi.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
