package fehidro.model;

import java.util.List;

import javax.servlet.http.Part;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Proposta {
	private Long id;
	private String nomeProjeto;
	private Instituicao instituicao;
	private SubPDC subPDC;
	private List<TipoProposta> tiposProposta;
	private String nomeArquivoTermoReferencia;
	private String nomeArquivoCronogramaFisicoFinanceiro;
	private String nomeArquivoPlanilhaOrcamento;
	private String nomeArquivoFichaResumo;

	@JsonIgnore
	private Part termoReferencia;
	@JsonIgnore
	private Part cronogramaFisicoFinanceiro;
	@JsonIgnore
	private Part planilhaOrcamento;
	@JsonIgnore
	private Part fichaResumo;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeProjeto() {
		return nomeProjeto;
	}
	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}
	public Instituicao getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	public SubPDC getSubPDC() {
		return subPDC;
	}
	public void setSubPDC(SubPDC subPDC) {
		this.subPDC = subPDC;
	}
	public Part getTermoReferencia() {
		return termoReferencia;
	}
	public void setTermoReferencia(Part termoReferencia) {
		this.termoReferencia = termoReferencia;
	}
	public Part getCronogramaFisicoFinanceiro() {
		return cronogramaFisicoFinanceiro;
	}
	public void setCronogramaFisicoFinanceiro(Part cronogramaFisicoFinanceiro) {
		this.cronogramaFisicoFinanceiro = cronogramaFisicoFinanceiro;
	}
	public Part getPlanilhaOrcamento() {
		return planilhaOrcamento;
	}
	public void setPlanilhaOrcamento(Part planilhaOrcamento) {
		this.planilhaOrcamento = planilhaOrcamento;
	}
	public Part getFichaResumo() {
		return fichaResumo;
	}
	public void setFichaResumo(Part fichaResumo) {
		this.fichaResumo = fichaResumo;
	}
	public String getNomeArquivoTermoReferencia() {
		return nomeArquivoTermoReferencia;
	}
	public void setNomeArquivoTermoReferencia(String nomeArquivotermoReferencia) {
		this.nomeArquivoTermoReferencia = nomeArquivotermoReferencia;
	}
	public String getNomeArquivoCronogramaFisicoFinanceiro() {
		return nomeArquivoCronogramaFisicoFinanceiro;
	}
	public void setNomeArquivoCronogramaFisicoFinanceiro(String nomeArquivocronogramaFisicoFinanceiro) {
		this.nomeArquivoCronogramaFisicoFinanceiro = nomeArquivocronogramaFisicoFinanceiro;
	}
	public String getNomeArquivoPlanilhaOrcamento() {
		return nomeArquivoPlanilhaOrcamento;
	}
	public void setNomeArquivoPlanilhaOrcamento(String nomeArquivoPlanilhaOrcamento) {
		this.nomeArquivoPlanilhaOrcamento = nomeArquivoPlanilhaOrcamento;
	}
	public String getNomeArquivoFichaResumo() {
		return nomeArquivoFichaResumo;
	}
	public void setNomeArquivoFichaResumo(String nomeArquivoFichaResumo) {
		this.nomeArquivoFichaResumo = nomeArquivoFichaResumo;
	}
	public List<TipoProposta> getTiposProposta() {
		return tiposProposta;
	}
	public void setTiposProposta(List<TipoProposta> tiposProposta) {
		this.tiposProposta = tiposProposta;
	}	
}
