package cl.uchile.dcc
package gwent.Componentes.Observador

trait Observador [T]{
  def actualizar(objeto: T): Unit
}
