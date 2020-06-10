//package fehidro.control;
//
//import javax.faces.context.FacesContext;
//import javax.faces.event.AbortProcessingException;
//import javax.faces.event.ValueChangeEvent;
//import javax.faces.event.ValueChangeListener;
//
//import fehidro.model.CriterioAvaliacao;
//
//
//
//public class CriterioChangeListener implements ValueChangeListener {
//   
//   @Override
//   public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
//     System.out.println("value change");
//      AvaliacaoBean bean = (AvaliacaoBean) FacesContext.getCurrentInstance().
//      getExternalContext().getSessionMap().get("avaliacaoBean"); 
//      bean.setCriterio( CriterioAvaliacao.class.cast(event.getNewValue()) );
//   }
//}