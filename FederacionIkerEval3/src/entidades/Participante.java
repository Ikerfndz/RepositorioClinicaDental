package entidades;

import java.util.Scanner;

import validaciones.Validaciones;

public class Participante {
	protected long id;
	protected int dorsal; // valor entre 001 y 150
	protected char calle;
	protected boolean penalizacion = false;
	protected String otros;
	private Tiempo tiempo;
	private Prueba prueba;
	
	public Participante(long id, int dorsal, char calle) {
		super();
		this.id = id;
		this.dorsal = dorsal;
		this.calle = calle;
	}

	// EJERCICIO 2  1EVAL
	
	public static Participante nuevoParticipante() {
		Participante participante = null;

		Scanner teclado;
		teclado = new Scanner(System.in);

		// id
		long id = 0;
		boolean valido = false;
		do {
			System.out.println("Introduzca el id del nuevo Participante: ");
			id = teclado.nextLong();
			if (id<0)
				System.out.println("ERROR: Valor incorrecto para el id");
		} while (!valido);
		valido = false;

		// dorsal
		int dorsal = 0;
		boolean dorsalValido = false;
		do {
			System.out.println("Introduzca el dorsal entre 0001 y 150: ");
			dorsal = teclado.nextInt();
			dorsalValido = Validaciones.validarDorsalParticipante(dorsal);
		} while (!dorsalValido);

		//calle
		char calle = 0;
		boolean calleValida = false;
		do {
			System.out.println("Introduzca la direcci�n: ");
			calle = teclado.next().charAt(calle);
			calleValida = Validaciones.validarCalleParticipante(calle);
		} while (!calleValida);
		
		//penalizacion
		boolean penalizacion = false;
		do {
			System.out.println("¿Esta penalizado?");
			penalizacion = teclado.nextBoolean();
		} while (!calleValida);
		
		//otros
		String otro = "";
		boolean otroValida = false;
		do {
			System.out.println("Introduzca lo demas (Max 500 carazteres): ");
			otro = teclado.nextLine();
			otroValida = Validaciones.validarotroParticipante(otro);
		} while (!otroValida);
		
		Tiempo tiempo = Tiempo.nuevoTiempo();
		Prueba prueba = Prueba.nuevaPrueba();
		
		participante = new Participante (id, dorsal, calle, penalizacion, otro, tiempo, prueba);
		return participante;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public Tiempo getTiempo() {
		return tiempo;
	}

	public void setTiempo(Tiempo tiempo) {
		this.tiempo = tiempo;
	}

	public Prueba getPrueba() {
		return prueba;
	}

	public void setPrueba(Prueba prueba) {
		this.prueba = prueba;
	}
	public Participante() {
	}

	public Participante(long id2, int dorsal2, char calle2, boolean penalizacion2, String otro, Tiempo tiempo2,
			Prueba prueba2) {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public char getCalle() {
		return calle;
	}

	public void setCalle(char calle) {
		this.calle = calle;
	}

	public boolean isPenalizacion() {
		return penalizacion;
	}

	public void setPenalizacion(boolean penalizacion) {
		this.penalizacion = penalizacion;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	@Override
	public String toString() {
		return "Participante [id=" + id + ", dorsal=" + dorsal + ", calle=" + calle + ", penalizacion=" + penalizacion
				+ ", otros=" + otros + ", tiempo=" + tiempo + ", prueba=" + prueba + "]";
	}
	
	

}
