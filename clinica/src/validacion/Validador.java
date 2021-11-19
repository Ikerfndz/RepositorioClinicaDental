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
		else 
			if(nombre.length() > 30)
				return false;
			else
				return true;
	}
	
	

}
