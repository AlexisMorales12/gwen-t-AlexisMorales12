package cl.uchile.dcc
package gwent.Componentes.Observador

class ObservadorGemas {
  def actualizar(jugador: Jugador): Unit = {
    if (jugador.getAtributo <= 0) {
      println("El atributo del jugador ha llegado a cero.")
      // Realizar acciones adicionales según sea necesario
    }
  }
}
