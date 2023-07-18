package cl.uchile.dcc
package gwent.Componentes.Estados

import gwent.Componentes.Estados.*
/**
 * Juega_Jugador2 es un posible estado para el GameController y activa ciertas funciones
 * definidas en GameState
 *
 * @constructor crea el estado Juega_Jugador2
 * @example
 * {{{
 * val juega_jugador2 = new Juega_Jugador2
 * }}}
 *
 * @author Alexis Morales
 */
class Juega_Jugador2 extends GameState {
  /**
   * Setea el Juega_Jugador2 en el GameController
   *
   * @param gameController es el controlodar al que se aplicara
   * @example
   * {{{
   * val gamecontroller: GameController = new GameController
   * val jugador: Juega_Jugador2 = new Juega_Jugador2
   * jugador.juega_jugador2(gamecontroller)
   * }}}
   *
   */
  override def juega_jugador2(gameController: GameController): Unit = this.changeState(gameController,new Juega_Jugador2)
  /**
   * Setea el estado Juega_Jugador1 o Limpiar en el GameController, segun 
   *
   * @param gameController es el controlodar al que se aplicara
   * @example
   * {{{
   * val gamecontroller: GameController = new GameController
   * val jugador: Juega_Jugador2 = new Juega_Jugador2
   * jugador.pasar(gamecontroller)
   * }}}
   *
   */
  override def pasar(gameController: GameController): Unit = {
    gameController.pasar_2 = true
    if(gameController.pasar_1){
      this.changeState(gameController, new Limpiar)
    }
    else{
      this.changeState(gameController, new Juega_Jugador1)
    }
  }
  /**
   * Se setea en true turno_jugado2()
   *
   * @example
   * {{{
   * val jugador: Juega_Jugador2 = new Juega_Jugador2
   * jugador.turno_jugador2()
   * }}}
   *
   */
  override def turno_jugador_2(): Boolean = true
}