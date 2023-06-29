package cl.uchile.dcc
package gwent.Componentes.Cartas

import gwent.Componentes.Cartas.Carta

/**
 *Una version generica de las cartas de unidad que estan definidas con un Nombre, una Descripcion y Fuerza
 *
 * @param Nombre es el nombre de la carta
 * @param Descripcion es la descripcion de la carta
 * @param Fuerza es la fuerza de la carta
 *
 *
 * @see Carta
 * @author Alexis Morales
 */
abstract class CartaUnidadAbstracta protected(val Nombre: String ,val Descripcion: String, val Fuerza: Int) extends Carta{
  private var _FuerzaModificada: Int = Fuerza
  private var _FuerzaModificadaReal: Int = Fuerza
  private var _Clima: Boolean = false
  private var observadores: List[Observador] = List()

  def agregarObservador(observador: Observador): Unit = {
    observadores = observador :: observadores
  }

  def eliminarObservador(observador: Observador): Unit = {
    observadores = observadores.filterNot(_ == observador)
  }

  def notificarObservadores(): Unit = {
    observadores.foreach(_.actualizar(this))
  }
  /**
   *
   * @return la fuerza actual la carta afectada por climas
   */
  private def FuerzaActual: Int = _FuerzaModificada

  /**
   *
   * @return la fuerza actual de la carta sin modificador de clima
   */
  private def FuerzaReal: Int = _FuerzaModificadaReal

  /**
   *
   * @return booleano que representa si hay un clima que afecta a esta carta
   */
  private def Clima : Boolean = _Clima

  /**Establece la fuerza de la carta
   *
   * @param NuevaFuerza es la fuerza que tendra la carta a la hora del calculo de fuerza
   */
  def FuerzaModificada_(NuevaFuerza: Int): Unit = {
    _FuerzaModificada = NuevaFuerza
    if(Clima){
      _FuerzaModificada = 1
    }
  }

  /**Es el calculo de fuerza con los modificadores sin el clima
   *
   * @param NuevaFuerza es la fuerza que tendra la carta sin incluir los efectos de clima
   */
  def FuerzaModificadaReal_(NuevaFuerza: Int): Unit = {
    _FuerzaModificadaReal = NuevaFuerza
  }

  /**Representa la entrada de un clima que afecta a la carta
   *
   */
  def entrada_clima(): Unit = {
    _Clima = true
    FuerzaModificada_(obtener_FuerzaReal())
  }

  /**Representa la salidad de un clima que afecta a la carta
   *
   */
  def salida_clima(): Unit = {
    _Clima = false
    FuerzaModificada_(obtener_FuerzaReal())
  }

  /**Permite obtener la fuerza de la carta incluido el modificador de clima
   *
   * @return la fuerza actual de la carta con modificador de clima
   */
  def obtener_Fuerza(): Int = {
    return FuerzaActual
  }
  /** Permite obtener la fuerza de la carta sin el modificador de clima
   *
   * @return la fuerza actual de la carta sin modificador de clima
   */
  def obtener_FuerzaReal(): Int = {
    return FuerzaReal
  }
  override def canEqual(that: Any): Boolean = that.isInstanceOf[CartaUnidadAbstracta]


  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CartaUnidadAbstracta]
      (this eq other) ||
        (this.Nombre == other.Nombre && this.Descripcion == other.Descripcion && this.Fuerza == other.Fuerza)
    }
    else {
      false
    }
  }
  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + classOf[CartaUnidadAbstracta].##
    result = prime * result + Nombre.##
    result = prime * result + Descripcion.##
    result = prime * result + Fuerza.##
    result
  }
}