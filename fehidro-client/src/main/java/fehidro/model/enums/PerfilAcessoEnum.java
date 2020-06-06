package fehidro.model.enums;

public enum PerfilAcessoEnum {
	PerfilAcesso1("Secretaria Executiva"),
	PerfilAcesso2("Avaliador CT-PG");
	
	PerfilAcessoEnum(String s) {
		perfil = s;
	}

	private final String perfil;

	public boolean equalsName(String perfilname) {
		return perfilname.equals(perfil);
	}

	public String toString() {
		return this.perfil;
	}

	public String getString() {
		return this.perfil;
	}
}
