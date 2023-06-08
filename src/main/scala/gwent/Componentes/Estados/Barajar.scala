package cl.uchile.dcc
package gwent.Componentes.Estados

class Barajar extends Estado{
  override def barajar(estado_actual: Estado_Actual): Unit = {
    jugador_1.Mazo.shuffle()
    jugador_2.Mazo.shuffle()
    if(super.ronda == 1){
        jugador_1.robar(jugador_1, 10)
        jugador_2.robar(jugador_2, 10)
    }
    else{
      jugador_1.robar(jugador_1, 3)
      jugador_2.robar(jugador_2, 3)
    }
  }

}
