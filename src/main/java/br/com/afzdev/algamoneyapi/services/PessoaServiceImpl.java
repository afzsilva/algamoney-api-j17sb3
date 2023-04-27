package br.com.afzdev.algamoneyapi.services;

import br.com.afzdev.algamoneyapi.model.Pessoa;
import br.com.afzdev.algamoneyapi.repositories.PessoaRepository;
import org.hibernate.collection.spi.PersistentSortedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService{

    @Autowired
    PessoaRepository repository;

    @Override
    public Pessoa buscarPorCodigo(Long codigo) {
        return repository.findById(codigo).get();
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

        Optional<Pessoa> p = repository.findById(codigo);

        if (p.isEmpty()){
            throw new NoSuchElementException("Pessoa não localizada");
        }

        repository.deleteById(codigo);
    }

    @Override
    public Pessoa atualizar(Long codigo, Pessoa pessoa) {
        Optional<Pessoa> p = repository.findById(codigo);

        if (p.isEmpty()){
            throw new NoSuchElementException("Pessoa não localizada");
        }

        p.get().setCodigo(codigo);
        p.get().setEndereco(pessoa.getEndereco());
        p.get().setAtivo(pessoa.isAtivo());
        Pessoa ps = repository.save(p.get());
        return ps;
    }

    @Override
    public Pessoa atualizarStatus(Long codigo, boolean ativo) {

        Optional<Pessoa> p = repository.findById(codigo);

        if (p.isEmpty()){
            throw new NoSuchElementException("Pessoa não localizada");
        }
        p.get().setCodigo(codigo);
        p.get().setAtivo(ativo);

        return p.get();
    }

}
