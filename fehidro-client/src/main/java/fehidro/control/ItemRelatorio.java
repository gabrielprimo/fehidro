package fehidro.control;

import java.util.LinkedList;
import java.util.List;

import fehidro.model.Avaliacao;
import fehidro.model.Proposta;
import fehidro.model.SubPDC;

public class ItemRelatorio {
	
	private Proposta proposta;
	private int soma;
	private SubPDC subPDC;
	private List<Avaliacao> avaliacoes;
	private int classificacao;
	private boolean desclassificado;
	
	public ItemRelatorio() {
		avaliacoes = new LinkedList<Avaliacao>();
		soma = 0;
		desclassificado = false;
	}
	
	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}
	
	public boolean isDesclassificado() {
		return desclassificado;
	}

	public void setDesclassificado(boolean desclassificado) {
		this.desclassificado = desclassificado;
	}

	public void addAvaliacao(Avaliacao a)
	{
		//Setando propriedades desse itemRelatorio caso não esteja setado
		if(this.proposta == null)
		{
			this.proposta = a.getProposta();
		}
		if(this.subPDC == null)
		{
			subPDC = a.getSubpdc();
		}
		
		this.avaliacoes.add(a);//Adiciona a avaliacao à lista de avaliacoes
		if(a.getNota().isDesclassificavel())//Verifica se esta declassificado
		{
			this.desclassificado = true;
		}
		this.soma += a.getNota().getPontos();//Atualiza a soma das notas
	}
	
	public void soma(List<Avaliacao> avaliacoes)
	{
		int s = 0;
		for(int i=0;i<avaliacoes.size();i++)//Navegue por tudo e some.
		{
			s += avaliacoes.get(i).getNota().getPontos();
		}
		this.soma = s;
	}

	public Proposta getProposta() {
		return proposta;
	}

	public int getSoma() {
		return soma;
	}
	
	public SubPDC getSubPDC() {
		return subPDC;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	
}
