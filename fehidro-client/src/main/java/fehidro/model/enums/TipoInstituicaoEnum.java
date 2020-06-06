package fehidro.model.enums;

public enum TipoInstituicaoEnum {
	TipoInstituicao1("Municípios e entidades municipais"),
	TipoInstituicao2("Órgãos e entidades estaduais"),
	TipoInstituicao3("Entidades da sociedade civil sem finalidades lucrativas"),
	TipoInstituicao4("Usuários de recursos hídricos com finalidades lucrativas");

	TipoInstituicaoEnum(String s) {
		tipo = s;
	}

	private final String tipo;

	public boolean equalsName(String tiponame) {
		return tiponame.equals(tipo);
	}

	public String toString() {
		return this.tipo;
	}

	public String getString() {
		return this.tipo;
	}
}