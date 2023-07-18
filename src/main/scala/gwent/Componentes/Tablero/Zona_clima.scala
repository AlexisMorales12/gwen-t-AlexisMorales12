package cl.uchile.dcc
package gwent.Componentes.Tablero

import gwent.Componentes.Cartas.{Carta, CartaClimaAbstracta, CartaClimaCieloDespejado, CartaClimaEscarchaMordiente, CartaClimaLluviaTorrencial, CartaClimaNieblaImpenetrable}
import gwent.Componentes.Jugador.Jugador
import scala.::

/** Genera la zona donde se ubicaran los climas
 *
 * @constructor crea la zona clima
 *
 * @example
 * {{{
 * val zona: Zona_clima = new Zona_clima
 * }}}
 *
 * @author Alexis Morales             
 */
class Zona_clima extends Tablero{
  var zona_clima: CartaClimaAbstracta = new CartaClimaCieloDespejado

  /**Setea la carta clima en zona clima
   * 
   * @param carta es la carta clima que se seteara en la zona clima
   */
  def jugarT(carta: CartaClimaAbstracta): Unit = {
    set(carta)
  }

  /**Entrega el clima en zona clima
   * 
   * @return entrega el clima en zona clima
   */
  def get(): CartaClimaAbstracta = zona_clima

  /**Invoca un clima
   * 
   * @param carta es el la carta que se ubicara en zona clima
   */
  def set(carta:CartaClimaAbstracta):Unit = {
    zona_clima = carta
  }

  /**Comprueba que la carta que se jugara es del tipo correcto
   * 
   * @param carta es la carta que se comprobara
   */
  override def jugar(carta: Carta): Unit = {
    carta match {
      case cartaU: CartaClimaAbstracta => jugarT(cartaU)
      case _ => throw new IllegalArgumentException("Tipo de carta inválido")
    }
  }
}
