package principal;

import java.util.Scanner;

public class Secretariado extends Empleado {
	protected String numAñosExp;
	// almacena los años de experiencia de un secretario
	// es una cadena de caracteres con un minimo de 3 caracteres y maximo de 50
	// no acepta numeros ni caracteres especiales

	public Secretariado() {
	}

	public Secretariado(String numAñosExp, Empleado empleado) {
		super(empleado);
		this.numAñosExp = numAñosExp;
	}

	public static Secretariado nuevoSecretario() {
		Secretariado ret = new Secretariado();
		Scanner teclado;
		teclado = new Scanner(System.in);

		System.out.println("Introduzca los años de experiencia del secretario");
		String anios = "";
		anios = teclado.nextLine();
		ret.setNumAñosExp(anios);
		return ret;
	}

	public String getNumAñosExp() {
		return numAñosExp;
	}

	public void setNumAñosExp(String numAñosExp) {
		this.numAñosExp = numAñosExp;
	}

	@Override
	public String toString() {
		return "Secretariado [numAñosExp=" + numAñosExp + ", idEmpleado=" + idEmpleado + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", telefono=" + telefono + ", direccion=" + direccion + ", nif=" + nif
				+ "]";
	}

}
