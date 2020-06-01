package br.unisantos.fehidro.model.dao;

import java.util.List;

import br.unisantos.fehidro.model.TipoProposta;

public class TipoPropostaDAO  extends DAOFactory<TipoProposta> {

	public TipoPropostaDAO() {
		super(TipoProposta.class);
		// TODO Auto-generated constructor stub
	}
	
	public void cadastrar(TipoProposta tipoProposta) {
		adicionar(tipoProposta);
	}
	
	public void atualizar(TipoProposta tipoProposta) {
		alterar(tipoProposta);
	}
	
	public TipoProposta obter(long id) {
		return consultarGenerico("TipoProposta.consultarPorId", id);
	}
		
	public List<TipoProposta> listar() {
		return listarGenerico("TipoProposta.listarTodos");
	}
	
	public List<TipoProposta> obterPorSubcriterio(long idSubcriterio) {
		return listarGenerico("TipoProposta.obterPorIdSubcriterio", idSubcriterio);
	}
}
