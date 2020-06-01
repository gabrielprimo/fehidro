package fehidro.model;

import java.util.ArrayList;
import java.util.List;

public class PDC {
	
	private Long id;
	private int codigo;
	private String titulo;
	private List<SubPDC> cronogramas = new ArrayList<SubPDC>();
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public List<SubPDC> getCronogramas() {
		return cronogramas;
	}
	public void setCronogramas(List<SubPDC> cronogramas) {
		this.cronogramas = cronogramas;
	}
	
	

}
