package entidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Comparator;

public class comparadorTiempos implements Comparator<Tiempo>{

	public int compare(Tiempo t1, Tiempo t2) {
		int ret = Integer.compare(t1.getHora(),t2.getHora());
		if(ret!=0)
			return ret;
		else {
			ret = Integer.compare(t1.getMinutos(),t2.getMinutos());
			if(ret!=0)
				return ret;
			else {
				ret = Integer.compare(t1.getSegundos(),t2.getSegundos());
				if(ret!=0)
					return ret;
					else {
						ret = Integer.compare(t1.getCentesimas(),t2.getCentesimas());
						}
				}

			}

	return ret;
	}
	
	public static void recorrerTiempos() {
		File f;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			f = new File("Tiempos.dat");
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			
			
			
		
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
