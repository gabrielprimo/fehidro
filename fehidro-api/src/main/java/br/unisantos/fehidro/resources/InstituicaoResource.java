package br.unisantos.fehidro.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.unisantos.fehidro.model.Instituicao;
import br.unisantos.fehidro.model.dao.InstituicaoDAO;

@Path("/instituicao")
public class InstituicaoResource {
	@GET
	@Produces("application/json")
	public Response getAll() 
	{
		InstituicaoDAO dao = new InstituicaoDAO();
		List<Instituicao> instituicoes = dao.listar();
		return Response.ok(instituicoes).build();
	}
	
	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response get(@PathParam("id") Long id) 
	{
		InstituicaoDAO dao = new InstituicaoDAO();		
		Instituicao instituicao = dao.obter(id);
		if (instituicao != null) {
			return Response.ok(instituicao).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Instituicao instituicao) {
		InstituicaoDAO dao = new InstituicaoDAO();
		dao.cadastrar(instituicao);
		return Response.ok(instituicao).build();
	}

	@PUT
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Instituicao instituicao) {		
		InstituicaoDAO dao = new InstituicaoDAO();
		dao.atualizar(instituicao);
		return Response.ok(instituicao).build();
	}
}
