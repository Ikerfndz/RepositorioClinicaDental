package principal;

import java.util.Arrays;
import java.util.Scanner;

public class Paciente {

	public Paciente() {

	}

	private String nombre;
	// nombre representa el nombre del paciente.
	// es una cadena de caracteres con un minimo de 3 caracteres y maximo de 50.
	// no acepta numeros ni caracteres especiales .
	private long idPaciente;
	// idPaciente representa al identificador único del paciente.
	// es un valos entero >0 .
	private String telefono;
	// telefono representa al numero de telfono del paciente.
	// esta formado por 9 digitos
	// es un valor entero
	private String direccion;
	// direccion representa la direccion del paciente.
	// esta formado por una cadena de caracteres de minimo 5 caracteres y un maximo
	// de 50
	private String edad;
	// edad representa a la edad del paciente
	
	private String nif;

	private Historial historial = new Historial();
	private Tratamiento tratamientos[] = new Tratamiento[10];

	public static Paciente nuevoPaciente() {
		Paciente ret = new Paciente();
		Scanner teclado;
		teclado = new Scanner(System.in);
		
		System.out.println("Introduzca el nombre del nuevo paciente");
		String nom = "";
		nom = teclado.nextLine();
		ret.setNombre(nom);
		
		
		System.out.println("Introduzca el id del nuevo paciente");
		long id = 0;
		id = teclado.nextLong();
		ret.setIdPaciente(id);
		
		
		System.out.println("Introduzca el telefono:");
		String tel = "";
		tel= teclado.nextLine();
		ret.setTelefono(tel);
		
		System.out.println("Introduzca la dirección:");
		String dir = "";
		dir = teclado.nextLine();
		ret.setDireccion(dir);
		
		System.out.println("Introduzca la edad:");
		String edad = "";
		edad= teclado.nextLine();
		ret.setEdad(edad);
		
		System.out.println("Introduzca el NIF.");
		String nif ="";
		nif= teclado.nextLine();
		ret.setNif(nif);
		return ret;
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public Historial getHistorial() {
		return historial;
	}

	public void setHistorial(Historial historial) {
		this.historial = historial;
	}

	public Tratamiento[] getTratamientos() {
		return tratamientos;
	}

	public void setTratamientos(Tratamiento[] tratamientos) {
		this.tratamientos = tratamientos;
	}

	@Override
	public String toString() {
		return "Paciente [nombre=" + nombre + ", idPaciente=" + idPaciente + ", telefono=" + telefono + ", direccion="
				+ direccion + ", edad=" + edad + ", nif=" + nif + ", historial=" + historial + ", tratamientos="
				+ Arrays.toString(tratamientos) + "]";
	}

}
