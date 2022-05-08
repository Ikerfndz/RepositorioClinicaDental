package dao;

import java.util.Collection;

public interface OperacionesCRUD<T> {

	/***
	 * Este método inserta en la tabla correspondiente de la BD bdclinica un nuevo
	 * registro
	 *
	 * 
	 * @param elemento del tipo que se quiere insertar como nuevo elemento completo
	 *                 (con ID)
	 *
	 * @return true si la inserción fue exitosa, false en caso contrario
	 */
	public boolean insertarConID(T elemento);

	/***
	 * Este método inserta en la tabla correspondiente de la BD bdclinica un nuevo
	 * registro
	 * 
	 * @param elemento del tipo que se quiere insertar como nuevo elemento completo
	 *                 (sin ID, que es autocalculado)
	 *
	 * @return id del nuevo elemento insertado si tuvo exito, o -1 en caso contrario
	 */
	public boolean insertarSinID(T elemento);

	/**
	 * Función que busca en la tabla correspondiente si hay un elemento cuyo id
	 * coincide con el que se pasa por parámetro
	 *
	 * @param id identificador del elemento a buscar
	 * @return el elemento si existe o null si no
	 */
	public boolean buscarPorID(long id);

	/**
	 * Funcion que devuelva la coleccion de todos los elementos de un tipo
	 * 
	 * @return la coleccion de elementos que puede ser vacía
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
