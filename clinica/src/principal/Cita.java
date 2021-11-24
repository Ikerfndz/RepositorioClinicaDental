package principal;

import java.time.LocalDate;
import java.util.Scanner;

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

	public static Cita nuevaFecha() {
		Cita ret = new Cita();
		Scanner teclado = new Scanner(System.in);

		System.out.println("Introduce la nueva fecha: ");
		String fechaCita = "";
		LocalDate fecha = LocalDate.now();
		fechaCita = teclado.nextLine();
		fecha = LocalDate.parse(fechaCita);
		ret.setFecha(fecha);

		char rango;
		System.out.print("Introduce mañana o tarde: ");
		rango = teclado.next().charAt(0); // se obtiene el primer carácter del String introducido por teclado
		System.out.println("Carácter introducido -> " + rango);

		System.out.println("Introduce la hora: ");
		String horaCita = "";
		LocalDate hora = LocalDate.now();
		horaCita = teclado.nextLine();
		ret.setHora(horaCita);
		return ret;

	}

	public void setHora(String horaCita) {
		// TODO Auto-generated method stub

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