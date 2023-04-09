package cl.uchile.dcc
package gwent.Componentes.Cartas

import gwent.Componentes.Acciones.Acciones
import gwent.Componentes.Cartas.CartaUnidad
class Mazo extends Acciones{
  var Cantidad: Int = 25
  var Cartas: List[CartaUnidad]
  def robar(obj: Mazo): Unit = {
    if (obj.Cantidad > 0){
      obj.Cantidad -= 1
    }
  }
}
