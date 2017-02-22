public class Auto{

private Chofer chofer[];
private Dueno dueno[];

public Auto(){
  chofer = new Chofer[20];
  ArchivoChofer archivoChofer = new ArchivoChofer();
  try{
    System.out.println("Leyendo datos....");
  chofer = archivoChofer.leeChofer();
    System.out.println("Datos leidos....");
  }catch(ArchivoLecturaNoCreadoException e){
    System.out.println(e.getMessage());
  }
}


public void agregaChofer(Chofer chofer) throws ExcesoChoferException {
  if (!lugarChoferDisponible()) {
    throw new ExcesoChoferException("Ya no hay espacios disponible para agregar un chofer");
  } else {
    this.chofer[obtenerCantidadChofer()] = chofer;
  }

}




public void guardaChofer(){
  ArchivoChofer archivoC = new ArchivoChofer();
  archivoC.escribeChofer(chofer);
}



private int obtenerCantidadChofer() {
  int cantidad = 0;
  for (Chofer c : chofer) {
    if (c != null) {
      cantidad++;
    }
  }
  return cantidad;
}





private boolean lugarChoferDisponible() {
  return obtenerCantidadChofer() < chofer.length;
}


public String toStringChofer() {
  String todosChofer = "";
  for(int i = 0; i < obtenerCantidadChofer(); i++){
    todosChofer += chofer[i] + "\n";
  }
  return todosChofer;
}


public String listadoChofer() throws ExcesoChoferException{
  String choferString = "";
  int i = 0;
  for(Chofer chofer: this.chofer){
    if(chofer != null){
      choferString += i + " - Nombre: " + chofer.getNombre() + " Dueno:" + chofer.getDueno() + "\n";
      i++;
    }
  }
  if(choferString.equals("")){
    throw new ExcesoChoferException("No existen choferes registrados");
  }
  return choferString;
}

public Dueno[] getDueno() {
  return dueno;
}
//error al ejecutar
public Chofer getChofer(int i) throws ExcesoChoferException{
  if(i < 0 || i >= this.obtenerCantidadChofer()){
    throw new ExcesoChoferException("Chofer seleccionado incorrectamente");
  }
  return this.chofer[i];
}

public void eliminaChofer(int i) throws ExcesoChoferException{
  if(i < 0 || i >= this.obtenerCantidadChofer()){
    throw new ExcesoChoferException("Chofer seleccionado incorrectamente");
  }
  this.chofer[i] = null;
  this.recorreChofer(i);
}

private void recorreChofer(int i){

  int indiceUltimoM = this.obtenerCantidadChofer();
  if(i != indiceUltimoM){
    this.chofer[i] = chofer[indiceUltimoM];
    chofer[indiceUltimoM] = null;
  }
}

public void setDueno(Dueno[] dueno) {
  this.dueno = dueno;
}



public void setChofer(Chofer chofer[]) {
  this.chofer = chofer;
}

}
