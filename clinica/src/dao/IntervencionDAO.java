package dao;

import java.util.Collection;

import entidades.Intervencion;

public class IntervencionDAO implements OperacionesCRUD<Intervencion> {

	@Override
	public boolean insertarConID(Intervencion elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insertarSinID(Intervencion elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Intervencion buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Intervencion> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Intervencion elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Intervencion elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Intervencion> eliminarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
