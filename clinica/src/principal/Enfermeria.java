package principal;

import java.util.Scanner;

public class Enfermeria extends Empleado {
	private char categoria;


	public Enfermeria() {

	}


	public static Enfermeria nuevoEnfermero() {
		Enfermeria ret = new Enfermeria();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce la categoría del enfermero/a");
		char cat;
		cat=teclado.next().charAt(0);
		ret.setCategoria(cat);
		teclado.close();
		return ret;
	}

	public char getCategoria() {
		return categoria;
	}

	public void setCategoria(char categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Enfermeria [categoria=" + categoria + "]";
	
	}

}