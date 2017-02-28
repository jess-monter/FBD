/**
 * Auto.java
 * Clase general que simula un auto y sus atributos.
 */
public class Auto{

  //Arreglo que guarda los choferes de los autos.
  private Chofer chofer[];
  //Arreglo que guarda a los dueños de los autos.
  private Dueno dueno[];

  /**
   * Constructor del auto.
   */
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


  /**
   * Método que agrega un chofer a un auto.
   * @param chofer a agregar.
   * @throws excepcion en caso de que el limite de choferes se haya alcanzado.
   */
  public void agregaChofer(Chofer chofer) throws ExcesoChoferException {
    if (!lugarChoferDisponible()) {
      throw new ExcesoChoferException("Ya no hay espacios disponible para agregar un chofer");
    } else {
      this.chofer[obtenerCantidadChofer()] = chofer;
    }

  }

  /**
   * Método que agrega los registros de chofer al archivo.
   */
  public void guardaChofer(){
    ArchivoChofer archivoC = new ArchivoChofer();
    archivoC.escribeChofer(chofer);
  }

  /**
   * Método que indica la cantidad de choferes que tiene un auto.
   * @return entero que cuenta a los choferes actuales.
   */
  private int obtenerCantidadChofer() {
    int cantidad = 0;
    for (Chofer c : chofer) {
      if (c != null) {
        cantidad++;
      }
    }
    return cantidad;
  }

  /**
   * Método que indica si hay lugares disponibles para choferes.
   * @return boolean true si hay lugar disponible, false en otro caso.
   */
  private boolean lugarChoferDisponible() {
    return obtenerCantidadChofer() < chofer.length;
  }

  /**
   * Método que convierte el entero correspondiente a la cantidad de choferes a cadena.
   * @return cadena que indica a los choferes actuales.
   */
  public String toStringChofer() {
    String todosChofer = "";
    for(int i = 0; i < obtenerCantidadChofer(); i++){
      todosChofer += chofer[i] + "\n";
    }
    return todosChofer;
  }

  /**
   * Método que regresa la lista de choferes.
   * @return cadena con la lista de choferes.
   * @throws excepcion en caso de que no existan choferes actuales.
   */
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

  /**
   * Método que obtiene el arreglo duenos actuales.
   * @return dueno el arreglo de duenos.
   */
  public Dueno[] getDueno() {
    return dueno;
  }
  
  /**
   * Método que obtiene a un chofer segun su identificador.
   * @param entero i identificador del chofer.
   * @return objeto Chofer correspondiente al identificador.
   */
  //error al ejecutar
  public Chofer getChofer(int i) throws ExcesoChoferException{
    if(i < 0 || i >= this.obtenerCantidadChofer()){
      throw new ExcesoChoferException("Chofer seleccionado incorrectamente");
    }
    return this.chofer[i];
  }

  /**
   * Método que elimina a un chofer de los registros.
   * @param entero i correspondiente al identificador del chofer a eliminar.
   */
  public void eliminaChofer(int i) throws ExcesoChoferException{
    if(i < 0 || i >= this.obtenerCantidadChofer()){
      throw new ExcesoChoferException("Chofer seleccionado incorrectamente");
    }
    this.chofer[i] = null;
    this.recorreChofer(i);
  }

  /**
   * Método que recorre la informacion en el arreglo.
   * @param entero i indice a partir del cual se recorreran.
   */
  private void recorreChofer(int i){
    int indiceUltimoM = this.obtenerCantidadChofer();
    if(i != indiceUltimoM){
      this.chofer[i] = chofer[indiceUltimoM];
      chofer[indiceUltimoM] = null;
    }
  }

  /**
   * Método que asigna el arreglo de duenos al auto actual.
   * @param arreglo de duenos a asignar.
   */
  public void setDueno(Dueno[] dueno) {
    this.dueno = dueno;
  }


  /**
   * Método que asigna el arreglo de choferes al auto actual.
   * @param arreglo de choferes a asignar.
   */
  public void setChofer(Chofer chofer[]) {
    this.chofer = chofer;
  }

}
