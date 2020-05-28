package br.unisantos.fehidro.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.unisantos.fehidro.model.SubPDC;
import br.unisantos.fehidro.model.dao.SubPDCDAO;

@Path("/subpdc")
public class SubPDCResource {

	@GET
	@Produces("application/json")
	public Response getAll() {
		SubPDCDAO dao = new SubPDCDAO();
		List<SubPDC> subpdcs = dao.listar();
		return Response.ok(subpdcs).build();
	}
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(SubPDC subpdc) {
		SubPDCDAO dao = new SubPDCDAO();
		dao.cadastrar(subpdc);
		return Response.ok(subpdc).build();
	}
	
}
