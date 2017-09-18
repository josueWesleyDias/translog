package br.edu.unifesspa.model.entidade;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;

import br.edu.unifesspa.service.EnviarEmail;

@Entity
public class Carga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String obs;

	@Column
	private float tamanho;

	@Column(name = "data_entrega")
	private Date dataEntrega;

	@OneToOne(fetch = FetchType.LAZY)
	private Peso peso = new Peso();

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Endereco enderecoInicial = new Endereco();

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Endereco enderecoFinal = new Endereco();

	@OneToOne(fetch = FetchType.LAZY)
	private Usuario usuario = new Usuario();
	
	@PostPersist
	public void enviarEmail() {
		EnviarEmail enviarEmail = new EnviarEmail();
		enviarEmail.enviar();
	}

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

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Peso getPeso() {
		return peso;
	}

	public void setPeso(Peso peso) {
		this.peso = peso;
	}

	public Endereco getEnderecoInicial() {
		return enderecoInicial;
	}

	public void setEnderecoInicial(Endereco enderecoInicial) {
		this.enderecoInicial = enderecoInicial;
	}

	public Endereco getEnderecoFinal() {
		return enderecoFinal;
	}

	public void setEnderecoFinal(Endereco enderecoFinal) {
		this.enderecoFinal = enderecoFinal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
