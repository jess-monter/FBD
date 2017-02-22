

  public class ArchivoDueno extends ManipulaArchivo{

  public ArchivoDueno(){
    super("dueno.txt");
  }

  public void escribeDueno(Dueno dueno[]) {
    String lineaDueno = "";
    for (Dueno m : dueno) {
      lineaDueno += m + "\n";
    }
    super.escribeArchivo(lineaDueno);
  }


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
