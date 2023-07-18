package cl.uchile.dcc
package gwent.Componentes.Habilidades

import gwent.Componentes.Cartas.CartaUnidadAbstracta

/**
 * Esta es la habilidad vinculo estrecho
 *
 * @constructor crea la habilidad vinculo estrecho
 * @example
 * {{{
 * val habilidad: VinculoEstrecho = new VinculoEstrecho
 * }}}
 *
 * @author Alexis Morales
 */
class VinculoEstrecho extends Habilidad {
  /** 
   * Activa la habilidad vinculo estrecho
   * 
   * @param fila es la fila a la que se aplicara el efecto de la habilidad
   * @param nombre es el nombre de la carta que tiene la habilidad
   */
  override def activar_habilidad(fila: List[CartaUnidadAbstracta], nombre: String): Unit = {
    for(elemento <- fila){
      if (nombre == elemento.Nombre) {
        elemento.FuerzaModificadaReal_(elemento.obtener_FuerzaReal() * 2)
        elemento.FuerzaModificada_(elemento.obtener_FuerzaReal())
      }
    }
  }
}
