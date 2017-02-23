/**
 * ArchivoChofer.java
 * Clase que realiza lectura, escritura y borrado en el archivo chofer.txt
 */
public class ArchivoChofer extends ManipulaArchivo{

  /**
   * Constructor que indica el archivo a manipular.
   */
  public ArchivoChofer(){
    super("chofer.txt");
  }

  /**
   * Metodo que se encarga de escribir los registros en el archivo chofer.txt
   * @param arreglo de registros correspondientes a los choferes.
   */
  public void escribeChofer(Chofer chofer[]) {
    String lineaChofer = "";
    for (Chofer m : chofer) {
      lineaChofer += m + "\n";
    }
    super.escribeArchivo(lineaChofer);
  }

  /**
   * Metodo que se encarga de leer los registros en el archivo chofer.txt
   * @return arreglo con los registros.
   */
  public Chofer[] leeChofer() throws ArchivoLecturaNoCreadoException {
    String lineas[] = super.leeArchivo();
    Chofer chofer[] = new Chofer[lineas.length];
    for (int i = 0; i < chofer.length; i++) {
      if (!lineas[i].equals("null")) {
        chofer[i] = this.parseaChofer(lineas[i]);
      }
    }
    return chofer;
  }

  /**
   * Metodo que convierte los datos del archivo al formato necesario para operar con ellos.
   * @param cadena leida del archivo.
   * @return registro a procesar en el formato requerido.
   */
  private Chofer parseaChofer(String cadenaChofer) {
    String linea[] = cadenaChofer.trim().split(",");
    String nombre = linea[0];
    String direccion = linea[1];
    String correo = linea[2];
    int telefono = Integer.parseInt(linea[3]);
    String licencia = linea[4];
    String dueño = linea[5];
    double ingreso = Double.parseDouble(linea[6]);


    return new Chofer(nombre,direccion,correo,telefono,licencia,dueño,ingreso);
  }


}
