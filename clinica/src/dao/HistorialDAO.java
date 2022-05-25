package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entidades.Historial;
import entidades.Paciente;
import utils.ConexBD;

public class HistorialDAO implements OperacionesCRUD<Historial> {

	Connection conex;
	
	
	public HistorialDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}
	
	@Override
	public boolean insertarConID(Historial h) {
		boolean ret = false;
		String consultaInsertStr1 = "insert into historiales(id_historial, descripcion, id_paciente) values (?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);
			pstmt.setLong(1, h.getIdHistorial());
			pstmt.setString(2, h.getDescripcion());
			pstmt.setLong(3, h.getPaciente().getIdPaciente());
			
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
	public long insertarSinID(Historial h) {
		long ret = -1;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "insert into historiales(descripcion, id_paciente) values (?,?)";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);

			pstmt.setString(1, h.getDescripcion());
			pstmt.setLong(2, h.getPaciente().getIdPaciente());
			int resultadoInsercion = pstmt.executeUpdate();

			if (resultadoInsercion == 1) {
				String consultaSelect = "SELECT id_historial FROM Historiales WHERE (descripcion=? AND id_paciente=?";
				PreparedStatement pstmt2 = conex.prepareStatement(consultaSelect);
				pstmt.setString(1, h.getDescripcion());
				pstmt.setLong(2, h.getPaciente().getIdPaciente());
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
	public Historial buscarPorID(long id) {
		Historial ret = null;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "select * FROM historiales WHERE id_historial=?";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, id);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				long idHis = result.getLong("id_historial");
				String desc = result.getString("descripcion");
				long idPac = result.getLong("id_paciente");
				
				
				ret = new Historial();
				ret.setIdHistorial(idHis);
				ret.setDescripcion(desc);
				ret.getPaciente().setIdPaciente(idPac);
			
				
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
	public Collection<Historial> buscarTodos() {
		List<Historial> todos = new ArrayList<>();
		String consultaInsertStr = "select * from historiales";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Historial h = new Historial();
				long idHis = result.getLong("id_historial");
				String nom = result.getString("descripcion");
				long idPac= result.getLong("id_paciente");
				
				h.setIdHistorial(idHis);	
				h.setDescripcion(nom);
				h.getPaciente().setIdPaciente(idPac);
				todos.add(h);	
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
	public boolean modificar(Historial h) {
		String consultaInsertStr = "update historiales SET  descripcion=?, id_paciente=? WHERE idHistorial=?";
		try {
			if (this.conex == null || this.conex.isClosed())
				conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setString(1, h.getDescripcion());
			pstmt.setLong(2, h.getPaciente().getIdPaciente());
			
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
	public boolean eliminar(Historial elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Historial> eliminarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
