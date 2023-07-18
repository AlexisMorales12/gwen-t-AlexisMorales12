package cl.uchile.dcc
package gwent.Componentes.Cartas

import gwent.Componentes.Jugador.Jugador
import gwent.Componentes.Cartas.Carta
import gwent.Componentes.Tablero.{Tablero, Zona,TraitZona}


/**
 *  Una version generica de las cartas de clima que estan definidas con un Nombre y una Descripcion
 *
 * @param Nombre es el nombre de la carta
 * @param Descripcion es la descripcion de la habilidad que posee la carta
 * 
 *
 * @see Carta
 * @author Alexis Morales
 */
abstract class CartaClimaAbstracta protected(val Nombre: String, val Descripcion: String)extends Carta{
  /** Juega una carta clima en ambos jugadores
   * 
   * @param jugador es el jugador al que se le aplicara la carta
   * @param oponente el el oponente del jugador al que se le aplicara la carta
   */
  def juego(jugador: Jugador,oponente:Jugador):Unit = {
    val clima_previo = jugador.Zona_clima.get()
    jugador.Zona_clima.jugar(this)
    oponente.Zona_clima.jugar(this)
    desinvocar(jugador, clima_previo)
    desinvocar(oponente, clima_previo)
  }

  /**Remueve un clima del juego
   * 
   * @param jugador es el jugador al que le afectara la salida del clima
   * @param clima es el clima que saldra de juego
   */
  private def desinvocar(jugador:Jugador, clima:CartaClimaAbstracta): Unit = {
    clima.desinvocar_clima(jugador)
  }

  /** Representa la desinvocacion de un clima
   * 
   * @param jugador es el jugador al que se le aplicara
   */
  def desinvocar_clima(jugador:Jugador): Unit

  /**Representa el efecto al salir un clima sobre una fila
   * 
   * @param zona es la zona donde se aplicara la salida del clima
   * @tparam T solo acepta cartas unidad abstractas o sus subclases, aunque se
   *           priorizan estas ultimas
   */
  def salida_de_clima[T<:CartaUnidadAbstracta](zona:TraitZona[T]): Unit = {
    val cambios = zona.get()
    for (elemento <- cambios) {
      elemento.salida_clima()
      elemento.FuerzaModificada_(elemento.obtener_FuerzaReal())
    }
    zona.set(cambios)
  }

  /** Representa el efecto al entrar un clima sobre una fila
   *
   * @param zona es la zona donde se aplicara la salida del clima
   * @tparam T solo acepta cartas unidad abstractas o sus subclases, aunque se
   *           priorizan estas ultimas
   */
  def invocar[T<:CartaUnidadAbstracta](zona:TraitZona[T]): Unit = {
    val cambios = zona.get()
    for (elemento <- cambios) {
      elemento.entrada_clima()
      elemento.FuerzaModificada_(elemento.obtener_FuerzaReal())
    }
    zona.set(cambios)
  }
  override def canEqual(that: Any): Boolean = that.isInstanceOf[CartaClimaAbstracta]

  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[CartaClimaAbstracta]
      (this eq other) ||
        (this.Nombre == other.Nombre && this.Descripcion == other.Descripcion)
    }
    else {
      false
    }
  }
  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + classOf[CartaClimaAbstracta].##
    result = prime * result + Nombre.##
    result = prime * result + Descripcion.##
    result
  }
}
