package br.senai.sc.exemplo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.senai.sc.exemplo.domain.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {
	
	Optional<Veiculo> findByPlaca(String cpf);
	
	Optional<Veiculo> findByAnoModelo(int anoModelo);
	
	@Query("SELECT v FROM Veiculo v WHERE v.valorDiaria BETWEEN :menor AND :maior")
	public List<Veiculo> listarPorValorEntre(@Param("menor") int menor, @Param("maior") int maior);
}
