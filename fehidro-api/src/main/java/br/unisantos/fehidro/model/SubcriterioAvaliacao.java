package br.unisantos.fehidro.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "tb_subcriterioavaliacao")
@Entity
public class SubcriterioAvaliacao extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name="nm_titulo")
	private String titulo;
	
	@Column(name="nr_subcriterio")
	private int numero;
	
	@Column(name="ic_letra")
	private char letra;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "subcriterioavaliacao_id")
	private List<Pontuacao> pontuacoes;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<TipoProposta> tiposProposta;

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
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
}
