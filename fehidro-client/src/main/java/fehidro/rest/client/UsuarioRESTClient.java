package fehidro.rest.client;

import java.util.List;

import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fehidro.model.Usuario;
import fehidro.rest.client.RESTClientInterface;

public class UsuarioRESTClient implements RESTClientInterface<Usuario>{

	@Override
	public List<Usuario> findAll() {
		Client c = ClientBuilder.newClient();
		WebTarget target = c.target(REST_WEBSERVICE_URL + REST_USUARIO_URL);
		javax.ws.rs.client.Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
		Response response = builder.get();
		System.out.println(response.toString());
		List<Usuario> usuarios = response.readEntity(new GenericType<List<Usuario>> () {});
		
		return usuarios;
	}

	@Override
	public Usuario find(Long id) {
		Usuario usuario = ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_USUARIO_URL + id).
				request(MediaType.APPLICATION_JSON).get()
				.readEntity(Usuario.class);
		
		return usuario;
	}

	public Usuario obterPorCPF(String CPF) {
		Usuario usuario = 
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_USUARIO_URL + "obterPorCPF/" + CPF).
				request(MediaType.APPLICATION_JSON).get().
				readEntity(Usuario.class);
		
		return usuario;
	}

	public List<Usuario> obterPorPerfilAcesso(Long perfilacesso) {
		List<Usuario> usuarios = 
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_USUARIO_URL + "obterPorPerfilAcesso/" +perfilacesso).
				request(MediaType.APPLICATION_JSON).get().
				readEntity(new GenericType<List<Usuario>> () {});
		
		return usuarios;
	}

	public Usuario obterPorLogin(String login) {
		Usuario usuario = 	
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_USUARIO_URL + "obterPorLogin/" + login).
				request(MediaType.APPLICATION_JSON).get().
				readEntity(Usuario.class);
		
		return usuario;
	}

	@Override
	public Usuario create(Usuario obj) {
		Usuario usuario = 			
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_USUARIO_URL).
				queryParam("usuario", obj).
				request(MediaType.APPLICATION_JSON).
				post(Entity.entity(obj, MediaType.APPLICATION_JSON)).
				readEntity(Usuario.class);
		
		return usuario;
	}

	@Override
	public Usuario edit(Usuario obj) {
		Usuario usuario = 
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_USUARIO_URL).
				queryParam("usuario", obj).
				request(MediaType.APPLICATION_JSON).
				put(Entity.entity(obj, MediaType.APPLICATION_JSON)).
				readEntity(Usuario.class);
		
		return usuario;
	}

	@Override
	public boolean delete(Long id) {
		return 	ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_USUARIO_URL + id).
				request(MediaType.APPLICATION_JSON).
				delete().getStatus() 
				== Response.Status.OK.getStatusCode();
	}

}
