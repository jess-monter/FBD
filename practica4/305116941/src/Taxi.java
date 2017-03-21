import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Taxi.java
 * Clase general que simula un taxi.
 * @extends la clase Persona.
 */
public class Taxi extends Persona{
  
  //Cadena que contiene el identificador de licencia.
  private String licencia;
  //Cadena que indica el dueño del auto manejado.
  private String dueno;
  //Double que indica el ingreso del chofer.
  private double ingreso;
  //Objeto de lectura de datos introducidos por el usuario.
  Scanner in = new Scanner(System.in);

  /**
   * Constructor del objeto Taxi.
   * @param string nombre Nombre del chofer.
   * @param string domicilio Domicilio del chofer.
   * @param String correo Email del chofer.
   * @param int Telefono del chofer.
   * @param string Identificador de la licencia del chofer.
   * @param string Nombre del dueno.
   * @param double Ingreso del chofer
   */
  public Taxi(String nombre, String domicilio, String correo, int telefono,String licencia, String dueno, double ingreso){
    super(nombre, domicilio, correo, telefono);
    this.licencia = licencia;
    this.ingreso  = ingreso;
    this.dueno = dueno;
  }

  /**
   * Constructor del objeto Taxi por medio de los datos introducidos por el usuario.
   */
  public Taxi(){
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
   * Metodo que agrega la informacion del taxi.
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
   * Método que obtiene el identificador de la licencia del chofer.
   * @return string con el identificador de la licencia del chofer.
   */
  public String getILicencia() {
    return licencia;
  }

  /**
   * Método que asigna el identificador de la licencia a la variable de clase.
   * @param string con el identificador de la licencia.
   */
  public void setLicencia(String licencia) {
    this.licencia = licencia;
  }
  
  /**
   * Método que obtiene el dueno del taxi.
   * @return string con el dueno del taxi.
   */
  public String getDueno() {
    return dueno;
  }

  /**
   * Método que asigna el dueno del taxi a la variable de clase.
   * @param string con el dueno del taxi.
   */
  public void setDueno(String dueno) {
    this.dueno = dueno;
  }

  /**
   * Método que obtiene el ingreso del chofer.
   * @return double con el ingreso del chofer.
   */
  public double getIngreso(){
    return ingreso;
  }

  /**
   * Método que asigna ingreso a la variable de clase.
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
