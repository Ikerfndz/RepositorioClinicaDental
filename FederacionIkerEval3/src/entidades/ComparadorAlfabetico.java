package entidades;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import utils.Datos;

public class ComparadorAlfabetico implements Comparator<DatosPersona> {

	// Ejercicio 1B examen 1Eval3
	@Override
	public int compare(DatosPersona dp1, DatosPersona dp2) {
		return dp1.getNombre().compareTo(dp2.getNombre());
	}
  
	//Ejercicio 1C examen 1Eval3
	public static void personasOrdenadas() {
		LinkedList<DatosPersona> ret = new LinkedList<DatosPersona>();
		for (DatosPersona dp : Datos.PERSONAS) {
		ret.add(dp);
		}
		Collections.sort(ret, new ComparadorAlfabetico());
		System.out.println("La lista ordenada de todas las personas es:");
		Iterator<DatosPersona> it = ret.iterator();
		int i = 1;
		while (it.hasNext()) {
		System.out.println(i + ": " + ((DatosPersona) it.next()).data() + " ");
		i++;
		}

	}

}
