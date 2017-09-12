package br.edu.unifesspa.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unifesspa.model.entidade.Endereco;

@ManagedBean
@RequestScoped
public class CargaMBean {
	
	private Endereco enderecoInicial = new Endereco();

	private Endereco enderecoFinal = new Endereco();
	
	public String cadastrar() {
		return null;
	}
	
	public String header()
	{
		return "/app/";
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
	
}