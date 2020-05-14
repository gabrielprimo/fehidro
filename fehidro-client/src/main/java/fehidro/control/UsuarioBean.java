package fehidro.control;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fehidro.model.Usuario;
import fehidro.rest.client.UsuarioRESTClient;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private List<Usuario> usuarios;


	private String consulta;

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
