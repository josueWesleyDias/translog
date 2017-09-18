package br.edu.unifesspa.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import br.edu.unifesspa.model.dao.CargaDao;
import br.edu.unifesspa.model.dao.PesoDao;
import br.edu.unifesspa.model.entidade.Carga;
import br.edu.unifesspa.model.entidade.Peso;
import br.edu.unifesspa.model.entidade.Usuario;
import br.edu.unifesspa.service.Redirect;
import br.edu.unifesspa.service.Session;
import br.edu.unifesspa.mbean.HelperJSF;

@ManagedBean
@RequestScoped
public class CargaMBean {
	
	private Carga carga = new Carga();
	
	public List<SelectItem> getComboAllPeso() {
		PesoDao dao = new PesoDao(HelperJSF.getEntityManagerInView());
		List<Peso> pesos = dao.findAll();
		List<SelectItem> combo = new ArrayList<>();
		
		for (Peso peso : pesos) {
			combo.add(new SelectItem(peso.getId(), peso.getDescricao()));
		}
		
		return combo;
	}
	
	public String avancar() {
		Session.addSession("carga", getCarga());
		return header();
	}
	
	public void cadastrar() {
		CargaDao cargaDao = new CargaDao(HelperJSF.getEntityManagerInView());
		Usuario usuario = (Usuario)Session.getSession("usuario");
		Carga carga = (Carga)Session.getSession("carga");
		carga.setEnderecoInicial(getCarga().getEnderecoInicial());
		carga.setEnderecoFinal(getCarga().getEnderecoFinal());
		carga.setUsuario(usuario);
		cargaDao.insert(carga);
		
		HelperJSF.adicionarMensagemSucesso("Carga cadastrada com sucesso.\nAgurade as propostas!");
		Redirect.redirectTo("index.xhtml");
	}
	
	public String header()
	{
		return "/app/form_endereco.xhtml";
	}
	
	public Carga getCarga() {
		return carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
	}
	
}