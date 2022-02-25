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
import java.util.Scanner;

import utils.Datos;


public class Alergia extends Historial {

	// idAlergia es el identificador ï¿½nico de cada elemento Alergia
	protected long idAlergia;

	// nombre representa el nombre de la alergia
	// Es una cadena de caracteres de longitud mï¿½nimo 3 y mï¿½ximo 50 caracteres
	// No acepta dï¿½gitos ni caracteres especiales
	protected String nombreAlergia;

	// Variable que utilizaremos para completar de forma automï¿½tica el identificador
	// de la alergia.
	private static int numeroAlergias = 0;
	
	public Medicamento medicamento;

	// Constructor por defecto, cada vez que le hagamos una llamada aumentarï¿½ el
	// numero de alergias en 1 y se le asignarï¿½ ese valor al identificador.
	public Alergia() {
		numeroAlergias = numeroAlergias + 1;
		idAlergia = numeroAlergias;
	}

	// Constructor que se le pide por parametro el nombre de la alergia.
	// Hace una llamada al constructor por defecto.
	// Guarda el valor del parametro introducido en la variable nombreAlergia.
	public Alergia(String nombreAlergia) {
		numeroAlergias = numeroAlergias + 1;
		idAlergia = numeroAlergias;
		this.nombreAlergia = nombreAlergia;
	}
	
	
	public Alergia (long idAlergia, String nombreAlergia, Medicamento medicamento) {
		super();
		this.idAlergia = idAlergia;
		this.nombreAlergia = nombreAlergia;
		this.medicamento = medicamento;
	}

	// Mï¿½todo encargado de guardar la nueva alergia de un paciente.
	// Se le pide al usuario que escriba el nombre de la alergia y se guarda en
	// una variable auxiliar.
	// Esta variable serï¿½ la que pasaremos por parametros haciendo llamada al
	// constructor anterior para establecer el nombre de la alergia
	// Finalmente devolvemos los datos introducidos.

	public static Alergia nuevaAlergia() {
		Scanner teclado = new Scanner(System.in);

		String nom = "";
		boolean nomValido = false;

		do {
			System.out.println("Introduce el nombre de la alergia (en el caso de que asï¿½ sea): ");
			nom = teclado.nextLine();
			nomValido = validarNombreAlergia(nom);
		} while (!nomValido);
		return new Alergia();
	}
	
	/*
	 * Metodo encargado de mostrar los datos de la Alergia a travÃ©s de un String
	 * de manera que todos queden separados por el carÃ¡cter "|".
	 * El primer campo corresponde con la clave primaria de la clase Alergia
	 */
	public String data() {
		String alergia = "";
		alergia = this.idAlergia + "|" + this.nombreAlergia;
		return alergia;
	}

	
	/*
	 * Método encargado de exportar un objeto de tipo Alergia en un fichero de Texto
	 */
	public static void exportarObjetoAlergiaFicheroTexto() {
		System.out.println("Guardando en alergias.txt");

		File fOut = new File("alergias.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(fOut);
			bw = new BufferedWriter(fw);
			for (int i = 0; i < Datos.numAlergias; i++) {
				Alergia a = new Alergia();
				a = Datos.ALERGIAS[i];
				bw.write(a.data() + "\n");
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

	/*
	 * Método encargado de la exportación de un Objeto Alergia en un fichero binario
	 */

	public static void exportarObjetoAlergiaFicheroBinario() {
		System.out.println("Guardando en alergias.dat");
		File f;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {

			f = new File("alergias.dat");
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(Datos.ALERGIAS[1]);

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

	/*
	 * Método encargado de la exportación de una colección de Alergias en un fichero
	 * binario
	 */

	public static void exportarColeccionAlergiasFicheroBinario() {
		System.out.println("Guardando en alergias.dat");
		File f;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {

			f = new File("alergiaByte.dat");
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(new Alergia("Alergia a la amoxicilina"));
			for (int i = 0; i < Datos.numAlergias; i++) {
				Alergia a = new Alergia();
				a = Datos.ALERGIAS[i];
				oos.writeObject(a);
			}

			oos.writeObject(new Alergia("Alergia a la amoxicilina"));

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

	/*
	 * Método encargado de importar una colección de alergias en un fichero de texto
	 */

	public static void importarColeccionAlergiasFicheroTexto() {

		System.out.println("Cargando de alergias.txt...");
		File f = new File("alergias.txt");
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

	/*
	 * Método encargado de importar una colección de alergias en un fichero binario
	 */

	public static void importarColeccionAlergiasFicheroBinario() {
		System.out.println("Cargando de alergias.dat...");
		File f;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			f = new File("alergias.dat");
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);

			for (int i = 0; i < 6; i++) {
				Alergia a = (Alergia) ois.readObject();
				System.out.println(a.data());
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
	
	
	// Validadores

	private static boolean validarNombreAlergia(String nom) {
		return false;
	}

	// Getters y setters

	public long getIdAlergia() {
		return idAlergia;
	}

	public void setIdAlergia(long idAlergia) {
		this.idAlergia = idAlergia;
	}

	public String getNombreAlergia() {
		return nombreAlergia;
	}

	public void setNombreAlergia(String nombreAlergia) {
		this.nombreAlergia = nombreAlergia;
	}

	public static int getNumeroAlergias() {
		return numeroAlergias;
	}

	public static void setNumeroAlergias(int numeroAlergias) {
		Alergia.numeroAlergias = numeroAlergias;
	}

	// ToString
	@Override
	public String toString() {
		return "Alergia [idAlergia=" + idAlergia + ", nombreAlergia=" + nombreAlergia + "]";
	}

	
}