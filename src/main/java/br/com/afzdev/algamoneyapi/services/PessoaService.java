package br.com.afzdev.algamoneyapi.services;

import br.com.afzdev.algamoneyapi.model.Pessoa;
import jakarta.transaction.Transactional;

import java.util.List;

public interface PessoaService {

    @Transactional
    Pessoa buscarPorCodigo(Long codigo);

    @Transactional
    List<Pessoa> listar();

    @Transactional
    Pessoa criarPessoa(Pessoa pessoa);

    @Transactional
    void deletar(Long codigo);

    @Transactional
    Pessoa atualizar(Long codigo, Pessoa pessoa);

    @Transactional
    Pessoa atualizarStatus(Long codigo, boolean ativo);
}
