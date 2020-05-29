package br.unisantos.fehidro.model.dao;

import java.util.List;

import br.unisantos.fehidro.model.CriterioAvaliacao;

public class CriterioAvaliacaoDAO extends DAOFactory<CriterioAvaliacao> {
	
	public CriterioAvaliacaoDAO() {
		super(CriterioAvaliacao.class);
	}
	
	public void cadastrar(CriterioAvaliacao criterioAvaliacao) {
		adicionar(criterioAvaliacao);
	}
	
	public void atualizar(CriterioAvaliacao criterioAvaliacao) {
		alterar(criterioAvaliacao);
	}
	
	public void remover(long id) {
		excluir(id);
	}

	public CriterioAvaliacao obter(long id) {
		return consultarGenerico("CriterioAvaliacao.consultarPorId", id);
		//return consultar(id);
	}

	public List<CriterioAvaliacao> listar() {
		return listarGenerico("CriterioAvaliacao.listarTodos");
	}
}