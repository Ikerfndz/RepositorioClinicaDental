package principal;

import java.util.Scanner;

import validacion.Validador;

public class Secretariado extends Empleado {
	protected int numAniosExp;
	// almacena los a�os de experiencia de un secretario
	// se almacenan en una variable de tipo int

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

//	public Secretariado(Empleado e, int aniosExp) {
//		super(e.getNombre(), e.getApellidos(), e.gettelefono(), e.getdireccion(), e.getnif());
//		this.numA�osExp = aniosExp;		
//	}
	
	public Secretariado(Empleado e, int aniosExp) {
		super(e);
		this.numAniosExp = aniosExp;
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
		
		int anios=0;
		boolean aniosExpvalidoSecretario=false;
		do {
		System.out.println("Introduzca los a�os de experiencia del secretario");
		anios = teclado.nextInt();
		aniosExpvalidoSecretario=Validador.validarAniosExpSecretario(anios);
		} while(!aniosExpvalidoSecretario);
		teclado.close();
		return ret;
	}

	// Getters y setters
	public int getNumAniosExp() {
		return numAniosExp;
	}

	public void setNumAniosExp(int numAniosExp) {
		this.numAniosExp = numAniosExp;
	}

	// To String
	@Override
	public String toString() {
		return "Secretariado [numA�osExp=" + numAniosExp + ", idEmpleado=" + idEmpleado + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", telefono=" + telefono + ", direccion=" + direccion + ", nif=" + nif
				+ "]";
	}

}
