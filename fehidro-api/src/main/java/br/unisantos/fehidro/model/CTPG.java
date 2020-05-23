package br.unisantos.fehidro.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.unisantos.fehidro.model.Usuario;

@Table(name = "tb_ctpg")
@Entity
public class CTPG extends Usuario {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nm_instituicao")
	private String instituicao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_inicio_mandato")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataInicioMandato;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_nascimento")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	

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
	
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@Column(name="usuario_id")
//	private Usuario usuario;
	

}
