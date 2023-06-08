package cl.uchile.dcc
package gwent.Componentes.Cartas

import gwent.Componentes.Tablero.Tablero
/**Es el constructor de la carta clima Niebla Impenetrable, la cual afecta a las cartas ubicadas en al zona de
 * combate a distancia
 *
 * @constructor Crea una carta de clima Niebla Impenetrable
 * @example
 * {{{
 * val carta = new CartaNieblaImpenetrable
 * val descripcion = carta.Descripcion
 * println("La habilidad de la carta de clima es:" + descripcion)
 * }}}
 *
 * @see CartaClimaAbstracta
 * @author Alexis Morales
 */
class CartaClimaNieblaImpenetrable extends CartaClimaAbstracta("Niebla Impenetrable", "Establece el valor de fuerza de todas las cartas de combate a distancia a 1"){
  /** Añade la carta clima Niebla Impenetrable a la zona de clima y genera los efectos de esta
   *
   * @param tablero es el tablero donde se jugara la carta
   */
  override def jugar(tablero: Tablero): Unit = {
    val clima_previo = tablero.zona_clima
    tablero.zona_clima = new CartaClimaNieblaImpenetrable
    clima_previo.salida_de_clima(tablero)
    for (elemento <- tablero.zona_a_distancia) {
      elemento.entrada_clima()
      elemento.FuerzaModificada_(elemento.obtener_FuerzaReal())
    }
    for (elemento <- tablero.zona_a_distancia_pc) {
      elemento.entrada_clima()
      elemento.FuerzaModificada_(elemento.obtener_FuerzaReal())
    }
  }

  /** La salida este clima le devuelve la fuerza a las cartas ubicadas en la zona de combate a distancia
   *
   * @param tablero es el tablero de donde es retirado el clima
   */
  override def salida_de_clima(tablero: Tablero): Unit = {
    for (elemento <- tablero.zona_a_distancia) {
      elemento.salida_clima()
      elemento.FuerzaModificada_(elemento.obtener_FuerzaReal())
    }
    for (elemento <- tablero.zona_a_distancia_pc) {
      elemento.salida_clima()
      elemento.FuerzaModificada_(elemento.obtener_FuerzaReal())
    }
  }
}
