package entidades;

import java.util.Scanner;

import utils.Datos;
import validacion.Validador;

/**
 * @author MiguelH
 */
public class Secretariado extends Empleado {

	// almacena los a�os de experiencia de un secretario
	// se almacenan en una variable de tipo int
	protected int numAniosExp;

	// Constructor por defecto de la clase Secretariado
	public Secretariado() {

	}

	// Constructor que recibe por parametros los atributos de la clase empleado
	// y los a�os de experiencia del secretario
	// Primero hace una llamada a super para sacar los datos del empleado.
	// Luego guarda los datos recibidos en la variable numA�osExp
	public Secretariado(String nombre, String apellidos, String telefono, String direccion, String nif,
			int numAniosExp) {
		super(nombre, apellidos, telefono, direccion, nif);
		this.numAniosExp = numAniosExp;
	}

	public Secretariado(Empleado e, int aniosExp) {
		super(e);
		this.numAniosExp = aniosExp;
	}

	// Getters y setters
	public int getNumAniosExp() {
		return numAniosExp;
	}

	public void setNumAniosExp(int numAniosExp) {
		this.numAniosExp = numAniosExp;
	}

	/***
	 * Funci�n que pregunta al usuario por cada uno de los campos para un nuevo
	 * Secretariado, los valida y si son correctos devuelve un objeto Secretariado
	 * completo Se preguntara al usuario por los a�os de experiencia del
	 * secretario, y a continuacion se preguntaran los datos del metodo
	 * nuevoEmpleado
	 * 
	 * @return un objeto Secretariado completo v�lido o null si hubo alg�n error
	 */
	public static Secretariado nuevoSecretario() {
		Secretariado ret = null;
		Scanner teclado;
		teclado = new Scanner(System.in);

		int anios = 0;
		boolean aniosExpvalidoSecretario = false;
		do {
			System.out.println("Introduzca los a�os de experiencia del secretario");
			anios = teclado.nextInt();
			aniosExpvalidoSecretario = Validador.validarAniosExpSecretario(anios);
		} while (!aniosExpvalidoSecretario);

		System.out.println("Ahora introduzca los datos del empleado: ");
		Secretariado s = (Secretariado) Empleado.nuevoEmpleado();

		ret = new Secretariado(s, anios);
		return ret;

	}

	/***
	 * Metodo que recorre el array de los secretarios, de la clase Datos, los
	 * almacena en la variable s y a continuacion se muestran a traves del metodo
	 * toString de la clase Secretariado
	 */
	public static void motrarSecretario() {
		System.out.println("Lista de Secretarios disponibles:");
		for (int i = 0; i < Datos.numSecretarios; i++) {
			Secretariado s = Datos.SECRETARIOS[i];
			System.out.println(s.toString());
		}
	}

	/**
	 * Funci�n que devuelve una cadena de caracteres con la siguiente estructura
	 * <Empleado.id>|<Empleado.nombre>|<Empleado.apellidos>|<Empleado.nif>|<Empleado.direccion>|<Empleado.telefono>|<numAniosExp>
	 * Cada campo se separa mediante el caracter '|'
	 * 
	 * @return
	 */
	public String data() {
		return "" + this.getIdEmpleado() + "|" + this.getNombre() + "|" + this.getApellidos() + "|" + this.getNif()
				+ "|" + this.getDireccion() + "|" + this.getTelefono() + "|" + this.numAniosExp;
	}

	/***
	 * Funci�n que devuelve una cadena de caracteres con los datos del
	 * Secretariado en el siguiente formato: "Secretariado [numAniosExp="
	 * <numAniosExp> ", idEmpleado=" <idEmpleado> ", nombre=" <nombre> ",
	 * apellidos=" <apellidos> ", telefono=" <telefono> ", direccion=" <direccion>
	 * ", nif=" <nif>"]"
	 */
	@Override
	public String toString() {
		return "Secretariado [numAniosExp=" + numAniosExp + ", idEmpleado=" + idEmpleado + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", telefono=" + telefono + ", direccion=" + direccion + ", nif=" + nif
				+ "]";
	}

}
