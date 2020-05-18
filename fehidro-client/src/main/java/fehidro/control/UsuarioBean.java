package fehidro.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import fehidro.model.Usuario;
import fehidro.rest.client.UsuarioRESTClient;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private List<Usuario> usuarios;
	private String consulta;
	
	private List<SelectItem> perfisAcesso;

	public UsuarioBean() {
		this.usuarios = new ArrayList<Usuario>();
		Usuario teste = new Usuario();
		teste.setNome("testeeee");
		teste.setId((long) 2);
		teste.setLogin("usr.teste"); 

		List<Usuario> testes = new ArrayList<Usuario>();
		testes.add(teste);
		testes.add(teste);
		testes.add(teste); 
		
		this.setUsuarios(testes);
		this.setPerfisAcesso();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public List<SelectItem> getPerfisAcesso() {
		 return this.perfisAcesso;
	}
	
	public void setPerfisAcesso() {
		List<SelectItem> perfis = new ArrayList<>();
		perfis.add(new SelectItem("1", "Administrador Secretaria Executiva"));
		perfis.add(new SelectItem("2", "Secretaria(o) Executiva(o)"));
		perfis.add(new SelectItem("3", "Avaliador CT-PG"));

		this.perfisAcesso = perfis;
	}

	public String consultar() {
		UsuarioRESTClient rest = new UsuarioRESTClient();
		if (consulta != null && !consulta.trim().isEmpty()) {

		}
		else {
			//this.setUsuarios(rest.findAll());
		}
		return null;
	}

	public String gravar() {
		UsuarioRESTClient rest = new UsuarioRESTClient();
		if (usuario.getId() == null) {
			//rest.create(usuario);
			usuario = new Usuario();			
		}
		else {
			//usuario = rest.edit(usuario);
		}
		return null;		
	}

}
