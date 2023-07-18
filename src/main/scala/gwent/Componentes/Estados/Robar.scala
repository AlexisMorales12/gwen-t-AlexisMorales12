package cl.uchile.dcc
package gwent.Componentes.Estados
/**
 * Robar es un posible estado para el GameController y activa ciertas funciones
 * definidas en GameState
 *
 * @constructor crea el estado Robar
 * @example
 * {{{
 * val robar = new Robar
 * }}}
 *
 * @author Alexis Morales
 */
class Robar extends GameState {
  /**
   * Setea el Robar en el GameController y dependiendo de la ronda los jugadores
   * roban cierta cantidad de cartas
   *
   * @param gameController es el controlodar al que se aplicara
   * @example
   * {{{
   * val gamecontroller: GameController = new GameController
   * val roba: Robar = new Robar
   * roba.robar(gamecontroller)
   * }}}
   *
   */
  override def robar(gameController: GameController): Unit = {
    this.changeState(gameController,new Robar)
    if (gameController.get_ronda() == 1) {
      gameController.jugador_1.robar(10)
      gameController.jugador_2.robar(10)
    }
    else{
      gameController.jugador_1.robar(3)
      gameController.jugador_2.robar(3)
    }
  }

  /**
   * Setea el estado Juega_Jugador1 en el GameController
   *
   * @param gameController es el controlodar al que se aplicara
   * @example
   * {{{
   * val gamecontroller: GameController = new GameController
   * val estado: Robar = new Robar
   * estado.juega_jugador1(gamecontroller)
   * }}}
   *
   */
  override def juega_jugador1(gameController: GameController): Unit = this.changeState(gameController,new Juega_Jugador1)
}
