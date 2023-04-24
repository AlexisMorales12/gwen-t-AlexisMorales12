package cl.uchile.dcc
import munit.FunSuite

import gwent.Componentes.Jugador.Jugador
import gwent.Componentes.Cartas.CartaUnidad
import gwent.Componentes.Cartas.Carta
import gwent.Componentes.Cartas.CartaClima
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

  test("Una CartaUnidad debe tener una clasificacion") {
    assertEquals(cartaunidad.Clasificacion, "melee")
  }

  test("Una CartaUnidad tiene una cantidad de fuerza") {
    assertEquals(cartaunidad.Fuerza, 2)
  }
}

class Cartatest extends FunSuite{
  var cartaunidad: Carta = _
  override def beforeEach(context: BeforeEach): Unit = {
    cartaunidad = new Carta("Barbaro", "Unidad")

  }
  test("Una carta debe tener un nombre"){
    assertEquals(cartaunidad.Nombre, "Barbaro")
  }
  test("Una carta debe tener un tipo"){
    assertEquals(cartaunidad.Tipo, "Unidad")
  }
}

class CartaClimatest extends FunSuite{
  var cartaclima: CartaClima = _
  override def beforeEach(context: BeforeEach): Unit = {
    cartaclima = new CartaClima("Escarcha mordiente", "Establece el valor de fuerza de todas las cartas de combate cuerpo a cuerpo en 1")

  }
  test("Una carta de clima debe tener un nombre"){
    assertEquals(cartaclima.Nombre, "Escarcha mordiente")
  }
  test("Una carta de clima debe tener una habilidad") {
    assertEquals(cartaclima.Habilidad, "Establece el valor de fuerza de todas las cartas de combate cuerpo a cuerpo en 1")
  }
}
