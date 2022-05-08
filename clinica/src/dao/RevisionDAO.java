package dao;

import java.util.Collection;

import entidades.Revision;

public class RevisionDAO implements OperacionesCRUD<Revision> {

	@Override
	public boolean insertarConID(Revision elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insertarSinID(Revision elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Revision buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Revision> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Revision elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Revision elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Revision> eliminarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
