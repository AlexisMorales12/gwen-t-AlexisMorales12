package cl.uchile.dcc
package gwent.Componentes.Cartas

/**
 *Una carta esta definida con un nombre y una tipo 
 *
 * @param nombre es el nombre de la carta
 * @param tipo es el tipo de la carta: unidad o clima
 * @constructor Crea una carta con un nombre y que tipo
 *
 * @example
 * {{{
 * val carta = new Carta("Barbaro","Unidad")
 * val tipo = carta.Tipo
 * println("El tipo de la carta es:" + tipo)
 * }}}
 *
 * @author Alexis Morales
 */
class Carta(nombre: String , tipo: String){
  val Nombre: String = nombre
  val Tipo: String = tipo
}
