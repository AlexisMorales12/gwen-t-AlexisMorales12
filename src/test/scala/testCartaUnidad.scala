package cl.uchile.dcc

import munit.FunSuite
import gwent.Componentes.Cartas.*
import gwent.Componentes.Habilidades.NullHabilidad
import scala.collection.mutable
class CartaUnidadtest extends FunSuite {
  var cartaunidadcuerpoacuerpo: CartaUnidadCuerpoACuerpo = _
  var cartaunidadcuerpoacuerpo1: CartaUnidadCuerpoACuerpo = _
  var cartaunidadadistancia: CartaUnidadADistancia = _
  var cartaunidadadistancia1: CartaUnidadADistancia = _
  var cartaunidaddeasedio: CartaUnidadDeAsedio = _
  var cartaunidaddeasedio1: CartaUnidadDeAsedio = _
  override def beforeEach(context: BeforeEach): Unit = {
    cartaunidadcuerpoacuerpo = new CartaUnidadCuerpoACuerpo("Barbaro", " ", 2, new NullHabilidad)
    cartaunidadcuerpoacuerpo1 = new CartaUnidadCuerpoACuerpo("Barbaro", " ", 2,new NullHabilidad)
    cartaunidadadistancia = new CartaUnidadADistancia("Arquero"," ", 3,new NullHabilidad)
    cartaunidadadistancia1 = new CartaUnidadADistancia("Arquero"," ", 3,new NullHabilidad)
    cartaunidaddeasedio = new CartaUnidadDeAsedio("Catapulta"," ", 5,new NullHabilidad)
    cartaunidaddeasedio1 = new CartaUnidadDeAsedio("Catapulta"," ", 5,new NullHabilidad)
  }
  test("Dos cartas son iguales si tienen el mismo nombre, descripcion y fuerza") {
    assertEquals(cartaunidadcuerpoacuerpo.equals(cartaunidadcuerpoacuerpo1), true)
    assertEquals(cartaunidadcuerpoacuerpo.hashCode, cartaunidadcuerpoacuerpo1.hashCode)
    assertEquals(cartaunidadadistancia.equals(cartaunidadadistancia1), true)
    assertEquals(cartaunidadadistancia.hashCode, cartaunidadadistancia1.hashCode)
    assertEquals(cartaunidaddeasedio.equals(cartaunidaddeasedio1), true)
    assertEquals(cartaunidaddeasedio.hashCode, cartaunidaddeasedio1.hashCode)
  }
}
