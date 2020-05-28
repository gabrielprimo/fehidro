package br.unisantos.fehidro.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.unisantos.fehidro.model.PDC;
import br.unisantos.fehidro.model.dao.PDCDAO;

@Path("/PDC")
public class PDCResource {

	@GET
	@Produces("application/json")
	public Response getAll()
	{
		PDCDAO dao = new PDCDAO();
		List<PDC> pdcs = dao.listar();
		if(pdcs == null)
		{
			Response.status(Response.Status.NO_CONTENT);
		}
		if(pdcs.size() <=0)
		{
			Response.status(Response.Status.NO_CONTENT);
		}
		return Response.ok(pdcs).build();
	}
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(PDC pdc) {
		PDCDAO dao = new PDCDAO();
		dao.cadastrar(pdc);
		return Response.ok(pdc).build();
	}

}
