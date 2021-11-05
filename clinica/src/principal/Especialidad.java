package principal;

import java.util.Scanner;

public class Especialidad {
	private long id;
	private String nombreEsp;
	private static int numeroEspecialiades = 0;
	
	public Especialidad() {
		
	}
	public Especialidad(long id, String nombreEsp) {
		numeroEspecialiades = numeroEspecialiades + 1;
		this.nombreEsp = nombreEsp;
		this.id = numeroEspecialiades;
	}
	
	public static Especialidad nuevaEspecialidad() {
		Especialidad ret=new Especialidad();
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduce el nombre de la especialidad");
		String nom="";
		nom=teclado.nextLine();
		ret.setNombreEsp(nom);
		teclado.close();
		return ret;
		
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombreEsp() {
		return nombreEsp;
	}
	public void setNombreEsp(String nombreEsp) {
		this.nombreEsp = nombreEsp;
	}

	public static int getnumeroEspecialiades() {
		return numeroEspecialiades;
	}

	public static void setnumeroEspecialiades(int numeroEspecialiades) {
		Especialidad.numeroEspecialiades = numeroEspecialiades;
	}

	@Override
	public String toString() {
		return "Especialidad [id=" + id + ", nombreEsp=" + nombreEsp + "]";
	}
	
}
