package principal2;
import java.util.*;
import javax.swing.*;


public class Menu2Miguel {
	
		public static void main(String[] args) {
			accesoPrograma();
			Scanner in = new Scanner(System.in);
			String continuar="1";	
			String continuarintroducido="";
			while(continuar.equals(continuarintroducido)==false) {
				continuarintroducido=in.nextLine();
				if (continuar.equals(continuarintroducido)==false) {
					System.out.println("Pulse 1 para continuar");
				}
			}
			
			int eleccion;
			boolean eleccionValida = false;
			boolean salir = false;
			
			do {
				mostrarMenuPrincipal();
				eleccion = in.nextInt();
				eleccionValida = (eleccion < 1 || eleccion > 4 ? false : true);
				if (!eleccionValida)
					System.out.println("Opcion invalida. Vuelva a introducir su eleccion.");

			} while (!eleccionValida);
			System.out.println("Usted ha elegido la opcion: " + eleccion);
				

		}

		
		public static void accesoPrograma() {
			String claveacceso="1";
			String claveintroducida="";
			
			while (claveacceso.equals(claveintroducida)==false) {
				claveintroducida=JOptionPane.showInputDialog("Introduce la contraseña para acceder al programa de gestion clinica dental: ");
				if (claveacceso.equals(claveintroducida)==false) {
					System.out.println("Contraseña incorrecta");
				}
			}
			System.out.println("Contraseña correcta. Pulse el 1 para continuar");
		}
		
		
		public static void mostrarMenuPrincipal() {
			System.out.println("Bienvenido/a al programa de gestion CLINICA DENTAL: ");
			System.out.println("   ");
			System.out.println("OPCIONES: ");
			
			System.out.println("   1. Gestion de pacientes.");
			System.out.println("   2. Gestion de empleados.");
			System.out.println("   3. Gestion de citas.");
			System.out.println("   4. Salir del programa de gestion.");
			System.out.println("   ");
			System.out.println("Pulse una de las opciones: ");
		}
		
		public static void mostrarMenuOpcion1() {
			System.out.println("OPCION 1 -> Bienvenido/a al sistema gestor de pacientes");
			System.out.println("  ");
			System.out.println("OPCIONES: ");
			System.out.println("   1. Ver paciente/s");
			System.out.println("   2. Nuevo paciente");
			System.out.println("   3. Buscar paciente/s");
			System.out.println("   4. Historial del paciente");
			System.out.println("   5. Volver atrás");
			System.out.println("   ");
			System.out.println("Pulse una de las opciones: ");
		}
		
		public static void mostrarMenuOpcion2() {
			System.out.println("OPCION 2 -> Bienvenido/a al sistema gestor de empleados");
			System.out.println("  ");
			System.out.println("OPCIONES: ");
			System.out.println("   1. Ver empleado/s");
			System.out.println("   2. Nuevo empleado");
			System.out.println("   3. Buscar empleado/s");
			System.out.println("   4. Volver atrás");
			System.out.println("   ");
			System.out.println("Pulse una de las opciones: ");
		}
		
		public static void mostrarMenuOpcion3() {
			System.out.println("OPCION 3 -> Bienvenido/a al sistema gestor de citas");
			System.out.println("  ");
			System.out.println("OPCIONES: ");
			System.out.println("   1. Ver cita/s");
			System.out.println("   2. Nueva cita");
			System.out.println("   3. Buscar cita/s");
			System.out.println("   4. Volver atrás");
			System.out.println("   ");
			System.out.println("Pulse una de las opciones: ");
		}
		
		
	}

