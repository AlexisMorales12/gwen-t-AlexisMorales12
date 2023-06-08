# Gwen't

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------
Inicialmente se añadieron las clases jugador que contiene nombre,cantidad de gemas, seccion del tablero, un mazo y mano asignados ; mazo que contiene a las carta que tiene dentro y mano que contiene a las cartas que contiene, ademas se creo un trait acciones que contiene jugar que extrae cartas de la mano y robar que extrae cartas del mazo. 
Tambien se creo la clase carta de unidad la que tiene un nombre, clasificacion y fuerza, enventualemente se añadira habilidades a estas.
Se eliminaron las clases mazo y mano porque no tenian ningun sentido ya que podian ser incluidas como una lista perteneciente al jugador y mover cartas entre cada una de ellas. 
Se crearon diferentes test para probar algunas casos. 
Se creo la clase carta y carta de clima, la cual es una subclase de la primera, ademas de añadir carta de unidad como subclase de carta con el fin de que en el futuro cuando se entreguen las cartas el mazo del jugador de una lista de cartas de la clase carta
Tambien se documentaron las clases , traits y funciones.
Se le hizo override a la funcion equals en las clases Jugador, Carta, CartaUnidad y CartaClima estableciendo diferentes parametros para determinar la igualdad de clase y luego se testeo 
Se le hizo override a la funcion hashCpdeen las clases Jugador, Carta, CartaUnidad y CartaClima estableciendo diferentes parametros para determinar la igualdad de clase y luego se testeo
Se corrigieron las clases, se añadieron los 3 tipos de carta unidad, se implemento el tablero y se cambio las acciones de jugar y robar
Se añadio documentacion , se agregaron distintos setters y getters, se corrigieron errores al jugar las cartas, y se añadieron los efectos que producen al jugar las distintas cartas
Añadido patron de estados, cuyos estados seran modificados en el futuro

## Diagrama de estados

![Diagrama de estados](diagrama.jpeg)

This project's goal is to create a (simplified) clone of the
[_Gwent_](https://www.playgwent.com/en)card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)

---

**The rest of the documentation is left for the users of this template to complete**