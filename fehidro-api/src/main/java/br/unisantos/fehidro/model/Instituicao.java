package br.unisantos.fehidro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "tb_instituicao")
@Entity
@NamedQueries({
	@NamedQuery(name = "Instituicao.listarTodas", query = "select i from Instituicao i order by i.nome, i.tipo"),
	@NamedQuery(name = "Instituicao.consultarPorId", query = "select i from Instituicao i where i.id=?1")
})
public class Instituicao extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name="nm_instituicao")
	private String nome;
	
	@Column(name="id_tipoinstituicao")
	private int tipo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
