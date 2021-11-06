package principal;

import java.util.Scanner;

public class Especialidad {
	private long id;
	private String nombreEsp;
	private static int numeroEspecialiades = 0;
	private Cirujano cirujano;

	public Especialidad() {
		numeroEspecialiades = numeroEspecialiades + 1;
		this.id = numeroEspecialiades;
	}

	public Especialidad(String nombreEsp) {
		this();
		this.nombreEsp = nombreEsp;
	}

	public static Especialidad nuevaEspecialidad() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el nombre de la especialidad");
		String nom = "";
		nom = teclado.nextLine();
		teclado.close();
		return new Especialidad(nom);
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

	public static int getNumeroEspecialiades() {
		return numeroEspecialiades;
	}

	public static void setNumeroEspecialiades(int numeroEspecialiades) {
		Especialidad.numeroEspecialiades = numeroEspecialiades;
	}

	public Cirujano getCirujano() {
		return cirujano;
	}

	public void setCirujano(Cirujano cirujano) {
		this.cirujano = cirujano;
	}

	@Override
	public String toString() {
		return "Especialidad [id=" + id + ", nombreEsp=" + nombreEsp + "]";
	}

}
