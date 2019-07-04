package br.senai.sc.exemplo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sc.exemplo.components.MapValidationComponent;
import br.senai.sc.exemplo.domain.Cliente;
import br.senai.sc.exemplo.service.ClienteService;


@RestController
@RequestMapping("/atividade/cliente")
@CrossOrigin
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@Autowired
	private MapValidationComponent mapValidationComponent;
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid Cliente cliente, BindingResult result) {
		ResponseEntity<?> errors = this.mapValidationComponent.mapValidationError(result);
		if (errors != null) {
			return errors;
		}
		Cliente clienteSalvo = this.clienteService.salvar(cliente);
		return new ResponseEntity<Cliente>(clienteSalvo, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-por-id/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Cliente cliente = this.clienteService.buscarPorId(id);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-por-cpf/{cpf}")
	public ResponseEntity<?> buscarPorCpf(@PathVariable String cpf) {
		Cliente cliente = this.clienteService.buscarPorCpf(cpf);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@GetMapping("/buscar-por-nome/{nome}")
	public ResponseEntity<?> buscarPorNome(@PathVariable String nome) {
		Cliente cliente = this.clienteService.buscarPorNome(nome);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<?> listarTodos() {
		Iterable<Cliente> clientes = this.clienteService.buscarTodos();
		return new ResponseEntity<Iterable<Cliente>>(clientes, HttpStatus.OK);
	}
}
