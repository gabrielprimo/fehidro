package br.unisantos.fehidro.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.unisantos.fehidro.model.dao.PontuacaoDAO;
import br.unisantos.fehidro.model.Pontuacao;

@Path("/pontuacao")
public class PontuacaoResource {

	@GET
	@Produces("application/json")
	public Response getAll() {
		PontuacaoDAO dao = new PontuacaoDAO();
		List<Pontuacao> pontuacoes = dao.listar();
		return Response.ok(pontuacoes).build();
	}
	
	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response get(@PathParam("id") Long id) {
		PontuacaoDAO dao = new PontuacaoDAO();		
		Pontuacao pontuacao = dao.obter(id);
		if (pontuacao != null) {
			return Response.ok(pontuacao).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Pontuacao pontuacao) {
		PontuacaoDAO dao = new PontuacaoDAO();
		dao.cadastrar(pontuacao);
		return Response.ok(pontuacao).build();
	}

	@PUT
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Pontuacao pontuacao) {		
		PontuacaoDAO dao = new PontuacaoDAO();
		dao.atualizar(pontuacao);
		return Response.ok(pontuacao).build();
	}

	@Path("/{id}")
	@DELETE
	@Produces("application/json")
	public Response delete(@PathParam("id") Long id) {
		PontuacaoDAO dao = new PontuacaoDAO();
		if (dao.excluir(id)) {
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
}
