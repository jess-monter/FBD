/**
 * ArchivoTaxi.java
 * Clase que realiza lectura, escritura y borrado en el archivo chofer.txt
 */
public class ArchivoTaxi extends ManipulaArchivo{

  /**
   * Constructor que indica el archivo a manipular.
   */
  public ArchivoTaxi(){
    super("taxi.txt");
  }

  /**
   * Metodo que se encarga de escribir los registros en el archivo taxi.txt
   * @param arreglo de registros correspondientes a los taxis.
   */
  public void escribeTaxi(Taxi taxi[]) {
    String lineaTaxi = "";
    for (Taxi t : taxi) {
      lineaTaxi += t + "\n";
    }
    super.escribeArchivo(lineaTaxi);
  }


  /**
   * Metodo que se encarga de leer los registros en el archivo taxi.txt
   * @return arreglo con los registros.
   */
  public Taxi[] leeTaxi() throws ArchivoLecturaNoCreadoException {
    String lineas[] = super.leeArchivo();
      Taxi taxi[] = new Taxi[lineas.length];
    for (int i = 0; i < taxi.length; i++) {
      if (!lineas[i].equals("null")) {
        taxi[i] = this.parseaTaxi(lineas[i]);
      }
    }
    return taxi;
  }
  /**
   * Metodo que convierte los datos del archivo al formato necesario para operar con ellos.
   * @param cadena leida del archivo.
   * @return registro a procesar en el formato requerido.
   */
  private Taxi parseaTaxi(String cadenaTaxi) {
    String linea[] = cadenaTaxi.trim().split(",");
    String nombre = linea[0];
    String direccion = linea[1];
    String correo = linea[2];
    int telefono = Integer.parseInt(linea[3]);
    String licencia = linea[4];
    String dueno = linea[5];
    double ingreso = Double.parseDouble(linea[6]);


    return new Taxi(nombre,direccion,correo,telefono,licencia,dueno,ingreso);
  }


}
