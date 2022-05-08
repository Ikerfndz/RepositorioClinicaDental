package dao;

import java.util.Collection;

import entidades.Alergia;

public class AlergiaDAO implements OperacionesCRUD<Alergia> {

	@Override
	public boolean insertarConID(Alergia elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insertarSinID(Alergia elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Alergia buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Alergia> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Alergia elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Alergia elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Alergia> eliminarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
