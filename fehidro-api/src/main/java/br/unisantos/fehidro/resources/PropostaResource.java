package br.unisantos.fehidro.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import br.unisantos.fehidro.model.Proposta;
import br.unisantos.fehidro.model.dao.PropostaDAO;

@Path("/proposta")
public class PropostaResource {
	@GET
	@Produces("application/json")
	public Response getAll() {
		PropostaDAO dao = new PropostaDAO();
		List<Proposta> propostas = dao.listar();
		return Response.ok(propostas).build();
	}

	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response get(@PathParam("id") Long id) {
		PropostaDAO dao = new PropostaDAO();		
		Proposta proposta = dao.obter(id);
		if (proposta != null) {
			return Response.ok(proposta).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Proposta proposta) {
		PropostaDAO dao = new PropostaDAO();
		dao.cadastrar(proposta);
		return Response.ok(proposta).build();
	}

	@PUT
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Proposta proposta) {		
		PropostaDAO dao = new PropostaDAO();
		dao.atualizar(proposta);
		return Response.ok(proposta).build();
	}

	@Path("/{id}")
	@DELETE
	@Produces("application/json")
	public Response delete(@PathParam("id") Long id) {
		PropostaDAO dao = new PropostaDAO();
		if (dao.excluir(id)) {
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
}
