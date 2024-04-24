package com.algaworks.algafood.infraestructure.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class RestauranteRepositoryImpl implements RestauranteRepository {
	
	private EntityManager manager;

	@Override
	public List<Restaurante> listar() {
		return manager.createQuery("from Restaurante",Restaurante.class).getResultList();
	}

	@Override
	public Restaurante buscar(Long id) {
		return manager.find(Restaurante.class, id);
	}

	@Transactional
	@Override
	public Restaurante salvar(Restaurante restaurante) {
		
		return manager.merge(restaurante);
	}

	@Transactional
	@Override
	public void remover(Restaurante restaurante) {
		restaurante = buscar(restaurante.getId());
		manager.remove(restaurante);
		
	}

}
