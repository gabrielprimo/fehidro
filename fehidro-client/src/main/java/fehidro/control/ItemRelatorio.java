package fehidro.control;

import java.util.LinkedList;
import java.util.List;

import fehidro.model.Avaliacao;
import fehidro.model.Proposta;

public class ItemRelatorio {
	
	private Proposta proposta;
	private int soma;
	private List<Avaliacao> avaliacoes;
	
	public ItemRelatorio() {
		avaliacoes = new LinkedList<Avaliacao>();
	}
	
	public void addAvaliacao(Avaliacao a)
	{
		this.avaliacoes.add(a);
		soma(this.avaliacoes);
	}
	
	public ItemRelatorio(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
		this.proposta = avaliacoes.get(0).getProposta();
		soma(avaliacoes);
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

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	
}
