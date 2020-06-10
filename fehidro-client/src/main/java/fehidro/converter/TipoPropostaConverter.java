package fehidro.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import fehidro.model.TipoProposta;

@FacesConverter(forClass = TipoProposta.class,value="tipoPropostaConverter")
public class TipoPropostaConverter implements Converter, Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty())
            return null;
		
		TipoProposta tp = new TipoProposta();
		tp.setId(Long.parseLong(value));
		
		return tp;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof TipoProposta) {
			long idTipoProposta = ((TipoProposta) value).getId();
			return String.valueOf(idTipoProposta);
		}
		
		return null;
	}

}
