package br.unisantos.fehidro.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.unisantos.fehidro.model.SubcriterioAvaliacao;
import br.unisantos.fehidro.model.dao.SubcriterioAvaliacaoDAO;

@Path("/subcriterio")
public class SubcriterioAvaliacaoResource {

	@GET
	@Produces("application/json")
	public Response getAll() {
		SubcriterioAvaliacaoDAO dao = new SubcriterioAvaliacaoDAO();
		List<SubcriterioAvaliacao> subcriterios = dao.listar();
		return Response.ok(subcriterios).build();
	}
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(SubcriterioAvaliacao subcriterio) {
		SubcriterioAvaliacaoDAO dao = new SubcriterioAvaliacaoDAO();
		dao.cadastrar(subcriterio);
		return Response.ok(subcriterio).build();
	}
	
}
