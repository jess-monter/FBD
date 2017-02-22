


public class ArchivoChofer extends ManipulaArchivo{

public ArchivoChofer(){
  super("chofer.txt");
}

public void escribeChofer(Chofer chofer[]) {
  String lineaChofer = "";
  for (Chofer m : chofer) {
    lineaChofer += m + "\n";
  }
  super.escribeArchivo(lineaChofer);
}


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
