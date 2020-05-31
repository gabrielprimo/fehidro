package fehidro.control;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fehidro.model.TipoProposta;
import fehidro.rest.client.TipoPropostaRESTClient;

@ManagedBean
@SessionScoped
public class TipoPropostaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private TipoPropostaRESTClient restTipoProposta;
	private TipoProposta tipoProposta;
	private List<TipoProposta> tiposProposta;
	private Long idTipoProposta;
	private String consulta;
	
	public TipoPropostaBean() {
		startView(true);
	}
	
	public String index() 
	{
		startView(true);
		return "/tipoProposta/index?faces-redirect=true";
	}
	
	public String cadastro() 
	{
		startView(true);
		return "/tipoProposta/cadastro?faces-redirect=true";
	}


	public String salvar() {
		this.restTipoProposta = new TipoPropostaRESTClient();
		if (tipoProposta.getId() == null)
		{
			this.restTipoProposta.create(tipoProposta);	
		}
		else
		{
			this.restTipoProposta.edit(tipoProposta);
		}

		startView(true);
		return null;		
	}

	public String editar() 
	{
		if (getIdTipoProposta() != null) {

			this.restTipoProposta = new TipoPropostaRESTClient();
			TipoProposta tipo = this.restTipoProposta.find(getIdTipoProposta());
			this.setTipoProposta(tipo);
		}

		return "/tipoProposta/cadastro?faces-redirect=true";
	}
	
	private void startView(boolean setInfo) 
	{
		this.tipoProposta = new TipoProposta();
		this.restTipoProposta = new TipoPropostaRESTClient();
		
		if (setInfo)
			setInfo();
	}
	
	private void setInfo() 
	{
		this.setTiposProposta(restTipoProposta.findAll());
	}

	
	
	public TipoPropostaRESTClient getRestTipoProposta() {
		return restTipoProposta;
	}
	public void setRestTipoProposta(TipoPropostaRESTClient restTipoProposta) {
		this.restTipoProposta = restTipoProposta;
	}
	public TipoProposta getTipoProposta() {
		return tipoProposta;
	}
	public void setTipoProposta(TipoProposta tipoProposta) {
		this.tipoProposta = tipoProposta;
	}
	public List<TipoProposta> getTiposProposta() {
		return tiposProposta;
	}
	public void setTiposProposta(List<TipoProposta> tiposProposta) {
		this.tiposProposta = tiposProposta;
	}
	public Long getIdTipoProposta() {
		return idTipoProposta;
	}
	public void setIdTipoProposta(Long idTipoProposta) {
		this.idTipoProposta = idTipoProposta;
	}
	public String getConsulta() {
		return consulta;
	}
	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}
}
