package principal;

import java.util.Scanner;

public class Paciente {

	public Paciente() {
	
	}

	private String nombre;
	private long id;
	private int edad;
	private Historial historial = new Historial();
	
	
	
	
	public static Paciente nuevoPaciente() {
		Paciente ret = new Paciente();
		Scanner teclado;
		teclado = new Scanner(System.in);
		
		System.out.println("Introduzca el nombre de la nueva persona");
		String nom="";
		nom= teclado.nextLine();
		ret.setNombre(nom);
		
		return ret;
	}
	

	private void setNombre(String nom) {
		
	}


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


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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

}
