package cl.uchile.dcc
package gwent.Componentes.Cartas

import gwent.Componentes.Tablero.Tablero
/**
 *Una carta esta definida con un nombre y una tipo 
 *
 * @param nombre es el nombre de la carta
 * @param tipo es el tipo de la carta: unidad o clima
 * @constructor Crea una carta con un nombre y que tipo
 *
 * @example
 * {{{
 * val carta = new Carta("Barbaro","Unidad")
 * val tipo = carta.Tipo
 * println("El tipo de la carta es:" + tipo)
 * }}}
 *
 * @author Alexis Morales
 */
trait Carta extends Equals{
  val Nombre: String
  val Descripcion: String

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Carta]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Carta]
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
    result = prime * result + classOf[Carta].##
    result = prime * result + Nombre.##
    result = prime * result + Descripcion.##
    result
  }
  def jugar(tablero: Tablero): Unit = Unit
}
