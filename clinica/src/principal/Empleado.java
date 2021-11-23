package principal;

import java.util.Scanner;

import validacion.Validador;

public class Empleado {

	protected long idEmpleado;
	// id es el identificador unico de cada elemento Empleado
	// es un valor entero > 0
	// el valor de idEmpleado se va rellenando automaticamente cada vez que se hace
	// llamada a uno de sus constructores
	protected String nombre;
	// nombre representa el nombre de la empleado
	// es una cadena de caracteres con un minimo de 3 caracteres y maximo de 50
	// no acepta numeros ni caracteres especiales
	protected String apellidos;
	// nombre representa el nombre de la empleado
	// es una cadena de caracteres con un minimo de 3 caracteres y maximo de 50
	// no acepta numeros ni caracteres especiales
	protected String telefono;
	// telefono representa al numero de telefono del empleado
	// esta formado por 9 digitos
	// es un valor entero
	protected String direccion;
	// direccion representa la direccion del empleado
	// esta formado por una cadena de caracteres de minimo 5 caracteres y un maximo
	// de 50
	protected String nif;
	// indica el nif de cada empleado
	// es una cadena de caracteres de minimo 3 caracteres y maximo 50
	// no acepta caracteres especiales
	private static int numeroEmpleados = 0;
	// numeroEmpleados es de tipo entero
	// esta variable nos permitira completar de forma automatica el idEmpleado

	// Constructor por defecto -> cada vez que le hagamos una llamada aumentara el
	// valor de numeroEmpleados en 1 y se le asignara ese valor al idEmpleado

	public Empleado() {
		numeroEmpleados++;
		this.idEmpleado = numeroEmpleados;
	}

	// Constructor que se le pide por parametro el nombre del empleado, los
	// apellidos, el telefono, la direccion y el nif
	// Hace una llamada al constructor por defecto.
	// Guarda el valor del parametro introducido en la variables
	public Empleado(String nombre, String apellidos, String telefono, String direccion, String nif) {
		this();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.nif = nif;
	}

	// Metodo nuevoEmpleado -> encargado de registrar a un nuevo empleado
	// Se le pide al usuario que ingrese los siguentes datos sobre el nuevo
	// empleado: nombre, apellidos, telefono, direccion y nif
	// Todos estos datos son guardados en variables auxiliares distintas
	// Estas variables serán las que pasaremos por parametros haciendo llamada al
	// constructor anterior para establecer un nuevo empleado con todos sus
	// atributos
	// Finalmente se devuelven los datos introducidos
	public static Empleado nuevoEmpleado() {
		Empleado ret = new Empleado();
		Scanner teclado;
		teclado = new Scanner(System.in);

		String nomEmpleado = "";
		boolean nombreEmpleadoValido = false;
		do {
			System.out.println("Introduzca el nombre del empleado");
			nomEmpleado = teclado.nextLine();
			nombreEmpleadoValido = Validador.validarNombreEmpleado(nomEmpleado);
		} while (!nombreEmpleadoValido);
		ret.setNombre(nomEmpleado);

		String apeEmpleado = "";
		boolean apeEmpleadoValido = false;
		do {
			System.out.println("Introduzca los apellidos del empleado");
			apeEmpleado = teclado.nextLine();
			apeEmpleadoValido = Validador.validarApellidoEmpleado(apeEmpleado);
		} while (!apeEmpleadoValido);
		ret.setApellidos(apeEmpleado);

		String telEmpleado = "";
		boolean telEmpleadoValido = false;
		do {
			System.out.println("Introduzca el telefono del empleado");
			telEmpleado = teclado.nextLine();
			telEmpleadoValido = Validador.validarTelefonoValido(telEmpleado);
		} while (!telEmpleadoValido);
		ret.setTelefono(telEmpleado);

		String dirEmpleado = "";
		boolean dirEmpleadoValido = false;
		do {
			System.out.println("Introduzca la direccion del empleado");
			dirEmpleado = teclado.nextLine();
			dirEmpleadoValido = Validador.validarDireccionEmpleado(dirEmpleado);
		} while (!dirEmpleadoValido);
		ret.setDireccion(dirEmpleado);

		String niEmpleado = "";
		boolean niEmpleadoValido = false;
		do {
			System.out.println("Introduzca el nif del empleado");
			niEmpleado = teclado.nextLine();
			niEmpleadoValido = Validador.validarnifEmpleado(niEmpleado);
		} while (!niEmpleadoValido);
		ret.setNif(niEmpleado);

		teclado.close();
		return ret;
	}

	// Getters y setters

	public long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public static int getNumeroEmpleados() {
		return numeroEmpleados;
	}

	public static void setNumeroEmpleados(int numeroEmpleados) {
		Empleado.numeroEmpleados = numeroEmpleados;
	}

	// To String

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono="
				+ telefono + ", direccion=" + direccion + ", nif=" + nif + "]";
	}

}
