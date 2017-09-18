package br.edu.unifesspa.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifesspa.model.entidade.Peso;

public class PesoDao {
	private EntityManager manager;

	public PesoDao(EntityManager manager) {
		this.manager = manager;
	}

	public List<Peso> findAll() {
		return this.manager.createQuery("FROM Peso", Peso.class).getResultList();
	}

	public Peso findById(int id) {
		return this.manager.find(Peso.class, id);
	}
	
}
