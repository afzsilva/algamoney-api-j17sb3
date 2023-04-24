package br.com.afzdev.algamoneyapi.services;

import br.com.afzdev.algamoneyapi.model.Pessoa;
import br.com.afzdev.algamoneyapi.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService{

    @Autowired
    PessoaRepository repository;

    @Override
    public Pessoa buscarPorCodigo(Long codigo) {
        return repository.findById(codigo).orElse(null);
    }

    @Override
    public List<Pessoa> listar() {
        return repository.findAll();
    }

    @Override
    public Pessoa criarPessoa(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    @Override
    public void deletar(Long codigo) {
        repository.deleteById(codigo);
    }
}
