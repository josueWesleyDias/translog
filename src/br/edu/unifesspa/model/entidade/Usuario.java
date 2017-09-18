package br.edu.unifesspa.model.entidade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	
	@Column(nullable=false, unique=true )
	private String login;
	
	@Column(nullable=false)
	private String senha;
	
	@Column(name="cpf_cnpj")
	private long cpfCnpj;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Parametro paramentro = new Parametro();
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Endereco endereco = new Endereco();
	
	@OneToOne(fetch = FetchType.LAZY)
	private TipoUsuario tipoUsuario = new TipoUsuario();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(long cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public Parametro getParamentro() {
		return paramentro;
	}

	public void setParamentro(Parametro paramentro) {
		this.paramentro = paramentro;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
