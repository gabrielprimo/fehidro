package br.unisantos.fehidro.model.dao;

import java.util.List;

import br.unisantos.fehidro.model.CTPG;

public class CTPGDAO extends DAOFactory<CTPG> {

	public CTPGDAO() {
		super(CTPG.class);
	}
	
	
	public void cadastrar(CTPG ctpg) {
		adicionar(ctpg);
	}
	
	public void atualizar(CTPG ctpg) {
		alterar(ctpg);
	}
	
	public void remover(long id) {
		excluir(id);
	}

	public CTPG obter(long id) {
		return consultar(id);
	}

	public List<CTPG> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<CTPG> listar(CTPG ctpg) {
		
		// TODO Auto-generated method stub
		return null;
	}	
}
