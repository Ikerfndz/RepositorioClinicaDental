package utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import principal.*;


public class Datos {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    
  
    public static final Paciente PACIENTES[] = {
        new Paciente("Luis", 1, "Gijon","luis@educantabria.es", 33, "5675543h"),
        new Paciente("Maria", 2, "Gijon","marta11@educastur.es", 20,"3875643h"),
        new Paciente("Juan", 3, "Malaga","illojuan1@educastur.es", 25,"5345643d"),
        new Paciente("Fermin", 4, "Lugones","fermin22@educastur.es", 19,"6375643n"),
        new Paciente("Catalina", 5, "Palencia","catali@educastur.es", 22,"7875643n"),

    };
     public static final int numPacientesd = PACIENTES.length;
     

     
     public static final Empleado EMPLEADOS[] = {
    	        new Empleado("Luis", 1, "Fernandez", "684659819","luis@educantabria.es","5675543h"),
    	        new Empleado("Maria",2 , "Arias", "678234459","maria@educastur.es","36553543D"),
    	        new Empleado("Juan", 3, "Garcia", "624616819","juan@educastur.es","56523513N"),
    	        new Empleado("Alberto", 4, "Hummels", "666129812","alberto@educastur.es","12343543T"),
    	        new Empleado("Julia", 5, "Bermudez", "684659893","julia@educastur.es","54323543D"),
    	        new Empleado("Barbara", 6, "Leiva", "680250980","barbara@educastur.es","71783143B"),
    	        new Empleado("Barbara", 7, "Leiva", "680250980","barbara@educastur.es","71783143B"),
    	        new Empleado("Barbara", 8, "Leiva", "680250980","barbara@educastur.es","71783143B"),
    	        
    	    };
     public static final int numEmpleadosd = EMPLEADOS.length;
     
   
     public static final Especialidad ESPECIALIDADES[]  = {
     		new Especialidad("Cirugia facial", 1),
     		new Especialidad("Cirugia facial", 2),
     		new Especialidad("Cirugia facial", 1)     		
     };
     
     public static final int numEspecialidades = ESPECIALIDADES.length;
     
     public static final Intervencion INTERVENCIONES[] = {
    	new Intervencion(11),
    	new Intervencion(20),
    	new Intervencion(60)	
     };
     
    public static final Cirujano CIRUJANOS[] = {
            new Cirujano(EMPLEADOS[0], true, ESPECIALIDADES[0], INTERVENCIONES[0]),
            new Cirujano(EMPLEADOS[5], false, INTERVENCIONES[0]),
        };
    
    public static final Enfermeria ENFERMEROS[] = {
    		new Enfermeria(EMPLEADOS[1], 'a',INTERVENCIONES[0]),
    		new Enfermeria(EMPLEADOS[2], 'b',INTERVENCIONES[1]),
    		new Enfermeria(EMPLEADOS[3], 'c',INTERVENCIONES[2]),
    };
 
    public static final Secretariado SECRETARIOS[] = {
    		new Secretariado(EMPLEADOS[4], 4),
    		new Secretariado(EMPLEADOS[6], 10),
    		new Secretariado(EMPLEADOS[7], 1),
    };
    
    public static final int numSecretarios = ESPECIALIDADES.length;

 
    public static final Alergia ALERGIAS[] = {
  
    };
    public static final int numAlergias = ALERGIAS.length;



}
