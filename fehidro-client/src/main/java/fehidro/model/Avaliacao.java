package fehidro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Avaliacao {
	 	
		private Long id;
		private Pontuacao nota;
		@JsonIgnore
	    private Usuario avaliador;
	    private Proposta proposta;
	    private SubcriterioAvaliacao subcriterio;
	    private CriterioAvaliacao criterio;
//	    private SubPDC subpdc;
//	    private PDC pdc;
	    
	    
	    
	    public Long getId()
	    {
	    	return id;
	    }
	    
		public void setId(Long id) {
			this.id = id;
		}

		public Pontuacao getNota() {
			return nota;
		}
		
		public void setNota(Pontuacao nota) {
			this.nota = nota;
		}

		public Usuario getAvaliador() {
			return avaliador;
		}

		public void setAvaliador(Usuario avaliador) {
			this.avaliador = avaliador;
		}

		public Proposta getProposta() {
			return proposta;
		}

		public void setProposta(Proposta proposta) {
			this.proposta = proposta;
		}

		public SubcriterioAvaliacao getSubcriterio() {
			return subcriterio;
		}

		public void setSubcriterio(SubcriterioAvaliacao subcriterio) {
			this.subcriterio = subcriterio;
		}

		public CriterioAvaliacao getCriterio() {
			return criterio;
		}

		public void setCriterio(CriterioAvaliacao criterio) {
			this.criterio = criterio;
		}

//		public SubPDC getSubpdc() {
//			return subpdc;
//		}
//
//		public void setSubpdc(SubPDC subpdc) {
//			this.subpdc = subpdc;
//		}
//
//		public PDC getPdc() {
//			return pdc;
//		}
//
//		public void setPdc(PDC pdc) {
//			this.pdc = pdc;
//		}
	    
}
