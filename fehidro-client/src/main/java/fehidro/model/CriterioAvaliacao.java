package fehidro.model;

import java.util.ArrayList;
import java.util.List;

public class CriterioAvaliacao {
	
	private Long id;
	
	private String titulo;
	
	private int pontuacao;
	
	private List<Pontuacao> pontuacoes = new ArrayList<Pontuacao>();
	
	private List<SubcriterioAvaliacao> subCriterio = new ArrayList<SubcriterioAvaliacao>();

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public List<Pontuacao> getPontuacoes() {
		return pontuacoes;
	}

	public void setPontuacoes(List<Pontuacao> pontuacoes) {
		this.pontuacoes = pontuacoes;
	}

	public List<SubcriterioAvaliacao> getSubCriterio() {
		return subCriterio;
	}

	public void setSubCriterio(List<SubcriterioAvaliacao> subCriterio) {
		this.subCriterio = subCriterio;
	}
	
	
}
