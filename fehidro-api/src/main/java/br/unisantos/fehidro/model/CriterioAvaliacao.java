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

@Table(name = "tb_criterioavaliacao")
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

	@Column(name = "nr_criterio")
	private Integer numero;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "criterioavaliacao_id")
	private List<Pontuacao> pontuacoes;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "criterioavaliacao_id")
	private List<SubcriterioAvaliacao> subcriterios;

	public CriterioAvaliacao() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public List<SubcriterioAvaliacao> getSubcriterios() {
		return subcriterios;
	}

	public void setSubcriterios(List<SubcriterioAvaliacao> subcriterios) {
		this.subcriterios = subcriterios;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
}
