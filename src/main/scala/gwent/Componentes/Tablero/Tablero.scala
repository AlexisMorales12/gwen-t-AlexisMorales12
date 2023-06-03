package cl.uchile.dcc
package gwent.Componentes.Tablero

import gwent.Componentes.Jugador.Jugador
import gwent.Componentes.Cartas.*


/**Es el tablero donde los jugadores invocaron las cartas, la cual cuenta con las respectivas zonas en las
 * que se ubicaran las diferentes cartas
 *
 */
class Tablero {
  var zona_cuerpo_a_cuerpo : List[CartaUnidadCuerpoACuerpo] = List()
  var zona_a_distancia : List[CartaUnidadADistancia] = List()
  var zona_de_asedio : List[CartaUnidadDeAsedio] = List()
  var zona_clima: CartaClimaAbstracta = new CartaClimaCieloDespejado
  var zona_cuerpo_a_cuerpo_pc: List[CartaUnidadCuerpoACuerpo] = List()
  var zona_a_distancia_pc: List[CartaUnidadADistancia] = List()
  var zona_de_asedio_pc: List[CartaUnidadDeAsedio] = List()
}
