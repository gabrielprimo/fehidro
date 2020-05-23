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
		return consultarGenerico("Usuario.consultarPorId", id);
		//return consultar(id);
	}

	public List<Usuario> listar() {
		return listarGenerico("Usuario.listarTodos");
	}
	
	public Usuario obterPorLogin(String login) {
		return consultarGenerico("Usuario.consultarPorLogin", login);
	}	
	
	public Usuario obterPorCPF(Long CPF) {
		return consultarGenerico("Usuario.consultarPorCPF", CPF);
	}
	
	public List<Usuario> obterPorPerfilAcesso(Long perfilacesso) {
		return listarGenerico("Usuario.consultarPorPerfilAcesso", perfilacesso);
	}
}
