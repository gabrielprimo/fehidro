package br.unisantos.fehidro.model.dao;

import java.util.List;

import br.unisantos.fehidro.model.PDC;

public class PDCDAO extends DAOFactory<PDC>{

	public PDCDAO()
	{
		super(PDC.class);
	}
	
	public void cadastrar(PDC pdc) {
		adicionar(pdc);
	}
	
	public void atualizar(PDC pdc) {
		alterar(pdc);
	}
	
//	public Instituicao obter(long id) {
//		return consultarGenerico("PDC.consultarPorId", id);
//	}
//		
	public List<PDC> listar() {
		return listarGenerico("PDC.listarTodas");
	}
	
}
