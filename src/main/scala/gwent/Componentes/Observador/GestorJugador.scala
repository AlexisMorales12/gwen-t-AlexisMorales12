package cl.uchile.dcc
package gwent.Componentes.Observador

import gwent.Componentes.Jugador.Jugador
import gwent.Componentes.Estados.GameController

/** Es el gestor del jugador que sirve como medio de comunicacion 
 * con el controller
 * 
 * @param gameController es el controlador con quien se comunicara
 *                       
 * @example
 * {{{
 * val controlador: GestorJugador =  new GestorJugador(controller))
 * }}}
 *
 * @author Alexis Morales
 */

class GestorJugador(gameController: GameController) {
  /** Notifica al controlador que al jugador se le acabaron las gemas
   * 
   * @param jugador es el jugador al que se le acabaron las gemas
   */
  def notificarGemasAgotadas(jugador:Jugador): Unit = {
    gameController.gemasAgotadas(jugador)
  }
}
