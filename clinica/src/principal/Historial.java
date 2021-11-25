package principal;

import java.util.Scanner;

import validacion.Validador;

public class Historial {

	private long idHistorial;
	// idHistorial representa al identificador único del historial
	// es un valos entero >0

	private String descripcion;
	// descripción representa una explicación de detallad del tratamiento
	// es una cadena de caracteres con un minimo de 10 caracteres

	public static Historial nuevoHistorial() {
		Historial ret = new Historial();
		Scanner teclado;
		teclado = new Scanner(System.in);
		
		String desHistorial = ("");
		boolean historialValido = false;
		do {
			System.out.println("Introduzca la descripcion: ");
			desHistorial = teclado.next();
			historialValido= Validador.validarHistorialPaciente(desHistorial);
		} while (!historialValido);
		
	ret.setDescripcion(desHistorial);
		return ret;
		
		
		
	}
	
	

	private static int numHistorial = 0;
	public Historial() {
		numHistorial++;
		this.idHistorial = numHistorial;}

	public Historial (String descripcion) {
		this ();
		this.descripcion = descripcion;
	}

	
	

	public long getIdHistorial() {
		return idHistorial;
	}

	public void setIdHistorial(long idHistorial) {
		this.idHistorial = idHistorial;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Historial [idHistorial=" + idHistorial + ", descripcion=" + descripcion + "]";
	}

}