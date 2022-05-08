package dao;

import java.util.Collection;

import entidades.Alergia;
import entidades.Cita;

public class CitaDAO implements OperacionesCRUD<Cita> {

	@Override
	public boolean insertarConID(Cita elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertarSinID(Cita elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean buscarPorID(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Cita> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
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
