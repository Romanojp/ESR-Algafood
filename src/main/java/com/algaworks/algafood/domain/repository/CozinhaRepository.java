package com.algaworks.algafood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

	//buca por nome 
	List<Cozinha> findByNome(String nome);
	
	//busca por LIKE 
	List<Cozinha> findByNomeContaining(String nome);
	
	//https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html (keywords de exemplos)
	


}