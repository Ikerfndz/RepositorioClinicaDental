package principal;

import java.util.Scanner;
import java.time.LocalDate;

public class Cobro {

	// idCobro es el identificador único de cada elemento Cobro
	protected long idCobro;

	// importe representa el importe del cobro
	// es un valor >0
	protected double importe;

	// fecha almacena la fecha en la que se realiza el cobro
	// es de tipo Localdate porque almacena una fecha
	protected Localdate fecha;

	public static Cobro nuevoCobro() {

		Cobro ret = new Cobro();
		Scanner teclado = new Scanner(System.in);

		System.out.println("Introduce el id del nuevo cobro: ");
		String idCobro = "";
		idCobro = teclado.nextLine();
		ret.setIdCobro(idCobro);

		System.out.println("Introduce el importe: ");
		double importe = 0;
		importe = teclado.nextDouble();
		ret.setImporte(importe);

		System.out.println("Introduce la fecha: ");
		Localdate fecha = "";
		fecha = teclado.nextLine();
		ret.setFecha(fecha);

		return ret;

	}

	public long getIdCobro() {
		return idCobro;
	}


	public void setIdCobro(long idCobro) {
		this.idCobro = idCobro;
	}


	public double getImporte() {
		return importe;
	}


	public void setImporte(double importe) {
		this.importe = importe;
	}


	public Localdate getFecha() {
		return fecha;
	}


	public void setFecha(Localdate fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "Cobro [idCobro=" + idCobro + ", importe=" + importe + "]";
	}

}
