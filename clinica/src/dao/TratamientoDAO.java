package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import entidades.Alergia;
import entidades.Tratamiento;
import utils.ConexBD;

public class TratamientoDAO implements OperacionesCRUD<Tratamiento> {

	Connection conex;
	
	
	public TratamientoDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}
	
	
	@Override
	public boolean insertarConID(Tratamiento t) {
		boolean ret = false;
		String consultaInsertStr1 = "insert into tratamientos(id_tratamiento, nombre_descriptivo, consentimiento, id_cobro, id_informe) values (?,?,?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);
			pstmt.setLong(1, t.getIdTratamiento());
			pstmt.setString(2, t.getNombreDescriptivo());
			pstmt.setBoolean(3, t.isConsentimiento());
			pstmt.setLong(4, t.getCobro().getIdCobro());
			pstmt.setLong(5, t.getInforme().getIdInforme());
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
	public long insertarSinID(Tratamiento t) {
		long ret = -1;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "insert into tratamientos(nombre_descriptivo, consentimiento, id_cobro, id_informe) values (?,?,?,?)";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);

			pstmt.setString(1, t.getNombreDescriptivo());
			pstmt.setBoolean(2, t.isConsentimiento());
			pstmt.setLong(3, t.getCobro().getIdCobro());
			pstmt.setLong(4, t.getInforme().getIdInforme());
			int resultadoInsercion = pstmt.executeUpdate();

			if (resultadoInsercion == 1) {
				String consultaSelect = "SELECT id_tratamiento FROM tratamienos WHERE (nombre_descriptivo=? AND consentimiento=? AND id_cobro=? AND id_informe=?";
				PreparedStatement pstmt2 = conex.prepareStatement(consultaSelect);
				pstmt.setString(1, t.getNombreDescriptivo());
				pstmt.setBoolean(2, t.isConsentimiento());
				pstmt.setLong(3, t.getCobro().getIdCobro());
				pstmt.setLong(4, t.getInforme().getIdInforme());
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
	public Tratamiento buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Tratamiento> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Tratamiento elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Tratamiento elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Tratamiento> eliminarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
