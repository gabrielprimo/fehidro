package br.unisantos.fehidro.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.unisantos.fehidro.dao.UsuarioDAO;
import br.unisantos.fehidro.model.Usuario;
//import br.unisantos.fehidro.util.jpa.JPAEntityManager;


@Path("/usuario")
public class UsuarioResource {

	@GET
	@Produces("application/json")
	public Response getAll() {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> usuarios = dao.listarGenerico("Usuario.listarTodos");
		return Response.ok(usuarios).build();
	}

	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response get(@PathParam("id") Long id) {
		UsuarioDAO dao = new UsuarioDAO();		
		Usuario usuario = dao.consultarGenerico("Usuario.consultarPorId", id);
		if (usuario != null) {
			return Response.ok(usuario).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

//	@Path("/{login}")
//	@GET
//	@Produces("application/json")
//	public Response getByLogin(@PathParam("login") Long login) {
//		UsuarioDAO dao = new UsuarioDAO();		
//		Usuario usuario = dao.consultarGenerico("Usuario.consultarPorLogin", login);
//		if (usuario != null) {
//			return Response.ok(usuario).build();
//		} else {
//			return Response.status(Response.Status.NOT_FOUND).build();
//		}
//	}
//
//	@Path("/{CPF}")
//	@GET
//	@Produces("application/json")
//	public Response getByCPF(@PathParam("CPF") Long CPF) {
//		UsuarioDAO dao = new UsuarioDAO();		
//		Usuario usuario = dao.consultarGenerico("Usuario.consultarPorCPF", CPF);
//		if (usuario != null) {
//			return Response.ok(usuario).build();
//		} else {
//			return Response.status(Response.Status.NOT_FOUND).build();
//		}
//	}

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response add(Usuario usuario) {
		UsuarioDAO dao = new UsuarioDAO();
		usuario.setLogin();
		usuario.setSenha();
		usuario.setAtivo();
		dao.cadastrar(usuario);
		return Response.ok(usuario).build();
	}

	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(Usuario usuario) {		
		UsuarioDAO dao = new UsuarioDAO();
		dao.atualizar(usuario);
		return Response.ok(usuario).build();
	}

	@Path("/{id}")
	@DELETE
	@Produces("application/json")
	public Response delete(@PathParam("id") Long id) {
		UsuarioDAO dao = new UsuarioDAO();
		if (dao.excluir(id)) {
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}
}
