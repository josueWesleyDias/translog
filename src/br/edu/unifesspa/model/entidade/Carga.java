package br.edu.unifesspa.model.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Carga {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String obs;
	
	@Column
	private float tamanho;
	
	@Column(name="data_inicio")
	private Date dataInicial;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Peso peso;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Endereco enderencoInicial;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Endereco enderencoFinal;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Usuario usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public float getTamanho() {
		return tamanho;
	}

	public void setTamanho(float tamanho) {
		this.tamanho = tamanho;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicio(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Peso getPeso() {
		return peso;
	}

	public void setPeso(Peso peso) {
		this.peso = peso;
	}

	public Endereco getEnderencoInicial() {
		return enderencoInicial;
	}

	public void setEnderencoInicial(Endereco enderencoInicial) {
		this.enderencoInicial = enderencoInicial;
	}

	public Endereco getEnderencoFinal() {
		return enderencoFinal;
	}

	public void setEnderencoFinal(Endereco enderencoFinal) {
		this.enderencoFinal = enderencoFinal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
