package com.algaworks.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long> {

	
	//busca por LIKE 
	List<Cozinha> findTodasByNomeContaining(String nome);
	
	//https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html (keywords de exemplos)
	
	Optional<Cozinha> findByNome(String nome);

	
	
	boolean existsByNome(String nome);


}