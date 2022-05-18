package entidades;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Scanner;

import utils.Datos;
import utils.Utilidades;
import validaciones.Validaciones;

public class Atleta extends Participante {
	private long idAtleta;
	private float altura;
	private float peso;
	

	private DatosPersona persona;

	public Atleta(long id, int dorsal, char calle, long idAtleta, float altura, float peso) {
		super(id, dorsal, calle);
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = Datos.buscarPersonaPorId(id);
	}

	public Atleta(long id, int dorsal, char calle, long idAtleta, float altura, float peso, DatosPersona dp) {
		super(id, dorsal, calle);
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = dp;
	}

	public Atleta(long idAtleta, float altura, float peso, DatosPersona dp) {
		super();
		this.idAtleta = idAtleta;
		this.altura = altura;
		this.peso = peso;
		this.persona = dp;
	}

	public Atleta(long idParticipante, Atleta a, int dorsal, char calle) {
		super(idParticipante, dorsal, calle);
		this.idAtleta = a.idAtleta;
		this.altura = a.altura;
		this.peso = a.peso;
		this.persona = Datos.buscarPersonaPorId(a.idAtleta);
	}

	public Atleta(Connection con) {
		// TODO Auto-generated constructor stub
	}

	public Atleta() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public long getId() {
		return idAtleta;
	}

	@Override
	public void setId(long id) {
		this.idAtleta = id;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public DatosPersona getPersona() {
		return this.persona;
	}



	// Examen 5 Ejercicio 5
	/***
	 * FunciÃ³n que pregunta al usuario por cada uno de los campos para un nuevo
	 * Atleta, los valida y si son correctos devuelve un objeto Atleta completo
	 * 
	 * @return un objeto Atleta completo vÃ¡lido o null si hubo algÃºn error
	 */
	public static Atleta nuevoAtleta() {
		Atleta ret = null;
		long id = -1;
		float altura = 0.0F;
		float peso = 0.0F;
		int elecc = -1;
		DatosPersona dp = null;
		Scanner in;
		boolean valido = false;
		do {
			System.out.println("Introduzca el id del nuevo atleta:");
			in = new Scanner(System.in);
			id = in.nextInt();
			if (id > 0)
				valido = true;
			else
				System.out.println("Valor incorrecto para el identificador.");
		} while (!valido);

		valido = false;
		do {
			System.out.println("Introduzca el peso del nuevo atleta (xx,xx)Kgs:");
			peso = Utilidades.leerFloat();
			valido = Validaciones.validarPeso(peso);
			if (!valido)
				System.out.println("ERROR: El valor introducido para el peso no es vÃ¡lido.");
		} while (!valido);

		valido = false;
		do {
			System.out.println("Introduzca la altura del nuevo atleta (xx,xx)m:");
			altura = Utilidades.leerFloat();
			valido = Validaciones.validarAltura(altura);
			if (!valido)
				System.out.println("ERROR: El valor introducido para la altura no es vÃ¡lido.");
		} while (!valido);

		System.out.println("Introduzca ahora los datos personales:");
		in = new Scanner(System.in);
		dp = DatosPersona.nuevaPersona();

		ret = new Atleta(id, altura, peso, dp);
		return ret;
	}

	/***
	 * FunciÃ³n que devuelve una cadena de caracteres con los datos del atleta con el
	 * siguiente formato: <nombre> â€œ (â€� <documentacion> â€�) del aÃ±o
	 * â€�<fechaNac.aÃ±o>â€™\tâ€™<peso>â€�Kgs. â€�<altura>â€�m.â€œ
	 */
	@Override
	public String toString() {
		return "" + persona.getNombre() + " (" + persona.getNifnie().mostrar() + ") del aÃ±o "
				+ persona.getFechaNac().getYear() + "\t" + peso + "Kgs. " + altura + "m.";
	}

	public void setPersona(DatosPersona persona) {
		this.persona = persona;
	}



}
