package principal;

import java.util.Scanner;

import Validación.Validador;

public class Alergia extends Historial {

	// idAlergia es el identificador único de cada elemento Alergia
	protected long idAlergia;

	// nombre representa el nombre de la alergia
	// Es una cadena de caracteres de longitud mínimo 3 y máximo 50 caracteres
	// No acepta dígitos ni caracteres especiales
	protected String nombreAlergia;

	// Variable que utilizaremos para completar de forma automática el identificador
	// de la alergia.
	private static int numeroAlergias = 0;

	// Constructor por defecto, cada vez que le hagamos una llamada aumentará el
	// numero de alergias en 1 y se le asignará ese valor al identificador.
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
		
	// Método encargado de guardar la nueva alergia de un paciente.
	// Se le pide al usuario que escriba el nombre de la alergia y se guarda en
	// una variable auxiliar.
	// Esta variable será la que pasaremos por parametros haciendo llamada al
	// constructor anterior para establecer el nombre de la alergia
	// Finalmente devolvemos los datos introducidos.

	public static Alergia nuevaAlergia() {
		Scanner teclado = new Scanner(System.in);
	
		String nom = "";
		boolean nomValido = false;

		do {
			System.out.println("Introduce el nombre de la alergia (en el caso de que así sea): ");
			nom = teclado.nextLine();
			nomValido = Validador.validarNombreAlergia(nom);
		} while (!nomValido);
		teclado.close();
		return new Alergia();
	}

	//Getters y setters

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

	//ToString
	@Override
	public String toString() {
		return "Alergia [idAlergia=" + idAlergia + ", nombreAlergia=" + nombreAlergia + "]";
	}

}