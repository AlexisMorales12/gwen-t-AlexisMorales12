package cl.uchile.dcc

import gwent.Componentes.Estados.*
import munit.FunSuite


class ControllerTest extends FunSuite{
  val gameController: GameController = new GameController
  test("Cambios de estados"){
    assertEquals(gameController.get_estado().isInstanceOf[Barajar], true)
    gameController.barajar()
    assertEquals(gameController.get_estado().isInstanceOf[Barajar], true)
    assertEquals(gameController.turno_jugador1(),false)
    assertEquals(gameController.turno_jugador2(),false)
    gameController.robar()
    assertEquals(gameController.get_estado().isInstanceOf[Robar], true)
    gameController.robar()
    assertEquals(gameController.get_estado().isInstanceOf[Robar], true)
    gameController.aumentar_ronda()
    gameController.robar()
    gameController.juega_jugador1()
    assertEquals(gameController.get_estado().isInstanceOf[Juega_Jugador1], true)
    gameController.juega_jugador1()
    assertEquals(gameController.get_estado().isInstanceOf[Juega_Jugador1], true)
    assertEquals(gameController.turno_jugador1(),true)
    gameController.pasar()
    assertEquals(gameController.get_estado().isInstanceOf[Juega_Jugador2], true)
    gameController.juega_jugador2()
    assertEquals(gameController.get_estado().isInstanceOf[Juega_Jugador2], true)
    assertEquals(gameController.turno_jugador2(),true)
    gameController.pasar()
    assertEquals(gameController.get_estado().isInstanceOf[Limpiar], true)
    gameController.limpieza()
    assertEquals(gameController.get_ronda(),3)
    gameController.barajar()
  }
}
