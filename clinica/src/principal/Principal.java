package principal;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		int eleccion;
		Scanner in = new Scanner(System.in);
		boolean eleccionValida = false;
		do {
			mostrarMenuPrincipal();
			eleccion = in.nextInt();
			eleccionValida = (eleccion < 1 || eleccion > 3 ? false : true);
			if (!eleccionValida)
				System.out.println("Opcion invalida! Vuelva a introducir su eleccion.");

		} while (!eleccionValida);
		System.out.println("Usted ha elegido la opción:" + eleccion);

		switch (eleccion) {
		case 1:
			System.out.println("Elegida la opción 1");
			break;

		case 2:
			System.out.println("Elegida la opción 2");
			break;
		case 3:
			System.out.println("Elegida la opción 3");
			break;
		default:
			System.out.println("Otro valor!");	
		}

		int variable;

		Persona pedro = new Persona();
		pedro.setNombre("Pedro Pérez");
		System.out.println("El id de la variable pedro es:" + pedro.getId());
		System.out.println("El valor del campo numeroPersonas la variable pedro es:" + Persona.getNumeroPersonas());

	}

	public static void mostrarMenuPrincipal() {
		System.out.println("Bienvenido/a al programa de gestión:");

		System.out.println("Pulse 1 para Nueva persona.");
		System.out.println("Pulse 2 para ver las personas:");
		System.out.println("Pulse 3 para salir.");

	}

}
