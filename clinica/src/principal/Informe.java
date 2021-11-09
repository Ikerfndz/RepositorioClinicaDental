package principal;

import java.util.Arrays;
import java.util.Scanner;

public class Informe extends Secretariado{
	private long idInforme;
	private String descripcion;

	private Informe informes[] = new Informe[10000];

	public Informe() {
		numeroInformes++;
		this.idInforme = numeroInformes;
	}

	protected static int numeroInformes;

	public static int getNumeroInforme() {
		return numeroInformes;
	}

	public static void setNumeroInforme(int numeroInformes) {
		Informe.numeroInformes = numeroInformes;

	}

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

	void setInforme(String des) {
	}

	public Informe(String descripcion, long idInforme) {
		super();
		numeroInformes = numeroInformes + 1;
		this.descripcion = descripcion;
		this.idInforme = numeroInformes;
	}

	public Informe(String numAñosExp, Empleado empleado, long idInforme, String descripcion, Informe[] informes) {
		super(numAñosExp , empleado);
		this.idInforme = idInforme;
		this.descripcion = descripcion;
		this.informes = informes;
	}

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
		return "Informe [idInforme=" + idInforme + ", descripcion=" + descripcion + ", informes="
				+ Arrays.toString(informes) + ", numAñosExp=" + numAñosExp + ", idEmpleado=" + idEmpleado + ", nombre="
				+ nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", direccion=" + direccion + ", nif="
				+ nif + "]";
	}
	
	


	}


