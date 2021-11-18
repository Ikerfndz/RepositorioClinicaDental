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
				System.out.println("Usted ha elegido la opcion: " + eleccion);

			Scanner teclado = new Scanner(System.in);
			if (eleccion== 1) {
				do {
					eleccion1();
					eleccion = in.nextInt();
					eleccionValida = (eleccion < 1 || eleccion > 5 ? false : true);
					if (!eleccionValida)
						System.out.println("Opcion invalida! Vuelva a introducir su eleccion.");
		
				} while (!eleccionValida);
				System.out.println("Usted ha elegido la opcion: " + eleccion);
				int eleccion11;
				eleccion11= teclado.nextInt();
				if (eleccion11== 1) {
					Paciente.nuevoPaciente();
				}
			}
			
			if (eleccion== 2) {
				eleccion2();
			}
			if (eleccion== 3) {
				eleccion3();
				
			}
	}

	public static void mostrarMenuPrincipal() {
		System.out.println("Bienvenido/a al programa de gestion:");

		System.out.println("Pulse 1 para Nueva persona.");
		System.out.println("Pulse 2 para ver las personas:");
		System.out.println("Pulse 3 para salir.");

	}
	
	public static void eleccion1() {
		System.out.println("Bienvenido/a al programa de registro de una nueva persona:");

		System.out.println("Pulse 1 para registrar un nuevo Paciente:");
		System.out.println("Pulse 2 para registrar un nuevo Cirujano/a:");
		System.out.println("Pulse 3 para registrar un nuevo Enfermero/a:");
		System.out.println("Pulse 4 para registrar un nuevo Secretario/a:");
		System.out.println("Pulse 5 para salir.");

	
	}
	
	public static void eleccion2() {
		System.out.println("Bienvenido/a al programa de visualizacion de personas:");

		System.out.println("Pulse 1 para ver los Pacientes:");
		System.out.println("Pulse 2 para ver los Cirujanos/as:");
		System.out.println("Pulse 3 para ver los Enfermeros/as:");
		System.out.println("Pulse 4 para ver los Secretarios/as:");
		System.out.println("Pulse 5 para salir.");

	
	}
	
	public static void eleccion3() {
		
		System.out.println("Hasta pronto!! <3");
		
	}
	
	
	
}
