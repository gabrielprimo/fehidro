package fehidro.model;

import java.util.List;

public class Deliberacao {
	private Long id;
	private Integer ano;
	private Integer numero;
	private List<Etapa> etapas;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public List<Etapa> getEtapas() {
		return etapas;
	}
	public void setEtapas(List<Etapa> etapas) {
		this.etapas = etapas;
	}	
}
