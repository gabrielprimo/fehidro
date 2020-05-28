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

@Table(name = "tb_subcriterio_avaliacao")
@Entity
@NamedQueries({
	@NamedQuery(name = "SubcriterioAvaliacao.listarTodos",
			    query = "select c from SubcriterioAvaliacao c")
})
public class SubcriterioAvaliacao extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name="nm_titulo")
	private String titulo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pontuacao_id")
	private List<Pontuacao> pontuacoes = new ArrayList<>();

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Pontuacao> getPontuacoes() {
		return pontuacoes;
	}

	public void setPontuacoes(List<Pontuacao> pontuacoes) {
		this.pontuacoes = pontuacoes;
	}
	

	
	
}
