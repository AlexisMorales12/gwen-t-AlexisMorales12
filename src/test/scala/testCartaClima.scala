package cl.uchile.dcc

import munit.FunSuite
import gwent.Componentes.Cartas.*
import scala.collection.mutable
class CartaClimatest extends FunSuite {
  var escarchamordiente: CartaClimaEscarchaMordiente = _
  var escarchamordiente1: CartaClimaEscarchaMordiente = _
  var lluviatorrencial: CartaClimaLluviaTorrencial = _
  var lluviatorrencial1: CartaClimaLluviaTorrencial = _
  var nieblaimpenetrable: CartaClimaNieblaImpenetrable = _
  var nieblaimpenetrable1: CartaClimaNieblaImpenetrable = _
  var cielodespejado: CartaClimaCieloDespejado = _
  var cielodespejado1: CartaClimaCieloDespejado = _
  override def beforeEach(context: BeforeEach): Unit = {
    escarchamordiente = new CartaClimaEscarchaMordiente
    escarchamordiente1 = new CartaClimaEscarchaMordiente
    lluviatorrencial = new CartaClimaLluviaTorrencial
    lluviatorrencial1 = new CartaClimaLluviaTorrencial
    nieblaimpenetrable = new CartaClimaNieblaImpenetrable
    nieblaimpenetrable1 = new CartaClimaNieblaImpenetrable
    cielodespejado = new CartaClimaCieloDespejado
    cielodespejado1 = new CartaClimaCieloDespejado
  }
  test("Dos cartas de clima son iguales si tienen igual nombre y descripcion") {
    assertEquals(escarchamordiente.equals(escarchamordiente1), true)
    assertEquals(escarchamordiente.hashCode, escarchamordiente1.hashCode)
    assertEquals(lluviatorrencial.equals(lluviatorrencial1), true)
    assertEquals(lluviatorrencial.hashCode, lluviatorrencial1.hashCode)
    assertEquals(nieblaimpenetrable.equals(nieblaimpenetrable1), true)
    assertEquals(nieblaimpenetrable.hashCode, nieblaimpenetrable1.hashCode)
    assertEquals(cielodespejado.equals(cielodespejado1), true)
    assertEquals( cielodespejado.hashCode, cielodespejado1.hashCode)
  }
}
