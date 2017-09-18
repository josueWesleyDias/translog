package br.edu.unifesspa.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifesspa.model.entidade.TipoUsuario;
import br.edu.unifesspa.model.entidade.Usuario;

public class UsuarioDao {
	private EntityManager manager;

	public UsuarioDao(EntityManager manager) {
		this.manager = manager;
	}

	public List<Usuario> findAll() {
		return this.manager.createQuery("FROM Usuario", Usuario.class).getResultList();
	}

	public List<Usuario> findAllTransportadores() {
		String hql = "SELECT u FROM Usuario u WHERE tipoUsuario = :tipoUsuario";
		return manager.createQuery(hql, Usuario.class).setParameter("tipoUsuario", TipoUsuario.TRANSPORTADOR)
				.getResultList();
	}

	public Usuario findById(int id) {
		return this.manager.find(Usuario.class, id);
	}

	public Usuario findByLoginAndPassword(Usuario usuario) {
		String hql = "SELECT u FROM Usuario u WHERE login = :Login and senha = :Senha";
		return manager.createQuery(hql, Usuario.class).setParameter("Login", usuario.getLogin())
				.setParameter("Senha", usuario.getSenha()).getSingleResult();
	}

	public Usuario findByLogin(Usuario usuario) {
		String hql = "SELECT u FROM Usuario u WHERE login = :Login";
		return manager.createQuery(hql, Usuario.class).setParameter("Login", usuario.getLogin()).getSingleResult();
	}

	public Usuario insert(Usuario usuario) {
		manager.persist(usuario);

		return usuario;
	}

}
