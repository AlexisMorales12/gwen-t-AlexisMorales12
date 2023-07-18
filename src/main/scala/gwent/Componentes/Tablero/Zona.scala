package cl.uchile.dcc
package gwent.Componentes.Tablero

import gwent.Componentes.Jugador.Jugador

import gwent.Componentes.Cartas.{Carta, CartaUnidadAbstracta}

/** Genera una linea donde se ubicaran las cartas unidad de un jugador
 * 
 * @tparam T solo acepta cartas unidad abstractas o sus subclases, aunque se
 *           priorizan estas ultimas
 *           
 * @constructor crea una fila de cartas unidad de un tipo especifico
 * 
 * @example
 * {{{
 * val fila: Zona[CartaUnidadCuerpoACuerpo] = new Zona[CartaUnidadCuerpoACuerp]
 * }}}
 *
 * @author Alexis Morales             
 */
class Zona[T <: CartaUnidadAbstracta] extends TraitZona[T] {
  var zona: List[T] = Nil

  /**Verifica que la carta que se jugara es del tipo correcto asignado en T
   * 
   * @param carta es la carta que se probara a jugar
   */
  override def jugar(carta: Carta): Unit = {
    carta match {
      case cartaU: T => jugarT(cartaU)
      case _ => throw new IllegalArgumentException("Tipo de carta inválido")
    }
  }

  /** Añade una carta a zona
   * 
   * @param carta es la carta que se jugara
   */
  override def jugarT(carta: T): Unit = {
    zona = carta :: zona
  }

  /** Retorna las cartas en zona
   * 
   *  @return retorna una lista de cartas
   */
  override def get(): List[T] = zona

  /**Coloca las cartas en zona
   * 
   * @param cartas son las cartas que se colocaran en la linea
   */
  override def set(cartas: List[T]): Unit = {
    zona = cartas
  }
}