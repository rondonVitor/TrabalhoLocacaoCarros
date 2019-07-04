package br.senai.sc.exemplo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcliente")
	private Long idCliente;
	
	@Column(name="nome", nullable=false, length=100)
	@NotBlank(message="O nome é obrigatório!")
	@Size(max=100, message="O nome deve conter no máximo 100 caracteres!")
	private String nome;
	
	@Column(name="cpf", nullable=false, length=14, unique=true)
	@NotBlank(message="O CPF é obrigatório!")
	@Size(message="O CPF deve estar no padrão 999.999.999-99", max=14, min=14)
	private String cpf;
	
	@Column(name="rg", nullable=false, length=9)
	@NotBlank(message="O RG é obrigatório!")
	@Size(message="O RG deve estar no padrão 9.999.999!", max=9, min=9)
	private String rg;
	
	@Column(name="naturalidade", nullable=false, length=100)
	@NotBlank(message="A naturalidade é obrigatória!")
	@Size(max=100, message="A naturalidade deve conter no máximo 100 caracteres")
	private String naturalidade;
	
	@Column(name="datanascimento", nullable=false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataNascimento;
	
	@Column(name="numcnh", nullable=false)
	@NotNull(message="O numero da carteira de motorista é obrigatório!")
	private int numCnh;
	
	@Column(name="datavalidadecnh", nullable=false, length=100)
	@NotBlank(message="A data de validade da carteira de motorista é obrigatória!")
	@Size(max=100, message="A data de validade da carteira de motorista deve conter no máximo 100 caracteres")
	private String dataValidadeCnh;
	
	@Column(name="tipolicenca", nullable=false, length=100)
	@NotBlank(message="O tipo de licença é obrigatória!")
	@Size(max=100, message="O tipo de licença deve conter no máximo 100 caracteres")
	private String tipoLicenca;
	
	@Column(name="enderecocompleto", nullable=false, length=100)
	@NotBlank(message="O Endereço é obrigatório!")
	@Size(max=100, message="O Endereço deve conter no máximo 100 caracteres")
	private String enderecoCompleto;
	
	@Column(name = "telefone", nullable = false, length = 15)
    @NotBlank(message = "O Telefone é Obrigatório")
    @Size(message = "O Telefone deve estar no padrão (99) 99999-9999", max = 15, min = 14)
    @JsonFormat(pattern = "(99) 99999-9999")
    private String telefone;
	
	@Column(name="email", nullable=false, length=100, unique=true)
	@NotBlank(message="O e-mail é obrigatório")
	@Size(max=100, message="O e-mail deve conter no máximo 100 caracteres!")
	@Email(message="Formato de e-mail inválido!")
	private String email;
	
	@Column(name="profissao", nullable=false, length=100)
	@NotBlank(message="A profissão é obrigatória!")
	@Size(max=100, message="A profissão deve conter no máximo 100 caracteres")
	private String profissao;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getNumCnh() {
		return numCnh;
	}

	public void setNumCnh(int numCnh) {
		this.numCnh = numCnh;
	}

	public String getDataValidadeCnh() {
		return dataValidadeCnh;
	}

	public void setDataValidadeCnh(String dataValidadeCnh) {
		this.dataValidadeCnh = dataValidadeCnh;
	}

	public String getTipoLicenca() {
		return tipoLicenca;
	}

	public void setTipoLicenca(String tipoLicenca) {
		this.tipoLicenca = tipoLicenca;
	}

	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}

	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}


	
	
}
