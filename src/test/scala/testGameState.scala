package cl.uchile.dcc

import gwent.Componentes.Estados.{GameController, GameState}

import munit.*

import scala.util.{Failure, Success, Try}

class GameStatetest extends munit.FunSuite {
  val gamestate: GameState = new GameState
  val gamecontroller: GameController = new GameController
  test("barajar debe arrojar un error en ciertos casos, pero para GameState lo hara siempre") {
    val result = Try {
      gamestate.barajar(gamecontroller)
    }

    assert(result.isFailure)
    val exception = result.failed.get
    assertEquals(exception.getMessage, "Estado erroneo\n")
  }
  test("robar debe arrojar un error en ciertos casos, pero para GameState lo hara siempre") {
    val result = Try {
      gamestate.robar(gamecontroller)
    }

    assert(result.isFailure)
    val exception = result.failed.get
    assertEquals(exception.getMessage, "Estado erroneo\n")
  }
  test("juega_jugador1 debe arrojar un error en ciertos casos, pero para GameState lo hara siempre") {
    val result = Try {
      gamestate.juega_jugador1(gamecontroller)
    }

    assert(result.isFailure)
    val exception = result.failed.get
    assertEquals(exception.getMessage, "Estado erroneo\n")
  }
  test("juega_jugador2 debe arrojar un error en ciertos casos, pero para GameState lo hara siempre") {
    val result = Try {
      gamestate.juega_jugador2(gamecontroller)
    }

    assert(result.isFailure)
    val exception = result.failed.get
    assertEquals(exception.getMessage, "Estado erroneo\n")
  }
  test("pasar debe arrojar un error en ciertos casos, pero para GameState lo hara siempre") {
    val result = Try {
      gamestate.pasar(gamecontroller)
    }

    assert(result.isFailure)
    val exception = result.failed.get
    assertEquals(exception.getMessage, "Estado erroneo\n")
  }
  test("limpieza debe arrojar un error en ciertos casos, pero para GameState lo hara siempre") {
    val result = Try {
      gamestate.limpieza(gamecontroller)
    }

    assert(result.isFailure)
    val exception = result.failed.get
    assertEquals(exception.getMessage, "Estado erroneo\n")
  }

}
