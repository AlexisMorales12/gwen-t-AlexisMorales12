package cl.uchile.dcc
package gwent.Componentes.Jugador

import gwent.Componentes.Cartas.Carta
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
class Jugador (nombre: String, seccion: String) extends Acciones with Equals with Carta{
  val Nombre: String = nombre
  val Seccion: String = seccion
  var Gemas: Int = 25
  var Mazo: List[Carta] = List()
  var Mano: List[Carta] = List()

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Jugador]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Jugador]
      (this eq other) ||
        (this.Nombre == other.Nombre && this.Gemas == other.Gemas && this.Seccion == other.Seccion && this.Mazo == other.Mazo && this.Mano == other.Mano)
    }
    else{
      false
    }
  }

  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + classOf[Jugador].##
    result = prime * result + Nombre.##
    result = prime * result + Gemas.##
    result = prime * result + Seccion.##
    result = prime * result + Mazo.##
    result = prime * result + Mano.##
    result
  }
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
    while ((obj.Mazo.nonEmpty) || ( numero > 0)){
      obj.Mano = obj.Mano :: obj.Mazo.head
      obj.Mazo = obj.Mazo.tail
      numero = numero - 1
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
  override def jugar(obj: Jugador, numero: Int,tablero: Tablero): Unit = {
    if(obj.Mano.nonEmpty){
      obj.Mano(numero+1).jugar(tablero)
      tablero.jugador_jugo(obj)
    }
  }
}
