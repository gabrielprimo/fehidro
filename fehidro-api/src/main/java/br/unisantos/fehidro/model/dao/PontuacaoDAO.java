package br.unisantos.fehidro.model.dao;
import java.util.List;

import br.unisantos.fehidro.model.Pontuacao;

public class PontuacaoDAO extends DAOFactory<Pontuacao> {
	
	public PontuacaoDAO() {
		super(Pontuacao.class);
	}
	
	public void cadastrar(Pontuacao pontuacao) {
		adicionar(pontuacao);
	}
	
	public void atualizar(Pontuacao pontuacao) {
		alterar(pontuacao);
	}
	
	public void remover(long id) {
		excluir(id);
	}

	public Pontuacao obter(long id) {
		return consultarGenerico("Pontuacao.consultarPorId", id);
	}

	public List<Pontuacao> listar() {
		return listarGenerico("Pontuacao.listarTodos");
	}
	
	public List<Pontuacao> obterPorCriterio(long id) {
		return listarGenerico("CriterioAvaliacao.obterPontuacoesPorCriterio", id);
	}
}
