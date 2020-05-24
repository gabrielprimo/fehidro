package fehidro.model;

public class SecretariaExecutiva extends Usuario {
	private boolean administrador;

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean adm) {
		this.administrador = adm;
	}
}
