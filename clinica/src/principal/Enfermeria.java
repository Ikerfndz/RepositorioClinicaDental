package principal;

import java.util.Scanner;

public class Enfermeria extends Empleado {
	private char categoria;
	private Intervencion intervenciones[]=new Intervencion[10];
	


	public Enfermeria() {

	}
	public Enfermeria(char categoria,Empleado empleado,Intervencion intervencion) {
		super(empleado);
		setCategoria(categoria);
		intervenciones[0]=intervencion;
	}

	public static Enfermeria nuevoEnfermero() {
		Empleado empleado=Empleado.nuevoEmpleado();
		Intervencion intervencion=Intervencion.nuevaIntervencion();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce la categoría del enfermero/a");
		char cat;
		cat=teclado.next().charAt(0);
		Enfermeria ret= new Enfermeria(cat,empleado,intervencion);
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