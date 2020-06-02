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

import br.unisantos.fehidro.model.PDC;
import br.unisantos.fehidro.model.dao.PDCDAO;

@Path("/pdc")
public class PDCResource {
	@GET
	@Produces("application/json")
	public Response getAll() 
	{
		PDCDAO dao = new PDCDAO();
		List<PDC> pdcs = dao.listar();
		return Response.ok(pdcs).build();
	}
	
	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response get(@PathParam("id") Long id) 
	{
		PDCDAO dao = new PDCDAO();		
		PDC pdc = dao.obter(id);
		if (pdc != null) {
			return Response.ok(pdc).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(PDC pdc) {
		PDCDAO dao = new PDCDAO();
		dao.cadastrar(pdc);
		return Response.ok(pdc).build();
	}

	@PUT
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(PDC pdc) {		
		PDCDAO dao = new PDCDAO();
		dao.atualizar(pdc);
		return Response.ok(pdc).build();
	}
}
