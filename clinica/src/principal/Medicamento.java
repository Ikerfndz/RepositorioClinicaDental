package principal;

import java.util.Scanner;

public class Medicamento extends Alergia {

	// idMedicamento es el identificador único de cada elemento Medicamento
	protected long idMedicamento;

	// nombre representa el nombre del medicamento
	// Es una cadena de caracteres de longiyud mínimo 3 y máximo 50 caracteres
	// No acepta dígitos ni caracteres especiales
	protected String nombreMedicamento;

	// Variable que utilizaremos para completar de forma automática el identificador
	// del medicamento.
	private static int numeroMedicamentos = 0;

	// principioActivo representa el nombre del principio activo
	// Es una cadena de caracteres de longitud mínimo 3 y máximo 50 caracteres
	// No acepta dígitos ni caracteres especiales
	protected String principioActivo;

	// dosisMaxDiaria representa la dosis máxima diaria
	// es un valor >0
	protected double dosisMaxDiaria;

	// Constructor por defecto, cada vez que le hagamos una llamada aumentará el
	// numero de medicamentos en 1 y se le asignará ese valor al identificador.
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

	// Método encargado de guardar el nuevo medicamento.
	// Se le pide al usuario que escriba el nombre del medicamento y se guarda en
	// una variable auxiliar.
	// Esta variable será la que pasaremos por parametros haciendo llamada al
	// constructor anterior para establecer el nombre del medicamento.
	// Finalmente devolvemos los datos introducidos.

	public static Medicamento nuevoMedicamento() {

		Medicamento ret = new Medicamento();
		Scanner teclado = new Scanner(System.in);

		String nombre = "";
		boolean nombreValido = false;

		do {
			System.out.println("Introduce el nombre del medicamento: ");
			nombre = teclado.nextLine();
			nombreValido = validarNombreMedicamento(nombre);
		} while (!nombreValido);

		teclado.close();
		ret.setNombreMedicamento(nombre);

		System.out.println("Introduce el nombre del principio activo: ");
		String principioActivo = "";
		principioActivo = teclado.nextLine();
		teclado.close();
		ret.setPrincipioActivo(principioActivo);

		System.out.print("Introduce la dosis máxima diaria: ");
		double dosisMaximaDiaria = 0;
		dosisMaximaDiaria = teclado.nextDouble();
		ret.setDosisMaxDiaria(dosisMaximaDiaria);

		return new Medicamento();
	}
	
	//Validadores

	private static boolean validarNombreMedicamento(String nombre) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//Getters y setters

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

	//ToString
	@Override
	public String toString() {
		return "Medicamento [idMedicamento=" + idMedicamento + ", nombreMedicamento=" + nombreMedicamento
				+ ", principioActivo=" + principioActivo + ", dosisMaxDiaria=" + dosisMaxDiaria + "]";
	}

}
