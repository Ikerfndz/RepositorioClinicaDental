package validacion;

import java.lang.*;

public class Validador {

	// Medicamento
	public static boolean validarNombreMedicamento(String nombre2) {
		return false;
	}

	public static boolean validarPrincipioActivo(String principioActivo2) {
		return false;
	}

	public static boolean validarDosisMaxima(double dosisMaximaDiaria) {
		// con este if else conseguimos que el programa de error si la dosis m�xima
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
		// con este if else nos encargamos de que el paciente s�lo pueda escribir
		// dos tipos de pago distintos: efectivo o tarjeta, sino es ninguno
		// de estos dos, dar� un error
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
		else if (nomPaciente.length() > 30)
			return false;

		return true;
	}

	public static boolean validarNifPaciente(String nifPaciente) {
		if (nifPaciente.length() != 8)
			return false;
		return false;
	}

	public static boolean validarEdadPaciente(int edadPaciente) {
		if (edadPaciente > 1 || edadPaciente < 130)
			;
		return false;
	}

	public static boolean validarDireccionPaciente(String dirPaciente) {
		if (dirPaciente.length() > 2 || dirPaciente.length() < 150)
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

	// VALIDADORES EMPLEADO

	// validarNombreEmpleado es un metodo que recibe como argumento la variable
	// auxiliar nomEmpleado, para validar el nombre del empleado
	// nomEmpleado sera invalido si la longitud de la cadena de caracteres es menor
	// que 2, o mayor que 30
	// en caso de que la cadena de caracteres tenga una longitud entre 2 y 30 el
	// dato sera valido
	public static boolean validarNombreEmpleado(String nomEmpleado) {
		if (nomEmpleado.length() < 2 || nomEmpleado.length() > 30) {
			return false;
		} else {
			return true;
		}
	}

	// validarApellidoEmpleado es un metodo que recibe como argumento la variable
	// auxiliar apeEmpleado, para validar los apellidos del empleado
	// epeEmpleado sera invalido si la longitud de la cadena de caracteres es menor
	// que 2, o mayor que 60
	// en caso de que la cadena de caracteres tenga una longitud entre 2 y 60 el
	// dato sera valido
	public static boolean validarApellidoEmpleado(String apeEmpleado) {
		if (apeEmpleado.length() < 2 || apeEmpleado.length() > 60) {
			return false;
		} else {
			return true;
		}
	}

	// validarTelefonoValido es un metodo que recibe como argumento la variable
	// auxiliar telEmpleado, para validar el telefono del empleado
	// telEmpleado sera valido si la longitud de la cadena de caracteres es igual a
	// 8, y ademas empieza por la cifra 9,8 en caso de tratarse numeros fijos, y 6 y
	// 7 en caso de tratarse de telefonos moviles
	// si las condiciones mencionadas anteriormente no se cumplen, el telefono
	// introducido sera invalido
	public static boolean validarTelefonoValido(String telEmpleado) {
		if (telEmpleado.length() == 8 && (telEmpleado.charAt(0) == 9 || telEmpleado.charAt(0) == 8
				|| telEmpleado.charAt(0) == 6 || telEmpleado.charAt(0) == 7)) {
			return true;
		} else {
			return false;
		}
	}

	// validarDireccionEmpleado es un metodo que recibe como arugumento la variable
	// auxiliar dirEmpleado, para validar la direccion del empleado
	// dirEmpleado sera invalido si la longitud de la cadena de caracteres es menor
	// que 2 o mayor que 150
	// en caso de que la longitud se encuentre entre 2 y 150 sera valido
	public static boolean validarDireccionEmpleado(String dirEmpleado) {
		if (dirEmpleado.length() < 2 || dirEmpleado.length() > 150) {
			return false;
		} else {
			return true;
		}
	}

	// validarnifEmpleado es un metodo que recibe como argumento la avariable
	// auxiliar niEmpleado, para validar el nif del empleado
	// niEmpleado sera valido si la longitud de la cadena de carateres introducida
	// es igual a 8, el numero de caracteres del Dni
	// en caso contrario sera invalido
	public static boolean validarnifEmpleado(String niEmpleado) {
		if (niEmpleado.length() != 8) {
			return false;
		} else {
			return true;
		}
	}

	// VALIDADORES SECRETARIADO

	// validarAniosExpSecretariado es un metodo que recibe como argumento la
	// variable auxiliar anios, para validar el numero de a�os del empleado
	// En este caso, mediante la clase Integer, que nos permite pasar un dato de
	// tipo string a int, decimos que el numero de a�os de experiencia introducidos
	// sera invalido si es menor que 0 o mayor que 100
	// En caso de que no fuera asi, seria aceptada
	public static boolean validarAniosExpSecretario(int anios) {
		if (anios < 0 || anios > 100) {
			return false;
		} else {
			return true;
		}
	}
	// Cita
	

		public static boolean validarFechaCita(String fechaCita) {
			return false;
		}
		public static boolean validarHoraCita(String horaCita) {
			return false;
		}

	//Intervencion
		
		public static boolean validarDuracion(int minutos) {
			if (minutos > 0 || minutos < 999)
				;
			return false;
		}
	//Revision
		
		public static boolean validarAnotacion(String comt) {
			if (comt.length() > 1 || comt.length() < 2000)
				return false;
			return false;
		}
	
	// VALIDADORES PERSONA
	
	
	public static boolean validarEdadEmpleado(int edadPersona) {
		if (edadPersona > 1 || edadPersona < 130);
			return false;
	}
	
	
	
	public static boolean validarNombrePersona(String nombrePersona) {
		if (nombrePersona.length() < 2)
			return false;
		else if (nombrePersona.length() > 30)
			return false;
		return true;
	}
	
	// VALIDADORES INFORME

		// validardescripcionInforme es un metodo que recibe como argumento la variable
		// auxiliar des, para validar la descripcion de cada informe
		// des sera valida si la longitud de la descripcion del informe introducida no
		// tiene menos de 10 o mas de 500 caracteres
		// en caso contrario la descripcion introducida no sera valida

		public static boolean validardescripcionInforme(String des) {
			if (des.length() < 10 || des.length() > 500) {
				return false;
			} else {
				return true;
			}
		}
		
}

