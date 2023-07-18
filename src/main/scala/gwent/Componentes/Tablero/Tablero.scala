package cl.uchile.dcc
package gwent.Componentes.Tablero

import gwent.Componentes.Cartas.Carta


/** Es el trait que representa las distintas zonas del tablero
 * 
 */
trait Tablero {
  def jugar(carta: Carta): Unit
}
