package cl.uchile.dcc
package gwent.Componentes.Observador

trait Observador {
  def actualizar(carta: Carta): Unit
}
