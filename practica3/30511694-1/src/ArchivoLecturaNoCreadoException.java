/**
 * ArchivoLecturaNoCreadoException
 * Clase que implementa a una escepcion para cuando un archivo para leer no sea encontrado
 */
public class ArchivoLecturaNoCreadoException extends Exception {
	public ArchivoLecturaNoCreadoException(String message){
		super(message);
	}
}
