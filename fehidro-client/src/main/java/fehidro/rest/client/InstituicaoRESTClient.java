package fehidro.rest.client;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fehidro.model.Instituicao;

public class InstituicaoRESTClient implements RESTClientInterface<Instituicao>{

	@Override
	public List<Instituicao> findAll() {
		List<Instituicao> instituicoes = 
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_INSTITUICAO_URL).
				request(MediaType.APPLICATION_JSON).get().
				readEntity(new GenericType<List<Instituicao>> () {});
		
		return instituicoes;
	}

	@Override
	public Instituicao find(Long id) {
		Instituicao instituicao = 
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_INSTITUICAO_URL + id).
				request(MediaType.APPLICATION_JSON).get()
				.readEntity(Instituicao.class);
		
		return instituicao;
	}

	@Override
	public Instituicao create(Instituicao obj) {
		Instituicao instituicao = 
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_INSTITUICAO_URL).
				queryParam("usuario", obj).
				request(MediaType.APPLICATION_JSON).
				post(Entity.entity(obj, MediaType.APPLICATION_JSON)).
				readEntity(Instituicao.class);	
		
		return instituicao;
	}

	@Override
	public Instituicao edit(Instituicao obj) {
		Instituicao instituicao = 			
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_INSTITUICAO_URL).
				queryParam("usuario", obj).
				request(MediaType.APPLICATION_JSON).
				put(Entity.entity(obj, MediaType.APPLICATION_JSON)).
				readEntity(Instituicao.class);	
		
		return instituicao;
	}

	@Override
	public boolean delete(Long id) {
		return 	ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_INSTITUICAO_URL + id).
				request(MediaType.APPLICATION_JSON).
				delete().getStatus() 
				== Response.Status.OK.getStatusCode();
	}
	
}
