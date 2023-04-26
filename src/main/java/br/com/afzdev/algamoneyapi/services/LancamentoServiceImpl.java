package br.com.afzdev.algamoneyapi.services;

import br.com.afzdev.algamoneyapi.model.Lancamento;
import br.com.afzdev.algamoneyapi.repositories.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LancamentoServiceImpl implements LancamentoService{

    @Autowired
    LancamentoRepository repository;

    @Override
    public List<Lancamento> listar() {
        return repository.findAll();
    }

    @Override
    public Lancamento buscarLancamentoPorId(Long id) {
        Optional<Lancamento> opt = repository.findById(id);

        if (opt.isEmpty()){
            throw new NoSuchElementException("Lancamento Não localizado ou Inexistente");
        }

        return opt.get();
    }


}
