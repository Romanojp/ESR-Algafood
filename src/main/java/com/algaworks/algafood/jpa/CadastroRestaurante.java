package com.algaworks.algafood.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.model.Restaurante;

@Component
public class CadastroRestaurante {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Restaurante> listar(){
		return manager.createQuery("from Restaurante",Restaurante.class )
				.getResultList();
	}
	
	public Restaurante buscar(Long id) {
		return manager.find(Restaurante.class, id);
	}
	@Transactional
	public Restaurante salvar(Restaurante restaurante) {
		return manager.merge(restaurante);
		
	}
	
	@Transactional
	public void remover(Restaurante restaurante) {
		restaurante =  buscar(restaurante.getId());
		manager.remove(restaurante);
	}

}
