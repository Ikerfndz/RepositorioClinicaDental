package principal;


public class Revision extends Cita {

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
