package br.unisantos.fehidro.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.unisantos.fehidro.model.Deliberacao;
import br.unisantos.fehidro.model.dao.DeliberacaoDAO;

@Path("/deliberacao")
public class DeliberacaoResource {

	@GET
	@Produces("application/json")
	public Response getAll() 
	{
		DeliberacaoDAO dao = new DeliberacaoDAO();
		List<Deliberacao> deliberacoes = dao.listar();
		return Response.ok(deliberacoes).build();
	}
	
	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response get(@PathParam("id") Long id) 
	{
		DeliberacaoDAO dao = new DeliberacaoDAO();		
		Deliberacao deliberacao = dao.obter(id);
		if (deliberacao != null) {
			return Response.ok(deliberacao).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Deliberacao deliberacao) {
		DeliberacaoDAO dao = new DeliberacaoDAO();
		dao.cadastrar(deliberacao);
		return Response.ok(deliberacao).build();
	}

	@PUT
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Deliberacao deliberacao) {		
		DeliberacaoDAO dao = new DeliberacaoDAO();
		dao.atualizar(deliberacao);
		return Response.ok(deliberacao).build();
	}
	
}
