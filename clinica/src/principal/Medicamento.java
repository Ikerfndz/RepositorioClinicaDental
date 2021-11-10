package principal;

import java.util.Scanner;

public class Medicamento extends Alergia {

	// idMedicamento es el identificador único de cada elemento Medicamento
	protected long idMedicamento;

	// nombre representa el nombre del medicamento
	// Es una cadena de caracteres de longiyud mínimo 3 y máximo 50 caracteres
	// No acepta dígitos ni caracteres especiales
	protected String nombre;

	// principioActivo representa el nombre del principio activo
	// Es una cadena de caracteres de longitud mínimo 3 y máximo 50 caracteres
	// No acepta dígitos ni caracteres especiales
	protected String principioActivo;

	// dosisMaxDiaria representa la dosis máxima diaria
	// es un valor >0
	protected double dosisMaxDiaria;

	public Medicamento() {

	}

	public static Medicamento nuevoMedicamento() {
		
		Medicamento ret = new Medicamento();
		Scanner teclado = new Scanner(System.in);

		System.out.println("Introduce el id del medicamento: ");
		long idMedicamento = 0;
		idMedicamento = teclado.nextLong();
		teclado.close();
		ret.setIdMedicamento(idMedicamento);

		
		String nombre = "";
		boolean nombreValido = false;
		
		do {
			System.out.println("Introduce el nombre del medicamento: ");
			nombre = teclado.nextLine();
			nombreValido = validarNombreMedicamento(nombre);
		} while (      ! nombreValido          );
		
		teclado.close();
		ret.setNombre(nombre);

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

	private static boolean validarNombreMedicamento(String nombre2) {
		// TODO Auto-generated method stub
		return false;
	}

	public long getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(long idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return "Medicamento [idMedicamento=" + idMedicamento + ", nombre=" + nombre + ", principioActivo="
				+ principioActivo + ", dosisMaxDiaria=" + dosisMaxDiaria + "]";
	}

}

