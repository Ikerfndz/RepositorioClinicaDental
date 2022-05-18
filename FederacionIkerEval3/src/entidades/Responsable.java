package entidades;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import utils.Utilidades;
import validaciones.Validaciones;

public class Responsable {

	private long id;
	private String telefonoProf;
	private LocalTime horarioIni;
	private LocalTime horarioFin;

	private static DatosPersona persona;

	public Responsable(long id, String telefonoProf, LocalTime horarioIni, LocalTime horarioFin, DatosPersona persona) {
		super();
		this.id = id;
		this.telefonoProf = telefonoProf;
		this.horarioIni = horarioIni;
		this.horarioFin = horarioFin;
		this.persona = persona;
	}

	public Responsable() {
		super();
	}

	public Responsable(long id) {
		this.id = id;
	}

	public Responsable(DatosPersona persona2, long id2, String telefonoProf2, LocalTime horarioIni2,
			LocalTime horarioFin2) {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTelefonoProf() {
		return telefonoProf;
	}

	public void setTelefonoProf(String telefonoProf) {
		this.telefonoProf = telefonoProf;
	}

	public LocalTime getHorarioIni() {
		return horarioIni;
	}

	public void setHorarioIni(LocalTime horarioIni) {
		this.horarioIni = horarioIni;
	}

	public LocalTime getHorarioFin() {
		return horarioFin;
	}

	public void setHorarioFin(LocalTime horarioFin) {
		this.horarioFin = horarioFin;
	}

	public DatosPersona getPersona() {
		return persona;
	}

	public void setPersona(DatosPersona persona) {
		this.persona = persona;
	}

	// EJERCICIO 3A-EX10
	public static Responsable nuevoResponsable() {
		Responsable responsable = null;
		Scanner teclado = new Scanner(System.in);
		DatosPersona persona = DatosPersona.nuevaPersona();
		long id = 0;
		boolean idValido = false;
		do {
			System.out.println("Introduce el id del responsable:");
			id = teclado.nextLong();
			idValido = Validaciones.validarIdResponsable(id);
			
		}while(!idValido);
		
		String telefonoProf="";
		boolean telefonoProfValido = false;
		do {
			System.out.println("Introduce el id telefonoProf del  responsable:");
			telefonoProf = teclado.nextLine();
			idValido = Validaciones.validartelefonoProfResponsable(telefonoProf);
			
		}while(!telefonoProfValido);
		
		LocalTime horarioIni;
		System.out.println("Introduce la hora de inicio:");
		horarioIni = Utilidades.leerhora();
		LocalTime horarioFin;
		System.out.println("Introduce la hora de final:");
		horarioFin = Utilidades.leerhora();
		
		responsable = new Responsable(persona, id, telefonoProf, horarioIni, horarioFin);
			return responsable;
		
	}
	
	
	// EJERCICIO 3B-EX10
	@Override
	public String toString() {
		return  this.id + ", " + persona.getNombre() + ", "
				+ "(" + persona.getNifnie() + ")" + " horario de: " 
				+ this.horarioIni + "a" + this.horarioFin + "tfno: " + this.telefonoProf;
	}

	//EJERCICIO 4
	public String data() {
		return "" + this.getId() + "|" + persona.getId() + "|" + this.getTelefonoProf() + "|"
		+ this.getHorarioIni().format(DateTimeFormatter.ofPattern("HH:mm")) + "|"+ this.getHorarioFin().format(DateTimeFormatter.ofPattern("HH:mm"));
		}
}
