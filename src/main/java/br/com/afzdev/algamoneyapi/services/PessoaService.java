package br.com.afzdev.algamoneyapi.services;

import br.com.afzdev.algamoneyapi.model.Pessoa;

import java.util.List;

public interface PessoaService {

    Pessoa buscarPorCodigo(Long codigo);

    List<Pessoa> listar();

    Pessoa criarPessoa(Pessoa pessoa);
}
