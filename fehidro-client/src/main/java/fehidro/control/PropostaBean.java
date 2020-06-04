package fehidro.control;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.servlet.http.Part;

import fehidro.model.Instituicao;
import fehidro.model.Proposta;
import fehidro.model.SubPDC;
import fehidro.model.TipoProposta;
import fehidro.rest.client.InstituicaoRESTClient;
import fehidro.rest.client.PropostaRESTClient;
import fehidro.rest.client.SubPDCRESTClient;
import fehidro.rest.client.TipoPropostaRESTClient;

@ManagedBean
@SessionScoped
public class PropostaBean {
	
	
	private Long idProposta;
	private String consulta;
	private PropostaRESTClient restProposta;
	private InstituicaoRESTClient restInstituicao;
	private TipoPropostaRESTClient restTipoProposta;
	private SubPDCRESTClient restSubPDC;
	
	private Proposta proposta;
	private List<Proposta> propostas;
	
	private List<SelectItem> instituicoes;
	private List<SelectItem> subpdcs;
	private List<TipoProposta> tiposProposta;
	private TipoProposta[] tiposPropostasSelecionados;
	
	private String folder = "C:\\Fehidro\\Propostas";
	
	public PropostaBean() {
		startView(true);
	}

	public String index() {
		startView(true);
		return "/proposta/index?faces-redirect=true"; 
	}

	public String cadastro() {
		startView(true);
		return "/proposta/cadastro?faces-redirect=true";
	}

	public String editar() 
	{
		if (getIdProposta() != null) {

			Proposta p = this.restProposta.find(getIdProposta());
			setProposta(p);
		}
		setInfo();

		return "/proposta/cadastro?faces-redirect=true";
	}

	public String salvar() {
		if (getIdProposta() == null) {
			uploadArquivosProposta();
			this.restProposta.create(this.proposta);
		}
		else {
			this.restProposta.edit(this.proposta);
		}
		startView(true);

		return null;
	}
	
	private void uploadArquivosProposta() {
		//TODO: tratativa para nome do arquivo localizavel e único - tanto pra criação quanto edição
		
		this.proposta.setNomeArquivoTermoReferencia(this.proposta.getTermoReferencia().getSubmittedFileName());   
		uploadFile(this.proposta.getTermoReferencia(), this.proposta.getNomeArquivoTermoReferencia());
		
		this.proposta.setNomeArquivoCronogramaFisicoFinanceiro(this.proposta.getCronogramaFisicoFinanceiro().getSubmittedFileName());
		uploadFile(this.proposta.getCronogramaFisicoFinanceiro(), this.proposta.getNomeArquivoCronogramaFisicoFinanceiro());
		
		this.proposta.setNomeArquivoPlanilhaOrcamento(this.proposta.getPlanilhaOrcamento().getSubmittedFileName());
		uploadFile(this.proposta.getPlanilhaOrcamento(), this.proposta.getNomeArquivoPlanilhaOrcamento());

		this.proposta.setNomeArquivoFichaResumo(this.proposta.getFichaResumo().getSubmittedFileName());
		uploadFile(this.proposta.getFichaResumo(), this.proposta.getNomeArquivoFichaResumo());
	}
	
	private void uploadFile(Part arquivo, String nomeArquivo) {
		try (InputStream input = arquivo.getInputStream()) {
			Files.copy(input, new File(folder, nomeArquivo).toPath());
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }	
	}
	
	private void startView(boolean setInfo) {
		this.restProposta = new PropostaRESTClient();
		this.proposta = new Proposta();
		this.proposta.setInstituicao(new Instituicao());
		this.proposta.setSubPDC(new SubPDC());
		this.proposta.setTiposProposta(new ArrayList<TipoProposta>());
			
		if (setInfo)
			setInfo();
	}

	private void setInfo() {
		this.setPropostas(this.restProposta.findAll());
		this.setInstituicoes();
		this.setSubpdcs();
		this.setTiposProposta();
	}

	public Long getIdProposta() {
		return idProposta;
	}

	public void setIdProposta(Long idProposta) {
		this.idProposta = idProposta;
	}

	public PropostaRESTClient getRestProposta() {
		return restProposta;
	}

	public void setRestProposta(PropostaRESTClient restProposta) {
		this.restProposta = restProposta;
	}

	public Proposta getProposta() {
		return proposta;
	}

	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

	public List<Proposta> getPropostas() {
		return propostas;
	}

	public void setPropostas(List<Proposta> propostas) {
		this.propostas = propostas;
	}

	public InstituicaoRESTClient getRestInstituicao() {
		return restInstituicao;
	}

	public void setRestInstituicao(InstituicaoRESTClient restInstituicao) {
		this.restInstituicao = restInstituicao;
	}
	
	public void setInstituicoes() {
		this.restInstituicao = new InstituicaoRESTClient();
		List<Instituicao> instituicoesBase = this.restInstituicao.findAll();
		List<SelectItem> instituicoes = new ArrayList<>();

		for (Instituicao i : instituicoesBase) 
		{
			instituicoes.add(new SelectItem(i.getId(), i.getNome()));
		}
		
		this.instituicoes = instituicoes;
	}
	
	public List<SelectItem> getInstituicoes() { 
		return instituicoes;
	}

	public List<SelectItem> getSubpdcs() {
		return subpdcs;
	}

	public void setSubpdcs() {
		this.restSubPDC = new SubPDCRESTClient();
		List<SubPDC> subPDCBase = this.getRestSubPDC().findAll();
		List<SelectItem> subpdcs = new ArrayList<>();
		
		for (SubPDC s : subPDCBase) {
			subpdcs.add(new SelectItem(s.getId(), s.getTitulo()));
		}
		
		this.subpdcs = subpdcs;
	}

	public SubPDCRESTClient getRestSubPDC() {
		return restSubPDC;
	}

	public void setRestSubPDC(SubPDCRESTClient restSubPDC) {
		this.restSubPDC = restSubPDC;
	}
	
	public TipoProposta[] getTiposPropostasSelecionados() {
		return tiposPropostasSelecionados;
	}

	public void setTiposPropostasSelecionados(TipoProposta[] tiposPropostasSelecionados) {
		this.tiposPropostasSelecionados = tiposPropostasSelecionados;
	}

	public TipoProposta[] getTiposPropostasSelecionadosValue() {
		this.tiposPropostasSelecionados = new TipoProposta[this.tiposProposta.size()];

		for(int i = 0; i < this.tiposProposta.size(); i++) {
			tiposPropostasSelecionados[i] = this.tiposProposta.get(i);
		}

		return this.tiposPropostasSelecionados;
	}
	
	public String getTiposPropostasSelecionadosInString() {
		return Arrays.toString(this.tiposPropostasSelecionados);
	}

	public List<TipoProposta> getTiposProposta() {
		return tiposProposta;
	}

	public void setTiposProposta() {
		this.restTipoProposta = new TipoPropostaRESTClient();
		this.tiposProposta  = this.restTipoProposta.findAll();		
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

}
