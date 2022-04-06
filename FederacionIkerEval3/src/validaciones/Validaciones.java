package validaciones;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.aeat.valida.Validador;

import entidades.NIE;
import entidades.NIF;

//Examen 5 Ejercicio 3
public class Validaciones {

	/**
	 * Valida que una cadena de caracteres contiene dÃ­gitos Ãºnicamente
	 * 
	 * @param tfn cadena con el telefono a validar
	 * @return true si es un telefono vÃ¡lido o false en caso contrario
	 */
	public static boolean validarTelefono(String tfn) {
		return tfn.trim().chars().allMatch(Character::isDigit);
	}

	/**
	 * Valida que una cadena de caracteres contiene letras o espacios Ãºnicamente,
	 * longitud entre 3 y 50 caractreres
	 * 
	 * @param nombre cadena con el nombre a validar
	 * @return true si es un nombre vÃ¡lido o false en caso contrario
	 */
	public static boolean validarNombre(String nombre) {
		// regEx general para cadena de caracteres con longitud entre 1 y 50 caracteres,
		// aceptando dÃ­gitos, letras MAYUS y minÃºsculas, con tildes, dirÃ©resis y
		// diferentes sÃ­mbolos especiales
		// Pattern patron = Pattern.compile("[
		// 0-9A-Za-zÃ±Ã‘Ã¡Ã©Ã­Ã³ÃºÃ�Ã‰Ã�Ã“ÃšÃ¤Ã«Ã¯Ã¶Ã¼Ã„Ã‹Ã�Ã–ÃœÂ¡!Â¿?@#$%()=+-â‚¬/.,]{1,50}");
		Pattern patron = Pattern.compile("[ A-Za-zÃ±Ã‘Ã¡Ã©Ã­Ã³ÃºÃ�Ã‰Ã�Ã“ÃšÃ¤Ã«Ã¯Ã¶Ã¼Ã„Ã‹Ã�Ã–Ãœ-]{3,50}");
		Matcher comprobacion = patron.matcher(nombre);
		return comprobacion.matches();//
	}

	/**
	 * 
	 * Funcion que valida si una cadena de caracteres que se pasa como parÃ¡metro
	 * tiene un NIF vÃ¡lido.
	 * 
	 * @param nif cadena con el NIF a validar
	 * @return true si la cadena nif es un NIF vÃ¡lido o false en caso contrario
	 */
	public static boolean validarNIF(String nif) {
		boolean ret = false;
		if (nif.length() != 9)
			ret = false;
		if (!Character.isLetter(nif.charAt(nif.length() - 1)))
			ret = false;
		// Usamos validador de AEAT --> valnif.jar
		Validador val = new Validador();
		ret = (val.checkNif(nif) > 0 ? true : false);
		return ret;
	}

	/**
	 * FunciÃ³n que valida un objeto NIF
	 * 
	 * @param nif objeto NIF que se va a validar
	 * @return true si el NIF pasado como parÃ¡metro es vÃ¡lido o false en caso
	 *         contrario
	 */
	public static boolean validarNIF(NIF nif) {
		boolean ret = false;
		if (nif.getNumero().length() != 8)
			ret = false;
		if (!Character.isLetter(nif.getLetraFinal()))
			ret = false;
		// Usamos validador de AEAT --> valnif.jar
		Validador val = new Validador();
		ret = (val.checkNif(nif.mostrar()) > 0 ? true : false);
		return ret;
	}

	/**
	 * Funcion que valida si una cadena de caracteres que se pasa como parÃ¡metro
	 * tiene un NIE vÃ¡lido.
	 * 
	 * @param nie cadena con el NIE a validar
	 * @return true si la cadena nie es un NIE vÃ¡lido o false en caso contrario
	 */
	public static boolean validarNIE(String nie) {
		boolean esValido = false;
		int i = 1;
		int caracterASCII = 0;
		char letra = ' ';
		int miNIE = 0;
		int resto = 0;
		char[] asignacionLetra = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q',
				'V', 'H', 'L', 'C', 'K', 'E' };

		if (nie.length() == 9 && Character.isLetter(nie.charAt(8)) && nie.substring(0, 1).toUpperCase().equals("X")
				|| nie.substring(0, 1).toUpperCase().equals("Y") || nie.substring(0, 1).toUpperCase().equals("Z")) {

			do {
				caracterASCII = nie.codePointAt(i);
				esValido = (caracterASCII > 47 && caracterASCII < 58);
				i++;
			} while (i < nie.length() - 1 && esValido);
		}

		if (esValido && nie.substring(0, 1).toUpperCase().equals("X")) {
			nie = "0" + nie.substring(1, 9);
		} else if (esValido && nie.substring(0, 1).toUpperCase().equals("Y")) {
			nie = "1" + nie.substring(1, 9);
		} else if (esValido && nie.substring(0, 1).toUpperCase().equals("Z")) {
			nie = "2" + nie.substring(1, 9);
		}

		if (esValido) {
			letra = Character.toUpperCase(nie.charAt(8));
			miNIE = Integer.parseInt(nie.substring(0, 8));
			resto = miNIE % 23;
			esValido = (letra == asignacionLetra[resto]);
		}

		return esValido;
	}

	/**
	 * FunciÃ³n que valida un objeto NIE
	 * 
	 * @param nie objeto NIE que se va a validar
	 * @return true si el NIE pasado como parÃ¡metro es vÃ¡lido o false en caso
	 *         contrario
	 */
	public static boolean validarNIE(NIE nie) {
		return validarNIE(nie.mostrar());
	}

	public static boolean validarAltura(float altura) {
		return (altura > 0.0F);
	}

	public static boolean validarPeso(float peso) {
		return (peso > 0.0F);
	}

	public static boolean validarDireccion(String direccion) {
		return (direccion.length() > 3);
	}

	/**
	 * FunciÃ³n que valida un valor flotante para la pureza (en %)
	 * 
	 * @param pureza valor flotante de la pureza para validar
	 * @return true si es valor vÃ¡lido (entre 0,0 y 100,0) o false en caso contrario
	 */
	public static boolean validarPureza(float pureza) {
		return (pureza >= 0.0F && pureza <= 100.0F);
	}

	public static boolean validarFecha(LocalDate fechaMin) {
		// TODO Esbozo de mÃ©todo generado automÃ¡ticamente
		return true;
	}

	public static boolean validarId(long id) {
		return (id > 0);
	}

	public static boolean validarAnio(int anio) {
		return (anio > 0);
	}
	
	public static boolean validarNombreEquipo(String nombre) {
		return false; //TO-DO
	}

	
	//EXAMEN 10
	public static boolean validarIdResponsable(long id) {
		return (id>0);
	}

	public static boolean validartelefonoProfResponsable(String telefonoProf) {
		char caracterinicial = telefonoProf.charAt(0);
		int enteroinicial = Character.getNumericValue(caracterinicial);
		if (telefonoProf.length() == 8
				&& (enteroinicial == 9 || enteroinicial == 8 || enteroinicial == 6 || enteroinicial == 7))
			return false;
		return true;
		
	}



	public static boolean validarNombrePatrocinador(String nombre) {
		Pattern patron = Pattern.compile("[ A-Za-zÃ±Ã‘Ã¡Ã©Ã­Ã³ÃºÃ�Ã‰Ã�Ã“ÃšÃ¤Ã«Ã¯Ã¶Ã¼Ã„Ã‹Ã�Ã–Ãœ-]{3,150}");
		Matcher comprobacion = patron.matcher(nombre);
		return comprobacion.matches();//
	
	}

	

	public static boolean validarwebPatrocinador(String web) {
		// TODO Auto-generated method stub
		return false;
	}

	
}