package principal;

import java.time.LocalDateTime;
import java.util.Scanner;

import utils.Utilidades;
import validacion.Validador;

public class Cita {
	// idCita representa al identificador unico de la cita.
	// es un valos entero >0.
	protected long idCita;
	// fecha representa el dia indicado para la cita.
	// hora representa la hora a la que se realizara la cita.
	// Seran para ambos la funcion LocalDate.

	protected LocalDateTime fechahora;
	// rango representa el horario preferido por el cliente siendo de mañana o de
	// tarde.
	// Es un char que representara una "M" para las mañanas y una "T" para las
	// tardes.
	// No se aceptara mas de un caracter.
	protected char rango;

	private static long numeroCitas = 0;

	public Cita() {
		numeroCitas++;
		this.idCita = numeroCitas;
	}

	public Cita(long idCita, LocalDateTime fechahora, char rango) {
		numeroCitas++;
		this.idCita = numeroCitas;
		this.fechahora = fechahora;
		this.rango = rango;
	}

	/**
	 * * Implementacion de un método nuevaFecha que pida por pantalla al usuario
	 * 
	 * @return una nueva Cita
	 */
	public static Cita nuevaCita() {
		Cita ret = new Cita();
		Scanner teclado = new Scanner(System.in);
		boolean valido=false;
		char rango;
		System.out.print("Introduce mañana o tarde: ");
		rango = teclado.next().charAt(0); // se obtiene el primer carácter del String introducido por teclado
		do {
			System.out.print("Introduce mañana o tarde: ");
			teclado = new Scanner(System.in);
			 
			if (rango =='m'|| rango=='t')
				valido = true;
		} while (!valido);
		valido = false;
		System.out.println("Carácter introducido -> " + rango);

		System.out.println(
				" <<<Por favor, siga el siguente formato como se muestra en el ejemplo a continuación: 02/12/2022>>> ");

		LocalDateTime fechaCita = Utilidades.leerFechaHora();

		ret.setFechahora(fechaCita);

		return ret;

	}

	public long getIdCita() {
		return idCita;
	}

	public void setIdCita(long idCita) {
		this.idCita = idCita;
	}

	public LocalDateTime getFechahora() {
		return fechahora;
	}

	public void setFechahora(LocalDateTime fechahora) {
		this.fechahora = fechahora;
	}

	public char getRango() {
		return rango;
	}

	public void setRango(char rango) {
		this.rango = rango;
	}

	public static long getNumeroCitas() {
		return numeroCitas;
	}

	public static void setNumeroCitas(long numeroCitas) {
		Cita.numeroCitas = numeroCitas;
	}

	@Override
	public String toString() {
		return "Cita [idCita=" + idCita + ", fechahora=" + fechahora + ", rango=" + rango + "]";
	}

}