package fehidro.control;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fehidro.model.Usuario;
import fehidro.rest.client.UsuarioRESTClient;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	
	public LoginBean() {
		setUsuario(new Usuario());
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String index() {
		return "/login/index";		
	}
	
	public String realizarLogin(Usuario usuario) {
		
		/*if (usuario != null) 
		{
			//obter usuario por login e senha da usuarioDAO
			UsuarioRESTClient rest = new UsuarioRESTClient();

			return "/home/index";
		}*/
		
		FacesContext.getCurrentInstance().addMessage("submitLogin", new FacesMessage("Erro: login/senha inválidos!"));
		return null;
	}

}
