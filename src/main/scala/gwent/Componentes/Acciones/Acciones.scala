package cl.uchile.dcc
package gwent.Componentes.Acciones

import gwent.Componentes.Jugador.Jugador

trait Acciones{
  def jugar(obj: Jugador): Unit
  def robar(obj: Jugador, numero: Int): Unit
}
