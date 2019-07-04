package br.senai.sc.exemplo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "veiculo")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idveiculo")
	private Long idVeiculo;
	
	@Column(name="marca", nullable=false, length=100)
	@NotBlank(message="A marca é obrigatória!")
	@Size(max=100, message="A marca deve conter no máximo 100 caracteres!")
	private String marca;
	
	@Column(name="modelo", nullable=false, length=100)
	@NotBlank(message="O modelo é obrigatório!")
	@Size(max=100, message="O modelo deve conter no máximo 100 caracteres")
	private String modelo;
	
	@Column(name="anomodelo", nullable=false)
	@NotNull(message="O ano do modelo é obrigatório!")
	private int anoModelo;
	
	@Column(name="cor", nullable=false, length=100)
	@NotBlank(message="A cor é obrigatória")
	@Size(max=100, message="A cor deve conter no máximo 100 caracteres")
	private String cor;
	
	@Column(name = "placa", nullable = false, length = 7, unique=true)
	@NotBlank(message = "A Placa do Veículo é obrigatória!")
	@Size(message = "A Placa deve ser o padrão XXX-9999 ou ABC1234", max = 8, min = 7)
	private String placa;
	
	@Column(name="km", nullable=false)
	@NotNull(message="KM é obrigatório")
	private int km;
	
	@Column(name="tipocombustivel", nullable=false, length=100)
	@NotBlank(message="O Tipo do combustivel é obrigatório")
	@Size(max=100, message="O Tipo do combustivel deve conter no máximo 100 caracteres")
	private String tipoCombustivel;
	
	@Column(name="valordiaria", nullable=false)
	@NotNull(message="O valor da diaria é obrigatório")
	private float valorDiaria;
	
	@Column(name="tipoveiculo", nullable=false, length=100)
	@NotBlank(message="O tipo do veiculo é obrigatório")
	@Size(max=100, message="O tipo do veiculo deve conter no máximo 100 caracteres")
	private String tipoVeiculo;

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public String getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public float getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(float valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	
	
}
