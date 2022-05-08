package dao;

import java.util.Collection;

import entidades.Especialidad;

public class EspecialidadDAO implements OperacionesCRUD<Especialidad> {

	@Override
	public boolean insertarConID(Especialidad elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insertarSinID(Especialidad elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Especialidad buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Especialidad> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Especialidad elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Especialidad elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Especialidad> eliminarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
