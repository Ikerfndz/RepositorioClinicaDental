package entidades;


import java.util.Scanner;


import validaciones.Validaciones;

public class Patrocinador  implements Comparable <Patrocinador>{

	private long id;
	private String nombre;
	private String web;
	private double dotacion;

	private Responsable responsable;

	public Patrocinador(long id, String nombre, String web, double dotacion, Responsable responsable) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.web = web;
		this.dotacion = dotacion;
		this.responsable = responsable;
	}

	public Patrocinador() {
		super();
	}

	public Patrocinador(long id, String nombre, String web, double dotacion) {
		this.id = id;
		this.nombre = nombre;
		this.web = web;
		this.dotacion = dotacion;
		
	}
	public Patrocinador(long id, String nombre, String web) {
		this.id = id;
		this.nombre = nombre;
		this.web = web;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public double getDotacion() {
		return dotacion;
	}

	public void setDotacion(double dotacion) {
		this.dotacion = dotacion;
	}

	public Responsable getResposable() {
		return responsable;
	}

	public void setResposable(Responsable resposable) {
		this.responsable = resposable;
	}
	
	// EJERCICIO 3A-EX10
	public static Patrocinador nuevoPatrocinador() {
		Patrocinador patrocinador = null;
		Scanner teclado = new Scanner(System.in);
		long id = 0;
		boolean idValido = false;
		do {
			System.out.println("Introduce el id del patrocinador: ");
			id = teclado.nextLong();
			idValido = Validaciones.validarIdResponsable(id);
			
		}while(!idValido);
		
		String nombre = "";
		boolean nombreValido = false;
		do {
			System.out.println("Introduzca el nombre del nuevo patrocinador: ");
			nombre = teclado.nextLine();
			nombreValido = Validaciones.validarNombrePatrocinador(nombre);
		} while (!nombreValido);
		
		String web="";
		boolean webValida = false;
		do {
			System.out.println("Introduce la web del patrocinador: ");
			web = teclado.nextLine();
			webValida = Validaciones.validarwebPatrocinador(web);
			
		}while(!webValida);
		
		double dotacion = 0;
		boolean dotacionValida = false;
		do {
			System.out.println("Introduce la web del patrocinador: ");
			dotacion = teclado.nextDouble();
			
			
		}while(!dotacionValida);
	
		
		patrocinador = new Patrocinador( id, nombre, web, dotacion);
		return patrocinador;
		
	}
	
	//EJERCICIO 3C -EX10
	
	public String mostarPatrocinadorBasico() {
		String ret = id + ", " + nombre + ", " + web;
		return ret;
	}
	public String mostrarPatrocinadorCompleto() {
		String ret = id + ", " + nombre + ", " + web + ", " + dotacion + "euros, " + responsable;
		return ret;
	}
 //EJERCICIO 5 - EX 10
	@Override
	public int compareTo(Patrocinador o) {
		int compararDotacion = (int) (this.getDotacion() - (o.getDotacion()));
		if(compararDotacion == 0) {
			int horario1 = this.getResposable().getHorarioIni().compareTo(this.getResposable().getHorarioFin());
			int horario2 = o.getResposable().getHorarioIni().compareTo(o.getResposable().getHorarioFin());
			int compararHorarios = horario1 - horario2;
			if(compararHorarios == 0) {
				int compararId = (int) (this.getId() - o.getId());
				return compararId;
			}else
				return compararHorarios;
		}else
		return compararDotacion;
		
		
	}
	
	// EJERCICIO 8a-EX10
		@Override
		public String toString() {
			return  this.id + ", " + responsable.data() +", " + this.nombre + ", "
					+  ", " + this.web +  ", " + this.dotacion;
		}

		public String mostrarBasico() {
			String ret = "";
			ret += this.id + ". " + this.nombre + (!this.web.equals("") ? " " + web : " ");
			return ret;
		}
		
}
