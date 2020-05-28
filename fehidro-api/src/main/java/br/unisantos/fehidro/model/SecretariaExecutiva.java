package br.unisantos.fehidro.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@DiscriminatorValue("Secretaria Executiva")
@JsonIgnoreProperties(ignoreUnknown = true)//TODO: REMOVER
public class SecretariaExecutiva extends Usuario {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "ic_administrativo")
	private boolean administrador;

	public SecretariaExecutiva() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	
}