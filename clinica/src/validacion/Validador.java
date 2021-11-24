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

	

	// VALIDADORES PACIENTE
	
	public static boolean validarNombrePaciente(String nomPaciente) {
		if (nomPaciente.length() < 2)
			return false;
		else 
			if (nomPaciente.length() > 30)
			return false;
			
			return true;
	}

	public static boolean validarNifPaciente(String nifPaciente) {
		if (nifPaciente.length() != 8) 
			return false;
		return false;
		}
	
	
	public static boolean validarEdadPaciente(int edadPaciente) {
		if (edadPaciente > 1) 
			return false;
		else (edadPaciente < 100)
		return false;
		
		return false;
	}
	
	public static boolean validarTelefonoPaciente(String telPaciente) {
		if (telPaciente.length() == 8 && (telPaciente.charAt(0) == 9 || telPaciente.charAt(0) == 8
				|| telPaciente.charAt(0) == 6 || telPaciente.charAt(0) == 7)) 
			return false;
		else
			return true;
			}
	
	public static boolean validarDireccionPaciente(String dirPaciente) {
		if(dirPaciente.length()< 10  ||  dirPaciente.length() > 150)
			return true;
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
