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

import br.unisantos.fehidro.model.TipoProposta;
import br.unisantos.fehidro.model.dao.TipoPropostaDAO;

@Path("/tipoProposta")
public class TipoPropostaResource {

	@GET
	@Produces("application/json")
	public Response getAll() 
	{
		TipoPropostaDAO dao = new TipoPropostaDAO();
		List<TipoProposta> tiposPropostas = dao.listar();
		return Response.ok(tiposPropostas).build();
	}
	
	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response get(@PathParam("id") Long id) 
	{
		TipoPropostaDAO dao = new TipoPropostaDAO();		
		TipoProposta tipoProposta = dao.obter(id);
		if (tipoProposta != null) {
			return Response.ok(tipoProposta).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(TipoProposta tipoProposta) {
		TipoPropostaDAO dao = new TipoPropostaDAO();
		dao.cadastrar(tipoProposta);
		return Response.ok(tipoProposta).build();
	}

	@PUT
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(TipoProposta tipoProposta) {		
		TipoPropostaDAO dao = new TipoPropostaDAO();
		dao.atualizar(tipoProposta);
		return Response.ok(tipoProposta).build();
	}
}
