package principal;

import java.util.Arrays;

public class Cirujano extends Empleado {
	
	private Especialidad especialidades[]=new Especialidad[10]; //Array donde se guarda el numero de especialidades que puede tener un cirujano.
	private Intervencion intervenciones[]=new Intervencion[10];	//Array donde se guarda el numero de intervenciones en las que interviene un cirujano.
	
	
	//Constructor por defecto
	public Cirujano() {
	}
	
	//Constructor que recibe por parametros la especialidad el empleado y la intervención.
	//Primero hace una llamada a super para sacar los datos del empleado.
	//Se guarda la especialidad en el array.
	//Se guarda la intervencion en el array.
	
	public Cirujano(Especialidad especialidad,Empleado empleado,Intervencion intervencion) {
		super(empleado);
		especialidades[0]=especialidad;
		intervenciones[0]=intervencion;
		
	}
	
	//Método encargado de crear un nuevo cirujano.
	//Se declara una variable de tipo Empleado donde se guardan los datos del empleado haciendo llamada al método nuevoEmpleado.
	//Se declara una variable de tipo Intervencion donde se guardan los datos de la intervención haciendo llamada al método nuevaIntervencion.
	//Se declara una variable de tipo Especialidad donde se guardan los datos de la especialidad haciendo llamada al método nuevaEspecialidad.
	//Se declara una variable de tipo Cirujano que se instancia haciendo llamada al constructor anterior y se le pasa por parametros las variables creadas en este metodo.
	//Se guarda el cirujano creado en la clase Especialidad porque cada Especialidad pertenece a un cirujano.
	public static Cirujano nuevoCirujano() {
		Empleado empleado=Empleado.nuevoEmpleado();
		Intervencion intervencion=Intervencion.nuevaIntervencion();
		Especialidad especialidad=Especialidad.nuevaEspecialidad();
		Cirujano ret=new Cirujano(especialidad,empleado,intervencion);
		especialidad.setCirujano(ret);
		return ret;
	}
	
	//Getters y setters
	public Especialidad[] getEspecialidades() {
		return especialidades;
	}


	public void setEspecialidades(Especialidad[] especialidades) {
		this.especialidades = especialidades;
	}

	public Intervencion[] getIntervenciones() {
		return intervenciones;
	}

	public void setIntervenciones(Intervencion[] intervenciones) {
		this.intervenciones = intervenciones;
	}

	//To string
	@Override
	public String toString() {
		return "Cirujano [especialidades=" + Arrays.toString(especialidades) + ", intervenciones="
				+ Arrays.toString(intervenciones) + "]";
	}
	

}
