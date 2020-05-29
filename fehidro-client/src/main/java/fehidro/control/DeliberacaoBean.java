package fehidro.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import fehidro.model.Cronograma;
import fehidro.model.Deliberacao;
import fehidro.model.Etapa;
import fehidro.rest.client.DeliberacaoRESTClient;

@ManagedBean
@SessionScoped
public class DeliberacaoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private DeliberacaoRESTClient restDeliberacao;
	
	private Deliberacao deliberacao;
	private List<Deliberacao> deliberacoes;
	private List<SelectItem> responsaveis;
	
	private String consulta;
	private int numeroEtapaNovoCronograma;
	private Long idDeliberacao;
		
	public DeliberacaoBean() {
		List<Etapa> e = new ArrayList<Etapa>();
		
		Deliberacao d = new Deliberacao();
		d.setEtapas(e);
		
		this.restDeliberacao = new DeliberacaoRESTClient();
		this.setDeliberacao(d);
		this.setDeliberacoes(this.restDeliberacao.findAll());
		this.setResponsaveis();
	}
	
	public Deliberacao getDeliberacao() {
		return deliberacao;
	}
	public void setDeliberacao(Deliberacao deliberacao) {
		this.deliberacao = deliberacao;
	}
	public List<Deliberacao> getDeliberacoes() {
		return deliberacoes;
	}
	public void setDeliberacoes(List<Deliberacao> deliberacoes) {
		this.deliberacoes = deliberacoes;
	}
	public String getConsulta() {
		return consulta;
	}
	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}
	
	public int getNumeroEtapaNovoCronograma() {
		return numeroEtapaNovoCronograma;
	}
	public void setNumeroEtapaNovoCronograma(int numeroEtapaNovoCronograma) {
		this.numeroEtapaNovoCronograma = numeroEtapaNovoCronograma;
	}
	public List<SelectItem> getResponsaveis() {
		return responsaveis;
	}
	public void setResponsaveis() {
		List<SelectItem> responsaveis = new ArrayList<>();
		responsaveis.add(new SelectItem("1", "Secretaria Executiva"));
		responsaveis.add(new SelectItem("2", "CT-PG"));
		responsaveis.add(new SelectItem("3", "CT-PG / Secretaria Executiva"));
		
		this.responsaveis = responsaveis;
	}
	public Long getIdDeliberacao() {
		return idDeliberacao;
	}
	public void setIdDeliberacao(Long idDeliberacao) {
		this.idDeliberacao = idDeliberacao;
	}
	public DeliberacaoRESTClient getRestDeliberacao() {
		return restDeliberacao;
	}

	public void setRestDeliberacao(DeliberacaoRESTClient restDeliberacao) {
		this.restDeliberacao = restDeliberacao;
	}

	
	public String addEtapa() 
	{
		Deliberacao d = this.getDeliberacao();
		
		if (d == null) 
		{
			d = new Deliberacao();
			List<Etapa> etapas = new ArrayList<>();
			d.setEtapas(etapas);
		}
		
		List<Etapa> e = d.getEtapas();
		
		int qtEtapas = e.size();
		Etapa novaEtapa = new Etapa();
		novaEtapa.setNumero(qtEtapas + 1);
		
		Cronograma cronograma = new Cronograma();
		List<Cronograma> c = new ArrayList<>();
		
		c.add(cronograma);
		novaEtapa.setCronogramas(c);
		
		this.getDeliberacao().getEtapas().add(novaEtapa);
		return null;
	}
	
	public String addCronograma() 
	{		
		Cronograma novoCronograma = new Cronograma();
		this.getDeliberacao().getEtapas().get(getNumeroEtapaNovoCronograma() - 1).getCronogramas().add(novoCronograma);		
		
		return null;
	}
	
	public String salvar() 
	{
		if(deliberacao.getId() == null) 
		{
			this.restDeliberacao.create(deliberacao);
		}
		else 
		{
			this.restDeliberacao.edit(deliberacao);
		}
		
		setDeliberacao(new Deliberacao());
		this.setDeliberacoes(this.restDeliberacao.findAll());
		
		return null;
	}
	
	public String editar() 
	{
		if (getIdDeliberacao() != null) {

			Deliberacao d = this.restDeliberacao.find(getIdDeliberacao());
			setDeliberacao(d);
		}
		
		return "/deliberacao/cadastro?faces-redirect=true";
	}

}
