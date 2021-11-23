package validacion;

public class Validador {

	// Medicamento
	public static boolean validarNombreMedicamento(String nombre2) {
		return false;
	}

	public static boolean validarPrincipioActivo(String principioActivo2) {
		return false;
	}

	public static boolean validarDosisMaxima(double dosisMaximaDiaria) {
		// con este if else conseguimos que el programa de error si la dosis máxima
		// diaria es menor de 1
		if (dosisMaximaDiaria < 1)
			return false;
		else
			return true;
	}

	// Alergia
	public static boolean validarNombreAlergia(String nom) {
		return false;
	}

	// Cobro
	public static boolean validarImporteCobro(double importe2) {
		return false;
	}

	public static boolean validarFechaCobro(String fech) {
		return false;
	}

	// Pago
	public static boolean validarImportePago(double importe2) {
		return false;
	}

	public static boolean validarMetodoPago(String metododePago) {
		// con este if else nos encargamos de que el paciente sólo pueda escribir
		// dos tipos de pago distintos: efectivo o tarjeta, sino es ninguno
		// de estos dos, dará un error
		if (metododePago == "Efectivo" && metododePago == "Tarjeta")
			return true;
		else
			return false;
	}

	public static boolean validarFechaPago(String fech) {
		return false;
	}

	// Paciente
	public static boolean validarNombrePaciente(String nombre) {
		if (nombre.length() < 2)
			return false;
		else if (nombre.length() > 30)
			return false;
		else
			return true;
	}

}
