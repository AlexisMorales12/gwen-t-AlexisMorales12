package cl.uchile.dcc
package gwent.Componentes.Estados

import gwent.Componentes.Estados.GameController
/**
 * Son los estados del juego
 *
 * @constructor crea la GameState que representa todos lo estados del juego y
 *              que cuenta con todas los metodos que estos modifican
 * 
 * @example
 * {{{
 * val estado: GameState = new GameState
 * }}}
 *
 * @author Alexis Morales
 */
class GameState {
 /** Cambia el estado del controlador
  * 
  * @param gameController es el controlador al que modificara
  * @param gameState es el estado al que cambiara
  */
 protected def changeState(gameController: GameController, gameState: GameState):Unit ={
   gameController.setState(gameState)
 }

 /** Representa un intento infructifero de utilizar metodo que no esta habilitado
  * en algun estado
  * 
  * @return arroja un error
  */
  private def error() = throw new AssertionError("Estado erroneo\n")

 /**baraja los mazos
  * 
  * @param gameController es el controlador al que afectara
  */
  def barajar(gameController: GameController): Unit = error()

 /** Los jugadores roban cartas
  * 
  * @param gameController es el controlador al que afectara
  */
  def robar(gameController: GameController): Unit = error()

 /**Juega el jugador 1
  * 
  * @param gameController es el controlador al que afectara
  */
  def juega_jugador1(gameController: GameController): Unit = error()

 /**Juega el jugador 2
  * 
  * @param gameController es el controlador al que afectara
  */
  def juega_jugador2(gameController: GameController): Unit = error()

 /**Un jugador pasa
  * 
  * @param gameController es el controlador al que afectara
  */
  def pasar(gameController: GameController): Unit = error()

 /** Se reinician las filas de los jugadores
  * 
  * @param gameController es el controlador al que afectara
  */
  def limpieza(gameController: GameController):Unit = error()

 /**Indica si es el turno del jugador 1
  * 
  * @return parte siendo falso, pero segun el estado puede ser verdadero
  */
 def turno_jugador_1(): Boolean = false
 /** Indica si es el turno del jugador 2
  *
  * @return parte siendo falso, pero segun el estado puede ser verdadero
  */

 def turno_jugador_2(): Boolean = false
}
