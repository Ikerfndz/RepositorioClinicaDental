package entidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import utils.Datos;
import validacion.Validador;

/**
 * @author MiguelH
 */

public class Empleado {

	// id del empleado, es un didentificador unico, un valor entero>0
	protected long idEmpleado;

	// Nombre del empleado, es una cadena de caracteres, con un minimo de 3 y un
	protected String nombre;

	// nombre representa el nombre de la empleado
	// es una cadena de caracteres con un minimo de 3 caracteres y maximo de 50
	// no acepta numeros ni caracteres especiales
	protected String apellidos;

	// telefono representa al numero de telefono del empleado
	// esta formado por 9 digitos
	// es un valor entero
	protected String telefono;

	// direccion representa la direccion del empleado
	// esta formado por una cadena de caracteres de minimo 5 caracteres y un maximo
	// de 50
	protected String direccion;

	// indica el nif de cada empleado
	// es una cadena de caracteres de minimo 3 caracteres y maximo 50
	// no acepta caracteres especiales
	protected String nif;

	// numeroEmpleados es de tipo entero
	// esta variable nos permitira completar de forma automatica el idEmpleado
	private static int numeroEmpleados = Datos.numEmpleadosd;

	/**
	 * Constructor por defecto de la clase empleado, da un estado inicial al numero
	 * de los empleados, aumentando el numero en 1.
	 */
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

	/***
	 * Funci???n que pregunta al usuario por cada uno de los campos para un nuevo
	 * Empleado, los valida y si son correctos devuelve un objeto Empleado completo
	 * Se preguntara al usuario por los siguentes datos: nombre, apellidos,
	 * telefono, direccion y nif Estos datos se guardan en variables auxialiares
	 * distintas
	 * 
	 * @return un objeto Manager completo v???lido o null si hubo alg???n error
	 */
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

	/**
	 * Funci???n que devuelve una cadena de caracteres con la siguiente estructura
	 * <Empleado.id>|<Empleado.nombre>|<Empleado.apellidos>|<Empleado.nif>|<Empleado.direccion>|<Empleado.telefono>
	 * Cada campo se separa mediante el caracter '|'*
	 */
	public static void motrarEmpleado() {
		System.out.println("Lista de Empleados disponibles:");
		for (int i = 0; i < Datos.numEmpleadosd; i++) {
			Empleado e = Datos.EMPLEADOS[i];
			System.out.println(e.toString());
		}
	}

	/**
	 * Funci???n que devuelve una cadena de caracteres con la siguiente estructura
	 * <Empleado.id>|<Empleado.nombre>|<Empleado.apellidos>|<Empleado.nif>|<Empleado.direccion>|<Empleado.telefono>
	 * Cada campo se separa mediante el caracter '|'
	 * 
	 * @return
	 */
	public String empleadosData() {
		String ret = "";
		ret = "id: " + this.getIdEmpleado() + " | " + "Nombre: " + this.getNombre() + " | " + "Apellidos: "
				+ this.getApellidos() + " | " + "NIF: " + this.getNif() + " | " + "Direccion: " + this.getDireccion()
				+ " | " + "Telefono: " + this.getTelefono();
		return ret;
	}

	/***
	 * Funci???n que devuelve una cadena de caracteres con los datos del empleado en
	 * el siguiente formato: "Empleado [idEmpleado=" <idEmpleado> ", nombre="
	 * <nombre> ", apellidos=" <apellidos> ", telefono=" <telefono> ", direccion="
	 * <direccion> ", nif=" <nif>"]"
	 */
	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono="
				+ telefono + ", direccion=" + direccion + ", nif=" + nif + "]";
	}

	/***
	 * Metodo que permite exportar un objeto Empleados hacia un fichero de texto
	 * llamado empleadosObjeto.txt
	 * 
	 */
	public void exportarEmpleadosObjetoTXT() {
		System.out.println("Guardando en empleados.txt");

		String path = "empleados.txt";
		File fichero = new File(path);
		FileWriter escritor = null;
		PrintWriter buffer = null;
		try {
			try {
				escritor = new FileWriter(fichero, false);
				buffer = new PrintWriter(escritor);
				buffer.println(this.empleadosData());

			} finally {
				if (buffer != null) {
					buffer.close();
				}
				if (escritor != null) {
					escritor.close();
				}
			}

		} catch (FileNotFoundException ex) {
			System.out.println("Se ha producido una FileNotFoundException" + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("Se ha producido una IOException" + ex.getMessage());
		} catch (Exception ex) {
			System.out.println("Se ha producido una Exception" + ex.getMessage());
		}
	}

	/***
	 * Metodo que permite exportar una coleccion del objeto Empleados hacia un
	 * fichero de texto llamado empleadosColeccion.txt
	 * 
	 */
	public static void exportarEmpleadoColeccionTXT(Empleado[] empleados) {
		System.out.println("Guardando en empleados.txt");
		String path = "empleados.txt";
		File fichero = new File(path);
		FileWriter escritor = null;
		PrintWriter buffer = null;
		try {
			try {
				escritor = new FileWriter(fichero, false);
				buffer = new PrintWriter(escritor);
				for (Empleado e : empleados) {
					buffer.println(e.empleadosData());
				}
			} finally {
				if (buffer != null) {
					buffer.close();
				}
				if (escritor != null) {
					escritor.close();
				}
			}

		} catch (FileNotFoundException ex) {
			System.out.println("Se ha producido una FileNotFoundException" + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("Se ha producido una IOException" + ex.getMessage());
		} catch (Exception ex) {
			System.out.println("Se ha producido una Exception" + ex.getMessage());
		}
	}

	/***
	 * Metodo que perimite exportar un objeto Empleado hacia un fichero binario
	 * 
	 */
	public void exportarEmpleadoObjetoBIN() {
		System.out.println("Guardando en empleados.dat");
		String path = "empleados.dat";
		try {
			File fichero = new File(path);
			FileOutputStream fos = new FileOutputStream(path, false);
			ObjectOutputStream escritor = new ObjectOutputStream(fos);
			escritor.writeObject(this.empleadosData());
			escritor.flush();
			escritor.close();
		} catch (FileNotFoundException e) {
			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Se ha producido una IOException" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception" + e.getMessage());
		}
	}

	/***
	 * Metodo que permite exportar una coleccion de objetos de tipo empleado hacia
	 * un fichero de tipo binario
	 * 
	 */
	public static void exportarEmpleadoColeccionBIN(Empleado[] empleados) {
		System.out.println("Guardando en empleados.dat");
		String path = "empleados.dat";
		try {
			File fichero = new File(path);
			FileOutputStream fos = new FileOutputStream(path, false);
			ObjectOutputStream escritor = new ObjectOutputStream(fos);
			for (Empleado e : Datos.EMPLEADOS) {
				escritor.writeObject(e.empleadosData());
				escritor.flush();
			}
			escritor.close();
		} catch (FileNotFoundException e) {
			System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Se ha producido una IOException" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception" + e.getMessage());
		}
	}

	/***
	 * Metodo que permite importar una coleccion de objetos del tipo empleado desde
	 * un fichero de texto (con extension .txt)
	 * 
	 */
	public static void importarColeccionEmpleadosTXT() {

		System.out.println("Cargando de empleados.txt...");
		File f = new File("empleados.txt");
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String s;

			for (int i = 0; i < 6; i++) {
				s = (String) br.readLine();
				System.out.println(s);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void importarColeccionEmpleadosBIN() {
		System.out.println("Cargando de empleados.dat...");
		File f;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			f = new File("empleados.dat");
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);

			for (int i = 0; i < 6; i++) {
				Empleado e = (Empleado) ois.readObject();
				System.out.println(e.empleadosData());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metodo para buscar los Empleados por el id/ o por el nombre
	 */
	public static void buscarEmpleado() {
		System.out.print("Menu de busqueda de Empleado: ");
		System.out.println("?Desea buscar el empleado por el Id o por el nombre? (Seleccione id/nombre");
		Scanner teclado;
		boolean valido = false;

		String respuestaCliente = "";
		do {
			teclado = new Scanner(System.in);
			respuestaCliente = teclado.nextLine();
			valido = Validador.validarRespuestaCliente(respuestaCliente);
		} while (!valido);

		valido = false;
		if (respuestaCliente.equals("id")) {
			long buscaId = 0;
			do {
				System.out.println("Intrduce el id del Empleado que quiere buscar (id>0): ");
				buscaId = teclado.nextLong();
				if (buscaId > 0) {
					valido = true;
				}
			} while (!valido);
			for (Empleado e : Datos.EMPLEADOS) {
				if (e.getIdEmpleado() == buscaId) {
					System.out.println("Empleado encontrado: " + e.empleadosData());
				}
			}
		}
		if (respuestaCliente.equals("nombre")) {
			String buscaNombre = "";
			do {
				System.out.println("Introduce el nombre del Empleado que quiere buscar: ");
				buscaNombre = teclado.nextLine();
				if (buscaNombre.length() < 30 && buscaNombre.length() > 0) {
					valido = true;
				}
			} while (!valido);
			for (Empleado e : Datos.EMPLEADOS) {
				if (e.getNombre().equalsIgnoreCase(buscaNombre)) {
					System.out.print("Empleado encontrado : " + e.empleadosData());
				}
			}
		}
	}

}
