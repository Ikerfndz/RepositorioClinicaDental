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

	// Variable que utilizaremos para completar de forma automática el identificador
	// del cobro.
	private static int numeroPagos = 0;

	// Constructor por defecto, cada vez que le hagamos una llamada aumentará el
	// numero de cobros en 1 y se le asignará ese valor al identificador.
	public Pago() {
		numeroPagos = numeroPagos + 1;
		idPago = numeroPagos;
	}

	// Constructor que se le pide por parametro el nombre de la especialidad.
	// Hace una llamada al constructor por defecto.
	// Guarda el valor del parametro introducido en la variable nombeesp.
	public Pago(double importe, LocalDate fecha, String metododePago) {
		numeroPagos = numeroPagos + 1;
		idPago = numeroPagos;
		this.importe = importe;
		this.fecha = fecha;
		this.metododePago = metododePago;
	}

	// Método encargado de guardar los nuevos pagos de un Paciente.
	// Se le pide al usuario que escriba la fecha, el importe y el método de pago y
	// se guarda en
	// una variable auxiliar.
	// Esta variable será la que pasaremos por parametros haciendo llamada al
	// constructor anterior.
	// Finalmente devolvemos los datos introducidos.
	public static Pago nuevoPago() {

		Pago ret = new Pago();
		Scanner teclado = new Scanner(System.in);

		// fecha pago
		String fech = "";
		boolean fechaValida = false;

		do {
			System.out.println("Introduce la fecha del pago: ");
			fech = teclado.nextLine();
			fechaValida = validarFechaPago(fech);
		} while (!fechaValida);

		LocalDate fecha = LocalDate.now();
		fecha = LocalDate.parse(fech);
		ret.setFecha(fecha);

		// importe pago
		double importe = 0;
		boolean importeValido = false;

		do {
			System.out.println("Introduce el importe del pago: ");
			importe = teclado.nextDouble();
			importeValido = validarImportePago(importe);
		} while (!importeValido);

		ret.setImporte(importe);

		// metodo pago
		String metododePago = "";
		boolean metododePagoValido = false;

		do {
			System.out.println("Introduce el método de pago: ");
			metododePago = teclado.nextLine();
			metododePagoValido = validarMetodoPago(metododePago);
		} while (!metododePagoValido);

		ret.setMetododePago(metododePago);

		return ret;
	}

	// Validadores
	public static boolean validarImportePago(double importe2) {
		return false;
	}

	public static boolean validarMetodoPago(String metododePago2) {
		return false;
	}

	public static boolean validarFechaPago(String fech) {
		return false;
	}

	// Getters y setters

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

	// ToString
	@Override
	public String toString() {
		return "Pago [idPago=" + idPago + ", fecha=" + fecha + ", importe=" + importe + ", metododePago=" + metododePago
				+ "]";
	}

}
