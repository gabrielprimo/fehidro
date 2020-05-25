package br.unisantos.fehidro.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.unisantos.fehidro.model.dao.CTPGDAO;
import br.unisantos.fehidro.model.CTPG;


@Path("/usuario/ctpg")
public class CTPGResource {
	
	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response get(@PathParam("id") Long id) {
		CTPGDAO dao = new CTPGDAO();		
		CTPG usuario = dao.obter(id);
		if (usuario != null) {
			return Response.ok(usuario).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(CTPG usuario) {
		CTPGDAO dao = new CTPGDAO();
		usuario.setLogin();
		usuario.setSenha();
		usuario.setAtivo();
		dao.cadastrar(usuario);
		return Response.ok(usuario).build();
	}

	@PUT
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(CTPG usuario) {		
		CTPGDAO dao = new CTPGDAO();
		dao.atualizar(usuario);
		return Response.ok(usuario).build();
	}
}
