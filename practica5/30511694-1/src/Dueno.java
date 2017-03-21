import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Dueno.java
 * Clase general que simula un Dueno
 * @extends la clase Persona.
 */
public class Dueno extends Persona{

  //Cadena que indica al chofer.
  private String chofer;

  /**
   * Constructor del objeto Dueno.
   * @param string nombre Nombre del dueno.
   * @param string domicilio Domicilio del dueno.
   * @param String correo Email del dueno-
   * @param int Telefono del dueno.
   * @param string nombre del chofer.
   */
  public Dueno(String nombre, String domicilio, String correo, int telefono, String chofer ){
    super(nombre,domicilio,correo,telefono);
    this.chofer=chofer;
  }

  /**
   * Constructor del objeto Dueno.
   */
  public Dueno(){
    super();
    boolean bandera = true;
    System.out.println("Ingresa chofer");
    this.chofer = in.next();
  }

  /**
   * Metodo que agrega la informacion de chofer.
   */
  public void edita(){
    super.edita();;
    System.out.println("Ingresa chofer");
    this.chofer = in.next();
  }

  /**
   * Metodo que obtiene al chofer.
   * @return string con el nombre del chofer.
   */
  public String getChofer() {
    return chofer;
  }

  /**
   * Metodo que asgina el chofer a la variable de clase.
   * @param string con el nombre del chofer.
   */
  public void setChofer(String chofer) {
    this.chofer = chofer;
  }

  /**
   * Metodo que convierte a cadena la informacion.
   * @return string con la informacion.
   */
  @Override
  public String toString() {
    return super.toString()+ "," + this.chofer;
  }

}
