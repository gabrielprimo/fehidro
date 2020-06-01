package fehidro.control;

import java.io.Serializable;
//import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fehidro.model.Avaliacao;
import fehidro.model.Relatorio;
import fehidro.rest.client.AvaliacaoRESTClient;

@ManagedBean(name="relatorioFinal")
@SessionScoped
public class RelatorioFinalBean implements Serializable {
	//TODO: Substituir por versão nova (ver RelatorioParcialBean)
	private static final long serialVersionUID = 1L;
	private Relatorio relatorio;
	private AvaliacaoRESTClient rest;
	
	public RelatorioFinalBean() {
		System.out.println("===========Metodo gerar - R Final===============");
		List<Avaliacao> avaliacoes = rest.findAll();//FIXME: Substituir por metodo mais apropriado + considerar data
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
		return "/relatorio/relatorioFinal";
	}
	
}
