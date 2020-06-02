package br.unisantos.fehidro.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "tb_criterio_avaliacao")
@Entity
@NamedQueries({
	@NamedQuery(name = "CriterioAvaliacao.listarTodos",
			    query = "select c from CriterioAvaliacao c"),
	
	@NamedQuery(name = "CriterioAvaliacao.consultarPorId",
    			query = "select c from CriterioAvaliacao c where c.id=?1"),
})
public class CriterioAvaliacao extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	@Column(name = "nm_titulo")
	private String titulo;
	
	@Column(name = "nr_pontuacao")
	private int pontuacao;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pontuacao_criterio_id")
	@JsonProperty
	@JsonIgnore
	private List<Pontuacao> pontuacoes;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "subcriterio_criterio_id")
	@JsonProperty
	@JsonIgnore
	private List<SubcriterioAvaliacao> subCriterio;

	public CriterioAvaliacao() {
		super();
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
	
	@JsonIgnore
	public List<Pontuacao> getPontuacoes() {
		return pontuacoes;
	}

	public void setPontuacoes(List<Pontuacao> pontuacoes) {
		this.pontuacoes = pontuacoes;
	}

	public void addPontuacao(Pontuacao pontuacao) {
		this.pontuacoes.add(pontuacao);
	}

	@JsonIgnore
	public List<SubcriterioAvaliacao> getSubCriterio() {
		return subCriterio;
	}

	public void setSubCriterio(List<SubcriterioAvaliacao> subCriterio) {
		this.subCriterio = subCriterio;
	}

	public void addSubCriterio(SubcriterioAvaliacao criterio) {
		this.subCriterio.add(criterio);
	}
	
	
}
