package br.unisantos.fehidro.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "tb_tipoproposta")
@Entity
@NamedQueries({
	@NamedQuery(name = "TipoProposta.listarTodos", query = "select tp from TipoProposta tp order by tp.nome"),
	@NamedQuery(name = "TipoProposta.consultarPorId", query = "select tp from TipoProposta tp where tp.id=?1")
})
public class TipoProposta extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
