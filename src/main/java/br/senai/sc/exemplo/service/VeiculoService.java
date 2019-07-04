package br.senai.sc.exemplo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.exemplo.domain.Veiculo;
import br.senai.sc.exemplo.exceptions.CustomRuntimeException;
import br.senai.sc.exemplo.repositories.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public Veiculo salvar(Veiculo veiculo) {
		Optional<Veiculo> veiculoOptional = this.veiculoRepository.findByPlaca(veiculo.getPlaca());
		if (veiculoOptional.isPresent()) {
			Veiculo veiculoPlaca = veiculoOptional.get();
			if (veiculo.getIdVeiculo() == null || 
					veiculo.getIdVeiculo() != veiculoPlaca.getIdVeiculo()) {
				throw new CustomRuntimeException("Placa", "Placa já cadastrado!");
			}
		}
		veiculoOptional = this.veiculoRepository.findByAnoModelo(veiculo.getAnoModelo());
	    if (veiculoOptional.isPresent()) {
	      Veiculo veiculoAnoVeiculo = veiculoOptional.get();
	      if (veiculo.getIdVeiculo() == null || veiculoAnoVeiculo.getIdVeiculo() > 2010) {
	        throw new CustomRuntimeException("AnoModelo", "O ano do veículo precisa ser MAIOR que 2010");
	      }
	    }
		return this.veiculoRepository.save(veiculo);
	}
	
	public Veiculo buscarPorId(Long id) {
		if (id == null) {
			throw new CustomRuntimeException("Id", "Não foi informado um ID para a consulta!");
		}
		Optional<Veiculo> veiculo = this.veiculoRepository.findById(id);
		if (veiculo.isPresent()) {
			return veiculo.get();
		}
		return null;
	}
	
	public Veiculo buscarPorPlaca(String placa) {
		if (placa == null) {
			throw new CustomRuntimeException("Placa", "Não foi informado uma placa para a consulta!");
		}
		Optional<Veiculo> veiculo = this.veiculoRepository.findByPlaca(placa);
		if (veiculo.isPresent()) {
			return veiculo.get();
		}
		return null;
	}
	
	public void delete(Long id) {
		this.veiculoRepository.deleteById(id);
	}
	
	public Iterable<Veiculo> buscarTodos() {
		return this.veiculoRepository.findAll();
	}
}
