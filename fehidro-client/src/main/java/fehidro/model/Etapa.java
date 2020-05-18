package fehidro.model;

import java.util.List;

public class Etapa {
	private int numero;
	private String descricao;
	private List<Cronograma> cronogramas;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Cronograma> getCronogramas() {
		return cronogramas;
	}
	public void setCronogramas(List<Cronograma> cronogramas) {
		this.cronogramas = cronogramas;
	}
}
