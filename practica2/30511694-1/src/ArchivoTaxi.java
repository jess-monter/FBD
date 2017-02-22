


public class ArchivoTaxi extends ManipulaArchivo{

public ArchivoTaxi(){
  super("taxi.txt");
}

public void escribeTaxi(Taxi taxi[]) {
  String lineaTaxi = "";
  for (Taxi t : taxi) {
    lineaTaxi += t + "\n";
  }
  super.escribeArchivo(lineaTaxi);
}


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
