package cl.uchile.dcc
package gwent.Componentes.Cartas

import gwent.Componentes.Cartas.CartaUnidadAbstracta
import gwent.Componentes.Tablero.Tablero
class CartaUnidadDeAsedio (Nombre: String, Descripcion: String, Fuerza: Int) extends CartaUnidadAbstracta(Nombre,Descripcion, Fuerza){
  override def jugar(tablero: Tablero): Unit ={
    tablero.zona_de_asedio = new CartaUnidadDeAsedio(Nombre, Descripcion, Fuerza) :: tablero.zona_de_asedio
  }
}
