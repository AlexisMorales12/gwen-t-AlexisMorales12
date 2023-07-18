package cl.uchile.dcc

import munit.FunSuite
import gwent.Componentes.Jugador.Jugador
import gwent.Componentes.Observador.GestorJugador
import gwent.Componentes.Estados.GameController

import scala.collection.mutable
class Tablerotest extends FunSuite {
  var jugador: Jugador = _
  var oponente:Jugador = _
  val gameController: GameController = new GameController

  override def beforeEach(context: BeforeEach): Unit = {
    jugador = new Jugador("John", "North", new GestorJugador(gameController))
    oponente = new Jugador("Francis","South", new GestorJugador(gameController))
  }

  test("situacion de juego 1") {
    jugador.robar(13)
    jugador.jugar(oponente,1)
    var zona = jugador.Zona_cuerpo_a_cuerpo.get()
    assertEquals(zona.head.Nombre,"Barbaro")
    assertEquals(zona.head.obtener_Fuerza(), 2)
    assertEquals(zona.head.obtener_FuerzaReal(), 2)
    jugador.jugar(oponente,1)
    zona = jugador.Zona_cuerpo_a_cuerpo.get()
    assertEquals(zona.head.Nombre, "Capitan")
    assertEquals(zona.head.obtener_Fuerza(), 4)
    assertEquals(zona.head.obtener_FuerzaReal(), 4)
    assertEquals(zona(1).Nombre, "Barbaro")
    assertEquals(zona(1).obtener_Fuerza(), 3)
    assertEquals(zona(1).obtener_FuerzaReal(), 3)
    jugador.jugar(oponente, 1)
    zona = jugador.Zona_cuerpo_a_cuerpo.get()
    assertEquals(zona.head.Nombre, "Barbaro")
    assertEquals(zona.head.obtener_Fuerza(), 4)
    assertEquals(zona.head.obtener_FuerzaReal(), 4)
    assertEquals(zona(1).Nombre, "Capitan")
    assertEquals(zona(1).obtener_Fuerza(), 4)
    assertEquals(zona(1).obtener_FuerzaReal(), 4)
    assertEquals(zona(2).Nombre, "Barbaro")
    assertEquals(zona(2).obtener_Fuerza(), 6)
    assertEquals(zona(2).obtener_FuerzaReal(), 6)
    jugador.jugar(oponente, 7)
    zona = jugador.Zona_cuerpo_a_cuerpo.get()
    assertEquals(zona.head.Nombre, "Barbaro")
    assertEquals(zona.head.obtener_Fuerza(), 1)
    assertEquals(zona.head.obtener_FuerzaReal(), 4)
    assertEquals(zona(1).Nombre, "Capitan")
    assertEquals(zona(1).obtener_Fuerza(), 1)
    assertEquals(zona(1).obtener_FuerzaReal(), 4)
    assertEquals(zona(2).Nombre, "Barbaro")
    assertEquals(zona(2).obtener_Fuerza(), 1)
    assertEquals(zona(2).obtener_FuerzaReal(), 6)
    oponente.robar(13)
    oponente.jugar(jugador,1)
    val zona2 = oponente.Zona_cuerpo_a_cuerpo.get()
    assertEquals(zona2.head.Nombre, "Barbaro")
    assertEquals(zona2.head.obtener_Fuerza(), 1)
    assertEquals(zona2.head.obtener_FuerzaReal(), 2)
    jugador.jugar(oponente, 7)
    zona = jugador.Zona_cuerpo_a_cuerpo.get()
    assertEquals(zona.head.Nombre, "Barbaro")
    assertEquals(zona.head.obtener_Fuerza(), 4)
    assertEquals(zona.head.obtener_FuerzaReal(), 4)
    assertEquals(zona(1).Nombre, "Capitan")
    assertEquals(zona(1).obtener_Fuerza(), 4)
    assertEquals(zona(1).obtener_FuerzaReal(), 4)
    assertEquals(zona(2).Nombre, "Barbaro")
    assertEquals(zona(2).obtener_Fuerza(), 6)
    assertEquals(zona(2).obtener_FuerzaReal(), 6)
  }
  test("situacion de juego 2") {
    jugador.robar(13)
    jugador.jugar(oponente, 7)
    var zona = jugador.Zona_a_distancia.get()
    assertEquals(zona.head.Nombre, "Arquero")
    assertEquals(zona.head.obtener_Fuerza(), 2)
    assertEquals(zona.head.obtener_FuerzaReal(), 2)
    jugador.jugar(oponente, 7)
    zona = jugador.Zona_a_distancia.get()
    assertEquals(zona.head.Nombre, "Ballestero")
    assertEquals(zona.head.obtener_Fuerza(), 4)
    assertEquals(zona.head.obtener_FuerzaReal(), 4)
    assertEquals(zona(1).Nombre, "Arquero")
    assertEquals(zona(1).obtener_Fuerza(), 3)
    assertEquals(zona(1).obtener_FuerzaReal(), 3)
    jugador.jugar(oponente, 7)
    zona = jugador.Zona_a_distancia.get()
    assertEquals(zona.head.Nombre, "Arquero")
    assertEquals(zona.head.obtener_Fuerza(), 4)
    assertEquals(zona.head.obtener_FuerzaReal(), 4)
    assertEquals(zona(1).Nombre, "Ballestero")
    assertEquals(zona(1).obtener_Fuerza(), 4)
    assertEquals(zona(1).obtener_FuerzaReal(), 4)
    assertEquals(zona(2).Nombre, "Arquero")
    assertEquals(zona(2).obtener_Fuerza(), 6)
    assertEquals(zona(2).obtener_FuerzaReal(), 6)
    jugador.jugar(oponente, 9)
    zona = jugador.Zona_a_distancia.get()
    assertEquals(zona.head.Nombre, "Arquero")
    assertEquals(zona.head.obtener_Fuerza(), 1)
    assertEquals(zona.head.obtener_FuerzaReal(), 4)
    assertEquals(zona(1).Nombre, "Ballestero")
    assertEquals(zona(1).obtener_Fuerza(), 1)
    assertEquals(zona(1).obtener_FuerzaReal(), 4)
    assertEquals(zona(2).Nombre, "Arquero")
    assertEquals(zona(2).obtener_Fuerza(), 1)
    assertEquals(zona(2).obtener_FuerzaReal(), 6)
    oponente.robar(13)
    oponente.jugar(jugador, 7)
    val zona2 = oponente.Zona_a_distancia.get()
    assertEquals(zona2.head.Nombre, "Arquero")
    assertEquals(zona2.head.obtener_Fuerza(), 1)
    assertEquals(zona2.head.obtener_FuerzaReal(), 2)
    jugador.jugar(oponente, 7)
    zona = jugador.Zona_a_distancia.get()
    assertEquals(zona.head.Nombre, "Arquero")
    assertEquals(zona.head.obtener_Fuerza(), 4)
    assertEquals(zona.head.obtener_FuerzaReal(), 4)
    assertEquals(zona(1).Nombre, "Ballestero")
    assertEquals(zona(1).obtener_Fuerza(), 4)
    assertEquals(zona(1).obtener_FuerzaReal(), 4)
    assertEquals(zona(2).Nombre, "Arquero")
    assertEquals(zona(2).obtener_Fuerza(), 6)
    assertEquals(zona(2).obtener_FuerzaReal(), 6)
  }
  test("situacion de juego 3") {
    jugador.robar(13)
    jugador.jugar(oponente, 4)
    var zona = jugador.Zona_de_asedio.get()
    assertEquals(zona.head.Nombre, "Catapulta")
    assertEquals(zona.head.obtener_Fuerza(), 2)
    assertEquals(zona.head.obtener_FuerzaReal(), 2)
    jugador.jugar(oponente, 4)
    zona = jugador.Zona_de_asedio.get()
    assertEquals(zona.head.Nombre, "Ariete")
    assertEquals(zona.head.obtener_Fuerza(), 4)
    assertEquals(zona.head.obtener_FuerzaReal(), 4)
    assertEquals(zona(1).Nombre, "Catapulta")
    assertEquals(zona(1).obtener_Fuerza(), 3)
    assertEquals(zona(1).obtener_FuerzaReal(), 3)
    jugador.jugar(oponente, 4)
    zona = jugador.Zona_de_asedio.get()
    assertEquals(zona.head.Nombre, "Catapulta")
    assertEquals(zona.head.obtener_Fuerza(), 4)
    assertEquals(zona.head.obtener_FuerzaReal(), 4)
    assertEquals(zona(1).Nombre, "Ariete")
    assertEquals(zona(1).obtener_Fuerza(), 4)
    assertEquals(zona(1).obtener_FuerzaReal(), 4)
    assertEquals(zona(2).Nombre, "Catapulta")
    assertEquals(zona(2).obtener_Fuerza(), 6)
    assertEquals(zona(2).obtener_FuerzaReal(), 6)
    jugador.jugar(oponente, 10)
    zona = jugador.Zona_de_asedio.get()
    assertEquals(zona.head.Nombre, "Catapulta")
    assertEquals(zona.head.obtener_Fuerza(), 1)
    assertEquals(zona.head.obtener_FuerzaReal(), 4)
    assertEquals(zona(1).Nombre, "Ariete")
    assertEquals(zona(1).obtener_Fuerza(), 1)
    assertEquals(zona(1).obtener_FuerzaReal(), 4)
    assertEquals(zona(2).Nombre, "Catapulta")
    assertEquals(zona(2).obtener_Fuerza(), 1)
    assertEquals(zona(2).obtener_FuerzaReal(), 6)
    oponente.robar(13)
    oponente.jugar(jugador, 4)
    val zona2 = oponente.Zona_de_asedio.get()
    assertEquals(zona2.head.Nombre, "Catapulta")
    assertEquals(zona2.head.obtener_Fuerza(), 1)
    assertEquals(zona2.head.obtener_FuerzaReal(), 2)
    jugador.jugar(oponente, 7)
    zona = jugador.Zona_de_asedio.get()
    assertEquals(zona.head.Nombre, "Catapulta")
    assertEquals(zona.head.obtener_Fuerza(), 4)
    assertEquals(zona.head.obtener_FuerzaReal(), 4)
    assertEquals(zona(1).Nombre, "Ariete")
    assertEquals(zona(1).obtener_Fuerza(), 4)
    assertEquals(zona(1).obtener_FuerzaReal(), 4)
    assertEquals(zona(2).Nombre, "Catapulta")
    assertEquals(zona(2).obtener_Fuerza(), 6)
    assertEquals(zona(2).obtener_FuerzaReal(), 6)
  }
}