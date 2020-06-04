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
	
	public ItemRelatorio() {
		avaliacoes = new LinkedList<Avaliacao>();
		soma = 0;
	}
	
	public void addAvaliacao(Avaliacao a)
	{
		if(this.proposta == null)
		{
			this.proposta = a.getProposta();
		}
		if(this.subPDC == null)
		{
			subPDC = a.getSubpdc();
		}
		this.avaliacoes.add(a);
		this.soma += a.getNota().getPontos();
	}
	
	public void soma(List<Avaliacao> avaliacoes)
	{
		int s = 0;
		for(int i=0;i<avaliacoes.size();i++)
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
