package cl.uchile.dcc
package gwent.Componentes.Observador

/** Es el trait que define al observador
 * 
 */
trait Observador {
  /** Actualiza el estado de las gemas
   */
  def actualizar(): Unit
}
