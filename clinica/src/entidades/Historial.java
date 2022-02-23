package entidades;

import java.util.Scanner;

import validacion.Validador;

public class Historial {

	private long idHistorial;
	// idHistorial representa al identificador �nico del historial
	// es un valos entero >0

	private String descripcion;
	// descripci�n representa una explicaci�n de detallad del tratamiento
	// es una cadena de caracteres con un minimo de 10 caracteres

	public static Historial nuevoHistorial() {
		Historial ret = new Historial();
		Scanner teclado;
		teclado = new Scanner(System.in);

		String desHistorial = ("");
		boolean historialValido = false;
		do {
			System.out.println("Introduzca la descripcion: ");
			desHistorial = teclado.next();
			historialValido = Validador.validarHistorialPaciente(desHistorial);
		} while (!historialValido);

		ret.setDescripcion(desHistorial);
		return ret;

	}

	private static int numHistorial = 0;

	public Historial() {
		numHistorial++;
		this.idHistorial = numHistorial;
	}

	public Historial(String descripcion, long idHistorial) {
		this();
		this.descripcion = descripcion;
		this.idHistorial = idHistorial;
	}

	/*Metodo encargado de mostrar los datos del Historial a través de un String
  	de manera que todos queden separados por el carácter "|".
 	El primer campo corresponde con la clave primaria de la clase Historial */
	public String data() {
		String historial= "";
		historial= this.idHistorial + " | " + this.descripcion;
		return historial;

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