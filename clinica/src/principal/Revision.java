package principal;

public class Revision extends Cita {
	// anotacion representa los datos que quiera apuntar el usuario.
	// es una cadena de caracteres con un minimo de 3 caracteres y maximo de 500.
	private String anotacion;

	public String getAnotacion() {
		return anotacion;
	}

	public void setAnotacion(String anotacion) {
		this.anotacion = anotacion;
	}

	@Override
	public String toString() {
		return "Revision [anotacion=" + anotacion + "]";
	}

}
