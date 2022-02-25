package entidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Cirujano extends Empleado {

	private boolean tieneEsp = false;
	// Atributo de tipo boolean para declarar si un cirujano tiene o no
	// especialidad.
	private Especialidad especialidades[] = new Especialidad[10];
	// Array donde se guarda el numero de especialidades que puede tener un
	// cirujano.
	private Intervencion intervenciones[] = new Intervencion[10];
	// Array donde se guarda el numero de intervenciones en las que interviene un
	// cirujano.

	// Constructor por defecto
	public Cirujano() {
		super();
	}

	// Constructor que recibe por parametros la especialidad el empleado y la
	// intervenci�n.
	// Primero hace una llamada a super para sacar los datos del empleado.
	// Se guarda la especialidad en el array.
	// Se guarda la intervencion en el array.

	public Cirujano(Empleado empleado,  boolean tieneEsp, Especialidad especialidad, Intervencion intervencion) {
		super(empleado);
		especialidades[0] = especialidad;
		intervenciones[0] = intervencion;
		this.tieneEsp = tieneEsp;

	}

	public Cirujano(Empleado empleado, boolean tieneEsp, Intervencion intervencion) {
		super(empleado);
		intervenciones[0] = intervencion;
		this.tieneEsp = tieneEsp;

	}
	
	public Cirujano( Especialidad especialidad, Empleado empleado, Intervencion intervencion, boolean tieneEsp) {
		super(empleado);
		especialidades[0] = especialidad;
		intervenciones[0] = intervencion;
		this.tieneEsp = tieneEsp;

	}


	// M�todo encargado de crear un nuevo cirujano.
	// Se declara una variable de tipo Empleado donde se guardan los datos del
	// empleado haciendo llamada al m�todo nuevoEmpleado.
	// Se declara una variable de tipo Intervencion donde se guardan los datos de la
	// intervenci�n haciendo llamada al m�todo nuevaIntervencion.
	// Se declara una variable de tipo Especialidad donde se guardan los datos de la
	// especialidad haciendo llamada al m�todo nuevaEspecialidad.
	// Se declara una variable de tipo Cirujano que se instancia haciendo llamada al
	// constructor anterior y se le pasa por parametros las variables creadas en
	// este metodo.
	// Se guarda el cirujano creado en la clase Especialidad porque cada
	// Especialidad pertenece a un cirujano.
	public static Cirujano nuevoCirujano() {
		Empleado empleado = Empleado.nuevoEmpleado();
		Intervencion intervencion = Intervencion.nuevaIntervencion();
		Especialidad especialidad = Especialidad.nuevaEspecialidad();
		Scanner teclado = new Scanner(System.in);
		System.out.println("¿Tiene el cirujano especialidad?");
		boolean aux = teclado.nextBoolean();
		Cirujano ret = new Cirujano(especialidad, empleado, intervencion, aux);
		especialidad.setCirujano(ret);
		return ret;
	}

	// Getters y setters
	public Especialidad[] getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Especialidad[] especialidades) {
		this.especialidades = especialidades;
	}

	public Intervencion[] getIntervenciones() {
		return intervenciones;
	}

	public void setIntervenciones(Intervencion[] intervenciones) {
		this.intervenciones = intervenciones;
	}

	
	/***
	 * Metodo que permite exportar un objeto cirujanos hacia un fichero de texto
	 * llamado cirujanosObjeto.txt
	 * 
	 */
	public static void exportarObjeto(Cirujano	cirujano) {
		String path = "cirujanoObjeto.txt";
		File fichero = new File(path);
		FileWriter escritor = null;
		PrintWriter buffer = null;
		try {
			try {
				escritor = new FileWriter(fichero, false);
				buffer = new PrintWriter(escritor);
				buffer.println(cirujano.data());

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
	 * Metodo que permite exportar una coleccion del objeto Cirujanos hacia un
	 * fichero de texto llamado cirujanosColeccion.txt
	 * 
	 */
	public static void exportarColeccion(Cirujano[] cirujano) {
		String path = "cirujanjoColeccion.txt";
		File fichero = new File(path);
		FileWriter escritor = null;
		PrintWriter buffer = null;
		try {
			try {
				escritor = new FileWriter(fichero, false);
				buffer = new PrintWriter(escritor);
				for (Cirujano c : cirujano) {
					buffer.println(c.data());
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
	/**
	 * Funci�n que devuelve una cadena de caracteres con la siguiente estructura
	 * <Empleado.id>|<Empleado.nombre>|<Empleado.apellidos>|<Empleado.nif>|<Empleado.direccion>|<Empleado.telefono>|<Cirujano.especialidad>|<Cirujano.intervenciones>
	 * Cada campo se separa mediante el caracter '|'
	 * 
	 * @return
	 */
	public String data() {
		return "" + this.getIdEmpleado() + "|" + this.getNombre() + "|" + this.getApellidos() + "|" + this.getNif()
				+ "|" + this.getDireccion() + "|" + this.getTelefono() + "|" + this.especialidades + "|" + this.intervenciones;
	}
	
	
	// To string
	@Override
	public String toString() {
		return "Cirujano [especialidades=" + Arrays.toString(especialidades) + ", intervenciones="
				+ Arrays.toString(intervenciones) + "]";
	}

}
