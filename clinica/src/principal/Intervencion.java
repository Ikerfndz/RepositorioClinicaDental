package principal;


public class Intervencion {
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
