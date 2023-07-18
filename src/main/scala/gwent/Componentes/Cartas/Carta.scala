package cl.uchile.dcc
package gwent.Componentes.Cartas

import gwent.Componentes.Tablero.Tablero
import gwent.Componentes.Jugador.Jugador
/** Trait representing a card in the Gwen't game.
 *
 * A card is characterized by its [[Nombre]] and [[Descripcion]].
 * This trait serves as a common interface for all card types and ensures that every card,
 * regardless of its specific subtype, will have these basic properties.
 *
 * The ``val`` keyword in the property declarations indicates that these properties are
 * immutable -- once a card has been created with a certain name and description, these
 * cannot be changed.
 * This reflects the real-world behaviour of game cards, which have fixed names and
 * descriptions printed on them.
 *
 * The actual content of these properties, as well as any additional properties or
 * behaviours, are to be defined in the concrete classes that extend this trait.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~YOUR NAME~
 * @version 1.1
 * @since 1.0
 */
trait Carta extends Equals{
  val Nombre: String
  val Descripcion: String

  /** Permite jugar una carta en el tablero de juego
   *  Esta añade las cartas jugadas a su espacio asignado en el tablero
   *
   * @param tablero es el tablero donde se jugara la carta
   */
  def jugar(jugador: Jugador,oponente: Jugador): Unit
}
