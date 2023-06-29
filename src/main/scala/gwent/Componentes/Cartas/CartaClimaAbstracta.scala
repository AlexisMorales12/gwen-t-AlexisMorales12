package cl.uchile.dcc
package gwent.Componentes.Cartas

import gwent.Componentes.Cartas.Carta
import gwent.Componentes.Tablero.Tablero

/**
 *  Una version generica de las cartas de clima que estan definidas con un Nombre y una Descripcion
 *
 * @param Nombre es el nombre de la carta
 * @param Descripcion es la descripcion de la habilidad que posee la carta
 * 
 *
 * @see Carta
 * @author Alexis Morales
 */
abstract class CartaClimaAbstracta protected(val Nombre: String, val Descripcion: String)extends Carta{
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
  /** Desencadena los efectos que ocurren sobre las lineas de cartas cuando una carta clima sale
   *  de juego
   * 
   * @param tablero es el tablero de donde es retirado el clima
   */
  def salida_de_clima(tablero: Tablero): Unit
  override def canEqual(that: Any): Boolean = that.isInstanceOf[CartaClimaAbstracta]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CartaClimaAbstracta]
      (this eq other) ||
        (this.Nombre == other.Nombre && this.Descripcion == other.Descripcion)
    }
    else {
      false
    }
  }
  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + classOf[CartaClimaAbstracta].##
    result = prime * result + Nombre.##
    result = prime * result + Descripcion.##
    result
  }
}
