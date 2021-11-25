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
	protected LocalDate fecha;

	// Variable que utilizaremos para completar de forma automática el identificador
	// del cobro.
	private static int numeroCobros = 0;

	// Constructor por defecto, cada vez que le hagamos una llamada aumentará el
	// numero de cobros en 1 y se le asignará ese valor al identificador.
	public Cobro() {
		numeroCobros = numeroCobros + 1;
		idCobro = numeroCobros;
	}

	// Constructor que se le pide por parametro el nombre de la especialidad.
	// Hace una llamada al constructor por defecto.
	// Guarda el valor del parametro introducido en la variable nombeesp.
	public Cobro(double importe, LocalDate fecha) {
		numeroCobros = numeroCobros + 1;
		idCobro = numeroCobros;
		this.importe = importe;
		this.fecha = fecha;
	}

	// Método encargado de guardar el nuevo cobro.
	// Se le pide al usuario que escriba el importe y la fecha del cobro y se guarda
	// en
	// una variable auxiliar.
	// Esta variable será la que pasaremos por parametros haciendo llamada al
	// constructor anterior.
	// Finalmente devolvemos los datos introducidos.
	public static Cobro nuevoCobro() {

		Cobro ret = new Cobro();
		Scanner teclado = new Scanner(System.in);

		// importe del cobro
		double importe = 0;
		boolean importeValido = false;
		do {
			System.out.println("Introduce el importe: ");
			importe = teclado.nextDouble();
			importeValido = validarImporteCobro(importe);
		} while (!importeValido);

		ret.setImporte(importe);

		// fecha del cobro
		String fech = "";
		boolean fechaValida = false;
		do {
			System.out.println("Introduce la fecha del cobro: ");
			fech = teclado.nextLine();
			fechaValida = validarFechaCobro(fech);
		} while (!fechaValida);

		LocalDate fecha = LocalDate.now();
		fecha = LocalDate.parse(fech);
		ret.setFecha(fecha);

		return ret;

	}

	// Validadores
	public static boolean validarImporteCobro(double importe2) {
		return false;
	}

	public static boolean validarFechaCobro(String fech) {
		return false;
	}

	// Getters y setters
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	// ToString
	@Override
	public String toString() {
		return "Cobro [idCobro=" + idCobro + ", importe=" + importe + "]";
	}
	
}
