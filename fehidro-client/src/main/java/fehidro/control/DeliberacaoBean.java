package fehidro.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fehidro.model.Cronograma;
import fehidro.model.Deliberacao;
import fehidro.model.Etapa;

@ManagedBean
@SessionScoped
public class DeliberacaoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Deliberacao deliberacao;
	private List<Deliberacao> deliberacoes;
	private String consulta;
	
	public DeliberacaoBean() {
		this.deliberacoes = new ArrayList<Deliberacao>();
		Deliberacao testeDeliberacao = new Deliberacao();
		List<Deliberacao> d = new ArrayList<Deliberacao>();
		Etapa testeEtapa = new Etapa();
		List<Etapa> e = new ArrayList<Etapa>();
		Cronograma testeCronograma = new Cronograma();
		List<Cronograma> c = new ArrayList<>();
		
		testeCronograma.setDataInicio(new Date());
		testeCronograma.setDataFim(new Date());
		c.add(testeCronograma);
		c.add(testeCronograma);
		
		testeEtapa.setNumero(1);
		testeEtapa.setDescricao("etapa 1");
		testeEtapa.setCronogramas(c);
		e.add(testeEtapa);
		e.add(testeEtapa);
		
		testeDeliberacao.setAno(2010);
		testeDeliberacao.setNumero(10);
		testeDeliberacao.setEtapas(e);
		
		d.add(testeDeliberacao);
		d.add(testeDeliberacao);
		d.add(testeDeliberacao);
		d.add(testeDeliberacao);
		
		this.setDeliberacoes(d);
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

}
