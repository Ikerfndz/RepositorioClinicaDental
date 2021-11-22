package principal;

import java.util.Arrays;
import java.util.Scanner;

public class Informe extends Secretariado{
	
	private long idInforme;
	// 	id es el identificador unico de cada elemento Informe
	// es un valor entero > 0
	// el valor de idInforme se va rellenando automaticamente cada vez que se hace
	// llamada a uno de sus constructores
	private String descripcion;
	// descripcion guarda la descripcion de cada uno de los informes
	// es una cadena de caracteres con un minimo de 3 caracteres y maximo de 50
	// no acepta numeros ni caracteres especiales
	protected static int numeroInformes;
	// numeroInfoemes es de tipo entero
	// esta variable nos permitira completar de forma automatica el idInforme
	private Informe informes[] = new Informe[10000];


	// Constructor por defecto, cada vez que le hagamos una llamada aumentará el
	// numero de informes en 1 y se le asignará ese valor al identificador.
	public Informe() {
		numeroInformes++;
		this.idInforme = numeroInformes;
	}

	// Metodo nuevoInforme -> encargado de registrar un nuevo informe
	// Se le pide al secretario que ingrese la descripcion del nuevo informe
	// Esta descripcion es guardada en una variable auxiliar distinta
	// Esta variable será la que pasaremos por parametros haciendo llamada al
	// constructor anterior para establecer un nuevo informe con su descripcion
	// Finalmente se devuelven los datos introducidos
	public static Informe nuevoInforme() {
		Informe ret = new Informe();
		Scanner teclado;
		teclado = new Scanner(System.in);

		System.out.println("Introduzca la descripcion del nuevo informe");
		String des = "";
		des = teclado.nextLine();
		ret.setDescripcion(des);

		teclado.close();
		return ret;

	}

	public Informe(String descripcion, long idInforme) {
		super();
		numeroInformes = numeroInformes + 1;
		this.descripcion = descripcion;
		this.idInforme = numeroInformes;
	}

	public Informe(String nombre, String apellidos, String telefono, String direccion, String nif, String numAñosExp, long idInforme, String descripcion, Informe[] informes) {
		super(nombre, apellidos, telefono, direccion, nif, numAñosExp);
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

	// To String
	@Override
	public String toString() {
		return "Informe [idInforme=" + idInforme + ", descripcion=" + descripcion + ", informes="
				+ Arrays.toString(informes) + ", numAñosExp=" + numAñosExp + ", idEmpleado=" + idEmpleado + ", nombre="
				+ nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", direccion=" + direccion + ", nif="
				+ nif + "]";
	}
	
	


	}


