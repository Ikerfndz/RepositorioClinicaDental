package principal_iker;

import entidades.Tiempo;

public class PrincipalExamen11 {

	

	public static void main(String[] args) {
		
		
		Tiempo arrayObjetos[]=new Tiempo[9];
		
		for (int i=0;i<9;i++){
		
			Tiempo.nuevoTiempo();
		}
		
		 
		 
		
		 	int tiempo = Tiempo.getHora();
	        for (int i=0;i<arrayObjetos.length;i++){
	            if(tiempo<1) {
	            	System.out.println(tiempo);
	            }
	        }
	        
	        
		 
	}

}
