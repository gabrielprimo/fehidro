package fehidro.model;

import java.util.List;

public class Etapa {
	private Long id;
	private int numero;
	private String descricao;
	private Integer responsavel;
	private List<Cronograma> cronogramas;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Integer getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Integer responsavel) {
		this.responsavel = responsavel;
	}
}
