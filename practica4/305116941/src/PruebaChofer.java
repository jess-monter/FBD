import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * PruebaChofer.java
 * Clase que se encarga de implementar la funcionalidad del sistema.
 */
public class PruebaChofer{

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    Auto auto = new Auto();
    AutoD autoD = new AutoD();
    AutoT autoT = new AutoT();
    boolean bandera = true;
    int opcion = 0;

    do{
      System.out.println("Ingresa alguna de las opciones");
      System.out.println("1.- Agregar ");
      System.out.println("2.- Ver ");
      System.out.println("3.- Modificar");
      System.out.println("4.- Eliminar ");
      System.out.println("5.- Salir");

      do{
        try {
          opcion = in.nextInt();
          bandera = false;
        }catch (InputMismatchException e) {
          in.next();
          System.out.println("Ingresa un numero como opcion");
          bandera = true;
        }
      }while(bandera);



      switch(opcion){

        case 1:

        int opChofer = 0;
        System.out.println("Seleccionaste la opcion de agregar, Elige alguna de las opciones");
        System.out.println("1.- Chofer");
        System.out.println("2.- Dueno");
        System.out.println("3.- Taxis");


        do{
          try {
            opChofer = in.nextInt();
            bandera = false;
          } catch (InputMismatchException e) {
            in.next();
            System.out.println("Ingresa un numero como opcion");
            bandera = true;
          }
        }while(bandera);

        switch(opChofer){

          case 1:

          try{
            System.out.println("Seleccionaste la opcion de Chofer");
            Chofer chofer = new Chofer();
            auto.agregaChofer(chofer);
            System.out.println("Se agrego chofer correctamente");
            auto.guardaChofer();
            System.out.print("Se guardo correctamente en la base de datos");
            bandera = true;

          }catch(ExcesoChoferException e){
            System.out.println(" No se pudo agregar correctamente chofer");
          }
          break;

          case 2:

          System.out.println("Seleccionaste la opcion de Dueno");
          try{
            Dueno dueno = new Dueno();
            autoD.agregaDueno(dueno);
            System.out.println("Se agrego dueno correctamente");
            autoD.guardaDueno();
            System.out.print("Se guardo correctamente en la base de datos");
            bandera = true;

          }catch(ExcesoChoferException e){
            System.out.println(" No se pudo agregar correctaente Dueno");
          }


          break;

          case 3:
          try{
            System.out.println("Seleccionaste la opcion de Taxis");
            Taxi taxi = new Taxi();
            autoT.agregaTaxi(taxi);
            System.out.println("Se agrego taxi correctamente");
            autoT.guardaTaxi();
            System.out.print("Se guardo correctamente en la base de datos");
            bandera = true;

          }catch(ExcesoChoferException e){
            System.out.println(" No se pudo agregar correctaente chofer");
          }

          break;



          default:
          System.out.println("Opcion invalida");
          break;


        }


        break;

        case 2:

        int opVer = 0;

        System.out.println("Seleccionaste la opcion de ver, Elige alguna de las opciones");
        System.out.println("1.- Chofer");
        System.out.println("2.- Dueno");
        System.out.println("3.- Taxis");


        do{
          try {
            opVer = in.nextInt();
            bandera = false;
          } catch (InputMismatchException e) {
            in.next();
            System.out.println("Ingresa un numero como opcion");
            bandera = true;
          }
        }while(bandera);

        switch(opVer){

          case 1:
          System.out.println("Seleccionaste ver Chofer");
          System.out.println(auto.toStringChofer());
          bandera = true;

          break;

          case 2:
          System.out.println("Seleccionaste ver Dueno");
          System.out.println(autoD.toStringDueno());
          bandera = true;
          break;

          case 3:
          System.out.println("Seleccionaste ver Taxi");
          System.out.println(autoT.toStringTaxi());
          bandera = true;
          break;

          default:
          System.out.println("opcion Invalida");
          break;

        }

        break;

        case 3:
        int opM = 0;

        System.out.println("Seleccionaste la opcion de modificar, Elige alguna de las opciones");
        System.out.println("1.- Chofer");
        System.out.println("2.- Dueno");
        System.out.println("3.- Taxis");


        do{
          try {
            opM = in.nextInt();
            bandera = false;
          } catch (InputMismatchException e) {
            in.next();
            System.out.println("Ingresa un numero como opcion");
            bandera = true;
          }
        }while(bandera);

        switch(opM){

          case 1:
          System.out.println("Selccionaste modificar Chofer");
          do {
            try {
              System.out.println(auto.listadoChofer());
              opcion = in.nextInt();
              auto.getChofer(opcion).edita();
              bandera = false;
              auto.guardaChofer();
              System.out.println("Chofer editado correctamente");
            } catch (ExcesoChoferException e) {
              System.out.println(e.getMessage());
              bandera = false;
            } catch (InputMismatchException i) {
              System.out.println("Ingresa un numero como opcion");
              in.next();
              bandera = true;
            }
          } while (bandera);

          bandera = true;

          break;

          case 2:
          System.out.println("Selccionaste modificar Dueno");
          do {
            try {
              System.out.println(autoD.listadoDueno());
              opcion = in.nextInt();
              autoD.getDueno(opcion).edita();
              bandera = false;
              autoD.guardaDueno();
              System.out.println("Chofer editado correctamente");
            } catch (ExcesoChoferException e) {
              System.out.println(e.getMessage());
              bandera = false;
            } catch (InputMismatchException i) {
              System.out.println("Ingresa un numero como opcion");
              in.next();
              bandera = true;
            }
          } while (bandera);

          bandera = true;


          break;

          case 3:
          System.out.println("Selccionaste modificar Taxi ");
          do {
            try {
              System.out.println(autoT.listadoTaxi());
              opcion = in.nextInt();
              autoT.getTaxi(opcion).edita();
              bandera = false;
              autoT.guardaTaxi();
              System.out.println("Taxi editado correctamente");
            } catch (ExcesoChoferException e) {
              System.out.println(e.getMessage());
              bandera = false;
            } catch (InputMismatchException i) {
              System.out.println("Ingresa un numero como opcion");
              in.next();
              bandera = true;
            }
          } while (bandera);

          bandera = true;
          break;

          default:
          System.out.println("Opcion Invalida");
          break;

        }

        break;

        case 4:
        int opE = 0;

        System.out.println("Seleccionaste la opcion de Eliminar, Elige alguna de las opciones");
        System.out.println("1.- Chofer");
        System.out.println("2.- Dueno");
        System.out.println("3.- Taxis");


        do{
          try {
            opE = in.nextInt();
            bandera = false;
          } catch (InputMismatchException e) {
            in.next();
            System.out.println("Ingresa un numero como opcion");
            bandera = true;
          }
        }while(bandera);

        switch(opE){

          case 1:

          System.out.println("Seleccionaste la opcion de eliminar Chofer");

          bandera = true;
          do {
            try {
              System.out.println(auto.listadoChofer());
              opcion = in.nextInt();
              auto.eliminaChofer(opcion);
              auto.guardaChofer();
              System.out.println("Se elimino correctamente");
              bandera = false;
            } catch (ExcesoChoferException e) {
              System.out.println(e.getMessage());
              bandera = false;
            } catch (InputMismatchException i) {
              System.out.println("Ingresa un numero como opcion");
              in.next();
              bandera = true;
            }
          } while (bandera);
          bandera = true;

          break;

          case 2:
          System.out.println("Seleccionaste la opcion de eliminar Dueno");

          bandera = true;
          do {
            try {
              System.out.println(autoD.listadoDueno());
              opcion = in.nextInt();
              autoD.eliminaDueno(opcion);
              autoD.guardaDueno();
              System.out.println("Se elimino correctamente");
              bandera = false;
            } catch (ExcesoChoferException e) {
              System.out.println(e.getMessage());
              bandera = false;
            } catch (InputMismatchException i) {
              System.out.println("Ingresa un numero como opcion");
              in.next();
              bandera = true;
            }
          } while (bandera);
          bandera = true;




          break;

          case 3:
          System.out.println("Seleccionaste la opcion de eliminar Taxi");
          bandera = true;
          do {
            try {
              System.out.println(autoT.listadoTaxi());
              opcion = in.nextInt();
              autoT.eliminaTaxi(opcion);
              autoT.guardaTaxi();
              System.out.println("Se elimino correctamente");
              bandera = false;
            } catch (ExcesoChoferException e) {
              System.out.println(e.getMessage());
              bandera = false;
            } catch (InputMismatchException i) {
              System.out.println("Ingresa un numero como opcion");
              in.next();
              bandera = true;
            }
          } while (bandera);
          bandera = true;
          break;

          default:
          break;
        }
        break;

        case 5:
        System.out.println("Gracias, hasta luego");
        auto.guardaChofer();
        bandera = false;
        break;

        default:

        System.out.println("Opcion Invalida");

        break;

      }

    }while(bandera);

  }

}
