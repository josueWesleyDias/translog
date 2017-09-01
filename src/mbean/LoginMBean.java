package mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.UsuarioDao;
import entidade.Usuario;
import persistence.PersistenceUtil;

@ManagedBean
@RequestScoped
public class LoginMBean {
	private Usuario usuario;

	public String buscarLogin() {
		UsuarioDao usuarioDao = new UsuarioDao(PersistenceUtil.getEntityManager());
		this.setUsuario(usuarioDao.findByLoginAndPassword(this.getUsuario()));
		usuarioDao.close();
		return null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}

// @ManagedBean
// @RequestScoped
// private Categoria categoriaBusca;
//
// private List<SelectItem> categorias;
//
// public CategoriaMBean()
// {
// this.setCategoriaBusca(new Categoria());
// this.categorias = new ArrayList<SelectItem>();
// }
//
// public String buscar()
// {
// CategoriaRepository repository = new
// CategoriaRepository(PersistenceUtil.getEntityManager());
// this.categoriaBusca = repository.findById(this.categoriaBusca.getId());
// this.categoriaBusca.getNoticias().iterator();
// repository.close();
// return null;
// }
//
// public String entrarRelatorio()
// {
// return "/app/categoria/index";
// }
//
// private void popularCombo()
// {
// if (this.categorias.isEmpty())
// {
// CategoriaRepository repository = new
// CategoriaRepository(PersistenceUtil.getEntityManager());
// List<Categoria> categorias = repository.findAll();
// repository.close();
//
// for (Categoria categoria : categorias) {
// this.categorias.add(new SelectItem(categoria.getId(), categoria.getNome()));
// }
// }
//
// }
//
// public List<SelectItem> getComboCategoria()
// {
// popularCombo();
// return this.categorias;
// }
//
