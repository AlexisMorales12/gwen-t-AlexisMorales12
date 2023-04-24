package cl.uchile.dcc
package gwent.Componentes.Jugador

import gwent.Componentes.Cartas.CartaUnidad
import gwent.Componentes.Acciones.Acciones

/**
 * Un jugador esta definido con un nombre y una seccion del tablero
 *
 * @param nombre el nombre del jugador
 * @param seccion la seccion del tablero que le corresponde
 * @constructor Crea un jugador con un nombre y que tiene asignado una seccion de tablero
 *
 * @example
 * {{{
 * val jugador = new Jugador("John","Norte")
 * val seccion = jugador.Seccion
 * println("La seccion del tablero es:" + seccion)
 * }}}
 *
 * @author Alexis Morales
 */
class Jugador (nombre: String, seccion: String) extends Acciones{
  val Nombre: String = nombre
  val Seccion: String = seccion
  var Gemas: Int = 25
  var Mazo: Int = 25
  var Mano: Int = 1

  /**
   * Roba una carta del mazo del jugador y la añade a la mano
   *
   * @param obj el jugador que ejecutara la accion
   * @param numero la cantidad de cartas que hay en el mazo
   * @throws No se ejecuta si el numero de cartas que se intenta robar es mayor a la que posee el mazo
   *
   * @example
   * {{{
   * val jugador = new Jugador("John","Norte")
   * println("La cantidad de cartas en el mazo es:" + jugador.Mazo)
   * jugador.robar
   * println(La cantidad de cartas en el mazo es:" + jugador.Mazo)
   * }}}
   *
   * @see Acciones
   */
  override def robar(obj:Jugador, numero: Int): Unit = {
    if ((obj.Mazo-numero)>=0){
      obj.Mazo -= numero
      obj.Mano += numero
    }
  }

  /**
   * Juega una carta de la mano
   *
   * @param obj el jugador que ejecutara la accion
   * @throws No se ejecuta si la mano no tiene cartas
   *            
   * @example
   * {{{
   * val jugador = new Jugador("John","Norte")
   * println("La cantidad de cartas en la mano es:" + jugador.Mano)
   * jugador.jugar
   * println(La cantidad de cartas en el mazo es:" + jugador.Mano)
   * }}}
   * @see Acciones
   */
  override def jugar(obj: Jugador): Unit = {
    if (obj.Mano>0){
      obj.Mano -= 1
    }
  }
}
