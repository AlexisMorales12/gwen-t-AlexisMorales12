package cl.uchile.dcc
package gwent.Componentes.Jugador

import gwent.Componentes.Cartas.*
import gwent.Componentes.Tablero.{Tablero, Zona, Zona_clima}
import gwent.Componentes.Observador.{GestorJugador, Observador}

import cl.uchile.dcc.gwent.Componentes.Habilidades.{NullHabilidad, RefuerzoMoral, VinculoEstrecho}

import scala.::

/**
 * Un jugador esta definido con un nombre y una seccion del tablero
 *
 * @param nombre el nombre del jugador
 * @param seccion la seccion del tablero que le corresponde
 * @param gestorJugador es el gestor del jugador y medio de comunicaion con el controlador
 * @constructor Crea un jugador con un nombre y que tiene asignado una seccion y un gestor
 *
 * @example
 * {{{
 * val jugador = new Jugador("John","Norte", new GestorJugador(controller))
 * val seccion = jugador.Seccion
 * println("La seccion del tablero es:" + seccion)
 * }}}
 *
 * @author Alexis Morales
 */
class Jugador (nombre: String, seccion: String,gestorJugador: GestorJugador) extends Equals with Observador {
  val Nombre: String = nombre
  val Seccion: String = seccion
  val GestorJugador: GestorJugador = gestorJugador
  var Zona_cuerpo_a_cuerpo: Zona[CartaUnidadCuerpoACuerpo] = new Zona[CartaUnidadCuerpoACuerpo]
  var Zona_de_asedio: Zona[CartaUnidadDeAsedio] = new Zona[CartaUnidadDeAsedio]
  var Zona_a_distancia: Zona[CartaUnidadADistancia] = new Zona[CartaUnidadADistancia]
  var Zona_clima: Zona_clima = new Zona_clima
  private var Gemas: Int = 2

  var Mazo: List[Carta] = List(new CartaUnidadCuerpoACuerpo("Barbaro"," ", 2, new NullHabilidad),new CartaUnidadCuerpoACuerpo("Capitan","Refuerzo Moral", 4, new RefuerzoMoral),new CartaUnidadCuerpoACuerpo("Barbaro","Vínculo Estrecho", 2, new VinculoEstrecho),
                               new CartaUnidadDeAsedio("Catapulta"," ", 2, new NullHabilidad), new CartaUnidadDeAsedio("Ariete","Refuerzo Moral", 4, new RefuerzoMoral), new CartaUnidadDeAsedio("Catapulta","Vínculo Estrecho", 2, new VinculoEstrecho),
                               new CartaUnidadADistancia("Arquero", " ", 2, new NullHabilidad), new CartaUnidadADistancia("Ballestero", "Refuerzo Moral", 4, new RefuerzoMoral), new CartaUnidadADistancia("Arquero","Vínculo Estrecho", 2, new VinculoEstrecho),
                               new CartaClimaEscarchaMordiente, new CartaClimaCieloDespejado, new CartaClimaNieblaImpenetrable ,new CartaClimaLluviaTorrencial)
  var Mano: List[Carta] = List()

  /**
   * Notifica al gestor del jugador que se acabaron las gemas
   */
  def gemasAgotadas(): Unit = {
    gestorJugador.notificarGemasAgotadas(this)
  }

  /**Verifica que las gemas no se hayan acabado
   *
   */
  def actualizar(): Unit = {
    if (getAtributo == 0) {
      gemasAgotadas()
    }
  }

  /** Entrega la gemas del jugador
   *
   * @return devuelve las gemas del jugador
   */
  def getAtributo: Int = Gemas
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
   * @param numero la cantidad de cartas que hay en el mazo
   * @throws No se ejecuta si el numero de cartas que se intenta robar es mayor a la que posee el mazo
   *
   * @example
   * {{{
   * val jugador = new Jugador("John","Norte", new GestorJugador)
   * println("La cantidad de cartas en el mazo es:" + jugador.Mazo.size)
   * jugador.robar(jugador,8)
   * println(La cantidad de cartas en la mano es:" + jugador.Mano.soze)
   * }}}
   *
   */
  def robar(numero: Int): Unit = {
    if((numero > 0) && (Mazo.length - numero >= 0)){
      val (cartas_sacadas,restantes) = Mazo.splitAt(numero)
      Mano = Mano ++ cartas_sacadas
      Mazo = restantes
    }
  }

  /**
   * Juega una carta de la mano
   *
   * @param oponente es el oponente
   * @param numero la posicion de la carta que se jugara
   * @throws No se ejecuta si la mano no tiene cartas
   *
   * @example
   * {{{
   * val jugador: Jugador  = new Jugador("John","Norte", new GestorJugador)
   * val oponente: Jugador = new Jugador("John","Norte", new GestorJugador)
   * println("La cantidad de cartas en la mano es:" + jugador.Mano.size)
   * jugador.robar(oponente,10)
   * jugador.jugar(oponente,3)
   * println(La cantidad de cartas en el mazo es:" + jugador.Mano.size)
   * }}}
   */
   def jugar(oponente: Jugador, numero: Int): Unit = {
    if(this.Mano.nonEmpty && (numero > 0 && numero <= this.Mano.size)){
      this.Mano(numero-1).jugar(this,oponente)
      this.Mano = this.Mano.filterNot(_ == this.Mano(numero-1))
    }
  }

  /**
   * Es la funcion que se ejecuta cuando un jugador pierde una ronda
   *
   * * @example
   * {{{
   * val jugador: Jugador  = new Jugador("John","Norte", new GestorJugador)
   * jugador.perder_rondar()
   * }}}
   */
  def perder_ronda(): Unit = {
    if(Gemas > 0) {
      Gemas -= 1
    }
    actualizar()
  }
}
