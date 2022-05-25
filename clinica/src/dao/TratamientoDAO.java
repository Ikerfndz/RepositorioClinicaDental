package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entidades.Alergia;
import entidades.Historial;
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
		String consultaInsertStr1 = "insert into tratamientos (id_tratamiento, nombre_descriptivo, consentimiento, id_cobro, id_informe) values (?,?,?,?,?)";
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
		String consultaInsertStr = "insert into tratamientos (nombre_descriptivo, consentimiento, id_cobro, id_informe) values (?,?,?,?)";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);

			pstmt.setString(1, t.getNombreDescriptivo());
			pstmt.setBoolean(2, t.isConsentimiento());
			pstmt.setLong(3, t.getCobro().getIdCobro());
			pstmt.setLong(4, t.getInforme().getIdInforme());
			int resultadoInsercion = pstmt.executeUpdate();

			if (resultadoInsercion == 1) {
				String consultaSelect = "SELECT id_tratamiento FROM tratamientos WHERE (nombre_descriptivo=? AND consentimiento=? AND id_cobro=? AND id_informe=?";
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
		Tratamiento ret = null;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "select * FROM tratamientos WHERE id_tratamiento=?";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, id);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				long idTra = result.getLong("id_tratamiento");
				String nom = result.getString("nombre");
				boolean con = result.getBoolean("consentimiento");
				long idCob = result.getLong("id_cobro");
				long idinf = result.getLong("id_informe");
				
				
				
				ret = new Tratamiento();
			ret.setIdTratamiento(idTra);
			ret.setNombreDescriptivo(nom);
			ret.setConsentimiento(con);
			ret.getCobro().setIdCobro(idCob);
			ret.getInforme().setIdInforme(idinf);
			
				
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
	public Collection<Tratamiento> buscarTodos() {
		List<Tratamiento> todos = new ArrayList<>();
		String consultaInsertStr = "select * from tratamientos";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Tratamiento t = new Tratamiento();
				long idTra = result.getLong("id_tratamiento");
				String nom = result.getString("nombre");
				boolean con = result.getBoolean("consentimiento");
				long idCob = result.getLong("id_cobro");
				long idinf = result.getLong("id_informe");
				
				t.setIdTratamiento(idTra);
				t.setNombreDescriptivo(nom);
				t.setConsentimiento(con);
				t.getCobro().setIdCobro(idCob);
				t.getInforme().setIdInforme(idinf);
				todos.add(t);	
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
	public boolean modificar(Tratamiento t) {
		String consultaInsertStr = "update tratamientos SET  nombre_descriptivo=?, consentimiento=?, id_cobro=?, id_informe=? WHERE idTratamiento=?";
		try {
			if (this.conex == null || this.conex.isClosed())
				conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setString(1, t.getNombreDescriptivo());
			pstmt.setBoolean(2, t.isConsentimiento());
			pstmt.setLong(3, t.getCobro().getIdCobro());
			pstmt.setLong(4, t.getInforme().getIdInforme());
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
