package dao;

import java.util.Collection;

import entidades.Medicamento;

public class MedicamentoDAO implements OperacionesCRUD<Medicamento>{

	@Override
	public boolean insertarConID(Medicamento elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertarSinID(Medicamento elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean buscarPorID(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Medicamento> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Medicamento elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Medicamento elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Medicamento> eliminarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
