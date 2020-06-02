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

@Table(name = "tb_pdc")
@Entity
@NamedQueries({ @NamedQuery(name = "PDC.listarTodos", query = "select p from PDC p order by p.titulo"),
                @NamedQuery(name = "PDC.consultarPorId", query = "select p from PDC p where p.id = ?1")
})
public class PDC extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name="cd_pdc")
	private int codigo;
	
	@Column(name="nm_titulo")
	private String titulo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "subpdc_id")
	@JsonProperty
	@JsonIgnore
	private List<SubPDC> cronogramas = new ArrayList<SubPDC>();

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

	@JsonIgnore
	public List<SubPDC> getCronogramas() {
		return cronogramas;
	}

	public void setCronogramas(List<SubPDC> cronogramas) {
		this.cronogramas = cronogramas;
	}
	
	

}
