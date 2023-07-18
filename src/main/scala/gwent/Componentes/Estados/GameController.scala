package cl.uchile.dcc
package gwent.Componentes.Estados

import gwent.Componentes.Estados.*
import gwent.Componentes.Jugador.Jugador
import gwent.Componentes.Observador.{GestorJugador, Observador}
/**
 * Es el controlador del juego
 *
 * @constructor es el controlador que administra los estados del juego
 *
 * @example
 * {{{
 * val controlador: GameController = new GameController
 * }}}
 *
 * @author Alexis Morales
 */
class GameController {
  private var estado: GameState = new Barajar
  val jugador_1: Jugador = new Jugador("John","North", new GestorJugador(this))
  val jugador_2: Jugador = new Jugador("Alicia","South", new GestorJugador(this))
  private var ronda: Int = 1
  var pasar_1:Boolean = false
  var pasar_2:Boolean = false

  /** Entrega el estado actual del juego
   *
   * @return entrega el estado en el que se encuentra el juego
   */
  def get_estado(): GameState = estado

  /**Entrega la ronda actual del juego
   *
   * @return ronda actual
   */
  def get_ronda(): Int = ronda

  /**Pasa a la siguiente ronda
   */
  def aumentar_ronda(): Unit = {
    ronda += 1
  }
  private var observadores: List[Observador] = List()

  /** Agrega objetos que seran observados en este caso jugadores
   *
   * @param observador seran observados para ver si finaliza el juego
   */
  private def agregarObservador(observador: Observador): Unit = {
    observadores = observador :: observadores
  }
  agregarObservador(jugador_1)
  agregarObservador(jugador_2)

  /**Se eliminan objetos que estaban siendo observados
   *
   * @param observador observador que sera eliminado de la lista de observados
   */
  private def eliminarObservado(observador: Observador): Unit = {
    observadores = observadores.filter(_ != observador)
  }

  /**Indica el final del juego
   *
   * @param jugador el jugador al que se le acabaron las gemas
   */
  def gemasAgotadas(jugador: Jugador): Unit = {
    print(jugador.Nombre + " perdio\n")
    for(elemento <- observadores) {
      this.eliminarObservado(elemento)
    }
  }

  /**Setea el estado actual del juego
   *
   * @param gameState estado en el que se encuentra el juego
   */
  def setState(gameState: GameState): Unit = {
    estado = gameState
  }

  /**Los siguientes metodos dependen del estado del juego, pero
   * se dara una descripcion de cuando estan activos
   */

  /**Baraja las cartas de los jugadores
   */
  def barajar(): Unit = estado.barajar(this)
  /**Los jugadores roban cartas
   */
  def robar(): Unit = estado.robar(this)
  /**Turno del jugador 1
   */
  def juega_jugador1(): Unit = estado.juega_jugador1(this)
  /**Turno del jugador 2
   */
  def juega_jugador2(): Unit = estado.juega_jugador2(this)
  /**Limpia las filas de los jugadores
   */
  def limpieza(): Unit = estado.limpieza(this)
  /**Indica que un jugador paso
   */
  def pasar(): Unit = estado.pasar(this)
  /**Define el turno del jugador 1
   *
   * @return entrega un booleano que indica si esta jugando
   */
  def turno_jugador1(): Boolean = estado.turno_jugador_1()
  /** Define el turno del jugador 2
   *
   * @return entrega un booleano que indica si esta jugando
   */
  def turno_jugador2(): Boolean = estado.turno_jugador_2()
}
