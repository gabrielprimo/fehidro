package br.unisantos.fehidro.resources;


import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.unisantos.fehidro.model.dao.SecretariaExecutivaDAO;
import br.unisantos.fehidro.util.email.EmailUtil;
import br.unisantos.fehidro.util.password.Password;
import br.unisantos.fehidro.model.SecretariaExecutiva;

@Path("/usuario/secretaria")
public class SecretariaExecutivaResource {
	
	@GET
	@Produces("application/json")
	public Response getAll() {
		SecretariaExecutivaDAO dao = new SecretariaExecutivaDAO();
		List<SecretariaExecutiva> usuarios = dao.listar();
		return Response.ok(usuarios).build();
	}
	
	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response get(@PathParam("id") Long id) {
		SecretariaExecutivaDAO dao = new SecretariaExecutivaDAO();		
		SecretariaExecutiva usuario = dao.obter(id);
		if (usuario != null) {
			return Response.ok(usuario).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(SecretariaExecutiva usuario) throws Exception {
		SecretariaExecutivaDAO dao = new SecretariaExecutivaDAO();
		usuario.setLogin();
		String senha = Password.generateRandomPassword(10);
		usuario.setSenha(Password.hashPassword(senha));
		EmailUtil.sendMail(usuario.getEmail(), usuario.getNome(), usuario.getLogin(), senha);
		//usuario.setAtivo();
		dao.cadastrar(usuario);
		return Response.ok(usuario).build();
	} 

	@PUT
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(SecretariaExecutiva usuario) throws Exception {		
		SecretariaExecutivaDAO dao = new SecretariaExecutivaDAO();
		SecretariaExecutiva usuarioBase = dao.obter(usuario.getId());
		if(usuario.getSenha() != null && usuarioBase != null && !usuarioBase.getSenha().equals(usuario.getSenha())) {
			usuario.setSenha(Password.hashPassword(usuario.getSenha()));
		}
		dao.atualizar(usuario);
		return Response.ok(usuario).build();
	}

	@Path("/{id}")
	@DELETE
	@Produces("application/json")
	public Response delete(@PathParam("id") Long id) {
		SecretariaExecutivaDAO dao = new SecretariaExecutivaDAO();
		if (dao.excluir(id)) {
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
}
