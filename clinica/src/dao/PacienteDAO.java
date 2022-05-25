package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import entidades.Paciente;
import utils.ConexBD;

public class PacienteDAO implements OperacionesCRUD<Paciente> {

	Connection conex;
	
	
	public PacienteDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}
	
	@Override
	public boolean insertarConID(Paciente paciente) {
		boolean ret = false;
		String consultaInsertStr1 = "insert into pacientes(id_paciente, nombre, telefono, direccion, nif) values (?,?,?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);
			pstmt.setLong(1, paciente.getIdPaciente());
			pstmt.setString(2, paciente.getNombre());
			pstmt.setString(3, paciente.getTelefono());
			pstmt.setString(4, paciente.getDireccion());
			pstmt.setString(5, paciente.getNif());
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
	public long insertarSinID(Paciente p) {
		long ret = -1;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "insert into pacientes(nombre, telefono, direccion, nif) values (?,?,?,?)";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);

			pstmt.setString(1, p.getNombre());
			pstmt.setString(2, p.getTelefono());
			pstmt.setString(3, p.getNif());
			pstmt.setString(4, p.getDireccion());
			int resultadoInsercion = pstmt.executeUpdate();

			if (resultadoInsercion == 1) {
				String consultaSelect = "SELECT id FROM pacientes WHERE (nombre=? AND telefono=? AND nif=? AND direccion=?";
				PreparedStatement pstmt2 = conex.prepareStatement(consultaSelect);
				pstmt2.setString(1, p.getNombre());
				pstmt2.setString(2, p.getTelefono());
				pstmt2.setString(3, p.getNif());
				pstmt2.setString(4, p.getDireccion());
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
	public Paciente buscarPorID(long id) {
		Paciente ret = null;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "select * FROM pacientes WHERE id_paciente=?";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, id);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				long idPac = result.getLong("id_paciente");
				String nom = result.getString("nombre");
				String tel = result.getString("telefono");
				String nif = result.getString("nif");
				String dir = result.getString("direccion");
				
				ret = new Paciente();
				ret.setIdPaciente(idPac);
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
	public Collection<Paciente> buscarTodos() {
		List<Paciente> todos = new ArrayList<>();
		String consultaInsertStr = "select * from pacientes";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Paciente p;
				long idPac = result.getLong("id_paciente");
				String nom = result.getString("nombre");
				String tel = result.getString("telefono");
				String nif = result.getString("nif");
				String dir = result.getString("direccion");
				
				p = new Paciente();
				p.setIdPaciente(idPac);
				p.setNombre(nom);
				p.setTelefono(tel);
				p.setNif(nif);
				p.setDireccion(dir);
				
				todos.add(p);	
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
	public boolean modificar(Paciente p) {
		String consultaInsertStr = "update pacientes SET nombre=?, telefono=?, direccion=?, nif=? WHERE idPaciente=?";
		try {
			if (this.conex == null || this.conex.isClosed())
				conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setString(1, p.getNombre());
			pstmt.setString(2, p.getTelefono());
			pstmt.setString(3, p.getDireccion());
			pstmt.setString(4, p.getNif());
			int resultado = pstmt.executeUpdate();
			if (resultado == 1)
				return true;
			else
				return false;
		} catch (Exception exc) {
			System.out.println("Se ha producido una SQLException:" + exc.getMessage());
			exc.printStackTrace();
		}
		return false;
	}
	

	@Override
	public boolean eliminar(Paciente p) {
		
		return false;
	}

	@Override
	public Collection<Paciente> eliminarTodos() {

		return null;
	}

}
