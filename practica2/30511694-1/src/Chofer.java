import java.util.InputMismatchException;
import java.util.Scanner;

public class Chofer extends Persona{

private String licencia;
private String dueno;
private double ingreso;


Scanner in = new Scanner(System.in);

public Chofer(String nombre, String domicilio, String correo, int telefono,String licencia, String dueno, double ingreso){
  super(nombre, domicilio, correo, telefono);
  this.licencia = licencia;
  this.ingreso  = ingreso;
  this.dueno = dueno;

}

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


public void edita(){
  super.edita();;

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


public String getILicencia() {
  return licencia;
}

public void setLicencia(String licencia) {
  this.licencia = licencia;
}

public String getDueno() {
  return dueno;
}

public void setDueno(String dueno) {
  this.dueno = dueno;
}

public double getIngreso(){
  return ingreso;
}

public void setIngreso(){
  this.ingreso = ingreso;
}

@Override
public String toString() {
  return super.toString() + "," + this.licencia + "," + this.dueno + "," +this.ingreso;
}


}
