package cl.uchile.dcc
package gwent.Componentes.Jugador

import gwent.Componentes.Cartas.*
import gwent.Componentes.Tablero.Tablero

import scala.::

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
class Jugador (nombre: String, seccion: String) extends Equals {
  val Nombre: String = nombre
  val Seccion: String = seccion
  var Gemas: Int = 2
  var Mazo: List[Carta] = List(new CartaUnidadCuerpoACuerpo("Barbaro"," ", 2),new CartaUnidadCuerpoACuerpo("Capitan","Refuerzo Moral", 4),new CartaUnidadCuerpoACuerpo("Barbaro","Vínculo Estrecho", 2),
                               new CartaUnidadDeAsedio("Catapulta"," ", 2), new CartaUnidadDeAsedio("Ariete","Refuerzo Moral", 4), new CartaUnidadDeAsedio("Catapulta","Vínculo Estrecho", 2),
                               new CartaUnidadADistancia("Arquero", " ", 2), new CartaUnidadADistancia("Ballestero", "Refuerzo Moral", 4), new CartaUnidadADistancia("Arquero","Vínculo Estrecho", 2),
                               new CartaClimaEscarchaMordiente, new CartaClimaCieloDespejado, new CartaClimaNieblaImpenetrable ,new CartaClimaLluviaTorrencial)
  var Mano: List[Carta] = List()

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Jugador]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Jugador]
      (this eq other) ||
        (this.Nombre == other.Nombre && this.Seccion == other.Seccion && this.Mazo == other.Mazo && this.Mano == other.Mano)
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
    result = prime * result + Seccion.##
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
   * println("La cantidad de cartas en el mazo es:" + jugador.Mazo.size)
   * jugador.robar(jugador,8)
   * println(La cantidad de cartas en la mano es:" + jugador.Mano.soze)
   * }}}
   *
   * @see Acciones
   */
  def robar(obj:Jugador, numero: Int): Unit = {
    if((numero > 0) && (obj.Mazo.length - numero >= 0)){
      val (cartas_sacadas,restantes) = obj.Mazo.splitAt(numero)
      obj.Mano = obj.Mano ++ cartas_sacadas
      obj.Mazo = restantes
    }
  }

  /**
   * Juega una carta de la mano
   *
   * @param obj el jugador que ejecutara la accion
   * @param numero la posicion de la carta que se jugara
   * @param tablero el tablero donde se jugara la carta
   * @throws No se ejecuta si la mano no tiene cartas
   *
   * @example
   * {{{
   * val jugador = new Jugador("John","Norte")
   * val tablero = new Tablero
   * println("La cantidad de cartas en la mano es:" + jugador.Mano.size)
   * jugador.robar(jugador,10)
   * jugador.jugar(jugador,3,tablero)
   * println(La cantidad de cartas en el mazo es:" + jugador.Mano.size)
   * }}}
   */
   def jugar(obj: Jugador, numero: Int,tablero: Tablero): Unit = {
    if(obj.Mano.nonEmpty && (numero > 0 && numero <= obj.Mano.size)){
      obj.Mano(numero-1).jugar(tablero)
      obj.Mano = obj.Mano.filterNot(_ == obj.Mano(numero-1))
    }
  }
  def perder_ronda(obj: Jugador): Unit = {
    if(obj.Gemas > 0) {
      obj.Gemas -= 1
      /**if(obj.Gemas == 0){
        obj.perder_partida()
      }**/
    }

  }
}
