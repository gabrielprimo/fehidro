package fehidro.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import fehidro.model.Instituicao;
import fehidro.model.enums.TipoInstituicaoEnum;
import fehidro.rest.client.InstituicaoRESTClient;

@ManagedBean
@SessionScoped
public class InstituicaoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private InstituicaoRESTClient restInstituicao;
	
	private Instituicao instituicao;
	private List<Instituicao> instituicoes;
	private List<SelectItem> tipos;

	private String consulta;
	private Long idInstituicao;
	
	public InstituicaoBean() {
		startView(true);
	}
	
	public String cadastro() {
		startView(true);
		return "/instituicao/cadastro?faces-redirect=true";
	}

	public String index() 
	{
		startView(true);
		return "/instituicao/index?faces-redirect=true";
	}


	public String salvar() {
		this.restInstituicao = new InstituicaoRESTClient();
		
		if (getInstituicao().getId() == null) 
		{
			restInstituicao.create(getInstituicao());
		}
		else 
		{
			restInstituicao.edit(getInstituicao());
		}
		
		startView(true);		
		
		return null;		
	}

	public String editar() 
	{
		if (getIdInstituicao() != null) {

			Instituicao i = this.restInstituicao.find(getIdInstituicao());
			setInstituicao(i);
		}

		return "/instituicao/cadastro?faces-redirect=true";
	}
	
	public void startView(boolean setInfo) {
		this.setRestInstituicao();
		this.setInstituicao(new Instituicao());
		this.idInstituicao = null;
		
		if (setInfo)
			setInfo();
	}
	
	public void setInfo() {
		this.setInstituicoes();
		this.setTipos();
	}
	
	public InstituicaoRESTClient getRestInstituicao() {
		return restInstituicao;
	}

	public void setRestInstituicao() {
		this.restInstituicao = new InstituicaoRESTClient();
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public List<Instituicao> getInstituicoes() {
		return instituicoes;
	}

	public void setInstituicoes() {
		this.instituicoes = restInstituicao.findAll();
	}

	public List<SelectItem> getTipos() {
		return tipos;
	}

	public void setTipos() {
		List<SelectItem> tipos = new ArrayList<>();
		tipos.add(new SelectItem("1", "Municípios e entidades municipais"));
		tipos.add(new SelectItem("2", "Órgãos e entidades estaduais"));
		tipos.add(new SelectItem("3", "Entidades da sociedade civil sem finalidades lucrativas"));
		tipos.add(new SelectItem("4", "Usuários de recursos hídricos com finalidades lucrativas"));

		this.tipos = tipos;
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	public Long getIdInstituicao() {
		return idInstituicao;
	}

	public void setIdInstituicao(Long idInstituicao) {
		this.idInstituicao = idInstituicao;
	}
	
	public TipoInstituicaoEnum[] getTipoInstituicao(){
		return TipoInstituicaoEnum.values();
	}

}
