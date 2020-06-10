package fehidro.model;

import java.util.Date;

public class CTPG extends Usuario {
	private Date dataNascimento;
	private Date dataInicioMandato;
	private Instituicao instituicao;
	private int tipoavaliador;
		
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Date getDataInicioMandato() {
		return dataInicioMandato;
	}
	public void setDataInicioMandato(Date dataInicioMandato) {
		this.dataInicioMandato = dataInicioMandato;
	}
	public Instituicao getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	public int getTipoavaliador() {
		return tipoavaliador;
	}
	public void setTipoavaliador(int tipoavaliador) {
		this.tipoavaliador = tipoavaliador;
	}
}
