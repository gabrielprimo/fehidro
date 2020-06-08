package br.unisantos.fehidro.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.unisantos.fehidro.model.SubPDC;
import br.unisantos.fehidro.model.dao.SubPDCDAO;

@Path("/subpdc")
public class SubPDCResource {
	@GET
	@Produces("application/json")
	public Response getAll() 
	{
		SubPDCDAO dao = new SubPDCDAO();
		List<SubPDC> subpdcs = dao.listar();
		return Response.ok(subpdcs).build();
	}
	
	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response get(@PathParam("id") Long id) 
	{
		SubPDCDAO dao = new SubPDCDAO();		
		SubPDC subpdc = dao.obter(id);
		if (subpdc != null) {
			return Response.ok(subpdc).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}
