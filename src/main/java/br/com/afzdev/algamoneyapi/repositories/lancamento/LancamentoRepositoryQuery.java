package br.com.afzdev.algamoneyapi.repositories.lancamento;

import br.com.afzdev.algamoneyapi.model.Lancamento;
import br.com.afzdev.algamoneyapi.repositories.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LancamentoRepositoryQuery {

    public Page<Lancamento> filtrar(LancamentoFilter filter, Pageable pageable);
}
