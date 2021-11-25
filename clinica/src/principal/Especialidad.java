package principal;

import java.util.Scanner;

import utils.Datos;

public class Especialidad {
	private long idEsp;
	// Identificador de la especialidad que se va rellenando automáticamente cada
	// vez que se hace una llamada a sus constructores
	private String nombreEsp;
	// Nombre de la especialidad de tipo String
	private static int numeroEspecialiades = Datos.numEspecialidades;
	// Variable que utilizaremos para completar de forma automática el identificador
	// de la especialidad.
	private Cirujano cirujano;
	// Variable de tipo Cirujano donde guardaremos a que cirujano pertenece la
	// especialidad.

	// Constructor por defecto, cada vez que le hagamos una llamada aumentará el
	// numero de especialidades en 1 y se le asignará ese valor al identificador.
	public Especialidad() {
		numeroEspecialiades = numeroEspecialiades + 1;
		idEsp = numeroEspecialiades;
	}

	// Constructor que se le pide por parametro el nombre de la especialidad.
	// Hace una llamada al constructor por defecto.
	// Guarda el valor del parametro introducido en la variable nombeesp.
	public Especialidad(String nombreEsp, long id) {
		this();
		this.nombreEsp = nombreEsp;
		idEsp=id;
	}
	
	public Especialidad(String nombreEsp) {
		this();
		this.nombreEsp = nombreEsp;
	}


	// Método encargado de guardar la nueva especialidad de un cirujano.
	// Se le pide al usuario que escriba el nombre de la especialidad y se guarda en
	// una variable auxiliar.
	// Esta variable será la que pasaremos por parametros haciendo llamada al
	// constructor anterior para establecer el nombre de la especialidad
	// Finalmente devolvemos los datos introducidos.
	public static Especialidad nuevaEspecialidad() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el nombre de la especialidad");
		String nom = "";
		nom = teclado.nextLine();
		teclado.close();
		return new Especialidad(nom);
	}

	// Getters y setters

	public long getIdEsp() {
		return idEsp;
	}

	public void setIdEsp(long idEsp) {
		this.idEsp = idEsp;
	}

	public String getNombreEsp() {
		return nombreEsp;
	}

	public void setNombreEsp(String nombreEsp) {
		this.nombreEsp = nombreEsp;
	}

	public static int getnumeroEspecialiades() {
		return numeroEspecialiades;
	}

	public static void setnumeroEspecialiades(int numeroEspecialiades) {
		Especialidad.numeroEspecialiades = numeroEspecialiades;
	}

	public static int getNumeroEspecialiades() {
		return numeroEspecialiades;
	}

	public static void setNumeroEspecialiades(int numeroEspecialiades) {
		Especialidad.numeroEspecialiades = numeroEspecialiades;
	}

	public Cirujano getCirujano() {
		return cirujano;
	}

	public void setCirujano(Cirujano cirujano) {
		this.cirujano = cirujano;
	}

	// To String
	@Override
	public String toString() {
		return "Especialidad [idEsp=" + idEsp + ", nombreEsp=" + nombreEsp + ", cirujano=" + cirujano + "]";
	}

}
