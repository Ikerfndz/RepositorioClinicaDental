package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import entidades.Empleado;
import utils.ConexBD;

public class EmpleadoDAO implements OperacionesCRUD<Empleado> {
	
	Connection conex;
	
	public EmpleadoDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}
	
	@Override
	public boolean insertarConID(Empleado elemento) {
		boolean ret = false;
		
		String consultaInsertStr1 = "insert into empleados";
		
		try {
			if (this.conex == null || this.conex.isClosed()) 
				this.conex = ConexBD.establecerConexion();
			PreparedStatement psmt = conex.prepareStatement(consultaInsertStr1);
		
		catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			return false;
		}
		
		return ret;
			
	}

	@Override
	public boolean insertarSinID(Empleado elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean buscarPorID(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Empleado> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Empleado elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Empleado elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Empleado> eliminarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
