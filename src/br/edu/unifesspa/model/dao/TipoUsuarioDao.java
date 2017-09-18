package br.edu.unifesspa.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifesspa.model.entidade.TipoUsuario;

public class TipoUsuarioDao {
	private EntityManager manager;

	public TipoUsuarioDao(EntityManager manager) {
		this.manager = manager;
	}

	public List<TipoUsuario> findAll() {
		return this.manager.createQuery("FROM TipoUsuario", TipoUsuario.class).getResultList();
	}

	public TipoUsuario findById(int id) {
		return this.manager.find(TipoUsuario.class, id);
	}
	
}
