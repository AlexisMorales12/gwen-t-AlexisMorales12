package cl.uchile.dcc

import munit.FunSuite
import gwent.Componentes.Jugador.Jugador
import gwent.Componentes.Observador.GestorJugador

import cl.uchile.dcc.gwent.Componentes.Estados.GameController
class Jugadortest extends FunSuite {
  var jugador: Jugador = _
  var jugador2: Jugador = _
  val gameController: GameController = new GameController
  override def beforeEach(context: BeforeEach): Unit = {
    jugador = new Jugador("John", "North",new GestorJugador(gameController))
    jugador2 = new Jugador("John", "North", new GestorJugador(gameController))
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
    assertEquals(jugador.getAtributo, 2)
    jugador.perder_ronda()
    assertEquals(jugador.getAtributo, 1)
    jugador.perder_ronda()
    assertEquals(jugador.getAtributo, 0)
    jugador.perder_ronda()
    assertEquals(jugador.getAtributo, 0)
  }

  test("un jugador debe poder robar y jugar cartas") {
    assertEquals(jugador.Mazo.length,13)
    assertEquals(jugador.Mano.length,0)
    jugador.robar(100)
    assertEquals(jugador.Mazo.length,13)
    assertEquals(jugador.Mano.length,0)
    jugador.robar(10)
    assertEquals(jugador.Mano.length, 10)
  }

}
