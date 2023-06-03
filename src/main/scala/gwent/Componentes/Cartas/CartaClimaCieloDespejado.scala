package cl.uchile.dcc
package gwent.Componentes.Cartas
import gwent.Componentes.Tablero.Tablero

/**Es el constructor de la carta clima Cielo Despejado, la cual no afecta ninguna de las lineas de cartas
 * en el tablero
 *  
 * @constructor Crea una carta de clima Cielo Despejado
 * @example
 * {{{
 * val carta = new CartaClimaCieloDespejado
 * val descripcion = carta.Descripcion
 * println("La habilidad de la carta de clima es:" + descripcion)
 * }}}
 *
 * @see CartaClimaAbstracta
 * @author Alexis Morales
 */
class CartaClimaCieloDespejado extends CartaClimaAbstracta("Clima despejado", "Elimina todos los efectos climáticos actualmente en efecto en el campo de batalla") {
  /**Añade la carta clima Cielo Despejado a la zona de clima y genera los efectos de esta
   * 
   * @param tablero es el tablero donde se jugara la carta
   */
  override def jugar(tablero: Tablero): Unit = {
    val clima_previo = tablero.zona_clima
    tablero.zona_clima = new CartaClimaCieloDespejado()
    clima_previo.salida_de_clima(tablero)
  }

  /**La salida de este clima no produce nada, ya que, esta carta no afecta a las lineas de cartas en el
   * tablero
   * 
   * @param tablero es el tablero de donde es retirado el clima
   */
  override def salida_de_clima(tablero:Tablero): Unit = {
    return
  }
}
