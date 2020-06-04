package fehidro.control;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import fehidro.model.Proposta;
import fehidro.rest.client.PropostaRESTClient;


@ManagedBean
@SessionScoped
public class PropostaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private PropostaRESTClient restProposta;
	private List<Proposta> propostas;
	private Proposta proposta;
	
	//CONSTRUTOR
	public PropostaBean() {
		this.restProposta = new PropostaRESTClient();
		this.propostas = restProposta.findAll();
	}

	
	//
	public List<Proposta> getPropostas() {
		return propostas;
	}

	public void setPropostas(List<Proposta> propostas) {
		this.propostas = propostas;
	}
	
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
			this.restProposta.create(proposta);
		}
		else
		{
			this.restProposta.edit(proposta);
		}
		
		this.setProposta(new Proposta());
		this.setPropostas(this.restProposta.findAll());
		
		return null;
	}
	
	
}
