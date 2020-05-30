package br.unisantos.fehidro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "tb_proposta")
@Entity
@NamedQueries({ @NamedQuery(name = "Proposta.listarTodos", query = "select p from Proposta p order by p.projeto"),
		@NamedQuery(name = "Proposta.consultarPorId", query = "select p from Proposta p where p.id=?1"),
//	@NamedQuery(name = "Proposta.listarEntreDatas", query = "select p from Proposta p where p.data between ?1 and ?2"),
		@NamedQuery(name = "Proposta.listarPorInstituicao", query = "select p from Proposta p where p.instituicao=?1") })

public class Proposta extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "nm_projeto")
	private String projeto;

	@Column(name = "nm_instituicao")
	private String instituicao;

	@Column(name = "ic_tipoPropostaEstudo")
	private Boolean isTipoEstudo;

	@Column(name = "ic_tipoPropostaProjeto")
	private Boolean isTipoProjeto;

	@Column(name = "ic_tipoPropostaServico")
	private Boolean isTipoServico;

	@Column(name = "ic_tipoPropostaObra")
	private Boolean isTipoObra;

//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "dt_proposta")
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//	private Date data;
//	
//	@Column(name="vl_proposta")
//	private float valor;

//	@Column(name = "nm_arquivoTermoReferência")     
//	private String termoReferência;
//
//	@Column(name = "nm_arquivoCronogramaFísicoFinanceiro")      
//	private String cronogramaFísicoFinanceiro;
//
//	@Column(name = "nm_arquivoPlanilhaOrçamento")       
//	private String planilhaOrçamento;
//
//	@Column(name = "nm_arquivoFichaResumo")     
//	private String fichaResumo;
//
//	@Column(name = "nm_arquivoSubPDC")      
//	private String subPDC;
//
//	@Column(name = "nr_tipoProposta")        
//	private int tipoProposta;

	public Proposta() {
		super();
	}

	public String getProjeto() {
		return projeto;
	}

	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public Boolean getIsTipoEstudo() {
		return isTipoEstudo;
	}

	public void setIsTipoEstudo(Boolean isTipoEstudo) {
		this.isTipoEstudo = isTipoEstudo;
	}

	public Boolean getIsTipoProjeto() {
		return isTipoProjeto;
	}

	public void setIsTipoProjeto(Boolean isTipoProjeto) {
		this.isTipoProjeto = isTipoProjeto;
	}

	public Boolean getIsTipoServico() {
		return isTipoServico;
	}

	public void setIsTipoServico(Boolean isTipoServico) {
		this.isTipoServico = isTipoServico;
	}

	public Boolean getIsTipoObra() {
		return isTipoObra;
	}

	public void setIsTipoObra(Boolean isTipoObra) {
		this.isTipoObra = isTipoObra;
	}
	
	public void setTipo(Boolean estudo, Boolean projeto, Boolean servico, Boolean obra) {
		setIsTipoEstudo(estudo);
		setIsTipoProjeto(projeto);
		setIsTipoServico(servico);
		setIsTipoObra(obra);
	}

	@Override
	public String toString() {
		return "Proposta [projeto=" + projeto + ", instituicao=" + instituicao + ", isTipoEstudo=" + isTipoEstudo
				+ ", isTipoProjeto=" + isTipoProjeto + ", isTipoServico=" + isTipoServico + ", isTipoObra=" + isTipoObra
				+ "]";
	}

//	public Date getData() {
//		return data;
//	}
//
//	public void setData(Date data) {
//		this.data = data;
//	}
//
//	public float getValor() {
//		return valor;
//	}
//
//	public void setValor(float valor) {
//		this.valor = valor;
//	}

}
