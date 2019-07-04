package br.senai.sc.exemplo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.senai.sc.exemplo.domain.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{

	Optional<Cliente> findByCpf(String cpf);
	
	Optional<Cliente> findByEmail(String email);

	@Query(value = "SELECT c FROM Cliente c WHERE lower(c.nome) like lower(CONCAT('%',:nome,'%'))")
	Optional<Cliente> buscarPorNome(@Param("nome") String nome);
}