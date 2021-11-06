package principal;

import java.util.Scanner;

public class Tratamiento {
	
	protected long idTratamiento;
	protected String nombreDescriptivo;
	protected boolean consentimiento= true;
	
	
	public static Tratamiento nuevoTratammiento() {
		Tratamiento ret = new Tratamiento();
		Scanner teclado;
		teclado = new Scanner(System.in);
		
		System.out.println("Introduzca el nombre del nuevo tratamiento");
		String nom="";
		nom= teclado.nextLine();
		ret.setNombreDescriptivo(nom);
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
