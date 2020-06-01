package fehidro.control;

import java.io.Serializable;
//import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fehidro.model.Avaliacao;
import fehidro.model.Relatorio;
import fehidro.rest.client.AvaliacaoRESTClient;

@ManagedBean(name="relatorioParcial")
@SessionScoped
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
		rest  = new AvaliacaoRESTClient();
		System.out.println("===========Metodo gerar - R Parcial===============");
		List<Avaliacao> avaliacoes = rest.findAll();//FIXME: Substituir por metodo mais apropriado + considerar data
		System.out.println("TESTE!!!!!!!!!!!!!!!!!!!");
		if(avaliacoes == null)//TODO: Remover, Mensagem de teste
		{
			System.out.println(">>>>>>>>>Avaliacoes eh null");
		}else {
			System.out.println("TEST");
		}
		relatorio.setItensRelatorio(avaliacoes);
		System.out.println("===========FIM Metodo gerar===============");
	}

	public String getUrl() {
		return "/relatorio/relatorioParcial";
	}
	
}
