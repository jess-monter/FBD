import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Chofer.java
 * Clase general que simula un Chofer
 * @extends la clase Persona.
 */
public class Chofer extends Persona{

  //Cadena que contiene el identificador de licencia.
  private String licencia;
  //Cadena que indica el dueño del auto manejado.
  private String dueno;
  //Double que indica el ingreso del chofer.
  private double ingreso;
  //Objeto de lectura de datos introducidos por el usuario.
  Scanner in = new Scanner(System.in);

  /**
   * Constructor del objeto Chofer.
   * @param string nombre Nombre del chofer.
   * @param string domicilio Domicilio del chofer.
   * @param String correo Email del chofer-
   * @param int Telefono del chofer.
   * @param string Identificador de la licencia.
   * @param string Nombre del dueno.
   * @param double Ingreso del chofer
   */
  public Chofer(String nombre, String domicilio, String correo, int telefono,String licencia, String dueno, double ingreso){
    super(nombre, domicilio, correo, telefono);
    this.licencia = licencia;
    this.ingreso  = ingreso;
    this.dueno = dueno;
  }

  /**
   * Constructor del objeto Chofer.
   */
  public Chofer(){
    super();
    boolean bandera = true;
    System.out.println("Ingresa licencia");
    this.licencia = in.nextLine();
    System.out.println("Ingresa el nombre del dueno");
    this.dueno = in.nextLine();

    do{
    try{
      System.out.println("Ingresa ingreso");
      this.ingreso = in.nextDouble();
      bandera = false;
    }catch(InputMismatchException e){
      in.next();
      bandera = true;
    }
    }while(bandera);
  }


  /**
   * Metodo que agrega la informacion de chofer.
   */
  public void edita(){
    super.edita();

    boolean bandera = true;
    System.out.println("Ingresa licencia");
    this.licencia = in.nextLine();
    System.out.println("Ingresa el nombre del dueno");
    this.dueno = in.nextLine();
    do{
    try{
      System.out.println("Ingresa ingreso");
      this.ingreso = in.nextDouble();
      bandera = false;
    }catch(InputMismatchException e){
      in.next();
      bandera = true;
    }
    }while(bandera);
  }

  /**
   * Método que obtiene la licencia del chofer.
   * @return cadena con el identificador de la licencia.
   */
  public String getILicencia() {
    return licencia;
  }

  /**
   * Metodo que asigna la licencia a la variable de clase.
   * @param string con el identificador de la licencia.
   */
  public void setLicencia(String licencia) {
    this.licencia = licencia;
  }

  /**
   * Metodo que obtiene al dueno.
   * @return string con el nombre del dueno.
   */
  public String getDueno() {
    return dueno;
  }

  /**
   * Metodo que asgina el dueno a la variable de clase.
   * @param string con el nombre del dueno.
   */
  public void setDueno(String dueno) {
    this.dueno = dueno;
  }

  /**
   * Metodo que obtiene ingreso.
   * @param double con el ingreso.
   */
  public double getIngreso(){
    return ingreso;
  }

  /**
   * Metodo que obtiene el ingreso a la variable de clase.
   * @param string con el ingreso.
   */
  public void setIngreso(){
    this.ingreso = ingreso;
  }

  /**
   * Metodo que convierte a cadena la informacion.
   * @return string con la informacion.
   */
  @Override
  public String toString() {
    return super.toString() + "," + this.licencia + "," + this.dueno + "," +this.ingreso;
  }


}
