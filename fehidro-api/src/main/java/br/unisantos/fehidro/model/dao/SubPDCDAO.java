package br.unisantos.fehidro.model.dao;

import java.util.List;

import br.unisantos.fehidro.model.SubPDC;

public class SubPDCDAO extends DAOFactory<SubPDC>{

	public SubPDCDAO()
	{
		super(SubPDC.class);
	}
	
	public void cadastrar(SubPDC subpdc) {
		adicionar(subpdc);
	}
	
	public void atualizar(SubPDC subpdc) {
		alterar(subpdc);
	}
	
//	public Instituicao obter(long id) {
//		return consultarGenerico("PDC.consultarPorId", id);
//	}
//		
	public List<SubPDC> listar() {
		return listarGenerico("SubPDC.listarTodas");
	}
	
}
