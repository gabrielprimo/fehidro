package fehidro.control;

import java.util.List;

import fehidro.model.Avaliacao;
import fehidro.rest.client.AvaliacaoRESTClient;

public abstract class Relatorio {
	
	private AvaliacaoRESTClient rest; //Ignore o warning de que não está sendo usado
	
	public Relatorio()
	{
		rest = new AvaliacaoRESTClient();
	}
	
	public static int calcularPontos(List<Avaliacao> avaliacoes)
	{
		int s = 0;
		for(int i=0;i<avaliacoes.size();i++)
		{
			s += avaliacoes.get(i).getNota();
		}
		return s;
	}
	
	//TODO: Usar string mesmo?
	public String gerar()
	{
		return null;
	}
	
	
}
