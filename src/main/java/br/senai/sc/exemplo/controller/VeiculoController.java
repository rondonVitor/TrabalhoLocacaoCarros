package br.senai.sc.exemplo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sc.exemplo.components.MapValidationComponent;
import br.senai.sc.exemplo.domain.Veiculo;
import br.senai.sc.exemplo.service.VeiculoService;

@RestController
@RequestMapping("/atividade/veiculo")
@CrossOrigin
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private MapValidationComponent mapValidationComponent;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid Veiculo veiculo, BindingResult result) {
		ResponseEntity<?> errors = this.mapValidationComponent.mapValidationError(result);
		if (errors != null) {
			return errors;
		}
		Veiculo veiculoSalvo = this.veiculoService.salvar(veiculo);
		return new ResponseEntity<Veiculo>(veiculoSalvo, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePorId(@PathVariable Long id) {
		this.veiculoService.delete(id);
		return new ResponseEntity<String>("Deletado com sucesso!", HttpStatus.OK);
	}
	
	@GetMapping("/buscar-por-id/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Veiculo veiculo = this.veiculoService.buscarPorId(id);
		return new ResponseEntity<Veiculo>(veiculo, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-por-placa/{placa}")
	public ResponseEntity<?> buscarPorPlaca(@PathVariable String placa) {
		Veiculo veiculo = this.veiculoService.buscarPorPlaca(placa);
		return new ResponseEntity<Veiculo>(veiculo, HttpStatus.OK);
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<?> listarTodos() {
		Iterable<Veiculo> veiculos = this.veiculoService.buscarTodos();
		return new ResponseEntity<Iterable<Veiculo>>(veiculos, HttpStatus.OK);
	}
}
