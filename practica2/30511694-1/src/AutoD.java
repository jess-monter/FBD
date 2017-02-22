public class AutoD{

private Chofer chofer[];
private Dueno dueno[];



public AutoD(){
  dueno = new Dueno[20];
  ArchivoDueno archivoDueno = new ArchivoDueno();
  try{
    System.out.println("Leyendo datos....");
  dueno = archivoDueno.leeDueno();
    System.out.println("Datos leidos....");
  }catch(ArchivoLecturaNoCreadoException e){
    System.out.println(e.getMessage());
  }
}


public void agregaDueno(Dueno dueno) throws ExcesoChoferException {
  if (!lugarDuenoDisponible()) {
    throw new ExcesoChoferException("Ya no hay espacios disponible para agregar un dueno");
  } else {
    this.dueno[obtenerCantidadDueno()] = dueno;
  }

}




public void guardaDueno(){
  ArchivoDueno archivoD = new ArchivoDueno();
  archivoD.escribeDueno(dueno);
}



private int obtenerCantidadDueno() {
  int cantidad = 0;
  for (Dueno d : dueno) {
    if (d != null) {
      cantidad++;
    }
  }
  return cantidad;
}





private boolean lugarDuenoDisponible() {
  return obtenerCantidadDueno() < dueno.length;
}


public String toStringDueno() {
  String todosDueno = "";
  for(int i = 0; i < obtenerCantidadDueno(); i++){
    todosDueno += dueno[i] + "\n";
  }
  return todosDueno;
}


public String listadoDueno() throws ExcesoChoferException{
  String duenoString = "";
  int i = 0;
  for(Dueno dueno: this.dueno){
    if(dueno != null){
      duenoString += i + " - Nombre: " + dueno.getNombre() + " Chofer:" + dueno.getChofer() + "\n";
      i++;
    }
  }
  if(duenoString.equals("")){
    throw new ExcesoChoferException("No existen choferes registrados");
  }
  return duenoString;
}

public Chofer[] getChofer() {
  return chofer;
}
//error al ejecutar
public Dueno getDueno(int i) throws ExcesoChoferException{
  if(i < 0 || i >= this.obtenerCantidadDueno()){
    throw new ExcesoChoferException("Dueno seleccionado incorrectamente");
  }
  return this.dueno[i];
}

public void eliminaDueno(int i) throws ExcesoChoferException{
  if(i < 0 || i >= this.obtenerCantidadDueno()){
    throw new ExcesoChoferException("Dueno seleccionado incorrectamente");
  }
  this.dueno[i] = null;
  this.recorreDueno(i);
}

private void recorreDueno(int i){

  int indiceUltimoD = this.obtenerCantidadDueno();
  if(i != indiceUltimoD){
    this.dueno[i] = dueno[indiceUltimoD];
    dueno[indiceUltimoD] = null;
  }
}

public void setChofer(Chofer[] chofer) {
  this.chofer = chofer;
}



public void setDueno(Dueno dueno[]) {
  this.dueno = dueno;
}

}
