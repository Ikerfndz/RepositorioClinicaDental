package utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import principal.*;


public class Datos {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    
  
    public static final Paciente PACIENTES[] = {
        new Paciente("Luis", 1, "652146985","luis@educantabria.es", 33, "5675543h"),
        new Paciente("Maria", 2, "632554239","marta11@educastur.es", 20,"3875643h"),
        new Paciente("Juan", 3, "684512589","illojuan1@educastur.es", 25,"5345643d"),
        new Paciente("Fermin", 4, "632145789","fermin22@educastur.es", 19,"6375643n"),
        new Paciente("Catalina", 5, "698745123","catali@educastur.es", 22,"7875643n"),

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
     public static final  Historial HISTORIALES[] = {
    		 new Historial("Tiene dos operaciones en la encia superior, la retirada de las muelas del juicio y tiene medicacion hasta el 2023", 1),
    		 new Historial (),
    		 new Historial (),
    		 new Historial (),
    		 new Historial (),
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

    public static final Cita CITAS[] = {
    		new Cita (123550, LocalDateTime.parse("12/04/2022 10:30:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), 'M'),
    		new Cita (123551, LocalDateTime.parse("12/04/2022 11:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), 'M'),
    		new Cita (123552, LocalDateTime.parse("14/04/2022 10:30:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), 'M'),
    		new Cita (123553, LocalDateTime.parse("15/07/2022 11:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), 'M'),
    		new Cita (123554, LocalDateTime.parse("06/07/2022 10:30:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), 'M'),
    		new Cita (123555, LocalDateTime.parse("09/07/2022 12:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), 'M'),
    		new Cita (123556, LocalDateTime.parse("22/10/2022 12:30:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), 'M'),
    		new Cita (123557, LocalDateTime.parse("12/06/2022 16:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), 'T'),
    		new Cita (123558, LocalDateTime.parse("12/06/2022 16:30:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), 'T'),
    		new Cita (123510, LocalDateTime.parse("20/06/2022 16:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), 'T'),
    		new Cita (123511, LocalDateTime.parse("20/06/2022 17:30:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), 'T'),
    		new Cita (123512, LocalDateTime.parse("29/06/2022 17:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), 'T'),
    		new Cita (123513, LocalDateTime.parse("11/10/2022 18:30:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), 'T'),
    		new Cita (123514, LocalDateTime.parse("02/12/2022 18:00:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), 'T'),
	    };
    
    
 public static final int numeroCitas = CITAS.length;
 
    public static final Alergia ALERGIAS[] = {
  
    };
    public static final int numAlergias = ALERGIAS.length;



}
