package br.unisantos.fehidro.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.unisantos.fehidro.dao.UsuarioDAO;
import br.unisantos.fehidro.model.Usuario;


@Path("/usuario")
public class UsuarioResource {

	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response get(@PathParam("id") Long id) {
		UsuarioDAO dao = new UsuarioDAO();		
		Usuario usuario = dao.obter(id);
		
		//Usuario usuario = new Usuario();
		//return Response.ok(usuario).build();

		if (usuario != null) {
			return Response.ok(usuario).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
}
