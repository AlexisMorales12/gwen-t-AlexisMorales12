package cl.uchile.dcc
package gwent.Componentes.Estados

class Estado_Actual {
  private var estado: Estado = new Barajar()
  estado.setEstadoActual(this)

  def setEstado(aEstado: Estado): Unit = {
    estado = aEstado
  }

  def barajar(): Unit = estado.barajar(this)

  def juega_jugador_1(): Unit = estado.juega_jugador_1(this)

  def juega_jugador_2(): Unit = estado.juega_jugador_2(this)

  def limpieza(): Unit = estado.limpieza(this)
}
