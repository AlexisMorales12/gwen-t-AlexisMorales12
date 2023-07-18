package cl.uchile.dcc
package gwent.Componentes.Cartas

import gwent.Componentes.Tablero.Tablero

import cl.uchile.dcc.gwent.Componentes.Jugador.Jugador
/**Es el constructor de la carta clima Escarcha Mordiente, la cual afecta a las cartas ubicadas en al zona de
 * combate cuerpo a cuerpo
 *
 * @constructor Crea una carta de clima Escarcha Mordiente
 * @example
 * {{{
 * val carta = new CartaClimaEscarchaMordiente
 * val descripcion = carta.Descripcion
 * println("La habilidad de la carta de clima es:" + descripcion)
 * }}}
 *
 * @see CartaClimaAbstracta
 * @author Alexis Morales
 */
class CartaClimaEscarchaMordiente extends CartaClimaAbstracta("Escarcha Mordiente", "Establece el valor de fuerza de todas las cartas de combate cuerpo a cuerpo en 1") {
  /**Añade la carta clima Escarcha Mordiente a la zona de clima y genera los efectos de esta
   *
   * @param jugador  es el jugador
   * @param oponente es el oponente del jugador
   */
  override def jugar(jugador: Jugador, oponente: Jugador): Unit = {
    juego(jugador,oponente)
    invocar(jugador.Zona_cuerpo_a_cuerpo)
    invocar(oponente.Zona_cuerpo_a_cuerpo)
  }

  /** La salida este clima le devuelve la fuerza a las cartas ubicadas en la zona de combate cuerpo a cuerpo
   *
   * @param jugador es el jugador al que afectara
   */
  override def desinvocar_clima(jugador: Jugador): Unit = {
    salida_de_clima(jugador.Zona_cuerpo_a_cuerpo)
  }
}
