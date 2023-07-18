package cl.uchile.dcc
package gwent.Componentes.Cartas

import gwent.Componentes.Tablero.Tablero
import gwent.Componentes.Jugador.Jugador
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
   * @param jugador  es el jugador
   * @param oponente es el oponente del jugador
   */
  override def jugar(jugador: Jugador,oponente:Jugador): Unit = {
    juego(jugador,oponente)
    invocar(jugador.Zona_a_distancia)
    invocar(oponente.Zona_a_distancia)
  }

  /** La salida este clima le devuelve la fuerza a las cartas ubicadas en la zona de combate a distancia
   *
   * @param jugador es el jugador al que afectara
   */
  override def desinvocar_clima(jugador: Jugador): Unit = {
    salida_de_clima(jugador.Zona_a_distancia)
  }
}
