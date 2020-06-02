package br.unisantos.fehidro.model;

import java.util.ArrayList;
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

@Table(name = "tb_subcriterio_avaliacao")
@Entity
@NamedQueries({
	@NamedQuery(name = "SubcriterioAvaliacao.listarTodos",
			    query = "select c from SubcriterioAvaliacao c"),
	@NamedQuery(name = "SubcriterioAvaliacao.consultarPorId",
    query = "select c from SubcriterioAvaliacao c where c.id = ?1"),
})
public class SubcriterioAvaliacao extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name="nm_titulo")
	private String titulo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pontuacao_subcriterio_id")
	@JsonProperty
	@JsonIgnore
	private List<Pontuacao> pontuacoes = new ArrayList<>();

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@JsonIgnore
	public List<Pontuacao> getPontuacoes() {
		return pontuacoes;
	}

	public void setPontuacoes(List<Pontuacao> pontuacoes) {
		this.pontuacoes = pontuacoes;
	}
	

	
	
}
