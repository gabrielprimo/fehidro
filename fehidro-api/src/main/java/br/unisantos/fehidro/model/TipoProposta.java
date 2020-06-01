package br.unisantos.fehidro.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "tb_tipoproposta")
@Entity
@NamedQueries({
	@NamedQuery(name = "TipoProposta.listarTodos", query = "select tp from TipoProposta tp order by tp.nome"),
	@NamedQuery(name = "TipoProposta.consultarPorId", query = "select tp from TipoProposta tp where tp.id=?1"),
	@NamedQuery(name = "TipoProposta.obterPorIdSubcriterio",
				query = "select tp from SubcriterioAvaliacao s inner join s.tiposProposta tp where s.id=?1"),
})
public class TipoProposta extends AbstractEntity {
	public TipoProposta() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
	@Column(name="nm_tipoproposta")
	private String nome;
	
    @ManyToMany(mappedBy="tiposProposta")
    @JsonIgnore
    private List<SubcriterioAvaliacao> subcriterios;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<SubcriterioAvaliacao> getSubcriterios() {
		return subcriterios;
	}

	public void setSubcriterios(List<SubcriterioAvaliacao> subcriterios) {
		this.subcriterios = subcriterios;
	}
}
