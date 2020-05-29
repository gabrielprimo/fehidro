package fehidro.control;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	private UsuarioRESTClient rest;

	public LoginBean() {
		setUsuario(new Usuario());
		this.rest = new UsuarioRESTClient();
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

	public String realizarLogin() { 
		FacesContext context = FacesContext.getCurrentInstance();

		if (usuario != null && usuario.getLogin() != null) 
		{
			Usuario user = rest.obterPorLogin(usuario.getLogin());

			if (user != null && user.getSenha().equals(usuario.getSenha())) 
			{
				return "/deliberacao/index?faces-redirect=true";
			} 
			else 
			{
				context.addMessage("formLogin:msgLogin", new FacesMessage("Erro: login/senha inválidos!"));
				context.getExternalContext().getFlash().setKeepMessages(true);
				return null;
			}
		} 
		else 
		{
			context.addMessage("formLogin:msgLogin", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Login", "Erro: login/senha inválidos!"));
			context.getExternalContext().getFlash().setKeepMessages(true);
			return null;
		}
	}
	
	private boolean confereSenha(String senhaInformada, String senhaBase) throws Exception {
		String senhaHash = "";
		try 
		{
			MessageDigest algorithm;
			algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(senhaInformada.getBytes("UTF-8"));
			StringBuilder strSenha = new StringBuilder();
		
			for (byte b : messageDigest) {
				strSenha.append(String.format("%02X", 0xFF & b));
			}
			
			senhaHash = strSenha.toString();
		
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw e;
		}
		
		return senhaHash.equals(senhaBase);
		
	}
}
