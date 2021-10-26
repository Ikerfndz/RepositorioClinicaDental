package principal;

public class Paciente {

	public Paciente() {
		// TODO Auto-generated constructor stub
	}

	protected String nombre;
	protected int id;
	protected int edad;
	protected Historial historial = new Historial();
	

	public Paciente(String nombre, int id) {
		super();
		this.nombre = nombre;
		this.id = id;
	}


	public Paciente(String nombre, int id, int edad, Historial documentacion, Historial historial) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.edad = edad;
		this.historial = historial;
	}

}
