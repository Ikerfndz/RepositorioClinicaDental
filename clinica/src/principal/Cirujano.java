package principal;

public class Cirujano extends Empleado {

	private Especialidad especialidad = new Especialidad();

	public Cirujano() {
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
}
