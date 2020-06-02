package fehidro.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class PDC {
	private Long id;
	private String titulo;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<SubPDC> subPDCs;
	
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
	public List<SubPDC> getSubPDCs() {
		return subPDCs;
	}
	public void setSubPDCs(List<SubPDC> subPDCs) {
		this.subPDCs = subPDCs;
	}
	
	
}
