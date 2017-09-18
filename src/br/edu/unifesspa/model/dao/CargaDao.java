package br.edu.unifesspa.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifesspa.model.entidade.Carga;

public class CargaDao {
	private EntityManager manager;

	public CargaDao(EntityManager manager) {
		this.manager = manager;
	}

	public List<Carga> findAll() {
		return this.manager.createQuery("FROM Carga", Carga.class).getResultList();
	}

	public Carga findById(int id) {
		return this.manager.find(Carga.class, id);
	}

	public Carga insert(Carga carga) {
		manager.persist(carga);
		
		return carga;
	}

}
