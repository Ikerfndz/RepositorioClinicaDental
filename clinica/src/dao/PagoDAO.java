package dao;

import java.util.Collection;

import entidades.Pago;

public class PagoDAO implements OperacionesCRUD<Pago> {

	@Override
	public boolean insertarConID(Pago elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insertarSinID(Pago elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Pago buscarPorID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Pago> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Pago elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Pago elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Pago> eliminarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
