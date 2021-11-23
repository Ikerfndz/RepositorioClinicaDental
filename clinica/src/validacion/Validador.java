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

	// VALIDADORES PACIENTE
	/*
	 * Con esto conseguimos que el nombre escrito tenga un minimo de 2 caracteres y
	 * un maximo de 30
	 */
	public static boolean validarNombrePaciente(String nombre) {
		if (nombre.length() < 2)
			return false;
		else if (nombre.length() > 30)
			return false;
		else
			return true;
	}

	public static boolean validarTelefonoPaciente(String tel) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static boolean validarDireccionPaciente(String dir) {
		// TODO Auto-generated method stub
		return false;
	}
	// VALIDADORES EMPLEADO

	public static boolean validarNombreEmpleado(String nomEmpleado) {
		if (nomEmpleado.length() < 2 || nomEmpleado.length() > 30) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean validarApellidoEmpleado(String apeEmpleado) {
		if (apeEmpleado.length() < 2 || apeEmpleado.length() > 60) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean validarTelefonoValido(String telEmpleado) {
		if (telEmpleado.length() == 8 && (telEmpleado.charAt(0) == 9 || telEmpleado.charAt(0) == 8
				|| telEmpleado.charAt(0) == 6 || telEmpleado.charAt(0) == 7)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validarDireccionEmpleado(String dirEmpleado) {
		if (dirEmpleado.length() < 2 || dirEmpleado.length() > 150) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean validarnifEmpleado(String niEmpleado) {
		if (niEmpleado.length() != 8) {
			return false;
		} else {
			return true;
		}
	}

}
