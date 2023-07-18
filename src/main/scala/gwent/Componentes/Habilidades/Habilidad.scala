package cl.uchile.dcc
package gwent.Componentes.Habilidades

import gwent.Componentes.Cartas.CartaUnidadAbstracta

/**
 * Es el trait que representa a las habilidades
 */
trait Habilidad {
  /** Activa la habilidad de una carta de unidad
   * 
   * @param fila es la fila a la que se aplicara el efecto de la habilidad
   * @param nombre es el nombre de la carta que tiene la habilidad
   */
  def activar_habilidad(fila: List[CartaUnidadAbstracta], nombre: String): Unit 
}
