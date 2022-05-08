package dao;

import java.util.Collection;

import entidades.Historial;

public class HistorialDAO implements OperacionesCRUD<Historial> {

	@Override
	public boolean insertarConID(Historial elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insertarSinID(Historial elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Historial buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Historial> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Historial elemento) {
		// TODO Auto-generated method stub
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
