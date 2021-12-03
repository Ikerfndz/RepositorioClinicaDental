package principal;


import java.time.LocalDateTime;
import java.util.Scanner;

import validacion.Validador;

public class Cita {
	// idCita representa al identificador unico de la cita.
	// es un valos entero >0.
	protected long idCita;
	// fecha representa el dia indicado para la cita.
	// hora representa la hora a la que se realizara la cita.
	// Seran para ambos la funcion LocalDate.

	protected LocalDateTime fecha, hora;
	// rango representa el horario preferido por el cliente siendo de mañana o de
	// tarde.
	// Es un char que representara una "M" para las mañanas y una "T" para las
	// tardes.
	// No se aceptara mas de un caracter.
	protected char rango;

	private static long numeroPacientes = 0;

	public Cita() {
	}

	public Cita(long idCita, LocalDateTime fecha, LocalDateTime hora, char rango) {
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
	public static Cita nuevaCita() {
		Cita ret = new Cita();
		Scanner teclado = new Scanner(System.in);
		
		char rango;
		System.out.print("Introduce mañana o tarde: ");
		rango = teclado.next().charAt(0); // se obtiene el primer carácter del String introducido por teclado
		System.out.println("Carácter introducido -> " + rango);


		String fechaCita = "";
		boolean fechaCitaValida = false;

		do {
			System.out.println("Introduce la nueva fecha: ");
			System.out.println(" <<<Por favor, siga el siguente formato como se muestra en el ejemplo a continuación: 02/12/2022>>> ");
			fechaCita = teclado.nextLine();
			fechaCitaValida = validarFechaCita(fechaCita);
		} while (!fechaCitaValida);

		LocalDateTime fecha = LocalDateTime.now();
		fecha = LocalDateTime.parse(fechaCita);
		ret.setFecha(fechaCita);
//		teclado.close();

		

		String horaCita = "";
		boolean horaCitaValida = false;

		do {
			System.out.println("Introduce la hora: ");
			horaCita = teclado.nextLine();
			horaCitaValida = validarhoraCita(horaCita);
		} while (!horaCitaValida);

		LocalDateTime hora = LocalDateTime.now();
		hora = LocalDateTime.parse(horaCita);
		ret.setHora(horaCita);
//		teclado.close();
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

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public LocalDateTime getHora() {
		return hora;
	}

	public void setHora(LocalDateTime hora) {
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