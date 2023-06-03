package cl.uchile.dcc

import munit.FunSuite
import gwent.Componentes.Jugador.Jugador
import scala.collection.mutable
class Jugadortest extends FunSuite {
  var jugador: Jugador = _
  var jugador2: Jugador = _
  override def beforeEach(context: BeforeEach): Unit = {
    jugador = new Jugador("John", "North")
    jugador2 = new Jugador("John", "North")
  }
  test("Un jugador es igual a otro si comparte parametros") {
    assertEquals(jugador.equals(jugador2), true)
    assertEquals(jugador.hashCode, jugador2.hashCode)
  }
  test("Un jugador debe tener nombre") {
    assertEquals(jugador.Nombre, "John")
  }

  test("un jugador debe tener una seccion") {
    assertEquals(jugador.Seccion, "North")
  }

  test("Un jugador tiene una cantidad de gemas y puede perder estas") {
    assertEquals(jugador.Gemas, 2)
    jugador.perder_ronda(jugador)
    assertEquals(jugador.Gemas, 1)
    jugador.perder_ronda(jugador)
    assertEquals(jugador.Gemas, 0)
    jugador.perder_ronda(jugador)
    assertEquals(jugador.Gemas, 0)
  }

  test("un jugador debe poder robar y jugar cartas") {
    assertEquals(jugador.Mazo.length,13)
    assertEquals(jugador.Mano.length,0)
    jugador.robar(jugador,100)
    assertEquals(jugador.Mazo.length,13)
    assertEquals(jugador.Mano.length,0)
    jugador.robar(jugador,10)
    assertEquals(jugador.Mano.length, 10)
  }

}
