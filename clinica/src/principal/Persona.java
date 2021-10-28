package principal;

import java.util.Scanner;

public class Persona {
	
	//id es identificador únicode cada elemento de cada elemento Persona.
	//Es un valor entero > 0
	//Tiene el valor defecto -1

	public Persona() {
		
	}

	protected String nombre;
	protected long id;
	protected int edad;
	private Historial historial;
	
	
	
	
	public static Persona nuevoPaciente() {
		Persona ret = new Persona();
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


	public Persona(String nombre, int id) {
		super();
		this.nombre = nombre;
		this.id = id;
	}


	public Persona(String nombre, int id, int edad, Historial documentacion, Historial historial) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.edad = edad;
		this.historial = historial;
	}

}
