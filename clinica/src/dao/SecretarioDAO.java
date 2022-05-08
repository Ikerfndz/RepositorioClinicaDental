package dao;

import java.util.Collection;

import entidades.Secretariado;

public class SecretarioDAO implements OperacionesCRUD<Secretariado> {

	@Override
	public boolean insertarConID(Secretariado elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insertarSinID(Secretariado elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Secretariado buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Secretariado> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Secretariado elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Secretariado elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Secretariado> eliminarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
