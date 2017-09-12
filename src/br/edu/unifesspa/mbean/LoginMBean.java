package br.edu.unifesspa.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unifesspa.model.dao.UsuarioDao;
import br.edu.unifesspa.model.entidade.Usuario;
import br.edu.unifesspa.persistence.PersistenceUtil;
import br.edu.unifesspa.service.Redirect;

@ManagedBean
@RequestScoped
public class LoginMBean {

	private Usuario usuario = new Usuario();

	public void buscarLogin() {
		UsuarioDao usuarioDao = new UsuarioDao(PersistenceUtil.getEntityManager());
		this.setUsuario(usuarioDao.findByLoginAndPassword(this.getUsuario()));
		usuarioDao.close();
	}

	public void logar() {
		buscarLogin();
		if (this.getUsuario() != null) {
			Redirect.redirectTo("app/");
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}