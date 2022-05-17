package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	public long insertarSinID(Tratamiento elemento) {
		// TODO Auto-generated method stub
		return 0;
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
