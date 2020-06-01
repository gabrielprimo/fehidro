package br.unisantos.fehidro.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "tb_subcriterioavaliacao")
@Entity
@NamedQueries({
	@NamedQuery(name = "SubcriterioAvaliacao.listarTodos",
			    query = "select c from SubcriterioAvaliacao c"),
	
	@NamedQuery(name = "SubcriterioAvaliacao.consultarPorId",
    			query = "select c from SubcriterioAvaliacao c join fetch c.pontuacoes p where c.id=?1"),
})
public class SubcriterioAvaliacao extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name="nm_titulo")
	private String titulo;
	
	@Column(name="nr_subcriterio")
	private int numero;
	
	@Column(name="ic_letra")
	private char letra;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_subcriterioavaliacao_id")
	private Set<Pontuacao> pontuacoes;
	
	 @ManyToMany
	 @JoinTable(name = "tb_subcriterio_tb_tipoproposta", 
	 	joinColumns = {@JoinColumn(name = "subcriterio_id", referencedColumnName = "id")}, 
	 	inverseJoinColumns = {@JoinColumn(name = "tipoproposta_id", referencedColumnName = "id") })
	private List<TipoProposta> tiposProposta;
	 
	@ManyToOne
	@JsonIgnore
	private CriterioAvaliacao criterio;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Set<Pontuacao> getPontuacoes() {
		return pontuacoes;
	}

	public void setPontuacoes(Set<Pontuacao> pontuacoes) {
		this.pontuacoes = pontuacoes;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<TipoProposta> getTiposProposta() {
		return tiposProposta;
	}

	public void setTiposProposta(List<TipoProposta> tiposProposta) {
		this.tiposProposta = tiposProposta;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public CriterioAvaliacao getCriterio() {
		return criterio;
	}

	public void setCriterio(CriterioAvaliacao criterio) {
		this.criterio = criterio;
	}
}
