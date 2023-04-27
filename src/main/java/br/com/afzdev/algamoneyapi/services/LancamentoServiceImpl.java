package br.com.afzdev.algamoneyapi.services;

import br.com.afzdev.algamoneyapi.model.Lancamento;
import br.com.afzdev.algamoneyapi.model.Pessoa;
import br.com.afzdev.algamoneyapi.repositories.LancamentoRepository;
import br.com.afzdev.algamoneyapi.repositories.PessoaRepository;
import br.com.afzdev.algamoneyapi.repositories.filter.LancamentoFilter;
import br.com.afzdev.algamoneyapi.services.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LancamentoServiceImpl implements LancamentoService{

    @Autowired
    LancamentoRepository repository;

    @Autowired
    PessoaRepository pessoaRepository;


    @Override
    public List<Lancamento> listar() {
        return repository.findAll();
    }

    @Override
    public Page<Lancamento> filtrar(LancamentoFilter filter, Pageable pageable) {
        return repository.filtrar(filter, pageable);
    }

    @Override
    public Lancamento buscarLancamentoPorId(Long id) {
        Optional<Lancamento> opt = repository.findById(id);

        if (opt.isEmpty()){
            throw new NoSuchElementException("Lancamento Não localizado ou Inexistente");
        }

        return opt.get();
    }

    @Override
    public Lancamento salvarLancamento(Lancamento lancamento) {

        Optional<Pessoa> p = pessoaRepository.findById(lancamento.getPessoa().getCodigo());

        if (p.isPresent() && !p.get().isAtivo()){
            throw new PessoaInexistenteOuInativaException();
        }

        return repository.save(lancamento);
    }

    @Override
    public void deletePorId(Long id) {
        Optional<Lancamento> lancamento = repository.findById(id);

        if (lancamento.isEmpty()){
            throw new NoSuchElementException("lancamento não localizado");
        }

        repository.deleteById(id);
    }


}
