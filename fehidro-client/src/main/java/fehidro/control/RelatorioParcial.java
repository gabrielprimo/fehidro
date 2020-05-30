package fehidro.control;

import java.util.List;

import fehidro.model.Avaliacao;

public class RelatorioParcial extends Relatorio {
	
	@Override
	public void gerar()
	{
		List<Avaliacao> avaliacoes = rest.findAll();//FIXME: substituir por um metodo mais apropriado para esse relatorio
		
		Avaliacao avaliacaoAtual;
		Integer idPropostaAtual;
		for(int i =0;i<avaliacoes.size();i++)
		{
			avaliacaoAtual = avaliacoes.get(i);
			idPropostaAtual = avaliacaoAtual.getProposta().getId();
			if(itensRelatorio.get(idPropostaAtual) == null)
			{
				itensRelatorio.put(i, new ItemRelatorio() );
			}
			
			itensRelatorio.get(idPropostaAtual).addAvaliacao(avaliacaoAtual);
		}
	}
}
