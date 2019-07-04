package br.senai.sc.exemplo.ws;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CursoWs {

	private Long idCurso;

	@NotBlank(message = "O nome do curso é obrigatório!")
	@Size(max = 150, message = "O nome do curso deve conter no máximo 150 caracteres!")
	private String nome;

	@Min(value=1, message = "A carga horária deve ser de no mínimo 1 hora!")
	private int cargaHoraria;

	@NotNull(message = "É obrigatório selecionar um responsável!")
	private Long idResponsavel;

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Long getIdResponsavel() {
		return idResponsavel;
	}

	public void setIdResponsavel(Long idResponsavel) {
		this.idResponsavel = idResponsavel;
	}

}
