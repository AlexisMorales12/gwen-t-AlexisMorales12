package cl.uchile.dcc
package gwent.Componentes.Cartas

import gwent.Componentes.Tablero.Tablero

import cl.uchile.dcc.gwent.Componentes.Jugador.Jugador
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
   * @param jugador  es el jugador
   * @param oponente es el oponente del jugador
   */
  override def jugar(jugador: Jugador,oponente:Jugador): Unit = {
    juego(jugador,oponente)
    invocar(jugador.Zona_de_asedio)
    invocar(oponente.Zona_de_asedio)
  }

  /** La salida este clima le devuelve la fuerza a las cartas ubicadas en la zona de asedio
   *
   * @param jugador es el jugador al que afectara
   */

  override def desinvocar_clima(jugador: Jugador): Unit = {
    salida_de_clima(jugador.Zona_de_asedio)
  }
}
