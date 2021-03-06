package entidades;

import java.util.Scanner;
import java.time.LocalDateTime;

public class Pago {

	// idPago es el identificador �nico de cada elemento Pago
	protected long idPago;

	// fecha almacena la fecha en la que se realiza el pago
	// es de tipo Localdate porque almacena una fecha
	protected LocalDateTime fecha;

	// importe representa el importe del cobro
	// es un valor >0
	protected double importe;

	// metododePago representa la manera en la que el cliente realiza el pago
	// Es una cadena de caracteres de longitud m�nimo 3 y m�ximo 50 caracteres
	// No acepta d�gitos ni caracteres especiales
	protected String metododePago;

	// Variable que utilizaremos para completar de forma autom�tica el identificador
	// del cobro.
	private static int numeroPagos = 0;
	
	//Array que guarda el numero de cobros que se le hacen a un paciente, como máximo 5.
	private Cobro cobros[] = new Cobro[5];

	// Constructor por defecto, cada vez que le hagamos una llamada aumentar� el
	// numero de cobros en 1 y se le asignar� ese valor al identificador.
	public Pago() {
		numeroPagos = numeroPagos + 1;
		idPago = numeroPagos;
	}

	/*
	 * Constructor que se le pide el importe, la fecha y el metodo de pago
	 * a la hora de realizar los pagos
	 */
	public Pago(double importe, LocalDateTime fecha, String metododePago) {
		numeroPagos = numeroPagos + 1;
		idPago = numeroPagos;
		this.importe = importe;
		this.fecha = fecha;
		this.metododePago = metododePago;
	}
	
	/*
	 *  Constructor que se le pide el importe, la fecha, el metodo de pago y el array de
	 *  cobros, donde se almacenan el numero de pagos distintos que realiza un paciente
	 */
		public Pago(double importe, LocalDateTime fecha, String metododePago, Cobro cobros) {
			numeroPagos = numeroPagos + 1;
			idPago = numeroPagos;
			this.importe = importe;
			this.fecha = fecha;
			this.metododePago = metododePago;
			this.cobros[0] = cobros;
		}

	/*
	 * M�todo encargado de guardar los nuevos pagos de un Paciente.
	 * Se le pide al usuario que escriba la fecha, el importe y el m�todo de pago y
	 * se guarda en
	 * una variable auxiliar.
	 * Esta variable ser� la que pasaremos por parametros haciendo llamada al
	 * constructor anterior.
	 * Finalmente devolvemos los datos introducidos.
	 */
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

		LocalDateTime fecha = LocalDateTime.now();
		fecha = LocalDateTime.parse(fech);
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
			System.out.println("Introduce el m�todo de pago: ");
			metododePago = teclado.nextLine();
			metododePagoValido = validarMetodoPago(metododePago);
		} while (!metododePagoValido);

		ret.setMetododePago(metododePago);

		return ret;
	}
	
	/*
	 * Metodo encargado de mostrar los datos del Pago a través de un String
	 * de manera que todos queden separados por el carácter "|".
	 * El primer campo corresponde con la clave primaria de la clase Pago
	 *
	 */
	public String data() {
		String pago = "";
		pago = this.idPago + "|" + this.fecha + "|" + this.importe + "|" + this.metododePago;
		return pago;
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

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
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
