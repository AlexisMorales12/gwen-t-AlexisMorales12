package cl.uchile.dcc
package gwent.Componentes.Estados

import gwent.Componentes.Estados.{GameController,Barajar}
/**
 * Limpiar es un posible estado para el GameController y activa ciertas funciones
 * definidas en GameState
 *
 * @constructor crea el estado Limpiar
 * @example
 * {{{
 * val limpiar = new Limpiar
 * }}}
 *
 * @author Alexis Morales
 */
class Limpiar extends GameState {
  /**
   * Setea el Limpiar en el GameController y aumenta la ronda
   *
   * @param gameController es el controlodar al que se aplicara
   * @example
   * {{{
   * val gamecontroller: GameController = new GameController
   * val limpiar: Limpiar = new Limpiar
   * limpiar.limpieza(gamecontroller)
   * }}}
   *
   */
  override def limpieza(gameController: GameController): Unit = {
    this.changeState(gameController, new Limpiar)
    gameController.aumentar_ronda()
  }

  /**
   * Setea el estado Barajar en el GameController
   *
   * @param gameController es el controlodar al que se aplicara
   * @example
   * {{{
   * val gamecontroller: GameController = new GameController
   * val limpiar: Limpiar = new Limpiar
   * limpiar.barajar(gamecontroller)
   * }}}
   *
   */

  override def barajar(gameController: GameController): Unit = this.changeState(gameController, new Barajar)

}
