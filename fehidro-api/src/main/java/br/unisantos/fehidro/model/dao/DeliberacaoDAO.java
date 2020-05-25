package br.unisantos.fehidro.model.dao;

import java.util.List;

import br.unisantos.fehidro.model.Deliberacao;

public class DeliberacaoDAO extends DAOFactory<Deliberacao> {
	
	public DeliberacaoDAO() {
		super(Deliberacao.class);
	}

	public void cadastrar(Deliberacao deliberacao) {
		adicionar(deliberacao);
	}
	
	public void atualizar(Deliberacao deliberacao) {
		alterar(deliberacao);
	}
	
	public Deliberacao obter(long id) {
		return consultarGenerico("Deliberacao.consultarPorId", id);
	}
		
	public List<Deliberacao> listar() {
		return listarGenerico("Deliberacao.listarTodas");
	}

}
