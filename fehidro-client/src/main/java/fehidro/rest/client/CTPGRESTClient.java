package fehidro.rest.client;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fehidro.model.CTPG;

public class CTPGRESTClient implements RESTClientInterface<CTPG>{

	private Response response;

	@Override
	public List<CTPG> findAll() {
		List<CTPG> usuarios = 
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_CTPG_URL).
				request(MediaType.APPLICATION_JSON).get().
				readEntity(new GenericType<List<CTPG>> () {});
		
		return usuarios;
	}

	@Override
	public CTPG find(Long id) {
		CTPG usuario = 
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_CTPG_URL + id).
				request(MediaType.APPLICATION_JSON).get()
				.readEntity(CTPG.class);
		
		return usuario;
	}

	@Override
	public CTPG create(CTPG obj) {
		this.response = ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_CTPG_URL).
				queryParam("usuario", obj).
				request(MediaType.APPLICATION_JSON).
				post(Entity.entity(obj, MediaType.APPLICATION_JSON));
		
		CTPG usuario = 
				this.response.
				readEntity(CTPG.class);	
		
		return usuario;
	}

	@Override
	public CTPG edit(CTPG obj) {
		CTPG usuario = 			
				ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_CTPG_URL).
				queryParam("usuario", obj).
				request(MediaType.APPLICATION_JSON).
				put(Entity.entity(obj, MediaType.APPLICATION_JSON)).
				readEntity(CTPG.class);	
		
		return usuario;
	}

	@Override
	public boolean delete(Long id) {
		return 	ClientBuilder.newClient().
				target(REST_WEBSERVICE_URL + REST_CTPG_URL + id).
				request(MediaType.APPLICATION_JSON).
				delete().getStatus() 
				== Response.Status.OK.getStatusCode();
	}

}
