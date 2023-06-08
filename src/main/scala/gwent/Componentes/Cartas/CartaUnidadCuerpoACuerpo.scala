package cl.uchile.dcc
package gwent.Componentes.Cartas

import gwent.Componentes.Tablero.Tablero

/**Es el constructor de la carta clima unidad cuerpo a cuerpo, la cual cuenta con un nombre, descripcion y
 * fuerza
 *
 * @param Nombre es el nombre de la carta
 * @param Descripcion es la descripcion de la carta
 * @param Fuerza es la fuerza de la carta
 *
 * @constructor Crea una carta de unidad cuerpo a cuerpo con un nombre, descripcion y fuerza
 * @example
 * {{{
 * val cartaunidad = new CartaUnidadCuerpoACuerpo("Barbaro"," ", 2)
 * val fuerza = cartaunidad.obtener_fuerza()
 * println("La fuerza de la carta de unidad es:" + fuerza)
 * }}}
 *
 * @see CartaUnidadAbstracta
 * @author Alexis Morales
 */


class CartaUnidadCuerpoACuerpo(Nombre: String, Descripcion: String, Fuerza: Int)extends CartaUnidadAbstracta(Nombre, Descripcion, Fuerza){
  /**Añade la carta unidad a su respectiva linea y se activan sus habilidades
   * 
   * @param tablero es el tablero donde se jugara la carta
   */
  override def jugar(tablero: Tablero): Unit = {
    if (Descripcion == "Refuerzo Moral") {
      for (elemento <- tablero.zona_cuerpo_a_cuerpo) {
        elemento.FuerzaModificadaReal_(elemento.obtener_FuerzaReal() + 1)
        elemento.FuerzaModificada_(elemento.obtener_FuerzaReal())
      }
    }
    tablero.zona_cuerpo_a_cuerpo = new CartaUnidadCuerpoACuerpo(Nombre, Descripcion, Fuerza) :: tablero.zona_cuerpo_a_cuerpo
    tablero.zona_clima.jugar(tablero)
    if (Descripcion == "Vínculo Estrecho") {
      for (elemento <- tablero.zona_cuerpo_a_cuerpo) {
        if (Nombre == elemento.Nombre) {
          elemento.FuerzaModificadaReal_(elemento.obtener_FuerzaReal() * 2)
          elemento.FuerzaModificada_(elemento.obtener_FuerzaReal())
        }
      }
    } 
  }
}
