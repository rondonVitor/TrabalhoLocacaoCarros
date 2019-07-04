package br.senai.sc.exemplo.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.senai.sc.exemplo.domain.Matricula;

public interface MatriculaRepository extends 
	CrudRepository<Matricula, Long> {
	
	@Query("SELECT m FROM Matricula m")
	List<Matricula> listarMatriculasPaginado(Pageable pageable);
	
	@Query("SELECT m FROM Matricula m "
			+ "JOIN m.usuario u "
			+ "WHERE u.idUsuario = :idUsuario")
	List<Matricula> buscarMatriculasPorUsuario(@Param("idUsuario") Long idUsuario);
	
	//@Query(nativeQuery=true, value="select * from matricula offset :offset limit :limit")
	//List<Matricula> listarMatriculasPaginadoNativo(@Param("limit") int limit, @Param("offset") int offset);

}
