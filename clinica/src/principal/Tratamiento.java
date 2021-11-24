package principal;

import java.util.Scanner;

public class Tratamiento {

	private long idTratamiento;
	// idTratamiento representa al identificador �nico de cada tratamiento.
	// es un valos entero >0 .
	private String nombreDescriptivo;
	// nombreDescriptivo representa el nombre del tratamiento.
	// es una cadena de caracteres con un minimo de 3 caracteres y maximo de 50.
	// no acepta numeros ni caracteres especiales .
	private boolean consentimiento = true;
	// consentimientos representa la aceptaci�n o rechazo del paciente al
	// tratamiento.

	public static Tratamiento nuevotratamiento() {
		Tratamiento ret = new Tratamiento();
		Scanner teclado;
		teclado = new Scanner(System.in);

		// nombreDescriptivo
		String nomDescriptivo = ("");
		boolean nombreDescriptivolValido = false;
		do {
			System.out.println("Introduzca el nombre descriptivo: ");
			nomDescriptivo = teclado.next();
			nombreDescriptivolValido = validarnombreDescriptivoTratamiento(nomDescriptivo);
		} while (!nombreDescriptivolValido);
		ret.setNombreDescriptivo(nomDescriptivo);
		return ret;
		
		
	}

	private static int numTratamientos = 0;

	public Tratamiento() {
		numTratamientos++;
		this.idTratamiento = numTratamientos;
	}

	public Tratamiento(String nombreDescriptivo, boolean consentimiento) {
		this();
		this.consentimiento = consentimiento;
		this.nombreDescriptivo = nombreDescriptivo;
	}

	public static boolean validarnombreDescriptivoTratamiento(String nomDescriptivo) {
		// TODO Auto-generated method stub
		return false;
	}

	public long getIdTratamiento() {
		return idTratamiento;
	}

	public void setIdTratamiento(long idTratamiento) {
		this.idTratamiento = idTratamiento;
	}

	public String getNombreDescriptivo() {
		return nombreDescriptivo;
	}

	public void setNombreDescriptivo(String nombreDescriptivo) {
		this.nombreDescriptivo = nombreDescriptivo;
	}

	public boolean isConsentimiento() {
		return consentimiento;
	}

	public void setConsentimiento(boolean consentimiento) {
		this.consentimiento = consentimiento;
	}

	@Override
	public String toString() {
		return "Tratamiento [idTratamiento=" + idTratamiento + ", nombreDescriptivo=" + nombreDescriptivo
				+ ", consentimiento=" + consentimiento + "]";
	}

}
