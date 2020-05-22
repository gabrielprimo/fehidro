package br.unisantos.fehidro.model;

import java.util.Date;

import javax.persistence.*;

import br.unisantos.fehidro.model.Usuario;

@Table(name = "tb_ctpg")
@Entity
public class CTPG extends Usuario {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nm_instituicao")
	private String instituicao;
	
	@Column(name = "dt_inicio_mandato")
	private Date dataInicioMandato;
	

	public CTPG() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CTPG(Date dataInicioMandato, String instituicao) {
		super();
		this.dataInicioMandato = dataInicioMandato;
		this.instituicao = instituicao;
	}

	/**
	 * @return the dataInicioMandato
	 */
	public Date getDataInicioMandato() {
		return dataInicioMandato;
	}

	/**
	 * @param dataInicioMandato the dataInicioMandato to set
	 */
	public void setDataInicioMandato(Date dataInicioMandato) {
		this.dataInicioMandato = dataInicioMandato;
	}

	/**
	 * @return the instituicao
	 */
	public String getInstituicao() {
		return instituicao;
	}

	/**
	 * @param instituicao the instituicao to set
	 */
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@Column(name="usuario_id")
//	private Usuario usuario;
	

}
