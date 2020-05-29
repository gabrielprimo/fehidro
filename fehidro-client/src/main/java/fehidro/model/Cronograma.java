package fehidro.model;

import java.util.Date;

public class Cronograma {
	private Long id;
	private Date dataInicio;
	private Date dataFim;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dtInicio) {
		dataInicio = dtInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dtFim) {
		dataFim = dtFim;
	}
}
