package fehidro.model;

public class Pontuacao {

	private Long id;
	private String titulo;
	private int pontos;
	private boolean desclassificavel;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isDesclassificavel() {
		return desclassificavel;
	}

	public void setDesclassificavel(boolean desclassificavel) {
		this.desclassificavel = desclassificavel;
	}
	
	
	
}
