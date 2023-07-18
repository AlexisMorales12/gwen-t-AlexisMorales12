package cl.uchile.dcc
package gwent.Componentes.Habilidades

import gwent.Componentes.Cartas.CartaUnidadAbstracta

/**
 * Esta la habilidad que no hace nada
 *
 * @constructor crea la habilidad nula
 * @example
 * {{{
 * val habilidad: NullHabilidad = new NullHabilidad
 * }}}
 *
 * @author Alexis Morales
 */
class NullHabilidad extends Habilidad {
  /**
   * Esta clase no tiene ninguna habilidad
   * 
   * @param fila es la fila a la que se aplicara el efecto de la habilidad
   * @param nombre es el nombre de la carta que tiene la habilidad
   */
  override def activar_habilidad(fila: List[CartaUnidadAbstracta], nombre: String): Unit = {
  }
}
