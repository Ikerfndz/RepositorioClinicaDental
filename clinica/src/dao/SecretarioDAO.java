package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entidades.Empleado;
import entidades.Secretariado;
import utils.ConexBD;

public class SecretarioDAO implements OperacionesCRUD<Secretariado> {
	Connection conex;

	public SecretarioDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean insertarConID(Secretariado s) {
		boolean ret = false;

		String consultaInsertStr1 = "insert into empleados(id_empleado, nombre, telefono, nif, direccion) values (?,?,?,?,?)";
		String consultaInsertStr2 = "insert into secretarios(num_años_exp) values (?)";

		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);

			pstmt.setLong(1, s.getIdEmpleado());
			pstmt.setString(2, s.getNombre());
			pstmt.setString(3, s.getTelefono());
			pstmt.setString(4, s.getNif());
			pstmt.setString(5, s.getDireccion());
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				PreparedStatement pstmt2 = conex.prepareStatement(consultaInsertStr2);
				pstmt2.setInt(1, resultadoInsercion);
				int resultadoInsercion2 = pstmt2.executeUpdate();
				if (resultadoInsercion2 == 1) {
					System.out.println("Se ha insertado correctamente el nuevo Secretario.");
					ret = true;
				}

				if (conex != null)
					conex.close();

			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public long insertarSinID(Secretariado s) {
		long ret = -1;

		String consultaInsertStr1 = "insert into empleados(id_empleado, nombre, telefono, nif, direccion) values (?,?,?,?,?)";
		String consultaInsertStr3 = "insert into secretarios(num_años_exp) values (?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);

			pstmt.setLong(1, s.getIdEmpleado());
			pstmt.setString(2, s.getNombre());
			pstmt.setString(3, s.getTelefono());
			pstmt.setString(4, s.getNif());
			pstmt.setString(5, s.getDireccion());
			int resultadoInsercion = pstmt.executeUpdate();

			if (resultadoInsercion == 1) {
				String consultaSelect = "SELECT id FROM empleados WHERE (nombre=? AND telefono=? AND nif=? AND direccion=?";
				PreparedStatement pstmt2 = conex.prepareStatement(consultaSelect);

				pstmt2.setString(1, s.getNombre());
				pstmt2.setString(2, s.getTelefono());
				pstmt2.setString(3, s.getNif());
				pstmt2.setString(4, s.getDireccion());
				ResultSet result = pstmt2.executeQuery();

				while (result.next()) {
					long idempleado = result.getLong("id_empleado");
					if (idempleado != -1) {
						PreparedStatement pstmt21 = conex.prepareStatement(consultaInsertStr3);
						pstmt21.setInt(1, s.getNumAniosExp());

						int resultadoInsercion2 = pstmt21.executeUpdate();
						if (resultadoInsercion2 == 1) {
							String consultaSelect2 = "SELECT id FROM secretarios WHERE (num_años_exp=?)";
							PreparedStatement pstmt3 = conex.prepareStatement(consultaSelect2);
							pstmt3.setInt(1, s.getNumAniosExp());

							ResultSet result3 = pstmt3.executeQuery();
							while (result3.next()) {
								long idsecretario = result3.getLong("id_secretario");
								if (idsecretario != -1) {
									System.out.println(
											"Se ha insertado correctamente el nuevo Atleta de id: " + idsecretario);
									if (conex != null)
										conex.close();
									return idsecretario;
								}
							}

						}
					}

				}
				result.close();
				pstmt2.close();
				if (conex != null)
					conex.close();
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			return -1;
		}

		return ret;
	}

	@Override
	public Secretariado buscarPorID(long id) {
		Secretariado ret = null;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "select * FROM secretarios WHERE id=?";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, id);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				long idSec = result.getLong("id_secretario");
				int anios = result.getInt("num_años_exp");

				ret = new Secretariado();
				ret.setIdEmpleado(idSec);
				ret.setNumAniosExp(anios);

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
	public Collection<Secretariado> buscarTodos() {
		List<Secretariado> todos = new ArrayList<>();
		String consultaInsertStr = "select * from secretarios";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Secretariado secretario;
				long idsec = result.getLong("id_secretario");
				int anios = result.getInt("num_años_exp");

				secretario = new Secretariado();
				secretario.setIdEmpleado(idsec);
				secretario.setNumAniosExp(anios);

				todos.add(secretario);
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
	public boolean modificar(Secretariado elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Secretariado elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Secretariado> eliminarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
