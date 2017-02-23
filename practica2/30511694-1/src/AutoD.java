/**
 * AutoD.java
 * Clase general que simula un auto respecto al dueno y sus atributos.
 */
public class AutoD{

  //Arreglo que guarda los choferes de los autos.
  private Chofer chofer[];
  //Arreglo que guarda a los dueños de los autos.
  private Dueno dueno[];


  /**
   * Constructor del auto.
   */
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

  /**
   * Método que agrega un dueno a un auto.
   * @param dueno a agregar.
   * @throws excepcion en caso de que el limite de duenos se haya alcanzado.
   */
  public void agregaDueno(Dueno dueno) throws ExcesoChoferException {
    if (!lugarDuenoDisponible()) {
      throw new ExcesoChoferException("Ya no hay espacios disponible para agregar un dueno");
    } else {
      this.dueno[obtenerCantidadDueno()] = dueno;
    }

  }

  /**
   * Método que agrega los registros de dueno al archivo.
   */
  public void guardaDueno(){
    ArchivoDueno archivoD = new ArchivoDueno();
    archivoD.escribeDueno(dueno);
  }

  /**
   * Método que indica la cantidad de duenos que tiene un auto.
   * @return entero que cuenta a los duenos actuales.
   */
  private int obtenerCantidadDueno() {
    int cantidad = 0;
    for (Dueno d : dueno) {
      if (d != null) {
        cantidad++;
      }
    }
    return cantidad;
  }

  /**
   * Método que indica si hay lugares disponibles para dueno.
   * @return boolean true si hay lugar disponible, false en otro caso.
   */
  private boolean lugarDuenoDisponible() {
    return obtenerCantidadDueno() < dueno.length;
  }

  /**
   * Método que convierte el entero correspondiente a la cantidad de duenos a cadena.
   * @return cadena que indica a los duenos actuales.
   */
  public String toStringDueno() {
    String todosDueno = "";
    for(int i = 0; i < obtenerCantidadDueno(); i++){
      todosDueno += dueno[i] + "\n";
    }
    return todosDueno;
  }

  /**
   * Método que regresa la lista de duenos.
   * @return cadena con la lista de duenos.
   * @throws excepcion en caso de que no existan duenos actuales.
   */
  public String listadoDueno() throws ExcesoChoferException{
    String duenoString = "";
    int i = 0;
    for(Dueno dueno: this.dueno){
      if(dueno != null){
        duenoString += i + " - Nombre: " + dueno.getNombre() + " Dueno:" + dueno.getChofer() + "\n";
        i++;
      }
    }
    if(duenoString.equals("")){
      throw new ExcesoChoferException("No existen duenos registrados");
    }
    return duenoString;
  }

  /**
   * Método que obtiene el arreglo choferes actuales.
   * @return dueno el arreglo de choferes.
   */
  public Chofer[] getChofer() {
    return chofer;
  }
  
  /**
   * Método que obtiene a un dueno segun su identificador.
   * @param entero i identificador del dueno.
   * @return objeto Dueno correspondiente al identificador.
   */
  //error al ejecutar
  public Dueno getDueno(int i) throws ExcesoChoferException{
    if(i < 0 || i >= this.obtenerCantidadDueno()){
      throw new ExcesoChoferException("Dueno seleccionado incorrectamente");
    }
    return this.dueno[i];
  }

  /**
   * Método que elimina a un dueno de los registros.
   * @param entero i correspondiente al identificador del dueno a eliminar.
   */
  public void eliminaDueno(int i) throws ExcesoChoferException{
    if(i < 0 || i >= this.obtenerCantidadDueno()){
      throw new ExcesoChoferException("Dueno seleccionado incorrectamente");
    }
    this.dueno[i] = null;
    this.recorreDueno(i);
  }

  /**
   * Método que recorre la informacion en el arreglo.
   * @param entero i indice a partir del cual se recorreran.
   */
  private void recorreDueno(int i){

    int indiceUltimoD = this.obtenerCantidadDueno();
    if(i != indiceUltimoD){
      this.dueno[i] = dueno[indiceUltimoD];
      dueno[indiceUltimoD] = null;
    }
  }

  /**
   * Método que asigna el arreglo de choferes al auto actual.
   * @param arreglo de choferes a asignar.
   */
  public void setChofer(Chofer[] chofer) {
    this.chofer = chofer;
  }

  /**
   * Método que asigna el arreglo de duenos al auto actual.
   * @param arreglo de duenos a asignar.
   */
  public void setDueno(Dueno dueno[]) {
    this.dueno = dueno;
  }

}
