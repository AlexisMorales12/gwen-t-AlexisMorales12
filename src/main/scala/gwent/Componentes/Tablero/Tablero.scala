package cl.uchile.dcc
package gwent.Componentes.Tablero

import gwent.Componentes.Jugador.Jugador

class Tablero {
  var zona_cuerpo_a_cuerpo : list[CartaUnidadCuerpoACuerpo] = List()
  var zona_a_distancia : list[CartaUnidadADistancia] = List()
  var zona_de_asedio : list[CartaUnidadDeAsedio] = List()
  var zona_clima: lista[CartaClima] = Lista()
  var zona_cuerpo_a_cuerpo_pc: list[CartaUnidadCuerpoACuerpo] = List()
  var zona_a_distancia_pc: list[CartaUnidadADistancia] = List()
  var zona_de_asedio_pc: list[CartaUnidadDeAsedio] = List()
  
}
