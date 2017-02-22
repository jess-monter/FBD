public class AutoT{

private Taxi taxi[];
private Dueno dueno[];

public AutoT(){
  taxi= new Taxi[20];
  ArchivoTaxi archivoTaxi = new ArchivoTaxi();
  try{
    System.out.println("Leyendo datos....");
  taxi = archivoTaxi.leeTaxi();
    System.out.println("Datos leidos....");
  }catch(ArchivoLecturaNoCreadoException e){
    System.out.println(e.getMessage());
  }
}


public void agregaTaxi(Taxi taxi) throws ExcesoChoferException {
  if (!lugarTaxiDisponible()) {
    throw new ExcesoChoferException("Ya no hay espacios disponible para agregar un chofer");
  } else {
    this.taxi[obtenerCantidadTaxi()] = taxi;
  }

}




public void guardaTaxi(){
  ArchivoTaxi archivoT = new ArchivoTaxi();
  archivoT.escribeTaxi(taxi);
}



private int obtenerCantidadTaxi() {
  int cantidad = 0;
  for (Taxi t : taxi) {
    if (t != null) {
      cantidad++;
    }
  }
  return cantidad;
}





private boolean lugarTaxiDisponible() {
  return obtenerCantidadTaxi() < taxi.length;
}


public String toStringTaxi() {
  String todosTaxi = "";
  for(int i = 0; i < obtenerCantidadTaxi(); i++){
    todosTaxi += taxi[i] + "\n";
  }
  return todosTaxi;
}


public String listadoTaxi() throws ExcesoChoferException{
  String taxiString = "";
  int i = 0;
  for(Taxi taxi: this.taxi){
    if(taxi != null){
      taxiString += i + " - Nombre: " + taxi.getNombre() + " Dueno:" + taxi.getDueno() + "\n";
      i++;
    }
  }
  if(taxiString.equals("")){
    throw new ExcesoChoferException("No existen taxis registrados");
  }
  return taxiString;
}

public Dueno[] getDueno() {
  return dueno;
}
//error al ejecutar
public Taxi getTaxi(int i) throws ExcesoChoferException{
  if(i < 0 || i >= this.obtenerCantidadTaxi()){
    throw new ExcesoChoferException("taxi seleccionado incorrectamente");
  }
  return this.taxi[i];
}

public void eliminaTaxi(int i) throws ExcesoChoferException{
  if(i < 0 || i >= this.obtenerCantidadTaxi()){
    throw new ExcesoChoferException("taxi seleccionado incorrectamente");
  }
  this.taxi[i] = null;
  this.recorreTaxi(i);
}

private void recorreTaxi(int i){

  int indiceUltimoT = this.obtenerCantidadTaxi();
  if(i != indiceUltimoT){
    this.taxi[i] = taxi[indiceUltimoT];
    taxi[indiceUltimoT] = null;
  }
}

public void setdueno(Dueno[] dueno) {
  this.dueno = dueno;
}



public void setTaxi(Taxi taxi[]) {
  this.taxi = taxi;
}

}
