package entidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import utils.Datos;
import utils.Utilidades;
import validaciones.Validaciones;

public class DatosPersona implements Comparable<DatosPersona> {
	private long id;
	private String nombre;
	private String telefono;
	private LocalDate fechaNac;

	private Documentacion nifnie; // Examen 2 Ejercicio 3.2

	public DatosPersona(long id, String nombre, String telefono, LocalDate fechaNac) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
	}

	// Examen 2 Ejercicio 3.2
	public DatosPersona(long id, String nombre, String telefono, LocalDate fechaNac, Documentacion nifnie) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
		this.nifnie = nifnie;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Documentacion getNifnie() {
		return nifnie;
	}

	public void setNifnie(Documentacion nifnie) {
		this.nifnie = nifnie;
	}

	@Override
	public String toString() {
		return nombre + " NIF/NIE: " + nifnie.mostrar() + " Tfn:" + telefono + " ("
				+ fechaNac.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ")";
	}

	// Examen 2 Ejercicio 3.3
	// Examen 5 Ejercicio 3
	public static DatosPersona nuevaPersona() {
		DatosPersona ret = null;
		Scanner in;
		long id = -1;
		String nombre = "";
		String tfn = "";
		boolean valido = false;
		do {
			System.out.println("Introduzca el id de la nueva persona:");
			in = new Scanner(System.in);
			id = in.nextInt();
			valido = Validaciones.validarId(id);
			if (!valido)
				System.out.println("ERROR: Valor incorrecto para el identificador.");
			else
				valido = true;
		} while (!valido);
		valido = false;
		do {
			System.out.println("Introduzca el nombre de la nueva persona:");
			in = new Scanner(System.in);
			nombre = in.nextLine();
			valido = Validaciones.validarNombre(nombre);
			if (!valido)
				System.out.println("ERROR: El valor introducido para el nombre no es vÃ¡lido. ");
		} while (!valido);
		do {
			System.out.println("Introduzca el telÃ©fono de la nueva persona:");
			in = new Scanner(System.in);
			tfn = in.nextLine();
			valido = Validaciones.validarTelefono(tfn);
			if (!valido)
				System.out.println("ERROR: El valor introducido para el telÃ©fono no es vÃ¡lido. ");
		} while (!valido);
		System.out.println("Introduzca la fecha de nacimiento de la nueva persona");
		LocalDate fecha = Utilidades.leerFecha();
		System.out.println("Â¿Va a introducir un NIF? (pulse 'S' par SÃ� o 'N' para NIE)");
		boolean esnif = Utilidades.leerBoolean();
		Documentacion doc;
		valido = false;
		do {
			if (esnif)
				doc = NIF.nuevoNIF();
			else
				doc = NIE.nuevoNIE();
			valido = doc.validar();
			if (!valido)
				System.out.println("ERROR: El documento introducido no es vÃ¡lido.");
		} while (!valido);
		ret = new DatosPersona(id, nombre, tfn, fecha, doc);
		return ret;
	}

	// Ejercicio 1A Examan1 Eval3

	public String data() {
		return "" + this.getId() + "|" + this.getNombre() + "|" + this.telefono + "|"
				+ this.getFechaNac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "|"
				+ this.getNifnie().mostrar();
	}

	

	//Ejercicio 2A Examen 1 Eval 3
	@Override
	public int compareTo(DatosPersona o) {
		if (this.fechaNac.compareTo(o.fechaNac) == 0) {
			// hay que desempatar
			return this.getNifnie().compareTo(o.getNifnie());
		} else
			return this.fechaNac.compareTo(o.fechaNac);
	}
	
	public static void exportarPersonas() {
		String s = "atletas_alfabetico.txt";
		File f = new File(s);
		FileWriter fw = null;
		PrintWriter b = null;
		ComparadorAlfabetico compare = null;
		try {
		try {
		fw = new FileWriter(f, false);
		b = new PrintWriter(fw);
		for (DatosPersona dp : Datos.PERSONAS) {
		compare.personasOrdenadas();
		b.println(dp.data());
		}



		} finally {
		if (b != null) {
		b.close();
		}
		if (fw != null) {
		fw.close();
		}
		}



		} catch (FileNotFoundException ex) {
		System.out.println("Se ha producido una FileNotFoundException" + ex.getMessage());
		} catch (IOException ex) {
		System.out.println("Se ha producido una IOException" + ex.getMessage());
		} catch (Exception ex) {
		System.out.println("Se ha producido una Exception" + ex.getMessage());
		}
		}
}













