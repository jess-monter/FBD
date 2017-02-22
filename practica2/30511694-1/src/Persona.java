import java.util.Scanner;
import java.util.InputMismatchException;

public class Persona{

  protected String nombre;
  protected String domicilio;
  protected String correo;
  protected int telefono;

  Scanner in = new Scanner(System.in);

  public Persona(String nombre, String domicilio, String correo, int telefono){
    this.nombre = nombre;
    this.domicilio = domicilio;
    this.correo = correo;
    this.telefono = telefono;
  }

  public Persona(){
    pideDatos();
  }

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

  public void edita() {
    this.pideDatos();
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDomicilio() {
    return domicilio;
  }

  public void setDomicilio(String domicilio) {
    this.domicilio = domicilio;
  }
  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }
  public int telefono() {
    return telefono;
  }

  public void setTelefono(int telefono) {
    this.telefono = telefono;
  }

  @Override
  public String toString() {
    return this.nombre + "," + this.domicilio + "," + this.correo +","+ this.telefono;
  }

  

}
