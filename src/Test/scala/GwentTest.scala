package cl.uchile.dcc
import munit.FunSuite

import gwent.Componentes.Jugador.Jugador
import gwent.Componentes.Cartas.CartaUnidad
class Jugadortest extends FunSuite {
  var jugador: Jugador = _
  override def beforeEach(context: BeforeEach): Unit = {
    jugador = new Jugador("John", "North")
  }

  test("Un jugador debe tener nombre") {
    assertEquals(jugador.Nombre, "John")
  }

  test("un jugador debe tener una seccion") {
    assertEquals(jugador.Seccion, "North")
  }

  test("Un jugador tiene una cantidad de gemas") {
    assertEquals(jugador.Gemas, 25)
  }

  test("un jugador debe poder robar y jugar cartas") {
    assertEquals(jugador.Mazo,25)
    assertEquals(jugador.Mano,1)
    jugador.robar(jugador,100)
    assertEquals(jugador.Mazo,25)
    assertEquals(jugador.Mano,1)
    jugador.jugar(jugador)
    assertEquals(jugador.Mano,0)
    jugador.robar(jugador, 8)
    assertEquals(jugador.Mazo, 17)
    assertEquals(jugador.Mano, 8)
    jugador.jugar(jugador)
    assertEquals(jugador.Mano, 7)
  }
}

class CartaUnidadtest extends FunSuite {
  var cartaunidad: CartaUnidad = _
  override def beforeEach(context: BeforeEach): Unit = {
    cartaunidad = new CartaUnidad("Barbaro", "melee", 2)
  }

  test("Un CartaUnidad debe tener nombre") {
    assertEquals(cartaunidad.Nombre, "Barbaro")
  }

  test("un jugador debe tener una clasificacion") {
    assertEquals(cartaunidad.Clasificacion, "melee")
  }

  test("Un jugador tiene una cantidad de fuerza") {
    assertEquals(cartaunidad.Fuerza, 2)
  }
}
