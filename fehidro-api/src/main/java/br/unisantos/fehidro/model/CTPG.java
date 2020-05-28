package br.unisantos.fehidro.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.unisantos.fehidro.model.Usuario;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)//TODO: REMOVER
public class CTPG extends Usuario {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_instituicao")
	private int instituicao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_inicio_mandato")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataInicioMandato;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_nascimento")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataNascimento;
	
	@Column(name = "id_tipoavaliador")
	private int tipoavaliador;

	

	public CTPG() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getInstituicao() {
		return instituicao;
	}

	/**
	 * @param instituicao the instituicao to set
	 */
	public void setInstituicao(int instituicao) {
		this.instituicao = instituicao;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getTipoavaliador() {
		return tipoavaliador;
	}

	public void setTipoavaliador(int tipoavaliador) {
		this.tipoavaliador = tipoavaliador;
	}
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@Column(name="usuario_id")
//	private Usuario usuario;
	

}
