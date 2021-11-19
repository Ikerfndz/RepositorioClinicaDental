package principal;

import java.util.Scanner;

public class Empleado {

	public Empleado(Empleado empleado) {
		setNombre(empleado.nombre);
		setApellidos(empleado.apellidos);
		setTelefono(empleado.telefono);
		setDireccion(empleado.direccion);
		setNif(empleado.nif);
	}

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

	// Constructor que se le pide por parametro el nombre del empleado
	public Empleado(String nombre, int id) {
		super();
		numeroEmpleados = numeroEmpleados + 1;
		this.nombre = nombre;
		this.idEmpleado = numeroEmpleados;
	}

	public Empleado(long idEmpleado, String nombre, String apellidos, String telefono, String direccion, String nif) {
		super();
		this.idEmpleado = idEmpleado;
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

		String nom = "";
		boolean nombreEmpleadoValido = false;
		
		
		System.out.println("Introduzca el nombre del empleado");
		nom = teclado.nextLine();
		ret.setNombre(nom);
		
		System.out.println("Introduzca los apellidos del empleado");
		String ape = "";
		ape = teclado.nextLine();
		ret.setApellidos(ape);
		System.out.println("Introduzca el telefono del empleado");
		String tel = "";
		tel = teclado.nextLine();
		ret.setTelefono(tel);
		System.out.println("Introduzca la direccion del empleado");
		String dir = "";
		dir = teclado.nextLine();
		ret.setDireccion(dir);
		System.out.println("Introduzca el nif del empleado");
		String ni = "";
		ni = teclado.nextLine();
		ret.setNif(ni);

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
