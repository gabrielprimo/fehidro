package fehidro.control;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import fehidro.model.Avaliacao;
import fehidro.model.CriterioAvaliacao;
import fehidro.model.Pontuacao;
import fehidro.model.Proposta;
import fehidro.model.SubcriterioAvaliacao;
import fehidro.rest.client.AvaliacaoRESTClient;
import fehidro.rest.client.CriterioAvaliacaoRESTClient;
import fehidro.rest.client.PropostaRESTClient;

@ManagedBean
@SessionScoped
public class AvaliacaoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	//Proposta
	private PropostaRESTClient restProposta;
	private List<Proposta> propostas;
	private Proposta proposta;
	//Subcriterio
	private List<SubcriterioAvaliacao> subcriterios;
	private SubcriterioAvaliacao subcriterio;
	//Criterio
	private CriterioAvaliacaoRESTClient restCriterio;
	private List<CriterioAvaliacao> criterios;
	private CriterioAvaliacao criterio;
	//Pontuacao
	private List<Pontuacao> pontuacoesSubcriterio;
	private Pontuacao pontuacao;
	
	private AvaliacaoRESTClient restAvaliacao;
	private Avaliacao avaliacao;
	private List<Avaliacao> avaliacoes;
	
	
	//CONSTRUTOR
	public AvaliacaoBean() {
		this.restProposta = new PropostaRESTClient();
		this.restCriterio = new CriterioAvaliacaoRESTClient();
		
		this.proposta = new Proposta();
		this.criterio = new CriterioAvaliacao();
		this.subcriterio = new SubcriterioAvaliacao();
		this.pontuacao = new Pontuacao();
		
		//REST
		setPropostas(restProposta.findAll());
		setCriterios(restCriterio.findAll());
	}
	
	public List<CriterioAvaliacao> getCriterios() {
		return criterios;
	}
	public void setCriterios(List<CriterioAvaliacao> criterios) {
		this.criterios = criterios;
	}

	public CriterioAvaliacao getCriterio() {
		return criterio;
	}
	public void setCriterio(CriterioAvaliacao criterio) {
		this.criterio = criterio;
	}

	//List pontuacoes
	public List<Pontuacao> getPontuacoesSubcriterio() {
		return pontuacoesSubcriterio;
	}
	public void setPontuacoesSubcriterio(List<Pontuacao> pontuacoesSubcriterio) {
		this.pontuacoesSubcriterio = pontuacoesSubcriterio;
	}
	
	//Pontuacao
	public Pontuacao getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(Pontuacao pontuacao) {
		this.pontuacao = pontuacao;
	}

	//Lista subcriterios
	public List<SubcriterioAvaliacao> getSubcriterios() {
		return subcriterios;
	}
	public void setSubcriterios(List<SubcriterioAvaliacao> subcriteriosProposta) {
		this.subcriterios = subcriteriosProposta;
	}

	//Subcriterio
	public SubcriterioAvaliacao getSubcriterio() {
		return subcriterio;
	}
	public void setSubcriterio(SubcriterioAvaliacao subcriterio) {
		this.subcriterio = subcriterio;
		this.pontuacao = null;//Reset, para evitar passar valor errado
		this.pontuacoesSubcriterio = subcriterio.getPontuacoes();//Atualiza pontuacoes de acordo com o subcriterio
	}

	//Lista de propostas
	public List<Proposta> getPropostas() {
		return propostas;
	}
	public void setPropostas(List<Proposta> propostas) {
		this.propostas = propostas;
	}
	
	//Proposta
	public Proposta getProposta() {
		return proposta;
	}
	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}


	//Avaliacao
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	//List Avaliacoes
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public String salvar()
	{
		avaliacao.setCriterio(criterio);
		avaliacao.setSubcriterio(subcriterio);
		avaliacao.setNota(pontuacao);
		avaliacao.setProposta(proposta);
		if(this.avaliacao.getId() == null)
		{
			//Não existe? Cria.
			this.restAvaliacao.create(avaliacao);
		}
		else
		{
			//Ja existe? Edita.
			this.restAvaliacao.edit(avaliacao);
		}
		
		this.setAvaliacao(new Avaliacao());
		this.setAvaliacoes(this.restAvaliacao.findAll());//TODO: possivelmente desnecessario
		
		return null;
	}
	
}
