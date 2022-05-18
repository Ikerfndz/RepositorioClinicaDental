package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



import entidades.Cita;

import utils.ConexBD;


public class CitaDAO implements OperacionesCRUD<Cita> {
	Connection conex;

	public CitaDAO(Connection c) {
		if (this.conex == null)
			conex = c;
	}

	@Override
	public boolean insertarConID(Cita c) {

		boolean ret = false;

		String consultaInsertStr = "insert into citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);

			pstmt.setLong(1, c.getIdCita());
			// pstmt.setLong(2, c.getTratamiento().getIdTratamiento());
			// pstmt.setLong(3, c.getEmpleado().getIdEmpleado());
			// pstmt.setLong(4, c.getEmpleado().getIdEmpleado());
			// pstmt.setLong(5, c.getEmpleado().getIdEmpleado());
			// pstmt.setLong(6, c.getEmpleado().getIdEmpleado());
			// pstmt.setLong(7, c.getEmpleado().getIdEmpleado());
			// pstmt.setLong(8, c.getMedicamento().getIdMedicamento());
			// pstmt.setChar(9, c.getRango());
			java.sql.Date fechaSQL = java.sql.Date.valueOf(c.getFechahora().format(null));
			pstmt.setDate(10, fechaSQL);
			pstmt.setInt(11, c.getTipo());
			// pstmt.setString(12, c.getRevision().getAnotacion());
			// pstmt.setInt(13, c.getIntervencion().getDuracion());
			int resultadoInsercion = pstmt.executeUpdate();
			ret = (resultadoInsercion == 1);

		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public long insertarSinID(Cita c) {
		long ret = -1;

		String consultaInsertStr = "insert into citas (idcita, tratamiento, secretariado, cirujano1, cirujano2, enfermeria1, enfermeria2, medicamento, rango, fechahora, tipo, anotacion, duracion) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			// pstmt.setLong(2, c.getTratamiento().getIdTratamiento());
			// pstmt.setLong(3, c.getEmpleado().getIdEmpleado());
			// pstmt.setLong(4, c.getEmpleado().getIdEmpleado());
			// pstmt.setLong(5, c.getEmpleado().getIdEmpleado());
			// pstmt.setLong(6, c.getEmpleado().getIdEmpleado());
			// pstmt.setLong(7, c.getEmpleado().getIdEmpleado());
			// pstmt.setLong(8, c.getMedicamento().getIdMedicamento());
			// pstmt.setChar(9, c.getRango());
			java.sql.Date fechaSQL = java.sql.Date.valueOf(c.getFechahora().format(null));
			pstmt.setDate(10, fechaSQL);
			pstmt.setInt(11, c.getTipo());
			// pstmt.setString(12, c.getRevision().getAnotacion());
			// pstmt.setInt(13, c.getIntervencion().getDuracion());
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				String consultaSelect = "SELECT idcita FROM citas WHERE (tratamiento=? AND secretariado=? "
						+ "AND cirujano1=?)" + "AND cirujano2=?)" + "AND enfermeria1=?)" + "AND enfermeria2=?)"
						+ "AND medicamento=?)" + "AND rango=?)" + "AND fechahora=?)" + "AND tipo=?)"
						+ "AND anotacion=?)" + "AND duracion=?)";
				PreparedStatement pstmt2 = conex.prepareStatement(consultaSelect);
				// pstmt2.setLong(2, c.getTratamiento().getIdTratamiento());
				// pstmt2.setLong(3, c.getEmpleado().getIdEmpleado());
				// pstmt2.setLong(4, c.getEmpleado().getIdEmpleado());
				// pstmt2.setLong(5, c.getEmpleado().getIdEmpleado());
				// pstmt2.setLong(6, c.getEmpleado().getIdEmpleado());
				// pstmt2.setLong(7, c.getEmpleado().getIdEmpleado());
				// pstmt2.setLong(8, c.getMedicamento().getIdMedicamento());
				// pstmt2.setChar(9, c.getRango());
				java.sql.Date fechaSQL2 = java.sql.Date.valueOf(c.getFechahora().format(null));
				pstmt.setDate(10, fechaSQL2);
				pstmt2.setInt(11, c.getTipo());
				// pstmt2.setString(12, c.getRevision().getAnotacion());
				// pstmt2.setInt(13, c.getIntervencion().getDuracion());

				ResultSet result = pstmt2.executeQuery();
				while (result.next()) {
					long idCita = result.getLong("idcita");
					if (idCita != -1)
						ret = idCita;
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
	public Cita buscarPorID(long idCita) {
		Cita ret = null;

		String consultaInsertStr = "select * FROM citas WHERE idcita=?";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, idCita);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				long idBD = result.getLong("id");
				long idcita = result.getLong("idcita");
				// char rango = result.getCharAt("rango");
				// LocalDateTime fechahora = result.getTime(fechahora);
				ret = new Cita();
				ret.setIdCita(idBD);
				// ret.setRango(rango);
				// ret.setLocalDateTime(fechahora);
				// ret.setCita(Datos.CITAS);
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
	public Collection<Cita> buscarTodos() {
		List<Cita> todos = new ArrayList<>();
		String consultaInsertStr = "select * FROM citas";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Cita cita;
				long idBD = result.getLong("id");
				long idCita = result.getLong("idcita");
				// char rango = result.getAtChar("rango");
				// LocalDateTime fechahora = result.getTime("fechahora");
				int tipo = result.getInt("tipo");

				cita = new Cita();
				cita.setIdCita(idBD);
				// cita.setRango(rango);
				// cita.setFechahora(fechahora);
				cita.setTipo(tipo);
				todos.add(cita);
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
	public boolean modificar(Cita elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Cita elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Cita> eliminarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
