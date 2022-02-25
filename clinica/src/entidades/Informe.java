package entidades;

import java.util.Arrays;
import java.util.Scanner;

import utils.Datos;
import validacion.Validador;

/**
 * @author MiguelH
 */

public class Informe {

	// id es el identificador unico de cada elemento Informe
	// es un valor entero > 0
	// el valor de idInforme se va rellenando automaticamente cada vez que se hace
	// llamada a uno de sus constructores
	private long idInforme;

	// descripcion guarda la descripcion de cada uno de los informes
	// es una cadena de caracteres con un minimo de 3 caracteres y maximo de 50
	// no acepta numeros ni caracteres especiales
	private String descripcion;

	// numeroInfoemes es de tipo entero
	// esta variable nos permitira completar de forma automatica el idInforme

	protected static int numeroInformes;
	// Array donde se guarda el numero de informes que puede tener un/a
	// secretario/a.

	// Constructor por defecto, cada vez que le hagamos una llamada aumentar� el
	// numero de informes en 1 y se le asignar� ese valor al identificador.
	private Informe informes[] = new Informe[10000];

	private Secretariado[] secretarios = new Secretariado[1000];

	public Informe() {
		numeroInformes++;
		this.idInforme = numeroInformes;
	}

	// Metodo nuevoInforme -> encargado de registrar un nuevo informe
	// Se le pide al secretario que ingrese la descripcion del nuevo informe
	// Esta descripcion es guardada en una variable auxiliar distinta
	// Esta variable ser� la que pasaremos por parametros haciendo llamada al
	// constructor anterior para establecer un nuevo informe con su descripcion
	// Finalmente se devuelven los datos introducidos
	public static Informe nuevoInforme() {
		Informe ret = new Informe();
		Scanner teclado;
		teclado = new Scanner(System.in);

		String des = "";
		boolean descripcionValida = false;
		do {
			System.out.println("Introduzca la descripcion del nuevo informe");
			des = teclado.nextLine();
			descripcionValida = Validador.validardescripcionInforme(des);
		} while (!descripcionValida);
		ret.setDescripcion(des);

		numeroInformes++;
		ret.idInforme = numeroInformes;

		Secretariado.motrarSecretario();
		System.out.println("Selecciona un secretario.");
		int eleccion = 0;
		eleccion = teclado.nextInt();
		boolean eleccionValidaS = false;
		do {
			if (eleccion >= 0 && eleccion < Datos.numSecretarios) {
				ret.secretarios[0] = Datos.SECRETARIOS[eleccion];
			}
		} while (!eleccionValidaS);

		/*
		 * 1) Mostrar todos los secretarios del sistema 2) El usuario selecciona uno de
		 * ellos 3) comprobar que el secretario seleccionado es valido 4a) si es valido
		 * , entonces ret.secretarios[0]= el_elegido 4b) volver al paso 1 5)
		 * 
		 */
		return ret;

	}

	// Constructor que recibe por parametros los atributos de la clase empleado,
	// los de la clase secretariado y la descripcion de cada informe
	// Hace una llamada al constructor por defecto (que permite introducir el
	// idInforme)
	// Despues hace una llamada a super para sacar los datos de las clases padre:
	// empleado y secretariado.
	// Luego guarda los datos recibidos en la variables descripcion y informes.
	public Informe(String nombre, String apellidos, String telefono, String direccion, String nif, int numAniosExp,
			long idInforme, String descripcion, Informe[] informes) {
		this.idInforme = idInforme;
		this.descripcion = descripcion;
		this.informes = informes;
	}

	// Getters y setters
	public long getIdInforme() {
		return idInforme;
	}

	public void setIdInforme(long idInforme) {
		this.idInforme = idInforme;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Informe[] getInformes() {
		return informes;
	}

	public void setInformes(Informe[] informes) {
		this.informes = informes;
	}

	public static int getNumeroInformes() {
		return numeroInformes;
	}

	public static void setNumeroInformes(int numeroInformes) {
		Informe.numeroInformes = numeroInformes;
	}

	@Override
	public String toString() {
		String ret = "";
		ret += "Informe [id=" + idInforme + ", descripcion=" + descripcion
				+ ", secretarios que scribieron en el informe:";
		for (Secretariado s : secretarios) {
			ret += "\n" + s.getNombre() + " " + s.getApellidos() + "(" + s.getNif() + ")";
		}
		return ret;
	}

	/***
	 * Metodo data de la clase informe
	 * 
	 */
	public String informeData() {
		String ret = "";
		return ret;

	}
}
