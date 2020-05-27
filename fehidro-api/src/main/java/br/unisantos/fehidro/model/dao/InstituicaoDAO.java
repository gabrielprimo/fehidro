package br.unisantos.fehidro.model.dao;

import java.util.List;

import br.unisantos.fehidro.model.Instituicao;

public class InstituicaoDAO extends DAOFactory<Instituicao>{
	
	public InstituicaoDAO() {
		super(Instituicao.class);
	}

	public void cadastrar(Instituicao instituicao) {
		adicionar(instituicao);
	}
	
	public void atualizar(Instituicao instituicao) {
		alterar(instituicao);
	}
	
	public Instituicao obter(long id) {
		return consultarGenerico("Instituicao.consultarPorId", id);
	}
		
	public List<Instituicao> listar() {
		return listarGenerico("Instituicao.listarTodas");
	}
}
