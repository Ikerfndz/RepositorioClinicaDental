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
					eleccionValida = (eleccion < 1 || eleccion > 4 ? false : true);
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
				
		
						
				do {
					
					eleccionValida = (eleccion < 1 || eleccion > 4 ? false : true);
					if (!eleccionValida)
						System.out.println("Opcion invalida! Vuelva a introducir su eleccion.");
					switch (eleccion) {
					
						case 1:
							Paciente.nuevoPaciente();
							eleccionValida=true;
							break;
						
						case 2:
							Cirujano.nuevoCirujano();
							eleccionValida=true;
							break;
							
						case 3:
							Enfermeria.nuevoEnfermero();
							eleccionValida=true;
							break;
							
						case 4 :
							Secretariado.nuevoSecretario();
							eleccionValida=true;
							break;
						
						default:
							eleccion=in.nextInt();
							break;
						
							}			
					
						} while(!eleccionValida);
					
			
			if (eleccion== 2) {
				eleccion2();
				
			}
			if (eleccion== 4) {
				eleccion4();
				
			}
			
		}		
			
	}

	public static void mostrarMenuPrincipal() {
		System.out.println("Bienvenido/a al programa de gestion:");

		System.out.println("Pulse 1 para gestionar los pacientes. ");
		System.out.println("Pulse 2 para gestionar los empleados ");
		System.out.println("Pulse 3 para gestionar las citas ");
		System.out.println("Pulse 4 para salir.");

	}
	
	public static void eleccion1() {
		System.out.println("Bienvenido/a al programa de gestion de los pacientes: ");

		System.out.println("Pulse 1 para ver un Paciente:");
		System.out.println("Pulse 2 para registrar un nuevo Paciente");
		System.out.println("Pulse 3 para buscar un Paciente");
		System.out.println("Pulse 4 para ver un historial de un paciente");
		System.out.println("Pulse 5 para volver atras.");

	
	}
	
	public static void eleccion2() {
		System.out.println("Bienvenido/a al programa de visualizacion de personas:");

		System.out.println("Pulse 1 para ver los Pacientes:");
		System.out.println("Pulse 2 para ver los Cirujanos/as:");
		System.out.println("Pulse 3 para ver los Enfermeros/as:");
		System.out.println("Pulse 4 para ver los Secretarios/as:");
		System.out.println("Pulse 5 para salir.");

	
	}
	
	public static void eleccion4() {
		
		System.out.println("Hasta pronto!! <3");
		
	}
	
	
	
}
