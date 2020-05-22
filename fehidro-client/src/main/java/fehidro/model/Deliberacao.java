package fehidro.model;

import java.util.List;

public class Deliberacao {
	private int ano;
	private int numero;
	private String descricao;
	private List<Etapa> etapas;
	private int idResponsavel;
	
	
	public int getNumero() {
		return numero;
	}	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Etapa> getEtapas() {
		return etapas;
	}
	public void setEtapas(List<Etapa> etapas) {
		this.etapas = etapas;
	}
	public int getIdResponsavel() {
		return idResponsavel;
	}
	public void setIdResponsavel(int idResponsavel) {
		this.idResponsavel = idResponsavel;
	}
	
}
