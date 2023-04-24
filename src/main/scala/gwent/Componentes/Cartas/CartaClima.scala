package cl.uchile.dcc
package gwent.Componentes.Cartas

import gwent.Componentes.Cartas.Carta

/**
 *Una carta de clima esta definida con un nombre y una habilidad
 *
 * @param nombre es el nombre de la carta
 * @param habilidad es la habilidad que posee la carta
 * @constructor Crea una carta de clima con un nombre y una habilidad
 *
 * @example
 * {{{
 * val cartaclima = new CartaClima("Escarcha mordiente","Establece el valor de fuerza de todas las cartas de combate cuerpo a cuerpo en 1.")
 * val habilidad = carta.Habilidad
 * println("La habilidad de la carta de clima es:" + habilidad)
 * }}}
 *
 * @see Carta
 * @author Alexis Morales
 */
class CartaClima (nombre: String, habilidad: String)extends Carta(nombre, "Clima"){
  val Habilidad: String = habilidad
}
