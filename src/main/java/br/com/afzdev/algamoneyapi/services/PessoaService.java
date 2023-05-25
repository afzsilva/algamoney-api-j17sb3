package br.com.afzdev.algamoneyapi.services;

import br.com.afzdev.algamoneyapi.model.Lancamento;
import br.com.afzdev.algamoneyapi.model.Pessoa;
import br.com.afzdev.algamoneyapi.repositories.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
;

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

    @Transactional(readOnly = true)
    Page<Pessoa> findByNomeContaining(String nome, Pageable pageable);
}
