package principal;

import java.time.LocalDate;
import java.util.Scanner;

public class Cita {

	private long idCita;
	private LocalDate fecha, hora;
	private char rango;

	
	
	
	public static Cita nuevaFecha() {
		Cita ret = new Cita();
		Scanner teclado;
		teclado = new Scanner(System.in);
		
		System.out.println("Introduzca la nueva fecha");
		String nom="";
		nom= teclado.nextLine();
		ret.setFecha(nom);
		return ret;
	}
	

	private void setFecha(final String nom) {
		
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