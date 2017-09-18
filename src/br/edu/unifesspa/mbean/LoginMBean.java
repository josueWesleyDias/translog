package br.edu.unifesspa.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unifesspa.model.dao.UsuarioDao;
import br.edu.unifesspa.model.entidade.Usuario;
import br.edu.unifesspa.service.Redirect;
import br.edu.unifesspa.service.Session;

@ManagedBean
@RequestScoped
public class LoginMBean {

	private Usuario usuario = new Usuario();

	public void buscarLogin() {
		UsuarioDao usuarioDao = new UsuarioDao(HelperJSF.getEntityManagerInView());
		this.setUsuario(usuarioDao.findByLoginAndPassword(this.getUsuario()));
	}

	public String logar() {
		buscarLogin();
		if (this.getUsuario() != null) {
			Session.addSession("usuario", getUsuario());
			Redirect.redirectTo("app/");
		}
		return null;
	}
	
	public Usuario getUsuarioSession() {
		return (Usuario) Session.getSession("usuario");
	}
	
	public void sair() {
		Session.setSession("usuario", null);
		Redirect.redirectTo("/translog");
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}