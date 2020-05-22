package br.unisantos.fehidro.model.dao;

import java.util.List;

import br.unisantos.fehidro.model.Usuario;

public class UsuarioDAO extends DAOFactory<Usuario> {
	
	public UsuarioDAO() {
		super(Usuario.class);
	}
	
	public void cadastrar(Usuario usuario) {
		adicionar(usuario);
	}
	
	public void atualizar(Usuario usuario) {
		alterar(usuario);
	}
	
	public void remover(long id) {
		excluir(id);
	}

	public Usuario obter(long id) {
		return consultar(id);
	}

	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Usuario> listar(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}	
}
