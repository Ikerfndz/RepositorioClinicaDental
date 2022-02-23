package entidades;

import java.util.Scanner;

public class Alergia extends Historial {

	// idAlergia es el identificador �nico de cada elemento Alergia
	protected long idAlergia;

	// nombre representa el nombre de la alergia
	// Es una cadena de caracteres de longitud m�nimo 3 y m�ximo 50 caracteres
	// No acepta d�gitos ni caracteres especiales
	protected String nombreAlergia;

	// Variable que utilizaremos para completar de forma autom�tica el identificador
	// de la alergia.
	private static int numeroAlergias = 0;
	
	public Medicamento medicamento;

	// Constructor por defecto, cada vez que le hagamos una llamada aumentar� el
	// numero de alergias en 1 y se le asignar� ese valor al identificador.
	public Alergia() {
		numeroAlergias = numeroAlergias + 1;
		idAlergia = numeroAlergias;
	}

	// Constructor que se le pide por parametro el nombre de la alergia.
	// Hace una llamada al constructor por defecto.
	// Guarda el valor del parametro introducido en la variable nombreAlergia.
	public Alergia(String nombreAlergia) {
		numeroAlergias = numeroAlergias + 1;
		idAlergia = numeroAlergias;
		this.nombreAlergia = nombreAlergia;
	}
	
	
	public Alergia (long idAlergia, String nombreAlergia, Medicamento medicamento) {
		super();
		this.idAlergia = idAlergia;
		this.nombreAlergia = nombreAlergia;
		this.medicamento = medicamento;
	}

	// M�todo encargado de guardar la nueva alergia de un paciente.
	// Se le pide al usuario que escriba el nombre de la alergia y se guarda en
	// una variable auxiliar.
	// Esta variable ser� la que pasaremos por parametros haciendo llamada al
	// constructor anterior para establecer el nombre de la alergia
	// Finalmente devolvemos los datos introducidos.

	public static Alergia nuevaAlergia() {
		Scanner teclado = new Scanner(System.in);

		String nom = "";
		boolean nomValido = false;

		do {
			System.out.println("Introduce el nombre de la alergia (en el caso de que as� sea): ");
			nom = teclado.nextLine();
			nomValido = validarNombreAlergia(nom);
		} while (!nomValido);
		return new Alergia();
	}

	// Validadores

	private static boolean validarNombreAlergia(String nom) {
		return false;
	}

	// Getters y setters

	public long getIdAlergia() {
		return idAlergia;
	}

	public void setIdAlergia(long idAlergia) {
		this.idAlergia = idAlergia;
	}

	public String getNombreAlergia() {
		return nombreAlergia;
	}

	public void setNombreAlergia(String nombreAlergia) {
		this.nombreAlergia = nombreAlergia;
	}

	public static int getNumeroAlergias() {
		return numeroAlergias;
	}

	public static void setNumeroAlergias(int numeroAlergias) {
		Alergia.numeroAlergias = numeroAlergias;
	}

	// ToString
	@Override
	public String toString() {
		return "Alergia [idAlergia=" + idAlergia + ", nombreAlergia=" + nombreAlergia + "]";
	}

	
}