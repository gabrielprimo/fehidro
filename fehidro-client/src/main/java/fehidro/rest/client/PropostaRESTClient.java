package fehidro.rest.client;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import fehidro.model.Proposta;

public class PropostaRESTClient implements RESTClientInterface<Proposta>{

	@Override
	public List<Proposta> findAll() {
		List<Proposta> propostas = 
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_PROPOSTA_URL).
				request(MediaType.APPLICATION_JSON).get().
				readEntity(new GenericType<List<Proposta>> () {});
		
		return propostas;		
	} 
 
	@Override
	public Proposta find(Long id) {
		Proposta proposta = 
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_PROPOSTA_URL + id).
				request(MediaType.APPLICATION_JSON).get()
				.readEntity(Proposta.class);
		
		return proposta;
	}

	@Override
	public Proposta create(Proposta obj) {
		Proposta proposta = ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_PROPOSTA_URL).
				queryParam("proposta", obj).
				request(MediaType.APPLICATION_JSON).
				post(Entity.entity(obj, MediaType.APPLICATION_JSON)).	
				readEntity(Proposta.class);	
		
		return proposta;
	}

	@Override
	public Proposta edit(Proposta obj) {
		Proposta proposta = 			
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_PROPOSTA_URL).
				queryParam("proposta", obj).
				request(MediaType.APPLICATION_JSON).
				put(Entity.entity(obj, MediaType.APPLICATION_JSON)).
				readEntity(Proposta.class);	
		
		return proposta;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
