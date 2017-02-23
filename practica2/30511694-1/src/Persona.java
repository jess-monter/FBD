import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Persona.java
 * Clase general que simula una Persona
 */
public class Persona{

  //string con el nombre de la persona.
  protected String nombre;
  //string con el domicilio de la persona.
  protected String domicilio;
  //string con el correo de la persona.
  protected String correo;
  //string con el telefono de la persona,
  protected int telefono;

  //Objeto de lectura de datos introducidos por el usuario.
  Scanner in = new Scanner(System.in);

  /**
   * Constructor del objeto Persona.
   * @param string nombre Nombre de la Persona.
   * @param string domicilio Domicilio de la Persona.
   * @param String correo Email de la Persona.
   * @param int Telefono de la Persona.
   */
  public Persona(String nombre, String domicilio, String correo, int telefono){
    this.nombre = nombre;
    this.domicilio = domicilio;
    this.correo = correo;
    this.telefono = telefono;
  }

  /**
   * Constructor del objeto Persona a partir de los datos introducidos por el usuario.
   */
  public Persona(){
    pideDatos();
  }


  /**
   * Método que se encarga de pedir los datos al usuario.
   */
  private void pideDatos(){

    boolean bandera = true;

    System.out.println("Ingresa nombre");
    this.nombre = in.nextLine();
    System.out.println("Ingresa domicilio");
    this.domicilio = in.nextLine();
    System.out.println("Ingresa correo");
    this.correo = in.nextLine();
    do{
      try{
        System.out.println("Ingresa telefono");
        this.telefono = in.nextInt();
        bandera = false;
      }catch(InputMismatchException e){
        in.next();
        bandera = true;
      }
    }while(bandera);

  }

  /**
   * Método que se encarga de pedir los datos al usuario en la edicion.
   */
  public void edita() {
    this.pideDatos();
  }

  /**
   * Método que obtiene el nombre de la persona.
   * @return string con el nombre de la persona.
   */
  public String getNombre() {
    return nombre;
  }


  /**
   * Método que asigna el nombre de la persona a la variable de clase.
   * @param string con el nombre de la persona.
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Método que obtiene el domicilio de la persona.
   * @return string con el domicilio de la persona.
   */
  public String getDomicilio() {
    return domicilio;
  }

  /**
   * Método que asigna el domicilio de la persona a la variable de clase.
   * @param string con el domicilio de la persona.
   */
  public void setDomicilio(String domicilio) {
    this.domicilio = domicilio;
  }

  /**
   * Método que obtiene el correo de la persona.
   * @return string con el correo de la persona.
   */
  public String getCorreo() {
    return correo;
  }

  /**
   * Método que asigna el correo de la persona a la variable de clase.
   * @param string con el correo de la persona.
   */
  public void setCorreo(String correo) {
    this.correo = correo;
  }
  
  /**
   * Método que obtiene el telefono de la persona.
   * @return string con el telefono de la persona.
   */
  public int telefono() {
    return telefono;
  }

  /**
   * Método que asigna el telefono de la persona a la variable de clase.
   * @param entero con el telefono de la persona.
   */
  public void setTelefono(int telefono) {
    this.telefono = telefono;
  }

  /**
   * Metodo que convierte a cadena la informacion.
   * @return string con la informacion.
   */
  @Override
  public String toString() {
    return this.nombre + "," + this.domicilio + "," + this.correo +","+ this.telefono;
  }

  

}
