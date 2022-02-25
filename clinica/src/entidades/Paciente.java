package entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;
import utils.Datos;
import validacion.Validador;

public class Paciente {

	// nombre representa el nombre del paciente.
	// es una cadena de caracteres con un minimo de 3 caracteres y maximo de 50.
	// no acepta numeros ni caracteres especiales .
	private String nombre;
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
	private int edad;
	// nif representa nif del paciente
	// esta formado por 8 digitos y 1 caracter
	private String nif;
	// numeroPacientes es de tipo entero
	// esta variable nos permitira completar de forma automatica el idPaciente
	private static long numeroPacientes = Datos.numPacientesd;

	private Historial historial = new Historial();
	private Tratamiento tratamientos[] = new Tratamiento[10];

	// Constructor por defecto que cada vez que le hagamos una llamada aumentara el
	// valor de numeroPacientes en 1 y se le asignara ese valor al idPaciente
	public Paciente() {
		numeroPacientes++;
		this.idPaciente = numeroPacientes;
	}

	public Paciente(String nombre, String direccion, String telefono, int edad, String nif) {
		this.nombre = nombre;
		this.edad = edad;
		this.telefono = telefono;
		this.direccion = direccion;
		this.nif = nif;
	}

	public Paciente(String nombre, long id, String telefono, String direccion, int edad, String nif) {
		this.nombre = nombre;
		this.idPaciente = id;
		this.edad = edad;
		this.telefono = telefono;
		this.direccion = direccion;
		this.nif = nif;
	}

	// Metodo nuevoPaciente encargado de registrar a un nuevo paciente
	public static Paciente nuevoPaciente() {
		Paciente paciente = null;

		Scanner teclado;
		teclado = new Scanner(System.in);

		// Nombre
		String nomPaciente = "";
		boolean nombreValido = false;
		do {
			System.out.println("Introduzca el nombre del nuevo paciente: ");
			nomPaciente = teclado.nextLine();
			nombreValido = Validador.validarNombrePaciente(nomPaciente);
		} while (!nombreValido);

		// Telefono
		String telPaciente = "";
		boolean telefonoValido = false;
		do {
			System.out.println("Introduzca el telefono: ");
			telPaciente = teclado.next();
			telefonoValido = Validador.validarTelefonoPaciente(telPaciente);
		} while (!telefonoValido);

		// Direccion
		String dirPaciente = "";
		boolean direccionValida = false;
		do {
			System.out.println("Introduzca la direcci�n: ");
			dirPaciente = teclado.next();
			direccionValida = Validador.validarDireccionPaciente(dirPaciente);
		} while (!direccionValida);

		// Edad
		int edadPaciente = 0;
		boolean edadValida = false;
		do {
			System.out.println("Introduzca la edad: ");
			edadPaciente = teclado.nextInt();
			edadValida = Validador.validarEdadPaciente(edadPaciente);
		} while (!edadValida);

		// NIF
		String nifPaciente = "";
		boolean nifValido = false;
		do {
			System.out.println("Introduzca el NIF: ");
			nifPaciente = teclado.next();
			nifValido = Validador.validarNifPaciente(nifPaciente);
		} while (!nifValido);

		paciente = new Paciente(nomPaciente, telPaciente, dirPaciente, edadPaciente, nifPaciente);
		System.out.println(paciente);
		return paciente;

	}

	/*
	 * Metodo encargado de mostrar los datos del Paciente a través de un String de
	 * manera que todos queden separados por el carácter "|". El primer campo
	 * corresponde con la clave primaria de la clase Paciente
	 */
	public String pacienteData() {
		String paciente = "";
		paciente = this.idPaciente + " | " + this.nif + " | " + this.nombre + " | " + this.telefono + " | "
				+ this.direccion + " | " + this.edad;
		return paciente;
	}

	public static void exportarObjetoPacientesFicheroTexto() {
		System.out.println("Guardando en pacientes.txt");

		File fOut = new File("pacientes.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(fOut);
			bw = new BufferedWriter(fw);
			for (int i = 0; i < Datos.numPacientesd; i++) {
				Paciente p = new Paciente();
				p = Datos.PACIENTES[i];
				bw.write(p.pacienteData() + "\n");
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void exportarObjetoPacienteFicheroBinario() {
		System.out.println("Guardando en pacientes.dat");
		File f;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {

			f = new File("pacientes.dat");
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(Datos.PACIENTES[1]);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void exportarColeccionPacientesFicheroBinario() {
		System.out.println("Guardando en pacientes.dat");
		File f;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {

			f = new File("clienteByte.dat");
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(new Paciente("Iker", "698745123", "iker@educastur.es", 20, "58430328n"));
			for (int i = 0; i < Datos.numPacientesd; i++) {
				Paciente p = new Paciente();
				p = Datos.PACIENTES[i];
				oos.writeObject(p);
			}

			oos.writeObject(new Paciente("Iker", "698745123", "iker@educastur.es", 20, "58430328n"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void importarColeccionPacientesFicheroTexto() {

		System.out.println("Cargando de pacientes.txt...");
		File f = new File("pacientes.txt");
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String s;

			for (int i = 0; i < 6; i++) {
				s = (String) br.readLine();
				System.out.println(s);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void importarColeccionPacientesFicheroBinario() {
		System.out.println("Cargando de pacientes.dat...");
		File f;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			f = new File("pacientes.dat");
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);

			for (int i = 0; i < 6; i++) {
				Paciente p = (Paciente) ois.readObject();
				System.out.println(p.pacienteData());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edadPaciente) {
		this.edad = edadPaciente;
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

	public static void buscarPaciente() {
		System.out.print("Menu de busqueda de Paciente: ");
		System.out.println("�Desea buscar el paciente por el Id o por el nombre? (Seleccione id/nombre");
		Scanner teclado;
		boolean valido = false;

		String respuestaCliente = "";
		do {
			teclado = new Scanner(System.in);
			respuestaCliente = teclado.nextLine();
			valido = Validador.validarRespuestaCliente(respuestaCliente);
		} while (!valido);

		valido = false;
		if (respuestaCliente.equals("id")) {
			long buscaId = 0;
			do {
				System.out.println("Intrduce el id del Paciente que quiere buscar (id>0): ");
				buscaId = teclado.nextLong();
				if (buscaId > 0) {
					valido = true;
				}
			} while (!valido);
			for (Paciente p : Datos.PACIENTES) {
				if (p.getIdPaciente() == buscaId) {
					System.out.println("Paciente encontrado: " + p.pacienteData());
				}
			}
		}
		if (respuestaCliente.equals("nombre")) {
			String buscaNombre = "";
			do {
				System.out.println("Introduce el nombre del Paciente que quiere buscar: ");
				buscaNombre = teclado.nextLine();
				if (buscaNombre.length() < 30 && buscaNombre.length() > 0) {
					valido = true;
				}
			} while (!valido);
			for (Paciente p : Datos.PACIENTES) {
				if (p.getNombre().equalsIgnoreCase(buscaNombre)) {
					System.out.print("Paciente encontrado : " + p.pacienteData());
				}
			}
		}
	}

}

