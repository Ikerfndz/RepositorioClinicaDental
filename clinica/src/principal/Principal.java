package principal;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		int eleccion;
		Scanner in = new Scanner(System.in);
		boolean eleccionValida = false;
		boolean salir = false;
		do {
			do {
				mostrarMenuPrincipal();
				eleccion = in.nextInt();
				eleccionValida = (eleccion < 1 || eleccion > 4 ? false : true);
				if (!eleccionValida)
					System.out.println("Opcion invalida! Vuelva a introducir su eleccion.");

			} while (!eleccionValida);
			System.out.println("Usted ha elegido la opcion: " + eleccion);

			
			if (eleccion == 1) {
				do {
					eleccionValida = false;
					eleccion1();
					eleccion = in.nextInt();
					eleccionValida = (eleccion < 1 || eleccion > 5 ? false : true);
					if (!eleccionValida)
						System.out.println("Opcion invalida! Vuelva a introducir su eleccion.");

					switch (eleccion) {

					case 1:
						Paciente.nuevoPaciente();
						eleccionValida = false;
						break;

					case 2:
						
						eleccionValida = true;
						break;

					case 3:
						
						eleccionValida = true;
						break;

					case 4:
						
						eleccionValida = true;
						break;

					default:
						eleccionValida = true;
						break;

					}

				} while (!eleccionValida);
			}
			if (eleccion == 2) {
					eleccion2();
					do {
						eleccionValida = false;
						eleccion = in.nextInt();
						eleccionValida = (eleccion < 1 || eleccion > 4 ? false : true);
					} while (!eleccionValida);
				
			switch (eleccion) {
			
			case 1:
				Empleado.nuevoEmpleado();
				eleccionValida= true;
				break;
			case 2:
				
				eleccionValida = true;
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				eleccionValida= true;
				break;
			}
			}
			if (eleccion == 3 ) {
				eleccion3();
				do {
					eleccionValida = false;
					eleccion = in.nextInt();
					eleccionValida = (eleccion < 1 || eleccion > 4 ? false : true);
				} while (!eleccionValida);
				
				switch (eleccion){
				
				case 1: 
					Cita.nuevaCita();
					break;
				}
				
				
			}
			
			
				if (eleccion == 4) {
					eleccion4();
					salir=true;
				}

			
		} while (!salir);
	}

	public static void mostrarMenuPrincipal() {
		System.out.println("Bienvenido/a al programa de gestion:");

		System.out.println("Pulse 1 para gestionar los pacientes. ");
		System.out.println("Pulse 2 para gestionar los empleados ");
		System.out.println("Pulse 3 para gestionar las citas ");
		System.out.println("Pulse 4 para salir.");

	}

	public static void eleccion1() {
		System.out.println("Bienvenido/a al programa de gestion de los pacientes. ");

		System.out.println("Pulse 1 para registrar un nuevo Paciente.");
		System.out.println("Pulse 2 para ver un  Paciente.");
		System.out.println("Pulse 3 para buscar un Paciente.");
		System.out.println("Pulse 4 para ver un historial de un paciente.");
		System.out.println("Pulse 5 para volver atras.");

	}

	public static void eleccion2() {
		System.out.println("Bienvenido/a al programa de gestion de empleados.");

		System.out.println("Pulse 1 para registrar un nuevo empleado.");
		System.out.println("Pulse 2 para ver los empleados.");
		System.out.println("Pulse 3 para buscar un empleado.");
		System.out.println("Pulse 5 para salir.");

	}

	
	public static void eleccion3() {
		
		System.out.println("Bienvenido/a al programa de gestion de citas.");

		System.out.println("Pulse 1 para registrar una nueva cita.");
		System.out.println("Pulse 2 para ver las citas.");
		System.out.println("Pulse 3 para buscar una cita.");
		System.out.println("Pulse 4 para salir.");
	}
	public static void eleccion4() {

		System.out.println("Hasta pronto!! <3");

	}

}
