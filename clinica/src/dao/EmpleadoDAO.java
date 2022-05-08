package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entidades.Empleado;
import utils.ConexBD;

public class EmpleadoDAO implements OperacionesCRUD<Empleado> {

	Connection conex;

	public EmpleadoDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean insertarConID(Empleado emp) {
		boolean ret = false;
		String consultaInsertStr1 = "insert into empleados(id_empleado, nombre, telefono, nif, direccion) values (?,?,?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);
			pstmt.setLong(1, emp.getIdEmpleado());
			pstmt.setString(2, emp.getNombre());
			pstmt.setString(3, emp.getTelefono());
			pstmt.setString(4, emp.getNif());
			pstmt.setString(5, emp.getDireccion());
			int resultadoInsercion = pstmt.executeUpdate();
			ret = (resultadoInsercion == 1);
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return ret;
	}

	@Override
	public long insertarSinID(Empleado emp) {
		long ret = -1;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "insert into empleados(nombre, telefono, nif, direccion) values (?,?,?,?)";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);

			pstmt.setString(1, emp.getNombre());
			pstmt.setString(2, emp.getTelefono());
			pstmt.setString(3, emp.getNif());
			pstmt.setString(4, emp.getDireccion());
			int resultadoInsercion = pstmt.executeUpdate();

			if (resultadoInsercion == 1) {
				String consultaSelect = "SELECT id FROM empleados WHERE (nombre=? AND telefono=? AND nif=? AND direccion=?";
				PreparedStatement pstmt2 = conex.prepareStatement(consultaSelect);
				pstmt2.setString(1, emp.getNombre());
				pstmt2.setString(2, emp.getTelefono());
				pstmt2.setString(3, emp.getNif());
				pstmt2.setString(4, emp.getDireccion());
				ResultSet result = pstmt2.executeQuery();
				while (result.next()) {
					long id = result.getLong("id");
					if (id != -1)
						ret = id;
				}
				result.close();
				pstmt2.close();
			}
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			return -1;
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception:" + e.getMessage());
			e.printStackTrace();
			return -1;
		}

		return ret;
	}

	@Override
	public Empleado buscarPorID(long id) {
		Empleado ret = null;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "select * FROM empleados WHERE id=?";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, id);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				long idEmp = result.getLong("id_empleado");
				String nom = result.getString("nombre");
				String tel = result.getString("telefono");
				String nif = result.getString("nif");
				String dir = result.getString("direccion");
				
				ret = new Empleado();
				ret.setIdEmpleado(idEmp);
				ret.setNombre(nom);
				ret.setTelefono(tel);
				ret.setNif(nif);
				ret.setDireccion(dir);
				
			}
			} catch (SQLException e) {
				System.out.println("Se ha producido una SQLException:" + e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Se ha producido una Exception:" + e.getMessage());
				e.printStackTrace();
			}
			return ret;
		}

	@Override
	public Collection<Empleado> buscarTodos() {
		List<Empleado> todos = new ArrayList<>();
		String consultaInsertStr = "select * from empleados";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Empleado empleado;
				long idEmp = result.getLong("id_empleado");
				String nom = result.getString("nombre");
				String tel = result.getString("telefono");
				String nif = result.getString("nif");
				String dir = result.getString("direccion");
				
				empleado = new Empleado();
				empleado.setIdEmpleado(idEmp);
				empleado.setNombre(nom);
				empleado.setTelefono(tel);
				empleado.setNif(nif);
				empleado.setDireccion(dir);
				
				todos.add(empleado);	
			}
			if (conex != null)
				conex.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception:" + e.getMessage());
			e.printStackTrace();
		}
		return todos;
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