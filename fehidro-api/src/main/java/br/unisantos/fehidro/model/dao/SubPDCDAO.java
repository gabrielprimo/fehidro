package br.unisantos.fehidro.model.dao;

import java.util.List;

import br.unisantos.fehidro.model.SubPDC;

public class SubPDCDAO extends DAOFactory<SubPDC>{

	public SubPDCDAO() {
		super(SubPDC.class);
	}
	
	public SubPDC obter(long id) {
		return consultarGenerico("SubPDC.consultarPorId", id);
	}
		
	public List<SubPDC> listar() {
		return listarGenerico("SubPDC.listarTodos");
	}

}
