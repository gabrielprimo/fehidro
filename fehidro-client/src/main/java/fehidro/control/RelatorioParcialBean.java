package fehidro.control;

import java.io.Serializable;
//import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import fehidro.model.Avaliacao;
import fehidro.model.Relatorio;
import fehidro.rest.client.AvaliacaoRESTClient;

@ManagedBean(name="relatorioParcial")
@ViewScoped
public class RelatorioParcialBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Relatorio relatorio;
	private AvaliacaoRESTClient rest;
	
	
	public Relatorio getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(Relatorio relatorio) {
		this.relatorio = relatorio;
	}

	public RelatorioParcialBean() {
		relatorio = new Relatorio();
		rest  = new AvaliacaoRESTClient();
		List<Avaliacao> avaliacoes = rest.findAll();
		
		this.relatorio.setItensRelatorio(avaliacoes);
	}

	public String getUrl() {
		return "/relatorio/relatorioParcial";
	}
	
}
