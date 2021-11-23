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
		Scanner teclado;
		teclado = new Scanner(System.in);

		System.out.println("Introduce la nueva fecha: ");
		LocalDate fecha = "";
		fecha = teclado.nextLine();
		ret.setFecha(fecha);

		System.out.println("Introduce la hora: ");
		LocalDate hora = "";
		hora = teclado.nextLine();
		ret.setFecha(hora);
		return ret;
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