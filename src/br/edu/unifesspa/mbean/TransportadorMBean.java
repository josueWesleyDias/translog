package br.edu.unifesspa.mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unifesspa.model.dao.UsuarioDao;
import br.edu.unifesspa.model.entidade.Usuario;
import br.edu.unifesspa.service.Redirect;
import br.edu.unifesspa.mbean.HelperJSF;

@ManagedBean
@RequestScoped
public class TransportadorMBean {
	
	private Usuario usuario = new Usuario();
	
	public List<Usuario> getAllTransportadores() {
		UsuarioDao dao = new UsuarioDao(HelperJSF.getEntityManagerInView());
		return dao.findAllTransportadores();
	}
	
	public String avancar() {
		return header();
	}
	
	public void cadastrar() {
		
		HelperJSF.adicionarMensagemSucesso("Carga cadastrada com sucesso.\nAgurade as propostas!");
		Redirect.redirectTo("index.xhtml");
	}
	
	public String header()
	{
		return "app/form_endereco.xhtml";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}