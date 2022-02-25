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

public class Medicamento extends Alergia {

	// idMedicamento es el identificador ï¿½nico de cada elemento Medicamento
	protected long idMedicamento;

	// nombre representa el nombre del medicamento
	// Es una cadena de caracteres de longiyud mï¿½nimo 3 y mï¿½ximo 50 caracteres
	// No acepta dï¿½gitos ni caracteres especiales
	protected String nombreMedicamento;

	// Variable que utilizaremos para completar de forma automï¿½tica el identificador
	// del medicamento.
	private static int numeroMedicamentos = 0;

	// principioActivo representa el nombre del principio activo
	// Es una cadena de caracteres de longitud mï¿½nimo 3 y mï¿½ximo 50 caracteres
	// No acepta dï¿½gitos ni caracteres especiales
	protected String principioActivo;

	// dosisMaxDiaria representa la dosis mï¿½xima diaria
	// es un valor >0
	protected double dosisMaxDiaria;

	// Constructor por defecto, cada vez que le hagamos una llamada aumentarï¿½ el
	// numero de medicamentos en 1 y se le asignarï¿½ ese valor al identificador.
	public Medicamento() {
		numeroMedicamentos = numeroMedicamentos + 1;
		idMedicamento = numeroMedicamentos;

	}

	// Constructor que se le pide por parametro el nombre de la especialidad.
	// Hace una llamada al constructor por defecto.
	// Guarda el valor del parametro introducido en la variable nombeesp.
	public Medicamento(String nombreMedicamento) {
		numeroMedicamentos = numeroMedicamentos + 1;
		idMedicamento = numeroMedicamentos;
		this.nombreMedicamento = nombreMedicamento;
	}

	// Mï¿½todo encargado de guardar el nuevo medicamento.
	// Se le pide al usuario que escriba el nombre del medicamento y se guarda en
	// una variable auxiliar.
	// Esta variable serï¿½ la que pasaremos por parametros haciendo llamada al
	// constructor anterior para establecer el nombre del medicamento.
	// Finalmente devolvemos los datos introducidos.

	public static Medicamento nuevoMedicamento() {

		Medicamento ret = new Medicamento();
		Scanner teclado = new Scanner(System.in);

		// nombreMedicamento
		String nombre = "";
		boolean nombreValido = false;

		do {
			System.out.println("Introduce el nombre del medicamento: ");
			nombre = teclado.nextLine();
			nombreValido = validarNombreMedicamento(nombre);
		} while (!nombreValido);

		ret.setNombreMedicamento(nombre);

		// nombrePrincipioActivo
		String principioActivo = "";
		boolean nombrepValido = false;

		do {
			System.out.println("Introduce el nombre del principio activo: ");
			principioActivo = teclado.nextLine();
			nombrepValido = validarPrincipioActivo(principioActivo);
		} while (!nombrepValido);

		ret.setPrincipioActivo(principioActivo);

		// dosisMï¿½xima
		double dosisMaximaDiaria = 0;
		boolean dosisValida = false;

		do {
			System.out.print("Introduce la dosis mï¿½xima diaria: ");
			dosisMaximaDiaria = teclado.nextDouble();
			dosisValida = validarDosisMaxima(dosisMaximaDiaria);
		} while (!dosisValida);

		ret.setDosisMaxDiaria(dosisMaximaDiaria);

		return new Medicamento();
	}
	
	/*
	 * Metodo encargado de mostrar los datos del Medicamento a travÃ©s de un String
	 * de manera que todos queden separados por el carÃ¡cter "|".
	 * El primer campo corresponde con la clave primaria de la clase Medicamento
	 */
	public String data() {
		String medicamento = "";
		medicamento = this.idMedicamento + "|" +  this.nombreMedicamento + "|" + this.principioActivo + "|" + this.dosisMaxDiaria;
		return medicamento;
	}

	/*
	 * Método encargado de exportar un objeto de tipo Medicamento en un fichero de Texto
	 */
	public static void exportarObjetoAlergiaFicheroTexto() {
		System.out.println("Guardando en medicamentos.txt");

		File fOut = new File("medicamentos.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(fOut);
			bw = new BufferedWriter(fw);
			for (int i = 0; i < Datos.numMedicamentos; i++) {
				Medicamento m = new Medicamento();
				m = Datos.MEDICAMENTOS[i];
				bw.write(m.data() + "\n");
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
	 * Método encargado de la exportación de un Objeto Medicamento en un fichero binario
	 */

	public static void exportarObjetoMedicamentoFicheroBinario() {
		System.out.println("Guardando en medicamentos.dat");
		File f;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {

			f = new File("mediacmentos.dat");
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(Datos.MEDICAMENTOS[1]);

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
	 * Método encargado de la exportación de una colección de Medicamentos en un fichero
	 * binario
	 */

	public static void exportarColeccionMedicamentosFicheroBinario() {
		System.out.println("Guardando en medicamentos.dat");
		File f;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {

			f = new File("medicamentoByte.dat");
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(new Medicamento("Gelocatil"));
			for (int i = 0; i < Datos.numMedicamentos; i++) {
				Medicamento m = new Medicamento();
				m = Datos.MEDICAMENTOS[i];
				oos.writeObject(m);
			}

			oos.writeObject(new Medicamento("Gelocatil"));

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
	 * Método encargado de importar una colección de Medicamentos en un fichero de texto
	 */

	public static void importarColeccionMedicamentosFicheroTexto() {

		System.out.println("Cargando de medicamentos.txt...");
		File f = new File("medicamentos.txt");
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
	 * Método encargado de importar una colección de Medicamentos en un fichero binario
	 */

	public static void importarColeccionMedicamentosFicheroBinario() {
		System.out.println("Cargando de medicamentos.dat...");
		File f;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			f = new File("medicamentos.dat");
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);

			for (int i = 0; i < 6; i++) {
				Medicamento m = (Medicamento) ois.readObject();
				System.out.println(m.data());
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

	public static boolean validarNombreMedicamento(String nombre) {
		return false;
	}

	public static boolean validarPrincipioActivo(String principioActivo2) {
		return false;
	}

	public static boolean validarDosisMaxima(double dosisMaximaDiaria) {
		// TODO Auto-generated method stub
		return false;
	}
	// Getters y setters

	public long getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(long idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public String getNombreMedicamento() {
		return nombreMedicamento;
	}

	public void setNombreMedicamento(String nombreMedicamento) {
		this.nombreMedicamento = nombreMedicamento;
	}

	public static int getNumeroMedicamentos() {
		return numeroMedicamentos;
	}

	public static void setNumeroMedicamentos(int numeroMedicamentos) {
		Medicamento.numeroMedicamentos = numeroMedicamentos;
	}

	public String getPrincipioActivo() {
		return principioActivo;
	}

	public void setPrincipioActivo(String principioActivo) {
		this.principioActivo = principioActivo;
	}

	public double getDosisMaxDiaria() {
		return dosisMaxDiaria;
	}

	public void setDosisMaxDiaria(double dosisMaxDiaria) {
		this.dosisMaxDiaria = dosisMaxDiaria;
	}

	// ToString
	@Override
	public String toString() {
		return "Medicamento [idMedicamento=" + idMedicamento + ", nombreMedicamento=" + nombreMedicamento
				+ ", principioActivo=" + principioActivo + ", dosisMaxDiaria=" + dosisMaxDiaria + "]";
	}
	
}
