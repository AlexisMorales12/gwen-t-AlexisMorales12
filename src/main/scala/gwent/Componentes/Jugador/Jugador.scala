package cl.uchile.dcc
package gwent.Componentes.Jugador

import gwent.Componentes.Cartas.Mazo
import gwent.Componentes.Cartas.Mano
class Jugador(nombre: String) {
  val Nombre: String = nombre
  var Seccion: String = "Norte"
  var Gemas: Int = 25
  var Mazo: Mazo = new Mazo
  var Mano: Mano = new Mano
}
