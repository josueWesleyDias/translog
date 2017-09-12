package br.edu.unifesspa.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unifesspa.model.dao.UsuarioDao;
import br.edu.unifesspa.model.entidade.Endereco;
import br.edu.unifesspa.model.entidade.Usuario;
import br.edu.unifesspa.persistence.PersistenceUtil;

@ManagedBean
@RequestScoped
public class CadastroMBean {
	
	private Usuario usuario = new Usuario();
	
	private Endereco endereco = new Endereco();
	
//	private Validate validate;
	public CadastroMBean() {
//		validate = new Validate();
	}

	public void buscarLogin() {
		UsuarioDao usuarioDao = new UsuarioDao(PersistenceUtil.getEntityManager());
		this.setUsuario(usuarioDao.findByLogin(this.getUsuario()));
		usuarioDao.close();
	}

	public String cadastrar() {
		buscarLogin();
		
//		validate.empty(this.getUsuario().getLogin());
		
		if(this.getUsuario() == null) {
			//avancar
			return header();
		}
		else
			return null;
	}
	
	public String header()
	{
		return "/app/";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}