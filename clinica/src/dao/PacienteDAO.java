package dao;

import java.util.Collection;

import entidades.Paciente;

public class PacienteDAO implements OperacionesCRUD<Paciente> {

	@Override
	public boolean insertarConID(Paciente elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertarSinID(Paciente elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean buscarPorID(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Paciente> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Paciente elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Paciente elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Paciente> eliminarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
