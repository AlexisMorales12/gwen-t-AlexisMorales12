package cl.uchile.dcc
package gwent.Componentes.Estados

import gwent.Componentes.Tablero
import gwent.Componentes.Estados.Estado_Actual
class Estado {
  private var estado_actual: Option[Estado_Actual] = None
  private var ronda: Int = 1
  private var jugador_1: Jugador = new Jugador("Player", "North")
  private var jugador_2: Pc = new Pc("Computer", "South")
  private var jugador_1_en_batalla: Boolean = true
  private var jugador_2_en_batalla: Boolean = true
  val tablero: Tablero = new Tablero
  protected def setEstadoActual(estado_actual: Estado_Actual, estado: Estado_Actual): Unit ={
    estado_actual.setEstado(estado)
  }
  protected def cambiarEstado(estado: Estado): Unit = {
    if(estado_actual.isDefined){
      estado_actual.get.setEstadoActual(estado)
    }
  }
  def error() = throw new AssertionError("Estado Erroneo")

  def barajar(estado_actual: Estado_Actual): Unit = error()
  def juega_jugador_1(estado_actual: Estado_Actual): Unit = error()
  def juega_jugador_2(estado_actual: Estado_Actual): Unit = error()
  def limpieza(estado_actual: Estado_Actual): Unit = error()
}
