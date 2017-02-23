/**
 * ArchivoDueno.java
 * Clase que realiza lectura, escritura y borrado en el archivo dueno.txt
 */

  public class ArchivoDueno extends ManipulaArchivo{

  /**
   * Constructor que indica el archivo a manipular.
   */
  public ArchivoDueno(){
    super("dueno.txt");
  }

  /**
   * Metodo que se encarga de escribir los registros en el archivo dueno.txt
   * @param arreglo de registros correspondientes a los duenos.
   */
  public void escribeDueno(Dueno dueno[]) {
    String lineaDueno = "";
    for (Dueno m : dueno) {
      lineaDueno += m + "\n";
    }
    super.escribeArchivo(lineaDueno);
  }

  /**
   * Metodo que se encarga de leer los registros en el archivo dueno.txt
   * @return arreglo con los registros.
   */
  public Dueno[] leeDueno() throws ArchivoLecturaNoCreadoException {
    String lineas[] = super.leeArchivo();
    Dueno dueno[] = new Dueno[lineas.length];
    for (int i = 0; i < dueno.length; i++) {
      if (!lineas[i].equals("null")) {
        dueno[i] = this.parseaDueno(lineas[i]);
      }
    }
    return dueno;
  }

  /**
   * Metodo que convierte los datos del archivo al formato necesario para operar con ellos.
   * @param cadena leida del archivo.
   * @return registro a procesar en el formato requerido.
   */
  private Dueno parseaDueno(String cadenaDueno) {
    String linea[] = cadenaDueno.trim().split(",");
    String nombre = linea[0];
    String direccion = linea[1];
    String correo = linea[2];
    int telefono = Integer.parseInt(linea[3]);
    String chofer = linea[4];

    return new Dueno(nombre,direccion,correo,telefono,chofer);
  }


}
