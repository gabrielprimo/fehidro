package br.unisantos.fehidro.resources;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.unisantos.fehidro.model.dao.SecretariaExecutivaDAO;
import br.unisantos.fehidro.model.SecretariaExecutiva;

@Path("/usuario/secretaria")
public class SecretariaExecutivaResource {
	
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
	public Response add(SecretariaExecutiva usuario) {
		SecretariaExecutivaDAO dao = new SecretariaExecutivaDAO();
		usuario.setLogin();
		usuario.setSenha();
		//usuario.setAtivo();
		dao.cadastrar(usuario);
		return Response.ok(usuario).build();
	}

	@PUT
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(SecretariaExecutiva usuario) {		
		SecretariaExecutivaDAO dao = new SecretariaExecutivaDAO();
		dao.atualizar(usuario);
		return Response.ok(usuario).build();
	}
}
