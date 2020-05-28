package br.unisantos.fehidro.model.dao;

import java.util.List;

import br.unisantos.fehidro.model.SubcriterioAvaliacao;

public class SubcriterioAvaliacaoDAO extends DAOFactory<SubcriterioAvaliacao> {

	public SubcriterioAvaliacaoDAO() {
		super(SubcriterioAvaliacao.class);
	}
	
	public void cadastrar(SubcriterioAvaliacao subcriterioAvaliacao) {
		adicionar(subcriterioAvaliacao);
	}
	
	public void atualizar(SubcriterioAvaliacao subcriterioAvaliacao) {
		alterar(subcriterioAvaliacao);
	}
	
	public void remover(long id) {
		excluir(id);
	}

	public SubcriterioAvaliacao obter(long id) {
		return consultarGenerico("SubcriterioAvaliacao.consultarPorId", id);
		//return consultar(id);
	}

	public List<SubcriterioAvaliacao> listar() {
		return listarGenerico("SubcriterioAvaliacao.listarTodos");
	}
	
}
