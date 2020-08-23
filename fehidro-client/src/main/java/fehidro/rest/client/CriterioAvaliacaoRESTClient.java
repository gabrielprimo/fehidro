package fehidro.rest.client;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fehidro.model.CriterioAvaliacao;
import fehidro.model.SubcriterioAvaliacao;

public class CriterioAvaliacaoRESTClient implements RESTClientInterface<CriterioAvaliacao> {
	@Override
	public List<CriterioAvaliacao> findAll() {
		List<CriterioAvaliacao> criterios  = 
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_CRITERIO_URL).
				request(MediaType.APPLICATION_JSON).get().
				readEntity(new GenericType<List<CriterioAvaliacao>> () {});
		
		return criterios;
	}
	
	
	public List<SubcriterioAvaliacao> obterSubcriterios(long id) {
		List<SubcriterioAvaliacao> criterios  = 
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_CRITERIO_URL + "subcriterios/" + id).
				request(MediaType.APPLICATION_JSON).get().
				readEntity(new GenericType<List<SubcriterioAvaliacao>> () {});
		
		return criterios;
	}
<<<<<<< HEAD
	
//	public List<CriterioAvaliacao> getCompleto() {
//		List<CriterioAvaliacao> criterios  = 
//				ClientBuilder.newClient().
//				target(REST_WEBSERVICE_URL + REST_CRITERIO_URL + "completo/").
//				request(MediaType.APPLICATION_JSON).get().
//				readEntity(new GenericType<List<CriterioAvaliacao>> () {});
//		
//		return criterios;
//	}
=======
>>>>>>> pr/3

	@Override
	public CriterioAvaliacao find(Long id) {
		CriterioAvaliacao criterio = 
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_CRITERIO_URL + id).
				request(MediaType.APPLICATION_JSON).get()
				.readEntity(CriterioAvaliacao.class);
		
		return criterio;
	}

	@Override
	public CriterioAvaliacao create(CriterioAvaliacao obj) {
		CriterioAvaliacao criterio = ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_CRITERIO_URL).
				queryParam("criterio", obj).
				request(MediaType.APPLICATION_JSON).
				post(Entity.entity(obj, MediaType.APPLICATION_JSON)).	
				readEntity(CriterioAvaliacao.class);	
		
		return criterio;
	}

	@Override
	public CriterioAvaliacao edit(CriterioAvaliacao obj) {
		CriterioAvaliacao criterio = 			
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_CRITERIO_URL).
				queryParam("criterio", obj).
				request(MediaType.APPLICATION_JSON).
				put(Entity.entity(obj, MediaType.APPLICATION_JSON)).
				readEntity(CriterioAvaliacao.class);	
		
		return criterio;
	}

	@Override
	public boolean delete(Long id) {
		return 	ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_CRITERIO_URL + id).
				request(MediaType.APPLICATION_JSON).
				delete().getStatus() 
				== Response.Status.OK.getStatusCode();
	}
}
