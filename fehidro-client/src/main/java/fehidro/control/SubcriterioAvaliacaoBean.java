package fehidro.control;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fehidro.model.SubcriterioAvaliacao;
import fehidro.rest.client.SubcriterioAvaliacaoRESTClient;


@ManagedBean
@SessionScoped
public class SubcriterioAvaliacaoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private SubcriterioAvaliacaoRESTClient restSubcriterioAvaliacao;
	private List<SubcriterioAvaliacao> subcriterioAvaliacaos;
	private SubcriterioAvaliacao subcriterioAvaliacao;
	
	//CONSTRUTOR
	public SubcriterioAvaliacaoBean() {
		this.restSubcriterioAvaliacao = new SubcriterioAvaliacaoRESTClient();
		this.subcriterioAvaliacaos = restSubcriterioAvaliacao.findAll();
	}

	
	//
	public List<SubcriterioAvaliacao> getSubcriterioAvaliacaos() {
		return subcriterioAvaliacaos;
	}

	public void setSubcriterioAvaliacaos(List<SubcriterioAvaliacao> subcriterioAvaliacaos) {
		this.subcriterioAvaliacaos = subcriterioAvaliacaos;
	}
	
	public SubcriterioAvaliacao getSubcriterioAvaliacao() {
		return subcriterioAvaliacao;
	}

	public void setSubcriterioAvaliacao(SubcriterioAvaliacao subcriterioAvaliacao) {
		this.subcriterioAvaliacao = subcriterioAvaliacao;
	}


	public String salvar()
	{
		if(this.subcriterioAvaliacao.getId() == null)
		{
			this.restSubcriterioAvaliacao.create(subcriterioAvaliacao);
		}
		else
		{
			this.restSubcriterioAvaliacao.edit(subcriterioAvaliacao);
		}
		
		this.setSubcriterioAvaliacao(new SubcriterioAvaliacao());
		this.setSubcriterioAvaliacaos(this.restSubcriterioAvaliacao.findAll());
		
		return null;
	}
	
	
}
