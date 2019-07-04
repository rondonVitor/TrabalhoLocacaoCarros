package br.senai.sc.exemplo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.senai.sc.exemplo.domain.Curso;
import br.senai.sc.exemplo.domain.Matricula;
import br.senai.sc.exemplo.domain.Usuario;
import br.senai.sc.exemplo.exceptions.CustomRuntimeException;
import br.senai.sc.exemplo.repositories.MatriculaRepository;
import br.senai.sc.exemplo.ws.MatriculaWs;

@Service
public class MatriculaService {

	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private CursoService cursoService;
	
	public Matricula salvar(MatriculaWs matriculaWs) {
		Matricula matricula = this.parseMatriculaWsToMatricula(matriculaWs);			
		matricula = this.matriculaRepository.save(matricula);
		return matricula;
	}
	
	private Usuario obterUsuario(Long idUsuario) {
		Usuario usuario = this.usuarioService.buscarPorId(idUsuario);
		if (usuario == null) {
			throw new CustomRuntimeException("usuario", "Usuário não encontrado!");
		}
		return usuario;
	}
	
	private Curso obterCurso(Long idCurso) {
		Curso curso = this.cursoService.buscarPorId(idCurso);
		if (curso == null) {
			throw new CustomRuntimeException("curso", "Curso não encontrado!");
		}
		return curso;
	}
	
	private Matricula parseMatriculaWsToMatricula(MatriculaWs matriculaWs) {
		Usuario usuario = this.obterUsuario(matriculaWs.getIdUsuario());
		Curso curso = this.obterCurso(matriculaWs.getIdCurso());
		Matricula matricula = new Matricula();
		matricula.setDataMatricula(new Date());
		matricula.setIdMatricula(matriculaWs.getIdMatricula());
		matricula.setUsuario(usuario);
		matricula.setValorMatricula(matriculaWs.getValorMatricula());
		matricula.setCurso(curso);
		return matricula;
	}
	
	public List<Matricula> listarMatriculasPaginado(int page, int size) {
		return this.matriculaRepository.listarMatriculasPaginado(PageRequest.of(page, size));
	}
	
	public List<Matricula> buscarMatriculasPorUsuario(Long idUsuario) {
		if (idUsuario == null) {
			throw new CustomRuntimeException("usuario", "É obrigatório informar um usuário");
		}
		List<Matricula> matriculas = this.matriculaRepository.buscarMatriculasPorUsuario(idUsuario);
		return matriculas;
	}
	
	public void remover(Long id) {
		this.matriculaRepository.deleteById(id);
	}
	
}
