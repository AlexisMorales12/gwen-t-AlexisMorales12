package cl.uchile.dcc
package gwent.Componentes.Habilidades
import gwent.Componentes.Cartas.CartaUnidadAbstracta

/**
 * Esta es la habilidad refuerzo moral
 *
 * @constructor crea la habilidad refuerzo moral
 * @example
 * {{{
 * val habilidad: RefuerzoMoral = new RefuerzoMoral
 * }}}
 *
 * @author Alexis Morales
 */
class RefuerzoMoral extends Habilidad {
  /** Aplica el efecto refuerzo moral
   * 
   * @param fila es la fila a la que se aplicara el efecto de la habilidad
   * @param nombre es el nombre de la carta que tiene la habilidad
   */
  override def activar_habilidad(fila: List[CartaUnidadAbstracta], nombre: String): Unit = {
    var contador: Int  = 1
    for (elemento <- fila) {
      if (contador != 1){
        elemento.FuerzaModificadaReal_(elemento.obtener_FuerzaReal() + 1)
        elemento.FuerzaModificada_(elemento.obtener_FuerzaReal())
      }
      contador -= 1
    }
  }
}
