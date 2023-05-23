package cl.uchile.dcc
package gwent.Componentes.Acciones

import gwent.Componentes.Jugador.Jugador
import gwent.Componentes.Tablero.Tablero
trait Acciones{
  def jugar(obj: Jugador): Unit
  def robar(obj: Jugador, numero: Int, tablero: Tablero): Unit
}
