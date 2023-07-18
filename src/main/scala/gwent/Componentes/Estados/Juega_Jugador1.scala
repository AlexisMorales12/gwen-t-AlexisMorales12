package cl.uchile.dcc
package gwent.Componentes.Estados

import gwent.Componentes.Estados.*
/**
 * Juega_Jugador1 es un posible estado para el GameController y activa ciertas funciones
 * definidas en GameState
 *
 * @constructor crea el estado Juega_Jugador1
 * @example
 * {{{
 * val juega_jugador1 = new Juega_Jugador1
 * }}}
 *
 * @author Alexis Morales
 */
class Juega_Jugador1 extends GameState {
  /**
   * Se setea en true turno_jugado1()
   * @example
   * {{{
   * val jugador: Juega_Jugador1 = new Juega_Jugador1
   * jugador.turno_jugador1()
   * }}}
   *
   */
  override def turno_jugador_1(): Boolean = true

  /**
   * Setea el Juega_Jugador1 en el GameController
   *
   * @param gameController es el controlodar al que se aplicara
   * @example
   * {{{
   * val gamecontroller: GameController = new GameController
   * val jugador: Juega_Jugador1 = new Juega_Jugador1
   * jugador.juega_jugador1(gamecontroller)
   * }}}
   *
   */
  override def juega_jugador1(gameController: GameController): Unit = this.changeState(gameController,new Juega_Jugador1)

  /**
   * Setea el estado Juega_Jugador2 o Limpiar en el GameController, segun 
   *
   * @param gameController es el controlodar al que se aplicara
   * @example
   * {{{
   * val gamecontroller: GameController = new GameController
   * val jugador: Juega_Jugador1 = new Juega_Jugador1
   * jugador.pasar(gamecontroller)
   * }}}
   *
   */
  override def pasar(gameController: GameController): Unit = {
    gameController.pasar_1 = true
    if(gameController.pasar_2){
      this.changeState(gameController, new Limpiar)
    }
    else{
      this.changeState(gameController, new Juega_Jugador2)
    }
  }
  
}
