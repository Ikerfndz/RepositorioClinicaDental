package entidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import utils.ConexBD;
import utils.Datos;
import utils.Utilidades;
import validacion.Validador;

public class Cita implements Serializable, Comparable<Cita> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6482338208329146684L;
	// idCita representa al identificador unico de la cita.
	// es un valos entero >0.
	protected long idCita;
	// fecha representa el dia indicado para la cita.
	// hora representa la hora a la que se realizara la cita.
	// Seran para ambos la funcion LocalDate.

	protected LocalDateTime fechahora;
	// rango representa el horario preferido por el cliente siendo de mañana o de
	// tarde.
	// Es un char que representara una "M" para las mañanas y una "T" para las
	// tardes.
	// No se aceptara mas de un caracter.
	protected char rango;

	private int tipo;
	private Tratamiento tratamiento;
	private Empleado empleado;
	private Medicamento medicamento;
	private Revision revision;
	private Intervencion intervencion;
	private static long numeroCitas = 0;

	public Cita() {
		numeroCitas++;
		this.idCita = numeroCitas;
	}

	public Cita(long idCita, LocalDateTime fechahora, char rango, int tipo) {
		super();
		this.idCita = idCita;
		this.fechahora = fechahora;
		this.rango = rango;
		this.tipo = tipo;
	}

	public Cita(long idCita, LocalDateTime fechahora, char rango) {
		numeroCitas++;
		this.idCita = numeroCitas;
		this.fechahora = fechahora;
		this.rango = rango;
	}

	/**
	 * Constructor de copia, para copiar los atributos de la clase padre Cita
	 * 
	 * @param c
	 */
	public Cita(Cita c) {
		numeroCitas++;
		this.idCita = c.getIdCita();
		this.fechahora = c.getFechahora();
		this.rango = c.getRango();
	}

	/**
	 * * Implementacion de un método nuevaFecha que pida por pantalla al usuario
	 * 
	 * @return una nueva Cita
	 */
	public static Cita nuevaCita() {
		Cita ret = new Cita();
		Scanner teclado = new Scanner(System.in);
		boolean valido = false;
		char rango;
		System.out.print(">>Introduce mañana o tarde: ");
		boolean rangoValido = false;
		;
		rangoValido = Utilidades.leerChar();

		System.out.println(" <<<Seleccione a continuación la fecha que desea reservar>>> ");

		LocalDateTime fechaCita = Utilidades.leerFechaHora();

		ret.setFechahora(fechaCita);

		return ret;

	}

	public long getIdCita() {
		return idCita;
	}

	public void setIdCita(long idCita) {
		this.idCita = idCita;
	}

	public LocalDateTime getFechahora() {
		return fechahora;
	}

	public void setFechahora(LocalDateTime fechahora) {
		this.fechahora = fechahora;
	}

	public char getRango() {
		return rango;
	}

	public void setRango(char rango) {
		this.rango = rango;
	}

	public static long getNumeroCitas() {
		return numeroCitas;
	}

	public static void setNumeroCitas(long numeroCitas) {
		Cita.numeroCitas = numeroCitas;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	/**
	 * Metodo que recorre el array de las citas, de la clase Datos, los almacena en
	 * la variable c y a continuacion se muestran a traves del metodo toString de la
	 * clase Cita
	 */
	public static void motrarCita() {
		System.out.println("Lista de Citas disponibles:");
		for (int i = 0; i < Datos.numeroCitas; i++) {
			Cita c = Datos.CITAS[i];
			System.out.println(c.toString());
		}
	}

	@Override
	public String toString() {
		return "Cita [idCita=" + idCita + ", fechahora=" + fechahora + ", rango=" + rango + "]";
	}

	/**
	 * Función que devuelve una cadena de caracteres con la siguiente estructura
	 * <DatosCita.id>|<DatosCita.fechaHora>|<DatosCita.rango>|<DatosCita.fechahora|
	 * Cada campo se separa mediante el caracter '|'
	 * 
	 * @return
	 */
	public String citaData() {
		String cita = "";
		cita = " | " + this.idCita + " | " + this.rango + " | "
				+ this.fechahora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + " | ";
		return cita;
	}

	/***
	 * Metodo que permite exportar un objeto Cita hacia un fichero de texto llamado
	 * citasListado.txt
	 * 
	 */
	public static void exportarCitasListado(Cita citas) {
		String path = "citasListado.txt";
		File fichero = new File(path);
		FileWriter escritor = null;
		PrintWriter buffer = null;
		try {
			try {
				escritor = new FileWriter(fichero, false);
				buffer = new PrintWriter(escritor);
				buffer.println(citas.citaData());

			} finally {
				if (buffer != null) {
					buffer.close();
				}
				if (escritor != null) {
					escritor.close();
				}
			}

		} catch (FileNotFoundException ext) {
			System.out.println("Se ha producido una FileNotFoundException" + ext.getMessage());
		} catch (IOException ext) {
			System.out.println("Se ha producido una IOException" + ext.getMessage());
		} catch (Exception ext) {
			System.out.println("Se ha producido una Exception" + ext.getMessage());
		}
	}

	/***
	 * Metodo que permite importar una coleccion de objetos del tipo cita desde un
	 * fichero de texto (con extension .txt)
	 * 
	 */
	public static void importarColeccionCitasTXT() {

		System.out.println("Importando fichero de Citas.txt...");
		File f = new File("citas.txt");
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String s;

			for (int i = 0; i < 3; i++) {
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

	/***
	 * Función para recorrer todos los elementos del array CITAS de la clase
	 * Datos.java, y exportar a un fichero binario de nombre citasPasadas.dat sólo
	 * aquellas citas consideradas como pasadas (es decir, cuya fecha fuera
	 * posterior al 01/01/2022).
	 */
	public static void exportarCitasPasadas() {
		String path = "citasPasadas.dat";
		try {
			FileOutputStream fichero = new FileOutputStream(path, false);

			ObjectOutputStream escritor = new ObjectOutputStream(fichero);
			for (Cita c : Datos.CITAS) {
				if (c.isAfter(LocalDateTime.of(2022, 1, 1, 00, 00, 00))) {
					escritor.writeObject((Cita) c);
					escritor.flush();
				}
			}
			escritor.close();
		} catch (FileNotFoundException ext) {
			System.out.println("Se ha producido una FileNotFoundException" + ext.getMessage());
		} catch (IOException ext) {
			System.out.println("Se ha producido una IOException" + ext.getMessage());
		} catch (Exception ext) {
			System.out.println("Se ha producido una Exception" + ext.getMessage());
		}
	}

	/***
	 * Metodo que permite importar una coleccion de objetos del tipo cita desde un
	 * fichero binario (con extension .dat)
	 * 
	 */
	public static void importarColeccionCitas() {
		System.out.println("Importando fichero de Citas.dat...");
		File f;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			f = new File("citas.dat");
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);

			for (int i = 0; i < 3; i++) {
				Cita c = (Cita) ois.readObject();
				System.out.println(c.citaData());
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

	private boolean isAfter(LocalDateTime of) {
		return false;
	}

	public static void buscarCitas() {
		System.out.print("Menu de busqueda de Citas: ");
		System.out.println("¿Desea buscar la cita por el Id? (Seleccione id");
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
				System.out.println("Intrduce el id de la Cita que quiere buscar (id>0): ");
				buscaId = teclado.nextLong();
				if (buscaId > 0) {
					valido = true;
				}
			} while (!valido);
			for (Cita c : Datos.CITAS) {
				if (c.getIdCita() == buscaId) {
					System.out.println("Paciente encontrado: " + c.citaData());
				}
			}
		}

	}

	/**
	 * Inserción de una Cita
	 * 
	 * @return
	 */
	public static boolean insertarCita() {
		boolean ret = false;
		String consultaInsertStr1 = "insert into citas(idCita, fechahora, rango, tipo) values (?,?,?,?)";
		try {
			Connection conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);

			List<Cita> cita = new LinkedList<>();
			for (Cita ct : Datos.CITAS) {
				cita.add(ct);
			}
			Collections.sort(cita);
			Iterator<Cita> it = cita.iterator();
			while (it.hasNext()) {
				Cita ct = (Cita) it.next();
				pstmt.setLong(1, ct.getIdCita());
				// java.sql.Date fechaSQL = java.sql.Date.valueOf(ct.getFechahora());
				// pstmt.setDate(2, fechaSQL);
				// pstmt.setCharrAt(3, ct.getRango());
				pstmt.setInt(4, ct.getTipo());
				int resultadoInsercion = pstmt.executeUpdate();
				ret = (resultadoInsercion != 0);
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			ret = false;
		}

		return ret;
	}

	@Override
	public int compareTo(Cita o) {
		return Long.compare(this.idCita, o.idCita);
	}

	public Tratamiento getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Revision getRevision() {
		return revision;
	}

	public void setRevision(Revision revision) {
		this.revision = revision;
	}

	public Intervencion getIntervencion() {
		return intervencion;
	}

	public void setIntervencion(Intervencion intervencion) {
		this.intervencion = intervencion;
	}
}
