package principal;

import java.util.Arrays;
import java.util.Scanner;

public class Enfermeria extends Empleado {
	private char categoria;
	// Categoría de el/la enfemero/a codificada con una letra
	private Intervencion intervenciones[] = new Intervencion[10];
	// Array donde se guarda el numero de intervenciones que puede tener un/a
	// enfermero/a.

	public Enfermeria() {
		// Contructor por defecto
	}

	// Constructor que recibe como parámetros atributos de tipo char, Empleado, e
	// Intervención
	// Hace una llamada a su clase super para sacar sus atributos
	// Guarda la categoría con el set ( Lo hago llamado al set pero también podría
	// ser con this.categoria=categoria)
	// Guarda la intervención en el array intervenciones.

	public Enfermeria(char categoria, Empleado empleado, Intervencion intervencion) {
		super();
		setCategoria(categoria);
		intervenciones[0] = intervencion;
	}

	// Método nuevoEnfermero encargado de registrar a un nuevo enfermero.
	// Se declara una variable de tipo Empleado donde se guarda la información del
	// empleado haciendo llamada al método nuevoEmpleado.
	// Se declara una variable de tipo Intervencion donde se guarda la información
	// de la intervencion haciendo llamada al método nuevaIntervencion.
	// Se pide por pantalla que introduzca la categoría del enfermero con el teclado
	// y se guarda en una variable auxiliar llamada cat.
	// Finalmente se declara y se inicializa una variable de tipo Enfermería
	// (llamando al constructor anterior) que será la que utilizaremos para devolver
	// todos los datos introducidos en este metodo .
	public static Enfermeria nuevoEnfermero() {
		Empleado empleado = Empleado.nuevoEmpleado();
		Intervencion intervencion = Intervencion.nuevaIntervencion();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce la categoría del enfermero/a");
		char cat;
		cat = teclado.next().charAt(0);
		Enfermeria ret = new Enfermeria(cat, empleado, intervencion);
		teclado.close();
		return ret;
	}

	// Getters y Setters de los atributos

	public char getCategoria() {
		return categoria;
	}

	public void setCategoria(char categoria) {
		this.categoria = categoria;
	}

	public Intervencion[] getIntervenciones() {
		return intervenciones;
	}

	public void setIntervenciones(Intervencion[] intervenciones) {
		this.intervenciones = intervenciones;
	}

	@Override
	public String toString() {
		return "Enfermeria [categoria=" + categoria + ", intervenciones=" + Arrays.toString(intervenciones) + "]";
	}

}