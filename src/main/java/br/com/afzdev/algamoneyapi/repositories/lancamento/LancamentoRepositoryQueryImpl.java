package br.com.afzdev.algamoneyapi.repositories.lancamento;

import br.com.afzdev.algamoneyapi.model.Lancamento;
import br.com.afzdev.algamoneyapi.model.Lancamento_;
import br.com.afzdev.algamoneyapi.repositories.filter.LancamentoFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class LancamentoRepositoryQueryImpl implements LancamentoRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Lancamento> filtrar(LancamentoFilter filter, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Lancamento> criteria = builder.createQuery(Lancamento.class);
        Root<Lancamento> root = criteria.from(Lancamento.class);

        //restrições
        Predicate[] predicates = criarRestricoes(filter, builder, root);
        criteria.where(predicates);

        TypedQuery<Lancamento> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(),pageable, total(filter));
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<Lancamento> query, Pageable pageable) {

        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistrosPorPagina);
    }

    private Long total(LancamentoFilter filter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Lancamento> root = criteria.from(Lancamento.class);

        Predicate[] predicates = criarRestricoes(filter,builder,root);
        criteria.where(predicates);
        criteria.select(builder.count(root));
        return manager.createQuery(criteria).getSingleResult();
    }



    private Predicate[] criarRestricoes(LancamentoFilter filter, CriteriaBuilder builder, Root<Lancamento> root) {

        List<Predicate> predicates = new ArrayList<>();


        if(!ObjectUtils.isEmpty(filter.getDescricao())){
            predicates.add(builder.like(
                    builder.lower(root.get(Lancamento_.descricao)),"%"+filter.getDescricao().toLowerCase()+"%"
            ));
        }

        if(filter.getDataVencimentoDe() != null){
            predicates.add(
                    builder.greaterThanOrEqualTo(root.get(Lancamento_.dataVencimento), filter.getDataVencimentoDe())
            );
        }

        if(filter.getDataVencimentoAte() != null){
            predicates.add(
                    builder.lessThanOrEqualTo(root.get(Lancamento_.dataVencimento), filter.getDataVencimentoAte())
            );
        }


        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
