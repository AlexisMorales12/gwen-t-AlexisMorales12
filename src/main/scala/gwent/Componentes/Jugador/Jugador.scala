package cl.uchile.dcc
package gwent.Componentes.Jugador

import gwent.Componentes.Cartas.CartaUnidad
import gwent.Componentes.Acciones.Acciones
class Jugador(nombre: String, seccion: String) {
  val Nombre: String = nombre
  val Seccion: String = seccion
  var Gemas: Int = 25
  var Mazo: Int = 25
  var Mano: Int = 1

  def robar(obj:Jugador, numero: Int): Unit ={
    if ((obj.Mazo-numero)>=0){
      obj.Mazo -= numero
      obj.Mano += numero
    }
  }
  def jugar(obj: Jugador): Unit = {
    if (obj.Mano>0){
      obj.Mano -= 1
    }
  }
}
