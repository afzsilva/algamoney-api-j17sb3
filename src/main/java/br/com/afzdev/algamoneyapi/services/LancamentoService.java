package br.com.afzdev.algamoneyapi.services;

import br.com.afzdev.algamoneyapi.model.Lancamento;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LancamentoService {

    @Transactional
    List<Lancamento> listar();

    @Transactional
    Lancamento buscarLancamentoPorId(Long id);
}
