/**
 * AutoT.java
 * Clase general que simula un auto identificado como taxi.
 */
public class AutoT{

  //Arreglo que guarda los autos identificados como taxis.
  private Taxi taxi[];
  //Arreglo que guarda a los dueños de los autos.
  private Dueno dueno[];

  /**
   * Constructor del auto.
   */
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

  /**
   * Método que agrega un nuevo taxi al arreglo de taxis.
   * @param taxi a agregar.
   * @throws excepcion en caso de que el limite de taxis se haya alcanzado.
   */
  public void agregaTaxi(Taxi taxi) throws ExcesoChoferException {
    if (!lugarTaxiDisponible()) {
      throw new ExcesoChoferException("Ya no hay espacios disponible para agregar un taxi");
    } else {
      this.taxi[obtenerCantidadTaxi()] = taxi;
    }
  }

  /**
   * Método que agrega los registros de taxi al archivo.
   */
  public void guardaTaxi(){
    ArchivoTaxi archivoT = new ArchivoTaxi();
    archivoT.escribeTaxi(taxi);
  }


  /**
   * Método que indica la cantidad de taxis.
   * @return entero que cuenta a los taxis actuales.
   */
  private int obtenerCantidadTaxi() {
    int cantidad = 0;
    for (Taxi t : taxi) {
      if (t != null) {
        cantidad++;
      }
    }
    return cantidad;
  }

  /**
   * Método que indica si hay lugares disponibles para taxis.
   * @return boolean true si hay lugar disponible, false en otro caso.
   */
  private boolean lugarTaxiDisponible() {
    return obtenerCantidadTaxi() < taxi.length;
  }


  /**
   * Método que convierte el entero correspondiente a la cantidad de taxis a cadena.
   * @return cadena que indica a los taxis actuales.
   */
  public String toStringTaxi() {
    String todosTaxi = "";
    for(int i = 0; i < obtenerCantidadTaxi(); i++){
      todosTaxi += taxi[i] + "\n";
    }
    return todosTaxi;
  }

  /**
   * Método que regresa la lista de taxis.
   * @return cadena con la lista de taxis.
   * @throws excepcion en caso de que no existan taxis actuales.
   */
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

  /**
   * Método que obtiene el arreglo duenos actuales.
   * @return dueno el arreglo de duenos.
   */
  public Dueno[] getDueno() {
    return dueno;
  }
  
  /**
   * Método que obtiene a un taxi segun su identificador.
   * @param entero i identificador del taxi.
   * @return objeto taxi correspondiente al identificador.
   */
  //error al ejecutar
  public Taxi getTaxi(int i) throws ExcesoChoferException{
    if(i < 0 || i >= this.obtenerCantidadTaxi()){
      throw new ExcesoChoferException("taxi seleccionado incorrectamente");
    }
    return this.taxi[i];
  }

  /**
   * Método que elimina a un taxi de los registros.
   * @param entero i correspondiente al identificador del taxi a eliminar.
   */
  public void eliminaTaxi(int i) throws ExcesoChoferException{
    if(i < 0 || i >= this.obtenerCantidadTaxi()){
      throw new ExcesoChoferException("taxi seleccionado incorrectamente");
    }
    this.taxi[i] = null;
    this.recorreTaxi(i);
  }

  /**
   * Método que recorre la informacion en el arreglo.
   * @param entero i indice a partir del cual se recorreran.
   */
  private void recorreTaxi(int i){
    int indiceUltimoT = this.obtenerCantidadTaxi();
    if(i != indiceUltimoT){
      this.taxi[i] = taxi[indiceUltimoT];
      taxi[indiceUltimoT] = null;
    }
  }

  /**
   * Método que asigna el arreglo de duenos al auto actual.
   * @param arreglo de duenos a asignar.
   */
  public void setdueno(Dueno[] dueno) {
    this.dueno = dueno;
  }


  /**
   * Método que asigna el arreglo de taxis a la variable de clase.
   * @param arreglo de taxis a asignar.
   */
  public void setTaxi(Taxi taxi[]) {
    this.taxi = taxi;
  }

}
