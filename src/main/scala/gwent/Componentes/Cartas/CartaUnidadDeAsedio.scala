package cl.uchile.dcc
package gwent.Componentes.Cartas

import gwent.Componentes.Tablero.Tablero
/**Es el constructor de la carta clima unidad de asedio, la cual cuenta con un nombre, descripcion y
 * fuerza
 *
 * @param Nombre es el nombre de la carta
 * @param Descripcion es la descripcion de la carta
 * @param Fuerza es la fuerza de la carta
 *
 * @constructor Crea una carta de unidad de asedio con un nombre, descripcion y fuerza
 * @example
 * {{{
 * val cartaunidad = new CartaUnidadDeAsedio("Catapulta"," ", 2)
 * val fuerza = cartaunidad.obtener_fuerza()
 * println("La fuerza de la carta de unidad es:" + fuerza)
 * }}}
 *
 * @see CartaUnidadAbstracta
 * @author Alexis Morales
 */
class CartaUnidadDeAsedio (Nombre: String, Descripcion: String, Fuerza: Int) extends CartaUnidadAbstracta(Nombre,Descripcion, Fuerza){
  /** Añade la carta unidad a su respectiva linea y se activan sus habilidades
   *
   * @param tablero es el tablero donde se jugara la carta
   */
  override def jugar(tablero: Tablero): Unit ={
    if (Descripcion == "Refuerzo Moral") {
      for (elemento <- tablero.zona_de_asedio) {
        elemento.FuerzaModificadaReal_(elemento.obtener_FuerzaReal() + 1)
        elemento.FuerzaModificada_(elemento.obtener_FuerzaReal())
      }
    }
    tablero.zona_de_asedio = new CartaUnidadDeAsedio(Nombre, Descripcion, Fuerza) :: tablero.zona_de_asedio
    tablero.zona_clima.jugar(tablero)
    if(Descripcion == "Vínculo Estrecho"){
      for (elemento <- tablero.zona_de_asedio){
        if(Nombre == elemento.Nombre){
          elemento.FuerzaModificadaReal_(elemento.obtener_FuerzaReal() * 2)
          elemento.FuerzaModificada_(elemento.obtener_FuerzaReal())
        }
      }
    }
  }
}
