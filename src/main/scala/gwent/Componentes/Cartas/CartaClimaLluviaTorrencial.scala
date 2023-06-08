package cl.uchile.dcc
package gwent.Componentes.Cartas

import gwent.Componentes.Tablero.Tablero
/**Es el constructor de la carta clima Lluvia Torrencial, la cual afecta a las cartas ubicadas en al zona de
 * asedio
 *
 * @constructor Crea una carta de clima Lluvia Torrencial
 * @example
 * {{{
 * val carta = new CartaClimaLluviaTorrencial
 * val descripcion = carta.Descripcion
 * println("La habilidad de la carta de clima es:" + descripcion)
 * }}}
 *
 * @see CartaClimaAbstracta
 * @author Alexis Morales
 */
class CartaClimaLluviaTorrencial extends CartaClimaAbstracta("Lluvia torrencial", "Establece el valor de todas las cartas de asedio a 1"){
  /** Añade la carta clima Lluvia Torrencial a la zona de clima y genera los efectos de esta
   *
   * @param tablero es el tablero donde se jugara la carta
   */
  override def jugar(tablero: Tablero): Unit = {
    val clima_previo = tablero.zona_clima
    tablero.zona_clima = new CartaClimaLluviaTorrencial
    clima_previo.salida_de_clima(tablero)
    for (elemento <- tablero.zona_de_asedio) {
      elemento.entrada_clima()
      elemento.FuerzaModificada_(elemento.obtener_FuerzaReal())
    }
    for (elemento <- tablero.zona_de_asedio_pc) {
      elemento.entrada_clima()
      elemento.FuerzaModificada_(elemento.obtener_FuerzaReal())
    }
  }

  /** La salida este clima le devuelve la fuerza a las cartas ubicadas en la zona de asedio
   *
   * @param tablero es el tablero de donde es retirado el clima
   */
  override def salida_de_clima(tablero: Tablero): Unit = {
    for (elemento <- tablero.zona_de_asedio) {
      elemento.salida_clima()
      elemento.FuerzaModificada_(elemento.obtener_FuerzaReal())
    }
    for (elemento <- tablero.zona_de_asedio_pc) {
      elemento.salida_clima()
      elemento.FuerzaModificada_(elemento.obtener_FuerzaReal())
    }
  }
}
