package principal;

import java.util.Scanner;
import java.time.LocalDate;

public class Pago {

	// idPago es el identificador único de cada elemento Pago
	protected long idPago;

	// fecha almacena la fecha en la que se realiza el pago
	// es de tipo Localdate porque almacena una fecha
	protected LocalDate fecha;

	// importe representa el importe del cobro
	// es un valor >0
	protected double importe;

	// metododePago representa la manera en la que el cliente realiza el pago
	// Es una cadena de caracteres de longitud mínimo 3 y máximo 50 caracteres
	// No acepta dígitos ni caracteres especiales
	protected String metododePago;

	public static Pago nuevoPago() {

		Pago ret = new Pago();
		Scanner teclado = new Scanner(System.in);

		System.out.println("Introduce el id del nuevo pago: ");
		long idPago = 0;
		idPago = teclado.nextLong();
		ret.setIdPago(idPago);

		System.out.println("Introduce la fecha del pago: ");
		LocalDate fecha = "";
		fecha = teclado.nextLocalDate();
		ret.setFecha(fecha);

		System.out.println("Introduce el importe del pago: ");
		double importe = 0;
		importe = teclado.nextDouble();
		ret.setImporte(importe);

		System.out.println("Introduce el método de pago: ");
		String metododePago = "";
		metododePago = teclado.nextLine();
		ret.setMetododePago(metododePago);

		return ret;
	}

	public long getIdPago() {
		return idPago;
	}

	public void setIdPago(long idPago) {
		this.idPago = idPago;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getMetododePago() {
		return metododePago;
	}

	public void setMetododePago(String metododePago) {
		this.metododePago = metododePago;
	}

	@Override
	public String toString() {
		return "Pago [idPago=" + idPago + ", fecha=" + fecha + ", importe=" + importe + ", metododePago=" + metododePago
				+ "]";
	}

}
