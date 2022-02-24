package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import utils.Datos;

public class Revision extends Cita {
	// anotacion representa los datos que quiera apuntar el usuario.
	// es una cadena de caracteres con un minimo de 1 caracteres y maximo de 2000.
	private String anotacion;

	public Revision(Cita c) {
		super(c);

	}

	public Revision() {
	}

	public Revision(String anotacion) {

		this.anotacion = anotacion;
	}

	public Revision(long idCita, LocalDateTime fechahora, char rango) {
		super(idCita, fechahora, rango);
	}

	public Revision(long idCita, LocalDateTime fechahora, char rango, String anotacion) {
		super(idCita, fechahora, rango);
		this.anotacion = anotacion;
	}

	public Revision(Revision c, String notas) {
		super(c);
		this.anotacion = notas;
	}

	public Revision(String string, Cita cita) {

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
			comentariofValido = validarAnotacion(comt);
		} while (!comentariofValido);
		ret.setComentario(comt);
		return ret;
	}

	private static boolean validarAnotacion(String comt) {
		return false;
	}

	private void setComentario(String comt) {

	}

	public String getAnotacion() {
		return anotacion;
	}

	public void setAnotacion(String anotacion) {
		this.anotacion = anotacion;
	}

	/**
	 * Metodo que recorre el array de las revisiones, de la clase Datos, los
	 * almacena en la variable r y a continuacion se muestran a traves del metodo
	 * toString de la clase Revision
	 */
	public static void motrarRevision() {
		System.out.println("Lista de Empleados disponibles:");
		for (int i = 0; i < Datos.numeroRevisiones; i++) {
			Revision r = Datos.REVISIONES[i];
			System.out.println(r.toString());
		}
	}

	@Override
	public String toString() {
		return "Examen Clínico: " + anotacion;
	}

	/**
	 * Función que devuelve una cadena de caracteres con la siguiente estructura
	 * <DatosRevision.id>|<DatosRevisiona.fechaHora>|<DatosRevision.rango>|<DatosRevision.fechahora>|<DatosRevision.anotacion>
	 * Cada campo se separa mediante el caracter '|'
	 * 
	 * @return
	 */
	public String data() {
		String revision = "";
		revision = " | " + this.getIdCita() + " | " + this.getRango() + " | "
				+ this.getFechahora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + " | "
				+ this.anotacion + " | ";
		return revision;
	}
}
