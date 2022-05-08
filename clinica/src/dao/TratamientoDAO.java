package dao;

import java.util.Collection;

import entidades.Alergia;
import entidades.Tratamiento;

public class TratamientoDAO implements OperacionesCRUD<Tratamiento> {

	@Override
	public boolean insertarConID(Tratamiento elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertarSinID(Tratamiento elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean buscarPorID(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Tratamiento> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Tratamiento elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Tratamiento elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Tratamiento> eliminarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
