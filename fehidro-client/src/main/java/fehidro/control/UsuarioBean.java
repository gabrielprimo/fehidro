package fehidro.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import fehidro.model.CTPG;
import fehidro.model.Usuario;
import fehidro.rest.client.UsuarioRESTClient;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private CTPG ctpg;
	private String consulta;
	private List<Usuario> usuarios;
	private List<SelectItem> perfisAcesso;
	private List<SelectItem> instituicoes;
	private UsuarioRESTClient rest;

	public UsuarioBean() {
		this.usuario = new Usuario();
		this.ctpg = new CTPG();
		this.rest = new UsuarioRESTClient();
		this.setUsuarios(rest.findAll());
		this.setPerfisAcesso();
		this.setInstituicoes();
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

	public CTPG getCtpg() {
		return ctpg;
	}

	public void setCtpg(CTPG ctpg) {
		this.ctpg = ctpg;
	}

	public List<SelectItem> getInstituicoes() { 
		return instituicoes;
	}

	public void setInstituicoes() {
		List<SelectItem> instituicoes = new ArrayList<>();
		instituicoes.add(new SelectItem("1", "Sociedade Civil"));
		instituicoes.add(new SelectItem("2", "Municipal"));
		instituicoes.add(new SelectItem("3", "Estadual"));

		this.instituicoes = instituicoes;
	}

	public void setPerfisAcesso() {
		List<SelectItem> perfis = new ArrayList<>();
		perfis.add(new SelectItem("1", "Administrador Secretaria Executiva"));
		perfis.add(new SelectItem("2", "Secretaria(o) Executiva(o)"));
		perfis.add(new SelectItem("3", "Avaliador CT-PG"));

		this.perfisAcesso = perfis;
	}

	public void validaCPF(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String CPF = value.toString();
		
		String msg = "CPF inválido!";

		if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
				CPF.equals("22222222222") || CPF.equals("33333333333") ||
				CPF.equals("44444444444") || CPF.equals("55555555555") ||
				CPF.equals("66666666666") || CPF.equals("77777777777") ||
				CPF.equals("88888888888") || CPF.equals("99999999999") || (CPF.length() != 11)) {
			FacesMessage message = new FacesMessage(msg);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);

		}

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			sm = 0;
			peso = 10;
			for (i=0; i<9; i++) {              
				// converte o i-esimo caractere do CPF em um numero:
				// (48 eh a posicao de '0' na tabela ASCII)         
				num = (int)(CPF.charAt(i) - 48); 
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else dig10 = (char)(r + 48); 

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for(i=0; i<10; i++) {
				num = (int)(CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else dig11 = (char)(r + 48);

			if (!((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))) {
				FacesMessage message = new FacesMessage(msg);
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		} catch (Exception erro) {
			FacesMessage message = new FacesMessage(msg);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}
	
	
	public String consultar() {
		//		UsuarioRESTClient rest = new UsuarioRESTClient();
		//		if (consulta != null && !consulta.trim().isEmpty()) {
		//
		//		}
		//		else {
		//			//this.setUsuarios(rest.findAll());
		//		}
		return null;
	}

	public String salvar() {
		if (usuario.getId() == null) {
			this.rest.create(usuario);
			usuario = new Usuario();			
		}
		else {
			usuario = this.rest.edit(usuario);
		}

		return null;		
	}
	
	public String editar() 
	{
		if (usuario.getId() != null) {
			usuario = this.rest.find(usuario.getId());			
		}
		
		return "/usuario/cadastro?faces-redirect=true";
	}
}
