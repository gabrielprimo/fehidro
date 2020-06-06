package fehidro.control;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fehidro.model.Pontuacao;
import fehidro.model.Proposta;
import fehidro.model.SubcriterioAvaliacao;
import fehidro.rest.client.PropostaRESTClient;
import fehidro.rest.client.SubcriterioAvaliacaoRESTClient;

@ManagedBean
@SessionScoped
public class AvaliacaoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private PropostaRESTClient restProposta;
	private List<Proposta> propostas;
	private Proposta proposta;
	private SubcriterioAvaliacaoRESTClient restSubcriterio;
	private List<SubcriterioAvaliacao> subcriterios;
	private SubcriterioAvaliacao subcriterio;
	private List<Pontuacao> pontuacoesSubcriterio;
	private Pontuacao pontuacao;
	
	//CONSTRUTOR
	public AvaliacaoBean() {
		this.restProposta = new PropostaRESTClient();
		this.restSubcriterio = new SubcriterioAvaliacaoRESTClient();
		//REST
		this.propostas = restProposta.findAll();
		setSubcriterios(restSubcriterio.findAll());
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


	public String salvar()
	{
		if(this.proposta.getId() == null)
		{
			//Não existe? Cria.
			this.restProposta.create(proposta);
		}
		else
		{
			//Ja existe? Edita.
			this.restProposta.edit(proposta);
		}
		
		this.setProposta(new Proposta());
		this.setPropostas(this.restProposta.findAll());
		
		return null;
	}
	
}
