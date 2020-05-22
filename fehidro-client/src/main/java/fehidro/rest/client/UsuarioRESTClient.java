package fehidro.rest.client;

import java.util.List;

import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fehidro.model.Usuario;
import fehidro.rest.client.RESTClientInterface;

public class UsuarioRESTClient implements RESTClientInterface<Usuario>{
    public static String URL_USUARIO = "usuario/";
	private Response response;

	@Override
	public List<Usuario> findAll() {
		List<Usuario> usuarios = 	ClientBuilder.newClient().
									target(REST_WEBSERVICE_URL + URL_USUARIO).
									request(MediaType.APPLICATION_JSON).get().
									readEntity(new GenericType<List<Usuario>> () {});	    
	    return usuarios;
	}

	@Override
	public Usuario find(Long id) {
		Usuario usuario = 			ClientBuilder.newClient().
									target(REST_WEBSERVICE_URL + URL_USUARIO + id).
									request(MediaType.APPLICATION_JSON).get().
									readEntity(Usuario.class);
		return usuario;
	}
	
	public Usuario findByCPF(String CPF) {
		Usuario usuario = 			ClientBuilder.newClient().
									target(REST_WEBSERVICE_URL + URL_USUARIO + CPF).
									request(MediaType.APPLICATION_JSON).get().
									readEntity(Usuario.class);
		return usuario;
	}

	public List<Usuario> findByPerfilAcesso(Long perfilacesso) {
		List<Usuario> usuarios = 	ClientBuilder.newClient().
									target(REST_WEBSERVICE_URL + URL_USUARIO + perfilacesso).
									request(MediaType.APPLICATION_JSON).get().
									readEntity(new GenericType<List<Usuario>> () {});
		return usuarios;
	}

	@Override
	public Usuario create(Usuario obj) {
		Usuario usuario = 			ClientBuilder.newClient().
									target(REST_WEBSERVICE_URL + URL_USUARIO).
									queryParam("usuario", obj).
									request(MediaType.APPLICATION_JSON).
									post(Entity.entity(obj, MediaType.APPLICATION_JSON)).
									readEntity(Usuario.class);	
		return usuario;
	}

	@Override
	public Usuario edit(Usuario obj) {
		Usuario usuario = 			ClientBuilder.newClient().
									target(REST_WEBSERVICE_URL + URL_USUARIO).
									queryParam("usuario", obj).
									request(MediaType.APPLICATION_JSON).
									put(Entity.entity(obj, MediaType.APPLICATION_JSON)).
									readEntity(Usuario.class);	
		return usuario;
	}

	@Override
	public boolean delete(Long id) {
		return 	ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + URL_USUARIO + id).
				request(MediaType.APPLICATION_JSON).
				delete().getStatus() 
				== Response.Status.OK.getStatusCode();
	}

}
