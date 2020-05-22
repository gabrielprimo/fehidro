package br.unisantos.fehidro.model;

import javax.persistence.*;


@Table(name = "tb_secretaria_executiva")
@Entity
@DiscriminatorValue("Secretaria Executiva")
public class SecretariaExecutiva extends Usuario {
	private static final long serialVersionUID = 1L;
	
}