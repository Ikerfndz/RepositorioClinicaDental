package principal;

import java.util.Scanner;

public class Revision extends Cita {
	// anotacion representa los datos que quiera apuntar el usuario.
	// es una cadena de caracteres con un minimo de 3 caracteres y maximo de 500.
	private String anotacion;

	public static Revision nuevaAnotacion() {
		Revision ret = new Revision();
		Scanner teclado;
		teclado = new Scanner(System.in);

		System.out.println("Introduzca el comentario");
		String comt = "";
		comt = teclado.nextLine();
		ret.setAnotacion(comt);
		return ret;
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
