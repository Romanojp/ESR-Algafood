package com.algaworks.algafood.infraestructure.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;

public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {
	
	private EntityManager manager;

	@Override
	public List<FormaPagamento> listar() {
		return manager.createQuery("from FormaPagamento",FormaPagamento.class).getResultList();
	}

	@Override
	public FormaPagamento buscar(Long id) {
		return manager.find(FormaPagamento.class, id);
	}

	@Transactional
	@Override
	public FormaPagamento salvar(FormaPagamento formaPagamento) {
		
		return manager.merge(formaPagamento);
	}

	@Transactional
	@Override
	public void remover(FormaPagamento formaPagamento) {
		formaPagamento = buscar(formaPagamento.getId());
		manager.remove(formaPagamento);
		
	}

}
