package principal;

import java.util.Scanner;

public class Historial {

	private long idHistorial;
	// idHistorial representa al identificador único del historial
	// es un valos entero >0

	private String descripcion;
	// descripción representa una explicación de detallad del tratamiento
	// es una cadena de caracteres con un minimo de 10 caracteres

	public static Historial nuevoHistorial() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el id del historial");
		String nom = "";
		nom = teclado.nextLine();
		teclado.close();
		return new Historial();
	}

	public long getIdHistorial() {
		return idHistorial;
	}

	public void setIdHistorial(long idHistorial) {
		this.idHistorial = idHistorial;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Historial [idHistorial=" + idHistorial + ", descripcion=" + descripcion + "]";
	}

}