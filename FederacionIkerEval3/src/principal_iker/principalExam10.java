package principal_iker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import entidades.Patrocinador;
import utils.Datos;

public class principalExam10 {

	
	// EJERCICIO 6 - EX 10
	public static void main(String[] args) {
		
	
		
			
		}
	
	public static void exportarPatrocinadoresFicherobinario() {
		
		System.out.println("Guardando en pacientes.dat");
			File f;
			FileOutputStream fos = null;
			ObjectOutputStream oos = null;

			try {

				f = new File("patrocinadores.dat");
				fos = new FileOutputStream(f);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(new Patrocinador(1, "Iker", "iker.fndz.m@gmail.com", 20.5));
				for (int i = 0; i < Datos.Patrocinadores; i++) {
					Patrocinador p = new Patrocinador();
					p = Datos.PATROCINADORES[i];
					oos.writeObject(p);
				}

				oos.writeObject(new Patrocinador (1, "Iker", "iker.fndz.m@gmail.com", 20.5));

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (oos != null)
						oos.close();
					if (fos != null)
						fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}

}
