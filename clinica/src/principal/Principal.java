package principal;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entidades.Cita;
import entidades.Empleado;
import entidades.Paciente;

public class Principal {

	public static void main(String[] args) {
		// accesoPrograma();
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
				navegacionPaciente();
			}

			if (eleccion == 2) {
				navegacionEmpleados();
			}
			if (eleccion == 3) {
				navegacionCitas();
			}

			if (eleccion == 4) {
				salir = true;
				eleccionSalida();

			}

		} while (!salir);
	}

	public static void mostrarMenuPrincipal() {
		System.out.println("Bienvenido/a al programa de gestion:");
		System.out.println("  ");
		System.out.println("- Pulse 1 para gestionar los pacientes. ");
		System.out.println("- Pulse 2 para gestionar los empleados ");
		System.out.println("- Pulse 3 para gestionar las citas ");
		System.out.println("- Pulse 4 para salir.");

	}

	public static void menuPacientes() {
		System.out.println("Bienvenido/a al programa de gestion de los pacientes. ");
		System.out.println("  ");
		System.out.println("- Pulse 1 para registrar un nuevo Paciente.");
		System.out.println("- Pulse 2 para ver los  Pacientes.");
		System.out.println("- Pulse 3 para buscar un Paciente.");
		System.out.println("- Pulse 4 para ver un historial de un paciente.");
		System.out.println("- Pulse 5 para volver atras.");

	}

	public static void menuEmpleados() {
		System.out.println("Bienvenido/a al programa de gestion de empleados.");
		System.out.println("  ");
		System.out.println("- Pulse 1 para registrar un nuevo empleado.");
		System.out.println("- Pulse 2 para ver los empleados.");
		System.out.println("- Pulse 3 para buscar un empleado.");
		System.out.println("- Pulse 4 para volver atrás.");

	}

	public static void menuCitas() {

		System.out.println("Bienvenido/a al programa de gestion de citas.");
		System.out.println("  ");
		System.out.println("Pulse 1 para registrar una nueva cita.");
		System.out.println("Pulse 2 para ver las citas.");
		System.out.println("Pulse 3 para buscar una cita.");
		System.out.println("Pulse 4 para salir.");
	}

	public static void eleccionSalida() {

		System.out.println("Hasta pronto!! <3");

	}
	// CONTRASEÑA DE ACCESO AL PROGRAMA

	/*
	 * public static void accesoPrograma() { String claveacceso="1"; String
	 * claveintroducida="";
	 * 
	 * while (claveacceso.equals(claveintroducida)==false) {
	 * claveintroducida=JOptionPane.
	 * showInputDialog("Introduce la contrase�a para acceder al programa de gestion clinica dental: "
	 * ); if (claveacceso.equals(claveintroducida)==false) {
	 * System.out.println("Contrase�a incorrecta"); } }
	 * System.out.println("Contrase�a correcta. Pulse el 1 para continuar"); }
	 */
	public static void navegacionPaciente() {
		int eleccion;
		Scanner in = new Scanner(System.in);
		boolean eleccionValida = false;

		do {
			eleccionValida = false;
			menuPacientes();
			eleccion = in.nextInt();
			eleccionValida = (eleccion < 1 || eleccion > 5 ? false : true);
			if (!eleccionValida)
				System.out.println("Opcion invalida! Vuelva a introducir su eleccion.");

			switch (eleccion) {

			case 1:
				System.out.println("Usted ha elegido la opcion: " + eleccion);
				Paciente.nuevoPaciente();
				eleccionValida = false;
				break;

			case 2:
				System.out.println("Usted ha elegido la opcion: " + eleccion);
				System.out.println(" ");
				Paciente[] pacientes = utils.Datos.PACIENTES;

				System.out.println("Hay " + utils.Datos.numPacientesd + " pacientes en el sistema.");

				for (Paciente i : pacientes)
					System.out.println("Nombre: " + i.getNombre() + (" | Edad: ") + i.getEdad() + (" | Nif: ")
							+ i.getNif() + (" | Telefono: ") + i.getTelefono() + (" | Mail: ") + i.getDireccion()
							+ " |  Id: " + i.getIdPaciente());
				eleccionValida = false;
				break;

			case 3:
				System.out.println("Usted ha elegido la opcion: " + eleccion);
				System.out.println(" ");
				Paciente.buscarPaciente();
				eleccionValida = false;
				break;

			case 4:
				System.out.println("Usted ha elegido la opcion: " + eleccion);
				System.out.println(" ");

				eleccionValida = false;
				break;

			case 5:
				eleccionValida = true;
				break;
			}

		} while (!eleccionValida);
	}

	public static void navegacionEmpleados() {
		int eleccion;
		Scanner in = new Scanner(System.in);
		boolean eleccionValida = false;

		do {
			eleccionValida = false;
			menuEmpleados();
			eleccion = in.nextInt();
			eleccionValida = (eleccion < 1 || eleccion > 4 ? false : true);
			if (!eleccionValida)
				System.out.println("Opcion invalida! Vuelva a introducir su eleccion.");

			switch (eleccion) {

			case 1:
				System.out.println("Usted ha elegido la opcion: " + eleccion);

				Empleado.nuevoEmpleado();
				eleccionValida = false;
				break;
			case 2:
				System.out.println("Usted ha elegido la opcion: " + eleccion);
				System.out.println(" ");
				Empleado[] empleados = utils.Datos.EMPLEADOS;

				System.out.println("Hay " + utils.Datos.numEmpleadosd + " empleados en el sistema.");
				System.out.println(" ");

				for (Empleado i : empleados)
					System.out.println("Nombre: " + i.getNombre() + (" ") + i.getApellidos() + (" | Nif: ") + i.getNif()
							+ (" | Telefono: ") + i.getTelefono() + (" | Mail: ") + i.getDireccion() + " |  Id: "
							+ i.getIdEmpleado());
				System.out.println(" ");
				eleccionValida = false;
				break;
			case 3:
				Empleado.buscarEmpleado();
				eleccionValida = false;
				break;
			case 4:
				eleccionValida = true;
				break;
			}
		} while (!eleccionValida);
	}

	public static void navegacionCitas() {
		int eleccion;
		Scanner in = new Scanner(System.in);
		boolean eleccionValida = false;

		do {
			eleccionValida = false;
			menuCitas();
			eleccion = in.nextInt();
			eleccionValida = (eleccion < 1 || eleccion > 4 ? false : true);

			switch (eleccion) {

			case 1:
				Cita.nuevaCita();
				eleccionValida = false;
				break;
			case 2:
				System.out.println("Usted ha elegido la opcion: " + eleccion);
				System.out.println(" ");
				Cita[] citas = utils.Datos.CITAS;

				System.out.println("<< Hay " + utils.Datos.numeroCitas + " citas en el sistema. >>");
				System.out.println(" ");

				for (Cita c : citas)
					System.out.println(" ID de la cita: " + c.getIdCita() + ("  | Franja horaria: ") + c.getRango()
							+ (" | Fecha y hora: ")
							+ c.getFechahora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy 'a las' HH:mm:ss")));

				eleccionValida = false;
				break;
			case 3:
				System.out.println("Usted ha elegido la opcion: " + eleccion);
				Cita.buscarCita();
				eleccionValida = false;
				break;
			case 4:
				eleccionValida = true;
				break;

			}

		} while (!eleccionValida);
	}

}
