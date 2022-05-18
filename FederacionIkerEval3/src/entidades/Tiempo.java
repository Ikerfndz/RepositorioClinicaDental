package entidades;

import java.util.Scanner;

import utils.Utilidades;
import validaciones.Validaciones;

public class Tiempo implements Comparable <Tiempo>{

	private static int hora;
	private int minutos;
	private int segundos;
	private int centesimas;
	
	private Participante participante;

	
	
	
	
	
	
	
	public Tiempo (Tiempo tiempo) {
		super();
	}
	
	
	
	
	public Tiempo(int hora, int minutos, int segundos, int centesimas) {
		super();
		this.hora = hora;
		this.minutos = minutos;
		this.segundos = segundos;
		this.centesimas = centesimas;
		
	}
	
	
	
	
	
	public Tiempo(int hora, int minutos, int segundos, int centesimas, Participante participante) {
		super();
		this.hora = hora;
		this.minutos = minutos;
		this.segundos = segundos;
		this.centesimas = centesimas;
		this.participante = participante;
	}

	
	
	
	@Override
	public String toString() {
		return  this.hora + ":" + this.minutos + ":" + this.segundos + "," + this.centesimas;
	}



	
	
	public static Tiempo  nuevoTiempo() {
		Tiempo ret = null;
		int h = 0;
		int min = 0;
		int seg = 0;
		int cen = 0;
		Scanner in;
		boolean valido = false;
		
		do {
			System.out.println("Introduzca las horas del nuevo tiempo:");
			in = new Scanner(System.in);
			h = in.nextInt();
			if (h >= 0)
				valido = true;
			else
				System.out.println("ERROR: Valor incorrecto para las horas.");
		} while (!valido);
		valido = false;
		
		do {
			System.out.println("Introduzca los minutos del nuevo tiempo:");
			min = in.nextInt();
			if (min>=0)
				System.out.println("ERROR: Valor incorrecto para los minutos.");
		} while (!valido);
		valido = false;
		
		do {
			System.out.println("Introduzca los segundos del nuevo tiempo:");
			in = new Scanner(System.in);
			seg = in.nextInt();
			if (seg >= 0)
				valido = true;
			else
				System.out.println("ERROR: Valor incorrecto para las horas.");
		} while (!valido);
		valido = false; 
		
		do {
			System.out.println("Introduzca las horas del nuevo tiempo:");
			in = new Scanner(System.in);
			cen = in.nextInt();
			if (cen >= 0)
				valido = true;
			else
				System.out.println("ERROR: Valor incorrecto para las horas.");
		} while (!valido);

		valido = false;

		System.out.println("Introduzca ahora los datos personales:");
		in = new Scanner(System.in);
		

		ret = new Tiempo(h, min, seg, cen);
		return ret;
	}
	
	
	
	
	
	

	public static int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public int getCentesimas() {
		return centesimas;
	}

	public void setCentesimas(int centesimas) {
		this.centesimas = centesimas;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}




	@Override
	public int compareTo(Tiempo o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
	
}
