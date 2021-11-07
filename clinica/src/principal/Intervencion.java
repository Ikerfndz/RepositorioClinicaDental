package principal;

public class Intervencion extends Cita {
	
	// duracion representa el tiempo que dura la Intervencion.
	// es un valos entero >0.
	// no acepta caracteres
	private int duracion;

	public float getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Intervencion [duracion=" + duracion + "]";
	}

}
