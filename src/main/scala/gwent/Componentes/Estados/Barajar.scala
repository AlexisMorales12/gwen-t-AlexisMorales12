package cl.uchile.dcc
package gwent.Componentes.Estados

import scala.util.Random
import gwent.Componentes.Estados.*
/**
 * Barajar es un posible estado para el GameController y activa ciertas funciones
 * definidas en GameState
 *
 * @constructor crea el estado Barajar
 * @example
 * {{{
 * val barajar = new Barajar
 * }}}
 *
 * @author Alexis Morales
 */
class Barajar extends GameState {

  /**
   * Baraja los manos de ambos jugadores y setea el Barajar en el GameController
   *
   * @param gameController es el controlodar al que se aplicara
   *
   * @example
   * {{{
   * val gamecontroller: GameController = new GameController
   * val baraja: Barajar = new Barajar
   * baraja.barajar(gamecontroller)
   * }}}
   *
   */
  override def barajar(gameController: GameController):Unit = {
    this.changeState(gameController,new Barajar)
    Random.shuffle(gameController.jugador_1.Mazo)
    Random.shuffle(gameController.jugador_2.Mazo)
  }

  /**
   * Setea el Robar en el GameController
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
  override def robar(gameController: GameController): Unit = this.changeState(gameController,new Robar)
}
