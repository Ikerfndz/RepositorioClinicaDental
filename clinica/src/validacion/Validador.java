package validacion;

public class Validador {

	public static boolean validarNombreMedicamento(String nombre2) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean validarNombreAlergia(String nom) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean validarNombrePaciente(String nombre) {
		if (nombre.length() < 2)
			return false;
		else if (nombre.length() > 30)
			return false;
		else
			return true;
	}

	// VALIDADORES EMPLEADO

	public static boolean validarNombreEmpleado(String nomEmpleado) {
		if (nomEmpleado.length() < 2 || nomEmpleado.length() > 30)
			return false;
		return true;
	}

	public static boolean validarApellidoEmpleado(String apeEmpleado) {
		if (apeEmpleado.length() < 2 || apeEmpleado.length() > 60)
			return false;
		return true;
	}

	public static boolean validarTelefonoValido(String telEmpleado) {
		if (telEmpleado.length() == 8 && (telEmpleado.charAt(0) == 9 || telEmpleado.charAt(0) == 8
				|| telEmpleado.charAt(0) == 6 || telEmpleado.charAt(0) == 7))
			return true;
		return false;
	}

	public static boolean validarDireccionEmpleado(String dirEmpleado) {
		if (dirEmpleado.length() < 2 || dirEmpleado.length() > 150)
			return false;
		return true;

	}

	public static boolean validarnifEmpleado(String niEmpleado) {
		if (niEmpleado.length() != 8)
			return false;
		return true;
	}

}
