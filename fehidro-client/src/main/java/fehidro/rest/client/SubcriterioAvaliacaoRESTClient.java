//TODO: implementar

package fehidro.rest.client;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fehidro.model.SubcriterioAvaliacao;

public class SubcriterioAvaliacaoRESTClient implements RESTClientInterface<SubcriterioAvaliacao> {
	
	public List<SubcriterioAvaliacao> findAll(){
		List<SubcriterioAvaliacao> subcriterioAvaliacaos = 	
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_SUBCRITERIO_URL).
				request(MediaType.APPLICATION_JSON).get().
				readEntity(new GenericType<List<SubcriterioAvaliacao>> () {});
		
		return subcriterioAvaliacaos;
	}

	@Override
	public SubcriterioAvaliacao find(Long id) {
		SubcriterioAvaliacao subcriterioAvaliacao = ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_SUBCRITERIO_URL + id).
				request(MediaType.APPLICATION_JSON).get()
				.readEntity(SubcriterioAvaliacao.class);
		
		return subcriterioAvaliacao;
	}

	@Override
	public SubcriterioAvaliacao create(SubcriterioAvaliacao obj) {
		SubcriterioAvaliacao subcriterioAvaliacao = 			
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_SUBCRITERIO_URL).
				queryParam("subcriterioAvaliacao", obj).
				request(MediaType.APPLICATION_JSON).
				post(Entity.entity(obj, MediaType.APPLICATION_JSON)).
				readEntity(SubcriterioAvaliacao.class);
		
		return subcriterioAvaliacao;
	}

	@Override
	public SubcriterioAvaliacao edit(SubcriterioAvaliacao obj) {
		SubcriterioAvaliacao subcriterioAvaliacao = 
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_SUBCRITERIO_URL).
				queryParam("subcriterioAvaliacao", obj).
				request(MediaType.APPLICATION_JSON).
				put(Entity.entity(obj, MediaType.APPLICATION_JSON)).
				readEntity(SubcriterioAvaliacao.class);
		
		return subcriterioAvaliacao;
	}

	@Override
	public boolean delete(Long id) {
		return 	ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_SUBCRITERIO_URL + id).
				request(MediaType.APPLICATION_JSON).
				delete().getStatus() 
				== Response.Status.OK.getStatusCode();
	}
	
}