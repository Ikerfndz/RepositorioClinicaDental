package entidades;

import java.util.Scanner;

public class Medicamento extends Alergia {

	// idMedicamento es el identificador �nico de cada elemento Medicamento
	protected long idMedicamento;

	// nombre representa el nombre del medicamento
	// Es una cadena de caracteres de longiyud m�nimo 3 y m�ximo 50 caracteres
	// No acepta d�gitos ni caracteres especiales
	protected String nombreMedicamento;

	// Variable que utilizaremos para completar de forma autom�tica el identificador
	// del medicamento.
	private static int numeroMedicamentos = 0;

	// principioActivo representa el nombre del principio activo
	// Es una cadena de caracteres de longitud m�nimo 3 y m�ximo 50 caracteres
	// No acepta d�gitos ni caracteres especiales
	protected String principioActivo;

	// dosisMaxDiaria representa la dosis m�xima diaria
	// es un valor >0
	protected double dosisMaxDiaria;

	// Constructor por defecto, cada vez que le hagamos una llamada aumentar� el
	// numero de medicamentos en 1 y se le asignar� ese valor al identificador.
	public Medicamento() {
		numeroMedicamentos = numeroMedicamentos + 1;
		idMedicamento = numeroMedicamentos;

	}

	// Constructor que se le pide por parametro el nombre de la especialidad.
	// Hace una llamada al constructor por defecto.
	// Guarda el valor del parametro introducido en la variable nombeesp.
	public Medicamento(String nombreMedicamento) {
		numeroMedicamentos = numeroMedicamentos + 1;
		idMedicamento = numeroMedicamentos;
		this.nombreMedicamento = nombreMedicamento;
	}

	// M�todo encargado de guardar el nuevo medicamento.
	// Se le pide al usuario que escriba el nombre del medicamento y se guarda en
	// una variable auxiliar.
	// Esta variable ser� la que pasaremos por parametros haciendo llamada al
	// constructor anterior para establecer el nombre del medicamento.
	// Finalmente devolvemos los datos introducidos.

	public static Medicamento nuevoMedicamento() {

		Medicamento ret = new Medicamento();
		Scanner teclado = new Scanner(System.in);

		// nombreMedicamento
		String nombre = "";
		boolean nombreValido = false;

		do {
			System.out.println("Introduce el nombre del medicamento: ");
			nombre = teclado.nextLine();
			nombreValido = validarNombreMedicamento(nombre);
		} while (!nombreValido);

		ret.setNombreMedicamento(nombre);

		// nombrePrincipioActivo
		String principioActivo = "";
		boolean nombrepValido = false;

		do {
			System.out.println("Introduce el nombre del principio activo: ");
			principioActivo = teclado.nextLine();
			nombrepValido = validarPrincipioActivo(principioActivo);
		} while (!nombrepValido);

		ret.setPrincipioActivo(principioActivo);

		// dosisM�xima
		double dosisMaximaDiaria = 0;
		boolean dosisValida = false;

		do {
			System.out.print("Introduce la dosis m�xima diaria: ");
			dosisMaximaDiaria = teclado.nextDouble();
			dosisValida = validarDosisMaxima(dosisMaximaDiaria);
		} while (!dosisValida);

		ret.setDosisMaxDiaria(dosisMaximaDiaria);

		return new Medicamento();
	}
	
	/*
	 * Metodo encargado de mostrar los datos del Medicamento a través de un String
	 * de manera que todos queden separados por el carácter "|".
	 * El primer campo corresponde con la clave primaria de la clase Medicamento
	 */
	public String data() {
		String medicamento = "";
		medicamento = this.idMedicamento + "|" +  this.nombreMedicamento + "|" + this.principioActivo + "|" + this.dosisMaxDiaria;
		return medicamento;
	}


	// Validadores

	public static boolean validarNombreMedicamento(String nombre) {
		return false;
	}

	public static boolean validarPrincipioActivo(String principioActivo2) {
		return false;
	}

	public static boolean validarDosisMaxima(double dosisMaximaDiaria) {
		// TODO Auto-generated method stub
		return false;
	}
	// Getters y setters

	public long getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(long idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public String getNombreMedicamento() {
		return nombreMedicamento;
	}

	public void setNombreMedicamento(String nombreMedicamento) {
		this.nombreMedicamento = nombreMedicamento;
	}

	public static int getNumeroMedicamentos() {
		return numeroMedicamentos;
	}

	public static void setNumeroMedicamentos(int numeroMedicamentos) {
		Medicamento.numeroMedicamentos = numeroMedicamentos;
	}

	public String getPrincipioActivo() {
		return principioActivo;
	}

	public void setPrincipioActivo(String principioActivo) {
		this.principioActivo = principioActivo;
	}

	public double getDosisMaxDiaria() {
		return dosisMaxDiaria;
	}

	public void setDosisMaxDiaria(double dosisMaxDiaria) {
		this.dosisMaxDiaria = dosisMaxDiaria;
	}

	// ToString
	@Override
	public String toString() {
		return "Medicamento [idMedicamento=" + idMedicamento + ", nombreMedicamento=" + nombreMedicamento
				+ ", principioActivo=" + principioActivo + ", dosisMaxDiaria=" + dosisMaxDiaria + "]";
	}
	
}
