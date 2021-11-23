package principal;

import java.util.Arrays;
import java.util.Scanner;

import Validaci�n.Validador;

public class Paciente {

	
	// nombre representa el nombre del paciente.
	// es una cadena de caracteres con un minimo de 3 caracteres y maximo de 50.
	// no acepta numeros ni caracteres especiales .
	private static String nombre;
	// idPaciente representa al identificador �nico del paciente.
	// es un valos entero >0 .
	private long idPaciente;
	// telefono representa al numero de telfono del paciente.
	// esta formado por 9 digitos
	private String telefono;
	// direccion representa la direccion del paciente.
	// esta formado por una cadena de caracteres de minimo 5 caracteres y un maximo
	// de 50
	private String direccion;
	// edad representa a la edad del paciente
	private String edad;
	// nif representa nif del paciente
	// esta formado por 8 digitos y 1 caracter
	private String nif;
	// numeroPacientes es de tipo entero
	// esta variable nos permitira completar de forma automatica el idPaciente
	private static int numeroPacientes = 0;
	
	private Historial historial = new Historial();
	private Tratamiento tratamientos[] = new Tratamiento[10];

	// Constructor por defecto que cada vez que le hagamos una llamada aumentara el
	// valor de numeroPacientes en 1 y se le asignara ese valor al idPaciente
	public Paciente () {
		numeroPacientes++;
		this.idPaciente = numeroPacientes;}
	
	public Paciente (String nombre, String edad, String telefono, String direccion, String nif) {
		this();
		this.nombre = nombre;
		this.edad = edad;
		this.telefono = telefono;
		this.direccion = direccion;
		this.nif = nif;
	}

	
	 // Metodo nuevoPaciente encargado de registrar a un nuevo paciente
	public static Paciente nuevoPaciente() {
		Paciente ret = new Paciente();
		Scanner teclado;
		teclado = new Scanner(System.in);

		
		String nom = "";
		boolean nombreValido=false;
		
		do {
			System.out.println("Introduzca el nombre del nuevo paciente: ");
			nom = teclado.nextLine();
			nombreValido= Validador.validarNombrePaciente(nom);
		} while (!nombreValido);
		ret.setNombre(nom);

		System.out.println("Introduzca el telefono:");
		String tel = "";
		boolean telefonoValido=false;
		tel = teclado.next();
		ret.setTelefono(tel);

		System.out.println("Introduzca la direcci�n:");
		String dir = "";
		boolean direccionValida=false;
		dir = teclado.next();
		ret.setDireccion(dir);

		System.out.println("Introduzca la edad:");
		String edad = "";
		boolean edadValida=false;
		edad = teclado.next();
		ret.setEdad(edad);

		System.out.println("Introduzca el NIF.");
		String nif = "";
		boolean nifValido=false;
		nif = teclado.next();
		ret.setNif(nif);
		return ret;

	}

	
	
	
	
	private static boolean nombreValido(String nombre2) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean validarNombrePaciente(String nombre2) {
		// TODO Auto-generated method stub
		return false;
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
