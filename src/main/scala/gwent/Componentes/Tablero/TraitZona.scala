package cl.uchile.dcc
package gwent.Componentes.Tablero

import gwent.Componentes.Cartas.{Carta, CartaUnidadAbstracta}

/** Representa las secciones del tablero correspondientes a las zonas donde
 * se colocan en las cartas unidades
 * 
 * @tparam U solo acepta cartas unidad abstractas o sus subclases, aunque se
 *           priorizan estas ultimas
 */
trait TraitZona[U<: CartaUnidadAbstracta] extends Tablero{
  /** Juega una carta
   * 
   * @param carta es la carta que se jugara
   */
  def jugarT(carta: U): Unit

  /** Sirve para obtener las cartas de una linea
   * 
   * @return retorna una lista de cartas
   */
  def get(): List[U]

  /** Modifica las cartas una linea colocan otras
   * 
   * @param cartas son las cartas que se colocaran en la linea
   */
  def set(cartas: List[U]): Unit
}
