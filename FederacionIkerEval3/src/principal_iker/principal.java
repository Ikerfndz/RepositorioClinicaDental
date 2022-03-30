package principal_iker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import entidades.DatosPersona;
import utils.ConexBD;

public class principal {

	public static void main(String[] args) {
		System.out.println("INICIO");
		Connection conex = null;
		java.sql.Statement consulta = null;
		ResultSet resultado = null;
		try {

//			insertarLugares();

			conex = ConexBD.establecerConexion();
			String consultaStr = "SELECT * FROM personas order by nombre asc";
			if (conex == null)
				conex = ConexBD.getCon();
			consulta = conex.createStatement();
			resultado = ((java.sql.Statement) consulta).executeQuery(consultaStr);
			while (resultado.next()) {
				int id = resultado.getInt(1);
				String nombre = resultado.getString(2);
				String telefono = resultado.getString(3);
				String nifnie = resultado.getString(4);
				System.out.println(consultaStr);
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una Excepcion:" + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				System.out.println("Cerrando recursos...");
				if (resultado != null)
					resultado.close();
				if (consulta != null)
					consulta.close();
				if (conex != null)
					conex.close();
			} catch (SQLException e) {
				System.out.println("Se ha producido una Excepcion:" + e.getMessage());
				e.printStackTrace();
			}
		}
		System.out.println("FIN");
	}


	}


