package br.unisantos.fehidro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "tb_proposta")
@Entity
@NamedQueries({ @NamedQuery(name = "Proposta.listarTodos", query = "select p from Proposta p order by p.titulo")
//	@NamedQuery(name = "Usuario.consultarPorId", query = "select u from Usuario u where u.id=?1"),
//	@NamedQuery(name = "Usuario.consultarPorLogin", query = "select u from Usuario u where u.login=?1"),
//	@NamedQuery(name = "Usuario.consultarPorCPF", query = "select u from Usuario u where u.CPF=?1"),
//	@NamedQuery(name = "Usuario.consultarPorPerfilAcesso", query = "select u from Usuario u where u.perfilAcesso=?1") 
})
public class Proposta extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name="nm_titulo")
	private String titulo;
	
	@Column(name="dt_proposta")
	private Date data;
	
	@Column(name="vl_proposta")
	private float valor;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	

}
