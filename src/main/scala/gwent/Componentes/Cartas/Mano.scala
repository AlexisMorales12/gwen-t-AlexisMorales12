package cl.uchile.dcc
package gwent.Componentes.Cartas

import gwent.Componentes.Acciones.Acciones
import gwent.Componentes.Cartas.CartaUnidad
class Mano {
  var Cantidad: Int = 0
  var Cartas: List[CartaUnidad]
  def robar(obj: Mano): Unit = {
    obj.Cantidad += 1
  }
}
