package principal;

import java.util.Scanner;

public class Secretariado extends Empleado {
	protected String numA�osExp;
	// almacena los a�os de experiencia de un secretario
	// es una cadena de caracteres con un minimo de 3 caracteres y maximo de 50
	// no acepta numeros ni caracteres especiales

	public Secretariado() {
	}

	public Secretariado(String numA�osExp, Empleado empleado) {
		super(empleado);
		this.numA�osExp = numA�osExp;
	}

	public static Secretariado nuevoSecretario() {
		Secretariado ret = new Secretariado();
		Scanner teclado;
		teclado = new Scanner(System.in);

		System.out.println("Introduzca los a�os de experiencia del secretario");
		String anios = "";
		anios = teclado.nextLine();
		ret.setNumA�osExp(anios);
		return ret;
	}

	public String getNumA�osExp() {
		return numA�osExp;
	}

	public void setNumA�osExp(String numA�osExp) {
		this.numA�osExp = numA�osExp;
	}

	@Override
	public String toString() {
		return "Secretariado [numA�osExp=" + numA�osExp + ", idEmpleado=" + idEmpleado + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", telefono=" + telefono + ", direccion=" + direccion + ", nif=" + nif
				+ "]";
	}

}
