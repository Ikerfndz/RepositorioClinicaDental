package dao;

import java.util.Collection;

import entidades.Alergia;
import entidades.Cirujano;

public class CirujanoDAO implements OperacionesCRUD<Cirujano> {

	@Override
	public boolean insertarConID(Cirujano elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insertarSinID(Cirujano elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cirujano buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Cirujano> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Cirujano elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Cirujano elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Cirujano> eliminarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
