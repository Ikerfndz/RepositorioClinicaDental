package principal;

import java.util.Scanner;

public class Persona {

	// id es identificador único de cada elemento Persona.
	// Es un valor entero > 0
	// Tiene el valor defecto -1

	public Persona() {
		numeroPersonas++;
		this.id = numeroPersonas;
	}

	protected String nombre;
	protected long id;
	protected int edad;
	private Historial historial;

	protected static int numeroPersonas = 0;

	public static int getNumeroPersonas() {
		return numeroPersonas;
	}

	public static void setNumeroPersonas(int numeroPersonas) {
		Persona.numeroPersonas = numeroPersonas;
	}

	public static Persona nuevoPersona() {
		Persona ret = new Persona();
		Scanner teclado;
		teclado = new Scanner(System.in);

		System.out.println("Introduzca el nombre de la nueva persona");
		String nom = "";
		nom = teclado.nextLine();
		ret.setNombre(nom);

		
		teclado.close();
		return ret;
	}

	void setNombre(String nom) {

	}

	public Persona(String nombre, int id) {
		super();
		numeroPersonas = numeroPersonas + 1;
		this.nombre = nombre;
		this.id = numeroPersonas;

	}

	public Persona(String nombre, int id, int edad, Historial documentacion, Historial historial) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.edad = edad;
		this.historial = historial;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Historial getHistorial() {
		return historial;
	}

	public void setHistorial(Historial historial) {
		this.historial = historial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", id=" + id + ", edad=" + edad + ", historial=" + historial + "]";
	}

}
