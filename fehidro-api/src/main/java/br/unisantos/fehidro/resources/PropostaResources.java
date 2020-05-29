package br.unisantos.fehidro.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.unisantos.fehidro.model.Proposta;
import br.unisantos.fehidro.model.dao.PropostaDAO;

@Path("/proposta")
public class PropostaResources {
	
	@GET
	@Produces("application/json")
	public Response getAll() {
		PropostaDAO dao = new PropostaDAO();
		List<Proposta> propostas = dao.listar();
		return Response.ok(propostas).build();
	}
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Proposta proposta) {
		PropostaDAO dao = new PropostaDAO();
		dao.cadastrar(proposta);
		return Response.ok(proposta).build();
	}
	
}
