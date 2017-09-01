package dao;

import java.util.List;

import javax.persistence.EntityManager;
import entidade.Usuario;

public class UsuarioDao {
	private EntityManager manager;

	public UsuarioDao(EntityManager manager) {
		this.manager = manager;
	}

	public List<Usuario> findAll() {
		return this.manager.createQuery("FROM Usuario", Usuario.class).getResultList();
	}

	public Usuario findById(int id) {
		return this.manager.find(Usuario.class, id);
	}
	
	public Usuario findByLoginAndPassword(Usuario usuario) {
		return (Usuario) manager.createQuery("SELECT id, nome, login, senha, cpf_cnpj FROM Usuario WHERE login = :Login and senha = :Senha")
				.setParameter("Login", usuario.getLogin()).setParameter("Senha", usuario.getSenha()).getSingleResult();
	}

	public void close() {
		this.manager.close();
	}
}
