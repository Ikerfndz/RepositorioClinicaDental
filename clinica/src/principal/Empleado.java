package principal;

import java.util.Scanner;

import utils.Datos;
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
	private static int numeroEmpleados = Datos.numEmpleadosd;
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

	public Empleado(String nombre, long id, String apellidos, String telefono, String direccion, String nif) {
		this();
		this.nombre = nombre;
		this.idEmpleado = id;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.nif = nif;
	}

	// Constructor de copia -> para copiar los atributos de la clase padre empleado
	public Empleado(Empleado e) {
		this.nombre = e.getNombre();
		this.apellidos = e.getApellidos();
		this.telefono = e.getTelefono();
		this.direccion = e.getDireccion();
		this.nif = e.getNif();
	}

	// Metodo nuevoEmpleado -> encargado de registrar a un nuevo empleado
	// Se le pide al usuario que ingrese los siguentes datos sobre el nuevo
	// empleado: nombre, apellidos, telefono, direccion y nif
	// Todos estos datos son guardados en variables auxiliares distintas
	// Estas variables ser�n las que pasaremos por parametros haciendo llamada al
	// constructor anterior para establecer un nuevo empleado con todos sus
	// atributos
	// Finalmente se devuelven los datos introducidos
	public static Empleado nuevoEmpleado() {
		Empleado ret = null;
		Scanner teclado;
		boolean valido = false;

		String nomEmpleado = "";
		do {
			System.out.println("Introduzca el nombre del nuevo empleado: ");
			teclado = new Scanner(System.in);
			nomEmpleado = teclado.nextLine();
			valido = Validador.validarNombreEmpleado(nomEmpleado);
		} while (!valido);

		valido = false;
		String apeEmpleado = "";
		do {
			System.out.println("Introduzca los apellidos del nuevo empleado");
			apeEmpleado = teclado.nextLine();
			valido = Validador.validarApellidoEmpleado(apeEmpleado);
		} while (!valido);

		valido = false;
		String telEmpleado = "";
		do {
			System.out.println("Introduzca el telefono del nuevo empleado");
			telEmpleado = teclado.nextLine();
			valido = Validador.validarTelefonoValido(telEmpleado);
		} while (!valido);

		valido = false;
		String dirEmpleado = "";
		do {
			System.out.println("Introduzca la direccion del nuevo empleado");
			dirEmpleado = teclado.nextLine();
			valido = Validador.validarDireccionEmpleado(dirEmpleado);
		} while (!valido);

		valido = false;
		String niEmpleado = "";
		do {
			System.out.println("Introduzca el nif del nuevo empleado");
			niEmpleado = teclado.nextLine();
			valido = Validador.validarnifEmpleado(niEmpleado);
		} while (!valido);

		ret = new Empleado(nomEmpleado, apeEmpleado, telEmpleado, dirEmpleado, niEmpleado);
		return ret;
	}

	public static void motrarEmpleado() {
		System.out.println("Lista de Empleados disponibles:");
		for (int i = 0; i < Datos.numEmpleadosd; i++) {
			Empleado e = Datos.EMPLEADOS[i];
			System.out.println(e.toString());
		}
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
