package dao;

import java.util.Collection;

public interface OperacionesCRUD<T> {

	/***
	 * Este m�todo inserta en la tabla correspondiente de la BD bdclinica un nuevo
	 * registro
	 *
	 * 
	 * @param elemento del tipo que se quiere insertar como nuevo elemento completo
	 *                 (con ID)
	 *
	 * @return true si la inserci�n fue exitosa, false en caso contrario
	 */
	public boolean insertarConID(T elemento);

	/***
	 * Este m�todo inserta en la tabla correspondiente de la BD bdclinica un nuevo
	 * registro
	 * 
	 * @param elemento del tipo que se quiere insertar como nuevo elemento completo
	 *                 (sin ID, que es autocalculado)
	 *
	 * @return id del nuevo elemento insertado si tuvo exito, o -1 en caso contrario
	 */
	public long insertarSinID(T elemento);

	/**
	 * Funci�n que busca en la tabla correspondiente si hay un elemento cuyo id
	 * coincide con el que se pasa por par�metro
	 *
	 * @param id identificador del elemento a buscar
	 * @return el elemento si existe o null si no
	 */
	public T buscarPorID(long id);

	/**
	 * Funcion que devuelva la coleccion de todos los elementos de un tipo
	 * 
	 * @return la coleccion de elementos que puede ser vac�a
	 */
	public Collection<T> buscarTodos();

	/**
	 * Funcion que permite modificar un elemento de un tipo
	 */
	public boolean modificar(T elemento);

	/**
	 * Funcion que permite eliminar un elemento de un tipo
	 */
	public boolean eliminar(T elemento);

	/**
	 * Funcion que permite una coleccion entera
	 */
	public Collection<T> eliminarTodos();

}
