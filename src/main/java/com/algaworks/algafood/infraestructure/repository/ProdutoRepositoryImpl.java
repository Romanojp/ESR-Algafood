package com.algaworks.algafood.infraestructure.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Produto;
import com.algaworks.algafood.domain.repository.ProdutoRepository;


@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {
	
	private EntityManager manager;

	@Override
	public List<Produto> listar() {
		return manager.createQuery("from Cozinha",Produto.class).getResultList();
	}

	@Override
	public Produto buscar(Long id) {
		return manager.find(Produto.class, id);
	}

	@Transactional
	@Override
	public Produto salvar(Produto produto) {
		
		return manager.merge(produto);
	}

	@Transactional
	@Override
	public void remover(Produto produto) {
		produto = buscar(produto.getId());
		manager.remove(produto);
		
	}

}
