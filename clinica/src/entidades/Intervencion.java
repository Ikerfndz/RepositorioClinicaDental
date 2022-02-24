package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import utils.Datos;

public class Intervencion extends Cita {

	// duracion representa el tiempo que dura la Intervencion.
	// es un valos entero >0.
	// no acepta caracteres
	private int duracion;

	public Intervencion() {

	}

	public Intervencion(Cita c) {
		super(c);

	}

	public Intervencion(int duracion) {
		this.duracion = duracion;
	}

	public Intervencion(long idCita, LocalDateTime fechahora, char rango) {
		super(idCita, fechahora, rango);

	}

	public static Intervencion nuevaIntervencion() {
		Intervencion ret = new Intervencion();
		Scanner teclado;
		teclado = new Scanner(System.in);

		int minutos = 0;
		boolean duracionValido = false;
		do {
			System.out.println("Introduzca la duracion de la Intervencion");
			minutos = teclado.nextInt();
			duracionValido = validarDuracion(minutos);
		} while (!duracionValido);
		ret.setDuracion(minutos);

		System.out.println("La duracion ha sido de " + minutos + " minutos.");

		return ret;

	}

	private static boolean validarDuracion(int minutos) {

		return minutos > 0;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	/**
	 * Metodo que recorre el array de las intervenciones, de la clase Datos, los
	 * almacena en la variable inte y a continuacion se muestran a traves del metodo
	 * toString de la clase Intervencion
	 */
	public static void motrarIntervencion() {
		System.out.println("Lista de Empleados disponibles:");
		for (int i = 0; i < Datos.numeroIntervenciones; i++) {
			Intervencion inte = Datos.INTERVENCIONES[i];
			System.out.println(inte.toString());
		}
	}

	@Override
	public String toString() {
		return "Intervencion [duracion=" + duracion + "]";
	}

	/**
	 * Función que devuelve una cadena de caracteres con la siguiente estructura
	 * <DatosIntervencion.id>|<DatosIntervencion.fechaHora>|<DatosIntervencion.rango>|<DatosIntervencion.fechahora>|<DatosIntervencion.duracion>
	 * Cada campo se separa mediante el caracter '|'
	 * 
	 * @return
	 */
	public String data() {
		String intervencion = "";
		intervencion = " | " + this.getIdCita() + " | " + this.getRango() + " | "
				+ this.getFechahora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + " | " + this.duracion
				+ " | ";
		return intervencion;
	}
}
