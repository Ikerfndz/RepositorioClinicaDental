package dao;

import java.util.Collection;

import entidades.Alergia;
import entidades.Cobro;

public class CobroDAO implements OperacionesCRUD<Cobro> {

	@Override
	public boolean insertarConID(Cobro elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insertarSinID(Cobro elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cobro buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Cobro> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Cobro elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Cobro elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Cobro> eliminarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
