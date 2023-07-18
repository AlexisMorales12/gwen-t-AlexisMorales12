package cl.uchile.dcc
package gwent.Componentes.Cartas
import gwent.Componentes.Tablero.Tablero

import cl.uchile.dcc.gwent.Componentes.Jugador.Jugador

/**Es el constructor de la carta clima Cielo Despejado, la cual no afecta ninguna de las lineas de cartas
 * en el tablero
 *  
 * @constructor Crea una carta de clima Cielo Despejado
 * @example
 * {{{
 * val carta = new CartaClimaCieloDespejado
 * val descripcion = carta.Descripcion
 * println("La habilidad de la carta de clima es:" + descripcion)
 * }}}
 *
 * @see CartaClimaAbstracta
 * @author Alexis Morales
 */
class CartaClimaCieloDespejado extends CartaClimaAbstracta("Clima despejado", "Elimina todos los efectos climáticos actualmente en efecto en el campo de batalla") {
  /**Añade la carta clima Cielo Despejado a la zona de clima y genera los efectos de esta
   * 
   * @param jugador es el jugador
   * @param oponente es el oponente del jugador
   */
  override def jugar(jugador: Jugador,oponente:Jugador): Unit = {
    juego(jugador,oponente)
  }

  /**La salida de este clima no produce nada, ya que, esta carta no afecta a las lineas de cartas en el
   * tablero
   * 
   * @param jugador es el jugador al que afectara
   */
  override def desinvocar_clima(jugador: Jugador): Unit = {
  }
}
