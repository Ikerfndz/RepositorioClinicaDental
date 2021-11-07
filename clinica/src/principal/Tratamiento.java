package principal;

import java.util.Scanner;

public class Tratamiento {

	private long idTratamiento;
	// idTratamiento representa al identificador único de cada tratamiento.
	// es un valos entero >0 .
	private String nombreDescriptivo;
	// nombreDescriptivo representa el nombre del tratamiento.
	// es una cadena de caracteres con un minimo de 3 caracteres y maximo de 50.
	// no acepta numeros ni caracteres especiales .
	private boolean consentimiento = true;
	// consentimientos representa la aceptación o rechazo del paciente al
	// tratamiento.

	public static Tratamiento nuevoTratammiento() {
		Tratamiento ret = new Tratamiento();
		Scanner teclado;
		teclado = new Scanner(System.in);

		System.out.println("Introduzca el nombre del tratamiento");
		String nom = "";
		nom = teclado.nextLine();
		ret.setNombreDescriptivo(nom);
		
		System.out.println("introduzca el id deltratamiento");
		long id = 0;
		id = teclado.nextLong();
		ret.setIdTratamiento(id);
		
		return ret;
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
