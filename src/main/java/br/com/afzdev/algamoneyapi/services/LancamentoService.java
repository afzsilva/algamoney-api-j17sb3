package br.com.afzdev.algamoneyapi.services;

import br.com.afzdev.algamoneyapi.model.Lancamento;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LancamentoService {

    @Transactional(readOnly = true)
    List<Lancamento> listar();

    @Transactional(readOnly = true)
    Lancamento buscarLancamentoPorId(Long id);

    Lancamento salvarLancamento(Lancamento lancamento);

}
