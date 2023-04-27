package br.com.afzdev.algamoneyapi.services;

import br.com.afzdev.algamoneyapi.model.Lancamento;
import br.com.afzdev.algamoneyapi.repositories.filter.LancamentoFilter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LancamentoService {

    @Transactional(readOnly = true)
    List<Lancamento> listar();

    @Transactional(readOnly = true)
    List<Lancamento> filtrar(LancamentoFilter filter);

    @Transactional(readOnly = true)
    Lancamento buscarLancamentoPorId(Long id);

    @Transactional
    Lancamento salvarLancamento(Lancamento lancamento);

    @Transactional
    void deletePorId(Long id);

}
