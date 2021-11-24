package principal;

import java.util.Scanner;

import validacion.Validador;

public class Secretariado extends Empleado {
	protected String numA�osExp;
	// almacena los a�os de experiencia de un secretario
	// es una cadena de caracteres con un minimo de 3 caracteres y maximo de 50
	// no acepta numeros ni caracteres especiales

	// Constructor por defecto de la clase Secretariado
	public Secretariado() {
	}

	// Constructor que recibe por parametros los atributos de la clase empleado
	// y los a�os de experiencia del secretario
	// Primero hace una llamada a super para sacar los datos del empleado.
	// Luego guarda los datos recibidos en la variable numA�osExp
	public Secretariado(String nombre, String apellidos, String telefono, String direccion, String nif,
			String numA�osExp) {
		super(nombre, apellidos, telefono, direccion, nif);
		this.numA�osExp = numA�osExp;
	}

	// Metodo nuevoSecretario -> encargado de guardar los a�os de experiencia de un
	// secretario
	// Se le pide al usuario que ingrese los a�os de experiencia y los guarda en una
	// variable auxiliar
	// Esta variable ser� la que pasaremos por parametros haciendo llamada al
	// constructor anterior para establecer el numero de a�os de experiencia
	// Finalmente devolvemos los datos introducidos.
	public static Secretariado nuevoSecretario() {
		Secretariado ret = new Secretariado();
		Scanner teclado;
		teclado = new Scanner(System.in);
		
		String anios="";
		boolean aniosExpvalidoSecretario=false;
		do {
		System.out.println("Introduzca los a�os de experiencia del secretario");
		anios = teclado.nextLine();
		aniosExpvalidoSecretario=Validador.validarAniosExpSecretario(anios);
		} while(!aniosExpvalidoSecretario);
		teclado.close();
		return ret;
	}

	// Getters y setters
	public String getNumA�osExp() {
		return numA�osExp;
	}

	public void setNumA�osExp(String numA�osExp) {
		this.numA�osExp = numA�osExp;
	}

	// To String
	@Override
	public String toString() {
		return "Secretariado [numA�osExp=" + numA�osExp + ", idEmpleado=" + idEmpleado + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", telefono=" + telefono + ", direccion=" + direccion + ", nif=" + nif
				+ "]";
	}

}
