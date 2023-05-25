package br.com.afzdev.algamoneyapi.services;

import br.com.afzdev.algamoneyapi.model.Lancamento;
import br.com.afzdev.algamoneyapi.model.Pessoa;
import br.com.afzdev.algamoneyapi.projection.ResumoLancamento;
import br.com.afzdev.algamoneyapi.repositories.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LancamentoService {

    @Transactional(readOnly = true)
    List<Lancamento> listar();

    @Transactional(readOnly = true)
    Page<Lancamento> filtrar(LancamentoFilter filter, Pageable pageable);

    @Transactional(readOnly = true)
    Page<ResumoLancamento> resumir(LancamentoFilter filter, Pageable pageable);

    @Transactional(readOnly = true)
    Lancamento buscarLancamentoPorId(Long id);

    @Transactional
    Lancamento salvarLancamento(Lancamento lancamento);

    @Transactional
    void deletePorId(Long id);

    @Transactional(readOnly = false)
    Lancamento atualizar(Long codigo, Lancamento lancamento);
}
