package principal;

import java.util.Scanner;

import Validaci�n.Validador;

public class Alergia extends Historial {

	// idAlergia es el identificador �nico de cada elemento Alergia
	protected long idAlergia;

	// nombre representa el nombre de la alergia
	// Es una cadena de caracteres de longiyud m�nimo 3 y m�ximo 50 caracteres
	// No acepta d�gitos ni caracteres especiales
	protected String nombre;

	public Alergia() {

	}

	public static Alergia nuevaAlergia() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce la id de la alergia (en el caso de que as� sea): ");
		long idAlergia = 0;
		idAlergia = teclado.nextLong();
		teclado.close();

		String nom = "";
		boolean nomValido = false;

		do {
			System.out.println("Introduce el nombre de la alergia (en el caso de que as� sea): ");
			nom = teclado.nextLine();
			nomValido = Validador.validarNombreAlergia(nom);
		} while (!nomValido);
		teclado.close();
		return new Alergia();
	}

	public long getIdAlergia() {
		return idAlergia;
	}

	public void setIdAlergia(long idAlergia) {
		this.idAlergia = idAlergia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Alergia [idAlergia=" + idAlergia + ", nombre=" + nombre + "]";
	}

}