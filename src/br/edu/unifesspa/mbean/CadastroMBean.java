package br.edu.unifesspa.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import br.edu.unifesspa.model.dao.TipoUsuarioDao;
import br.edu.unifesspa.model.dao.UsuarioDao;
import br.edu.unifesspa.model.entidade.TipoUsuario;
import br.edu.unifesspa.model.entidade.Usuario;
import br.edu.unifesspa.service.Redirect;
import br.edu.unifesspa.service.Session;

@ManagedBean
@RequestScoped
public class CadastroMBean {

	private Usuario usuario = new Usuario();

	public List<SelectItem> getComboTipoUsuario() {
		TipoUsuarioDao dao = new TipoUsuarioDao(HelperJSF.getEntityManagerInView());
		List<TipoUsuario> tipoUsuarios = dao.findAll();
		List<SelectItem> combo = new ArrayList<SelectItem>();

		for (TipoUsuario tipoUsuario : tipoUsuarios) {
			combo.add(new SelectItem(tipoUsuario.getId(), tipoUsuario.getDescricao()));
		}

		return combo;
	}

	public String cadastrar() {
		UsuarioDao dao = new UsuarioDao(HelperJSF.getEntityManagerInView());
		dao.insert(getUsuario());
		Session.addSession("usuario", getUsuario());
		if(getUsuario().getTipoUsuario().getId() == TipoUsuario.TRANSPORTADOR)
			return "";
		Redirect.redirectTo(header());
		return null;
	}

	public String header() {
		return "app/";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}