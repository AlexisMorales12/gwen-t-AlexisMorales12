package cl.uchile.dcc
package gwent.Componentes.Cartas

import gwent.Componentes.Jugador.Jugador
import gwent.Componentes.Habilidades.Habilidad
/**Es el constructor de la carta clima unidad cuerpo a cuerpo, la cual cuenta con un nombre, descripcion y
 * fuerza
 *
 * @param Nombre es el nombre de la carta
 * @param Descripcion es la descripcion de la carta
 * @param Fuerza es la fuerza de la carta
 * @param Habilidad es la habilidad de la carta
 *                  
 * @constructor Crea una carta de unidad cuerpo a cuerpo con un nombre, descripcion y fuerza
 * @example
 * {{{
 * val cartaunidad = new CartaUnidadCuerpoACuerpo("Barbaro"," ", 2)
 * val fuerza = cartaunidad.obtener_fuerza()
 * println("La fuerza de la carta de unidad es:" + fuerza)
 * }}}
 * @see CartaUnidadAbstracta
 * @author Alexis Morales
 */


class CartaUnidadCuerpoACuerpo(Nombre: String, Descripcion: String, Fuerza: Int, Habilidad:Habilidad)extends CartaUnidadAbstracta(Nombre, Descripcion, Fuerza,Habilidad){
  /**Añade la carta unidad a su respectiva linea y se activan sus habilidades
   *
   * @param jugador  es el jugador que invoco la carta
   * @param oponente es el oponente del jugador
   */
  override def jugar(jugador: Jugador, oponente: Jugador): Unit = {
    jugador.Zona_cuerpo_a_cuerpo.jugar(this)
    this.efectoColocacion(jugador.Zona_cuerpo_a_cuerpo.zona, Nombre)
    jugador.Zona_clima.zona_clima.jugar(jugador,oponente)
  }
}
