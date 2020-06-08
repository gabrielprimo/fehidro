package fehidro.rest.client;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import fehidro.model.SubcriterioAvaliacao;

public class SubcriterioAvaliacaoRESTClient implements RESTClientInterface<SubcriterioAvaliacao>{

	@Override
	public List<SubcriterioAvaliacao> findAll() {
		List<SubcriterioAvaliacao> subcriterios = 
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_SUBCRITERIO_URL).
				request(MediaType.APPLICATION_JSON).get().
				readEntity(new GenericType<List<SubcriterioAvaliacao>> () {});
		
		return subcriterios;		
	} 
 
	@Override
	public SubcriterioAvaliacao find(Long id) {
		SubcriterioAvaliacao subcriterio = 
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_SUBCRITERIO_URL + id).
				request(MediaType.APPLICATION_JSON).get()
				.readEntity(SubcriterioAvaliacao.class);
		
		return subcriterio;
	}

	@Override
	public SubcriterioAvaliacao create(SubcriterioAvaliacao obj) {
		SubcriterioAvaliacao subcriterio = ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_SUBCRITERIO_URL).
				queryParam("subcriterioAvaliacao", obj).
				request(MediaType.APPLICATION_JSON).
				post(Entity.entity(obj, MediaType.APPLICATION_JSON)).	
				readEntity(SubcriterioAvaliacao.class);	
		
		return subcriterio;
	}

	@Override
	public SubcriterioAvaliacao edit(SubcriterioAvaliacao obj) {
		SubcriterioAvaliacao subcriterio = 			
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_SUBCRITERIO_URL).
				queryParam("subcriterioAvaliacao", obj).
				request(MediaType.APPLICATION_JSON).
				put(Entity.entity(obj, MediaType.APPLICATION_JSON)).
				readEntity(SubcriterioAvaliacao.class);	
		
		return subcriterio;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
