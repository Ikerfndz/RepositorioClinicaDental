package entidades;

import java.time.LocalDate;
import java.util.Scanner;

public class Revision extends Cita {
	// anotacion representa los datos que quiera apuntar el usuario.
	// es una cadena de caracteres con un minimo de 1 caracteres y maximo de 2000.
	private String anotacion;
	
	
	
	
	public Revision() {
	}

	public Revision(String anotacion) {
	
		this.anotacion = anotacion;
	}
	
	
	

	public static Revision nuevaAnotacion() {
		Revision ret = new Revision();
		Scanner teclado;
		teclado = new Scanner(System.in);

		String comt = "";
		boolean comentariofValido = false;
		do {
			System.out.println("Introduzca el comentario:");
			comt = teclado.next();
			comt = validarAnotacion(comt);
		} while (!comentariofValido);
		ret.setComentario(comt);
		return ret;
	}

	private static String validarAnotacion(String comt) {
		return null;
	}

	private void setComentario(String comt) {

	}

	public String getAnotacion() {
		return anotacion;
	}

	public void setAnotacion(String anotacion) {
		this.anotacion = anotacion;
	}

	@Override
	public String toString() {
		return "Revision [anotacion=" + anotacion + "]";
	}

}
