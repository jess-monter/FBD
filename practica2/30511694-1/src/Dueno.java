import java.util.InputMismatchException;
import java.util.Scanner;

public class Dueno extends Persona{

private String chofer;

public Dueno(String nombre, String domicilio, String correo, int telefono, String chofer ){
  super(nombre,domicilio,correo,telefono);
  this.chofer=chofer;
}

public Dueno(){
  super();
  boolean bandera = true;
  System.out.println("Ingresa chofer");
  this.chofer = in.next();
}



public void edita(){
  super.edita();;
  System.out.println("Ingresa chofer");
  this.chofer = in.next();
}

public String getChofer() {
  return chofer;
}
public void setChofer(String chofer) {
  this.chofer = chofer;
}

@Override
public String toString() {
  return super.toString()+ "," + this.chofer;
}

}
