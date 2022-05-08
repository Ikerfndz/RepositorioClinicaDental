package dao;

import java.util.Collection;

import entidades.Informe;

public class InformeDAO implements OperacionesCRUD<Informe> {

	@Override
	public boolean insertarConID(Informe elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insertarSinID(Informe elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Informe buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Informe> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Informe elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Informe elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Informe> eliminarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
