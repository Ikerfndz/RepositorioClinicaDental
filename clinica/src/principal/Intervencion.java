package principal;

import java.util.Scanner;

import validacion.Validador;

public class Intervencion extends Cita {

	// duracion representa el tiempo que dura la Intervencion.
	// es un valos entero >0.
	// no acepta caracteres
	private int duracion;

	
	
	public Intervencion() {
		
	}
	
	public Intervencion(int duracion) {
		this.duracion=duracion;
	}
	public static Intervencion nuevaDuracion() {
		Intervencion ret = new Intervencion();
		Scanner teclado;
		teclado = new Scanner(System.in);

		int minutos;
		boolean duracionValido = false;
		do {
			System.out.println("Introduzca la duracion de la Intervencion");
			minutos = teclado.nextInt();
			minutos = validarDuracion(minutos);
		} while (!duracionValido);
		ret.setDuracion(minutos);

		System.out.println("La duracion ha sido de " + minutos + " minutos.");

		return ret;

	}

	private static int validarDuracion(int minutos) {
		// TODO Auto-generated method stub
		return 0;
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

	public static Intervencion nuevaIntervencion() {
		// TODO Auto-generated method stub
		return null;
	}

}
