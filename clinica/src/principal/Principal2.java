package principal;

import java.util.Scanner;

public class Principal2 {
	public static void main(String[] args) {
		int eleccion;
		Informe.nuevoInforme();
//		Scanner in = new Scanner(System.in);
//		boolean eleccionValida = false;
//		boolean salir = false;
//	do {
//		do {
//			mostrarMenuPrincipal();
//			eleccion = in.nextInt();
//			eleccionValida = eleccion>=1 && eleccion<=4;
//			if (!eleccionValida)
//				System.out.println("Opcion invalida! Vuelva a introducir su eleccion.");
//
//		} while (!eleccionValida);
//		System.out.println("Usted ha elegido la opcion:" + eleccion);
//			switch (eleccion) {
//			case 1:
//				caso1();
//				break;
//			case 2:
//				System.out.println("Ver personas");
//				caso2();
//				break;
//			case 3:
//				caso3();
//				break;
//			case 4:
//				salir=true;
//				break;
//			default:
//				System.out.println("Otro valor!");
//				break;
//			}
//	}while(!salir);
//}
//
//	public static void mostrarMenuPrincipal() {
//		System.out.println("Bienvenido/a al programa de gestion:");
//
//		System.out.println("Pulse 1 para gestionar los pacientes. ");
//		System.out.println("Pulse 2 para gestionar los empleados ");
//		System.out.println("Pulse 3 para gestionar las citas ");
//		System.out.println("Pulse 4 para salir.");
//
//	}
//
////	public static void eleccion1() {
////		System.out.println("Bienvenido/a al programa de registro de una nueva persona:");
////
////		System.out.println("Pulse 1 para registrar un nuevo Paciente:");
////		System.out.println("Pulse 2 para registrar un nuevo Cirujano/a:");
////		System.out.println("Pulse 3 para registrar un nuevo Enfermero/a:");
////		System.out.println("Pulse 4 para registrar un nuevo Secretario/a:");
////		System.out.println("Pulse 5 para volver al menu anterior.");
////
////	}
//	
//	public static void eleccion1() {
//		System.out.println("Bienvenido/a al programa de gestion de los pacientes: ");
//
//		System.out.println("Pulse 1 para ver un Paciente:");
//		System.out.println("Pulse 2 para registrar un nuevo Paciente");
//		System.out.println("Pulse 3 para buscar un Paciente");
//		System.out.println("Pulse 4 para ver un historial de un paciente");
//		System.out.println("Pulse 5 para volver atras.");
//
//	
//	}
//
//	public static void eleccion2() {
//		System.out.println("Bienvenido/a al programa de visualizacion de personas:");
//		
//		System.out.println("Pulse 1 para ver Empleado:");
//		System.out.println("Pulse 2 para nuevo empleado:");
//		System.out.println("Pulse 3 para buscar empleado:");
//		System.out.println("Pulse 4 para volver atrás");
//
//	}
//
//	
//	public static void eleccion3() {
//		System.out.println("Bienvenido/a al programa de visualizacion de citas:");
//		
//		System.out.println("Pulse 1 para ver cita/s:");
//		System.out.println("Pulse 2 para nueva cita:");
//		System.out.println("Pulse 3 para buscar cita/s:");
//		System.out.println("Pulse 4 para volver atrás");
//
//	}
//	
//	public static void eleccion22() {
//		System.out.println("Bienvenido/a al programa de registro de una nueva persona:");
//
//		System.out.println("Pulse 1 para registrar un nuevo Paciente:");
//		System.out.println("Pulse 2 para registrar un nuevo Cirujano/a:");
//		System.out.println("Pulse 3 para registrar un nuevo Enfermero/a:");
//		System.out.println("Pulse 4 para registrar un nuevo Secretario/a:");
//		System.out.println("Pulse 5 para volver al menu anterior.");
//
//	}
//	
//	public static void eleccion4() {
//
//		System.out.println("Hasta pronto!! <3");
//
//	}
//	
//	public static void caso1() {
//		Scanner in= new Scanner(System.in);
//		int eleccion;
//		boolean eleccionValida = false;
//		do {
//			eleccion1();
//			eleccion = 0;
//			eleccion = in.nextInt();
//			switch (eleccion) {
//			case 1:
//				System.out.println("Elegida la opcion 1");
//				System.out.println("-----------------");
//				
//				break;
//			case 2:
//				System.out.println("Elegida la opcion 2");
//				Paciente.nuevoPaciente();
//				System.out.println("-----------------");
//				
//				break;
//			case 3:
//				System.out.println("Elegida la opcion 3");
//				System.out.println("-----------------");
//				
//				break;
//			case 4:
//				System.out.println("Elegida la opcion 4");
//				System.out.println("-----------------");
//				break;
//			case 5:
//				eleccionValida=true;
//				break;					
//			default:
//				System.out.println("Opción incorrecta/n");
//				System.out.println("-------------------");
//				
//				break;
//			}
//		} while (!eleccionValida);
//		
//	}
//	public static void caso2() {
//		Scanner in= new Scanner(System.in);
//		int eleccion;
//		boolean eleccionValida = false;
//		do {
//			eleccion2();
//			eleccion = 0;
//			eleccion = in.nextInt();
//			switch (eleccion) {
//			case 1:
//				
//				System.out.println("Elegida la opcion 1");
//				Empleado.motrarEmpleado();
//				System.out.println("-----------------");
//				
//				break;
//			case 2:
//				System.out.println("Elegida la opcion 2");
//				caso22();
//				System.out.println("-----------------");
//				
//				break;
//			case 3:
//				System.out.println("Elegida la opcion 3");
//				System.out.println("-----------------");
//				
//				break;
//			case 4:
//				eleccionValida=true;
//				break;				
//			default:
//				System.out.println("Opción incorrecta/n");
//				System.out.println("-------------------");
//				
//				break;
//			}
//		} while (!eleccionValida);
//
//	}
//	
//	public static void caso3() {
//		Scanner in= new Scanner(System.in);
//		int eleccion;
//		boolean eleccionValida = false;
//		do {
//			eleccion3();
//			eleccion = 0;
//			eleccion = in.nextInt();
//			switch (eleccion) {
//			case 1:
//				System.out.println("Elegida la opcion 1");
//				System.out.println("-----------------");
//				
//				break;
//			case 2:
//				System.out.println("Elegida la opcion 2");
//				Cita.nuevaFecha();
//				System.out.println("-----------------");
//				
//				break;
//			case 3:
//				System.out.println("Elegida la opcion 3");
//				System.out.println("-----------------");
//				
//				break;
//			case 4:
//				eleccionValida=true;
//				break;				
//			default:
//				System.out.println("Opción incorrecta/n");
//				System.out.println("-------------------");
//				
//				break;
//			}
//		} while (!eleccionValida);
//
//	}
//	public static void caso22(){
//		Scanner in= new Scanner(System.in);
//		int eleccion;
//		boolean eleccionValida = false;
//		do {
//			eleccion22();
//			eleccion = 0;
//			eleccion = in.nextInt();
//			switch (eleccion) {
//			case 1:
//				System.out.println("Elegida la opcion 1");
//				Paciente.nuevoPaciente();
//				System.out.println("-----------------");
//				
//				break;
//			case 2:
//				System.out.println("Elegida la opcion 2");
//				Cirujano.nuevoCirujano();
//				System.out.println("-----------------");
//				
//				break;
//			case 3:
//				System.out.println("Elegida la opcion 3");
//				Enfermeria.nuevoEnfermero();
//				System.out.println("-----------------");
//				
//				break;
//			case 4:
//				System.out.println("Elegida la opcion 4");
//				
//				System.out.println("-----------------");
//				break;
//			case 5:
//				eleccionValida=true;
//				break;					
//			default:
//				System.out.println("Opción incorrecta/n");
//				System.out.println("-------------------");
//				
//				break;
//			}
//		} while (!eleccionValida);
//	
//	}
//	
	}
}
