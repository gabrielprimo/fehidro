package br.unisantos.fehidro.model.dao;

import java.util.List;

import br.unisantos.fehidro.model.Proposta;

public class PropostaDAO extends DAOFactory<Proposta> {
	
	public PropostaDAO() {
		super(Proposta.class);
	}
	
	public void cadastrar(Proposta proposta) {
		adicionar(proposta);
	}
	
	public void atualizar(Proposta proposta) {
		alterar(proposta);
	}
	
	public void remover(long id) {
		excluir(id);
	}

	public Proposta obter(long id) {
		return consultarGenerico("Proposta.consultarPorId", id);
		//return consultar(id);
	}

	public List<Proposta> listar() {
		return listarGenerico("Proposta.listarTodos");
	}
	
}
