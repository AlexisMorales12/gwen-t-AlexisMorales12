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
abstract class CartaUnidadAbstracta protected(val Nombre: String ,val Descripcion: String, val Fuerza: Int) extends Carta{
  var _FuerzaModificada: Int = Fuerza
  def FuerzaActual: Int = _FuerzaModificada

  def FuerzaModificada_(NuevaFuerza: Int): Unit = {
    _FuerzaModificada = NuevaFuerza
  }
  def refuerzo_moral(): Unit = {
    FuerzaModificada_(FuerzaActual + 1)
  }
  def vinculo_estrecho(): Unit = {
    FuerzaModificada_(FuerzaActual + 2)
  }
  override def canEqual(that: Any): Boolean = that.isInstanceOf[CartaUnidadAbstracta]


  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CartaUnidadAbstracta]
      (this eq other) ||
        (this.Nombre == other.Nombre && this.Descripcion == other.Descripcion )
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
    result
  }
}
