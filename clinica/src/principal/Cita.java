package principal;

import java.time.LocalDate;
import java.util.Scanner;

import validacion.Validador;

public class Cita {
	// idCita representa al identificador unico de la cita.
	// es un valos entero >0.
	protected long idCita;
	// fecha representa el dia indicado para la cita.
	// hora representa la hora a la que se realizara la cita.
	// Seran para ambos la funcion LocalDate.

	protected LocalDate fecha, hora;
	// rango representa el horario preferido por el cliente siendo de mañana o de
	// tarde.
	// Es un char que representara una "M" para las mañanas y una "T" para las
	// tardes.
	// No se aceptara mas de un caracter.
	protected char rango;

	private static long numeroPacientes = 0;

	public Cita() {
	}

	public Cita(long idCita, LocalDate fecha, LocalDate hora, char rango) {
		numeroPacientes++;
		this.idCita = numeroPacientes;
		this.fecha = fecha;
		this.hora = hora;
		this.rango = rango;
	}

	/**
	 * * Implementacion de un método nuevaFecha que pida por pantalla al usuario
	 * 
	 * @return una nueva Cita
	 */
	public static Cita nuevaFecha() {
		Cita ret = new Cita();
		Scanner teclado = new Scanner(System.in);

		String fechaCita = "";
		boolean fechaCitaValida = false;

		do {
			System.out.println("Introduce la nueva fecha: ");
			fechaCita = teclado.nextLine();
			fechaCitaValida = validarFechaCita(fechaCita);
		} while (!fechaCitaValida);

		LocalDate fecha = LocalDate.now();
		fecha = LocalDate.parse(fechaCita);
		ret.setFecha(fechaCita);
		teclado.close();

		char rango;
		System.out.print("Introduce mañana o tarde: ");
		rango = teclado.next().charAt(0); // se obtiene el primer carácter del String introducido por teclado
		System.out.println("Carácter introducido -> " + rango);

		String horaCita = "";
		boolean horaCitaValida = false;

		do {
			System.out.println("Introduce la hora: ");
			horaCita = teclado.nextLine();
			horaCitaValida = validarhoraCita(horaCita);
		} while (!horaCitaValida);

		LocalDate hora = LocalDate.now();
		hora = LocalDate.parse(horaCita);
		ret.setHora(horaCita);
		teclado.close();
		return ret;

	}

	private static boolean validarhoraCita(String horaCita) {
		return false;
	}

	private void setFecha(String fechaCita) {

	}

	private static boolean validarFechaCita(String fechaCita) {
		return false;
	}

	public void setHora(String horaCita) {

	}

	public long getIdCita() {
		return idCita;
	}

	public void setIdCita(long idCita) {
		this.idCita = idCita;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalDate getHora() {
		return hora;
	}

	public void setHora(LocalDate hora) {
		this.hora = hora;
	}

	public char getRango() {
		return rango;
	}

	public void setRango(char rango) {
		this.rango = rango;
	}

	@Override
	public String toString() {
		return "Cita [idCita=" + idCita + ", fecha=" + fecha + ", hora=" + hora + ", rango=" + rango + "]";
	}

}