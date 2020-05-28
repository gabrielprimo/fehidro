package br.unisantos.fehidro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name = "tb_subpdc")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)//TODO: REMOVER
@NamedQueries({ @NamedQuery(name = "SubPDC.listarTodos", query = "select p from SubPDC p order by p.titulo")
})
public class SubPDC extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	
	@Column(name="cd_subpdc")
	private int codigo;
	
	@Column(name="nm_titulo")
	private String titulo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	
}
