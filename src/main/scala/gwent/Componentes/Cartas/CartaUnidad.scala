package cl.uchile.dcc
package gwent.Componentes.Cartas

import gwent.Componentes.Cartas.Carta

/**
 *Una carta de unidad esta definida con un nombre, una clasificacion y una fuerza
 *
 * @param nombre es el nombre de la carta
 * @param clasificacion es la clasificacion de la carta: asedio, cuerpo a cuerpo y rango
 * @param fuerza es la fuerza de la carta
 * @constructor Crea una carta de de unidad con nombre, clasificacion y fuerza
 *
 * @example
 * {{{
 * val cartaunidad = new CartaUnidad("Barbaro","cuerpo a cuerpo",2)
 * val fueza = cartaunidad.Fuerza
 * println("La fuerza de la carta de unidad es:"+ fuerza)
 * }}}
 *
 * @see Carta
 * @author Alexis Morales
 */
class CartaUnidad(nombre: String ,clasificacion: String, fuerza: Int) extends Carta(nombre, "Unidad") {
  val Clasificacion: String = clasificacion
  var Fuerza: Int = fuerza

  override def canEqual(that: Any): Boolean = that.isInstanceOf[CartaUnidad]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CartaUnidad]
      (this eq other) ||
        (this.Nombre == other.Nombre && this.Clasificacion == other.Clasificacion )
    }
    else {
      false
    }
  }
}
