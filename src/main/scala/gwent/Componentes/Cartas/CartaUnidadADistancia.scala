package cl.uchile.dcc
package gwent.Componentes.Cartas

import gwent.Componentes.Cartas.CartaUnidadAbstracta
import gwent.Componentes.Tablero.Tablero
class CartaUnidadADistancia(Nombre: String, Descripcion: String, Fuerza: Int) extends CartaUnidadAbstracta(Nombre,Descripcion, Fuerza){
  override def jugar(tablero: Tablero): Unit = {
    tablero.zona_a_distancia = new CartaUnidadADistancia(Nombre, Descripcion, Fuerza) :: tablero.zona_a_distancia
  }
}
