package br.senai.sc.exemplo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.exemplo.domain.Cliente;
import br.senai.sc.exemplo.exceptions.CustomRuntimeException;
import br.senai.sc.exemplo.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		Optional<Cliente> clienteOptional = this.clienteRepository.findByCpf(cliente.getCpf());
		if (clienteOptional.isPresent()) {
			Cliente clienteCpf = clienteOptional.get();
			if (cliente.getIdCliente() == null || 
					cliente.getIdCliente() != clienteCpf.getIdCliente()) {
				throw new CustomRuntimeException("cpf", "CPF já cadastrado!");
			}
		}
		clienteOptional = this.clienteRepository.findByEmail(cliente.getEmail());
		if (clienteOptional.isPresent()) {
			Cliente clienteEmail = clienteOptional.get();
			if (cliente.getIdCliente() == null ||
					cliente.getIdCliente() != clienteEmail.getIdCliente()) {
				throw new CustomRuntimeException("email", "E-mail já cadastrado!");
			}
		}
		return this.clienteRepository.save(cliente);
	}
	
	public Cliente buscarPorId(Long id) {
		if (id == null) {
			throw new CustomRuntimeException("Id", "Não foi informado um ID para a consulta!");
		}
		Optional<Cliente> cliente = this.clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return cliente.get();
		}
		return null;
	}
	
	public Cliente buscarPorCpf(String cpf) {
		if (cpf == null) {
			throw new CustomRuntimeException("CPF", "Não foi informado um CPF para a consulta!");
		}
		Optional<Cliente> cliente = this.clienteRepository.findByCpf(cpf);
		if (cliente.isPresent()) {
			return cliente.get();
		}
		return null;
	}
	
	public Cliente buscarPorNome(String nome) {
		if (nome == null) {
			throw new CustomRuntimeException("Nome", "Não foi informado um nome para a consulta!");
		}
		Optional<Cliente> cliente = this.clienteRepository.buscarPorNome(nome);
		if (cliente.isPresent()) {
			return cliente.get();
		}
		
		return null;
	}
	
	public Iterable<Cliente> buscarTodos() {
		return this.clienteRepository.findAll();
	}
}
