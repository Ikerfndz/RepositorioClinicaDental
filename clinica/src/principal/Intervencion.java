package principal;

import java.util.Scanner;

public class Intervencion extends Cita {

	// duracion representa el tiempo que dura la Intervencion.
	// es un valos entero >0.
	// no acepta caracteres
	private int duracion;

	public static Intervencion nuevaDuracion() {
		Intervencion ret = new Intervencion();
		Scanner teclado;
		teclado = new Scanner(System.in);

		System.out.println("Introduzca la duracion de la Intervencion");
		int minutos = teclado.nextInt();
		minutos = teclado.nextInt();
		ret.setDuracion(minutos);
		System.out.println("La duracion ha sido de " + minutos + " minutos.");
		return ret;

	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Intervencion [duracion=" + duracion + "]";
	}

}
