package br.unisantos.fehidro.model.dao;

import java.util.List;

import br.unisantos.fehidro.model.Pontuacao;
import br.unisantos.fehidro.model.SubcriterioAvaliacao;
public class SubcriterioAvaliacaoDAO extends DAOFactory<SubcriterioAvaliacao> {

	public SubcriterioAvaliacaoDAO() {
		super(SubcriterioAvaliacao.class);
		// TODO Auto-generated constructor stub
	}
	
	public void cadastrar(SubcriterioAvaliacao subcriterioAvaliacao) {
		adicionar(subcriterioAvaliacao);
	}
	
	public void atualizar(SubcriterioAvaliacao subcriterioAvaliacao) {
		alterar(subcriterioAvaliacao);
		
		PontuacaoDAO pontuacaoDAO = new PontuacaoDAO();
		for(Pontuacao p : subcriterioAvaliacao.getPontuacoes()) {
			pontuacaoDAO.atualizar(p);
		}		
	}
	
	public void remover(long id) {
		excluir(id);
	}

	public SubcriterioAvaliacao obter(long id) {
		return consultarGenerico("SubcriterioAvaliacao.consultarPorId", id);
	}

	public List<SubcriterioAvaliacao> listar() {
		return listarGenerico("SubcriterioAvaliacao.listarTodos");
	}
	
	public List<SubcriterioAvaliacao> obterPorCriterio(long idCriterio) {
		return listarGenerico("CriterioAvaliacao.obterSubcriterios", idCriterio);
	}
	
	public List<SubcriterioAvaliacao> obterTiposPropostaPorSubcriterio(long idSubcriterio) {
		return listarGenerico("CriterioAvaliacao.obterTiposPropostaPorIdSubcriterio", idSubcriterio);
	}
}
