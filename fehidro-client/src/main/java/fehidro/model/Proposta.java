package fehidro.model;

import java.util.Date;

public class Proposta {

private Long id;
private String titulo;
private float valor;
private Date data;

public float getValor() {
	return valor;
}
public void setValor(float valor) {
	this.valor = valor;
}
public Date getData() {
	return data;
}
public void setData(Date data) {
	this.data = data;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}



}
