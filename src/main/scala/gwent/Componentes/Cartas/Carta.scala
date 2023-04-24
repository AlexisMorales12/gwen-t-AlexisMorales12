package cl.uchile.dcc
package gwent.Componentes.Cartas

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
class Carta(nombre: String , tipo: String) extends Equals{
  val Nombre: String = nombre
  val Tipo: String = tipo

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Carta]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Carta]
      (this eq other) ||
        (this.Nombre == other.Nombre && this.Tipo == other.Tipo)
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
    result = prime * result + Tipo.##
    result
  }
}
