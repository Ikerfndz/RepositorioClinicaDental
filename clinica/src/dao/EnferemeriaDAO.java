package dao;

import java.util.Collection;


import entidades.Enfermeria;

public class EnferemeriaDAO implements OperacionesCRUD<Enfermeria> {

	@Override
	public boolean insertarConID(Enfermeria elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insertarSinID(Enfermeria elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Enfermeria buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Enfermeria> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Enfermeria elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Enfermeria elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Enfermeria> eliminarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
