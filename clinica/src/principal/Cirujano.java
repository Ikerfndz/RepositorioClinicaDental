package principal;


public class Cirujano extends Empleado {
	private Especialidad especialidades[]=new Especialidad[10];
	private Intervencion intervenciones[]=new Intervencion[10];
	


	public Cirujano() {
	}
	
	public Cirujano(Especialidad especialidad,Empleado empleado,Intervencion intervencion) {
		super(empleado);
		especialidades[0]=especialidad;
		intervenciones[0]=intervencion;
				
	}
	
	public static Cirujano nuevoCirujano() {
		Empleado empleado=Empleado.nuevoEmpleado();
		Intervencion intervencion=Intervencion.nuevaIntervencion();
		Especialidad especialidad=Especialidad.nuevaEspecialidad();
		Intervencion intervenciones=Intervencion.nuevaIntervencion();
		Cirujano aux=new Cirujano(especialidad,empleado,intervencion);
		especialidad.setCirujano(aux);
		return aux;
	}

	public Especialidad[] getEspecialidades() {
		return especialidades;
	}


	public void setEspecialidades(Especialidad[] especialidades) {
		this.especialidades = especialidades;
	}
	

}
