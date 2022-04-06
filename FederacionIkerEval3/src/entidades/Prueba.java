package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

import utils.Utilidades;
import validaciones.Validaciones;

public class Prueba {
	private long id;
	private String nombre;
	private LocalDate fecha; // solo fecha
	private boolean individual; // indica si es individual o no (por equipos)
	private Lugar lugar;

	private Colegiado[] arbitraje = new Colegiado[3];
	private Resultado resultado = null;
	private Participante[] participantes;
	private Patrocinador patrocinador;

	public Prueba(long id, String nombre, LocalDate fecha, Lugar lugar, boolean ind, Patrocinador patrocinador) {
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
		this.individual = ind;
		this.patrocinador= patrocinador;
	}

	public Prueba(long id, String nombre, LocalDate fecha, Lugar lugar, boolean ind, Participante[] participantes) {
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
		this.individual = ind;
		this.participantes = participantes;
	}

	public Prueba(long id, String nombre, LocalDate fecha, Lugar lugar, boolean ind, Colegiado[] arbitraje) {
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
		this.individual = ind;
		this.arbitraje = arbitraje;
	}

	public Prueba(long id, String nombre, LocalDate fecha, Lugar lugar, boolean ind, Participante[] participantes,
			Colegiado[] arbitraje) {
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
		this.individual = ind;
		this.participantes = participantes;
		this.arbitraje = arbitraje;
	}

	public Prueba(long id, String nombre, LocalDate fecha, Lugar lugar, boolean ind, Participante[] participantes,
			Colegiado[] arbitraje, Resultado res) {
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
		this.individual = ind;
		this.participantes = participantes;
		this.arbitraje = arbitraje;
		this.resultado = res;
	}
	 //nuevo constructor añadiendo poatrocinador
	public Prueba(long id, String nombre, LocalDate fecha, Lugar lugar, boolean ind, Participante[] participantes,
			Colegiado[] arbitraje, Resultado res, Patrocinador patrocinador) {
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
		this.individual = ind;
		this.participantes = participantes;
		this.arbitraje = arbitraje;
		this.resultado = res;
		this.patrocinador= patrocinador;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	public Participante[] getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Participante[] participantes) {
		this.participantes = participantes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public boolean isIndividual() {
		return individual;
	}

	public void setIndividual(boolean individual) {
		this.individual = individual;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}
	

	public Colegiado[] getArbitraje() {
		return arbitraje;
	}

	public void setArbitraje(Colegiado[] arbitraje) {
		this.arbitraje = arbitraje;
	}

	public Patrocinador getPatrocinador() {
		return patrocinador;
	}

	public void setPatrocinador(Patrocinador patrocinador) {
		this.patrocinador = patrocinador;
	}

	/**
	 * FunciÃ³n que establece el equipo arbitral de la prueba (3 colegiados)
	 * 
	 * @param arbitros array de 3 Colegiado que componen el equipo arbitral de la
	 *                 prueba
	 * @return true si se estableciÃ³ con Ã©xito el equipo arbitral de la prueba o
	 *         false en caso contrario
	 */
	public boolean setEquipoArbitral(Colegiado[] arbitros) {
		boolean ret = false;
		if (arbitros.length != 3)
			return false;
		for (Colegiado c : arbitros)
			if (c == null)
				return false;

		return ret;
	}

	/**
	 * Funcion que indica si hay establecido un equipo arbitral para la prueba
	 * 
	 * @return true si sÃ­ haya establecido equipo arbitral par la prueba y false en
	 *         caso contrario
	 */
	public boolean hayEquipoArbitral() {
		if (this.arbitraje.length != 3)
			return false;
		for (Colegiado c : this.arbitraje)
			if (c == null)
				return false;

		return true;
	}

	public String nombresEquipoArbitral() {
		String ret = "";
		if (!hayEquipoArbitral())
			ret = "No hay equipo arbitral para esta prueba.";
		else {
			ret += "[EQUIPO ARBITRAL #" + id + "\n";
			for (Colegiado c : this.arbitraje) {
				ret += c.getPersona() + ", cat=" + c.getCategoria() + "\n";
			}
			ret += "]";
		}
		return ret;
	}

	/***
	 * Funcion que indica si la prueba estÃ¡ cerrada, es decir, si su resultado es
	 * definitivo
	 * 
	 * @return true si la prueba estÃ¡ cerrada o false en caso contrario
	 */
	public boolean cerrada() {
		if (this.resultado != null)
			return this.resultado.isDefinitivo();
		else
			return false;
	}

	/**
	 * Funcion que establece el resultado definitivo de la prueba, cerrÃ¡ndola. En
	 * caso de error avisa al usuario por la salida estandar del sistema
	 * 
	 * @param r objeto de tipo Resultado que debe ser definitivo
	 */
	public void cerrarPrueba(Resultado r) {
		if (!r.isDefinitivo()) {
			System.out.println("ERROR al cerrar la prueba: El resultado NO es definitivo.");
			return;
		} else {
			this.resultado = r;
			System.out.println("La prueba " + this.nombre + " ha quedado cerrada.");
		}
	}

	///Examen 6 Ejercicio 4
	/***
	 * FunciÃ³n que devuelve una cadena de caracteres con la siguiente estructura: 
	 * <idPrueba>â€�. â€�<nombre>â€� (â€�<fecha(dd/mm/YYYY)>â€� en <lugarPrueba>) de tipo â€œ
	 * <individual/colectiva>â€œ Si la prueba dispone de equipo arbitral, se mostrarÃ¡n
	 * los nombres del equipo arbitral. AdemÃ¡s, si estÃ¡ cerrada, se mostrarÃ¡ el
	 * Resultado de la misma, de esta forma: â€œPrimer puesto: â€œ<idParticipante>â€�, con
	 * el dorsal â€œ<dorsal>â€� por la calle â€œ<calle>â€� Oro#â€�<idOro>â€�.â€� â€œSegundo puesto:
	 * â€œ<idParticipante>â€�, con el dorsal â€œ<dorsal>â€� por la calle â€œ<calle>â€�
	 * Plata#<idPlata> â€œTercer puesto: â€œ<idParticipante>â€�, con el dorsal â€œ<dorsal>â€�
	 * por la calle â€œ<calle> Bronce#<idBronc>
	 * 
	 */
	@Override
	public String toString() {
		String ret = "";
		ret += "" + id + "." + nombre + " (" + fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " en " + lugar.getNombre() + ") de tipo " + (this.isIndividual()?"individual":"colectiva")+ "El patrocinador es: "+"(" + patrocinador.getId()+ patrocinador.getNombre()+patrocinador.getWeb()+ patrocinador.getDotacion()+ ")" + "\n";
		if(this.hayEquipoArbitral()) {
			ret += this.nombresEquipoArbitral();
		}
		if(this.cerrada()) {
			Resultado res = this.getResultado();
			Participante[] podio = res.getPodio();
			ret += "Primer puesto:"+ podio[0].getId()+", con el dorsal" + podio[0].getDorsal()+" por la calle "+ podio[0].getCalle()+" Oro#"+ res.getPrimero().getId()+"\n";
			ret += "Segundo puesto:"+ podio[1].getId()+", con el dorsal" + podio[1].getDorsal()+" por la calle "+ podio[1].getCalle()+" Oro#"+ res.getSegundo().getId()+"\n";
			ret += "Tercer puesto:"+ podio[2].getId()+", con el dorsal" + podio[2].getDorsal()+" por la calle "+ podio[2].getCalle()+" Oro#"+ res.getTercero().getId()+"\n";
		}
		return ret;
	}

	// Examen 1 Ejercicio 2, parte B
	public static Prueba nuevaPrueba() {
		Prueba ret = null;
		Scanner in;
		long id = -1;
		String nombre = "";
		Lugar lugar;
		boolean valido = false;
		do {
			System.out.println("Introduzca el id de la nueva prueba:");
			in = new Scanner(System.in);
			id = in.nextInt();
			valido = Validaciones.validarId(id);
			if (!valido)
				System.out.println("ERROR: Valor introducido para el identificador de la prueba invÃ¡lido.");
			else
				valido = true;
		} while (!valido);
		valido = false;
		do {
			System.out.println("Introduzca el nombre de la nueva prueba:");
			in = new Scanner(System.in);
			nombre = in.nextLine();
			valido = Validaciones.validarNombre(nombre);
			if (!valido)
				System.out.println("ERROR: Valor introducido para el nombre de la prueba invÃ¡lido.");
			else
				valido = true;
		} while (!valido);

		System.out.println("Introduzca la fecha de la nueva prueba");
		LocalDate fecha = Utilidades.leerFecha();

		System.out.println("Â¿Es la nueva prueba de tipo individual?");
		boolean ind = Utilidades.leerBoolean();

		valido = false;
		int idLugar = -1;
		do {
			System.out.println("Seleccione el lugar de la nueva prueba:");
			for (Lugar l : Lugar.values()) {
				System.out.println(l.ordinal() + " para " + l.getNombre());
			}
			idLugar = in.nextInt();
			if (idLugar >= 0 && idLugar < Lugar.values().length)
				valido = true;
		} while (!valido);
		lugar = Lugar.values()[idLugar];
		// Metodo nuevo patrocinador para que solicite los datos del patrocinador de la prueba 
		Patrocinador patrocinador = Patrocinador.nuevoPatrocinador();

		ret = new Prueba(id, nombre, fecha, lugar, ind, patrocinador);
		return ret;
	}

}
