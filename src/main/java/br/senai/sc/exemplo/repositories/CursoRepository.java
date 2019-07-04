package br.senai.sc.exemplo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.senai.sc.exemplo.domain.Curso;

public interface CursoRepository extends CrudRepository<Curso, Long>{

	//@Query("SELECT c FROM Curso c WHERE c.cargaHoraria >= :inicio AND c.cargaHoraria <= :termino")
	@Query("SELECT c FROM Curso c WHERE c.cargaHoraria BETWEEN :inicio AND :termino")
	public List<Curso> listarPorCargaHorariaEntre(@Param("inicio") int inicio, @Param("termino") int termino);
	
	/*@Query("SELECT c FROM Matricula m "
			+ "JOIN m.curso c "
			+ "WHERE m.idMatricula = :idMatricula")*/
	@Query("SELECT c FROM Curso c "
			+ "JOIN c.matriculas m "
			+ "WHERE m.idMatricula = :idMatricula")
	public Optional<Curso> buscarCursoPorMatricula(@Param("idMatricula") Long idMatricula); 
	
}
