package fehidro.model;

import java.util.Date;

public class Cronograma {
	private Date DataInicio;
	private Date DataFim;
	
	public Date getDataInicio() {
		return DataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		DataInicio = dataInicio;
	}
	public Date getDataFim() {
		return DataFim;
	}
	public void setDataFim(Date dataFim) {
		DataFim = dataFim;
	}
}
