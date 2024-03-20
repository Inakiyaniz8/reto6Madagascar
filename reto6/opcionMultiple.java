import java.util.*;

/**
 * Clase con el jeugo del Test de Opcion Multiple
 */
public class opcionMultiple {

    /**
     * Metodo que controla la ejecución del juego de Test de Verdadero - Falso
     * @return Cantidad maxima de puntos conseguidos en el juego 
     */
    public static int multiMain(Scanner sc) {
        sc.nextLine();
        String[][] preguntasRespuestas = {
                {"¿Cual es la capital de Madagascar?", "a) Antananarivo", "b) Morondava", "c) Antsiranana", "d) Antalaha", "a"},
                {"¿Quienes fueron los colonizadores de Madagascar?", "a) Franceses", "b) Indoneses", "c) Españoles", "d) Alemanes", "b"},
                {"¿Quien fue el primer europeo en visitar Madagascar?", "a) Cristóbal Colon", "b) Pedro Alvares Cabral", "c) Juan de Lezcano", "d) Diogo Días", "d"},
                {"¿En que año se establecieron reinos los piratas en las costas?", "a) 1550", "b) 1620", "c)1600", "d)1610", "c"},
                {"¿Cual es el gentilicio de Madagascar?", "a) Malgacha", "b) Malgarche", "c) Malgasche", "d) Malgache", "d"},
                {"¿Cual es el mamífero carnívoro más grande de Madagascar?", "a) Aye-Aye", "b) Fosa", "c) Civeta malgache", "d) Galidía enano", "b"},
                {"¿Cual es uno de los idiomas oficiales de Madagascar?", "a) Ingles", "b) Afrikáans", "c) Malgache", "d) Suajili", "c"},
                {"¿Cuantas personas viven en Madagascar?", "a) 25 Millones", "b)10 Millones", "c) 40 Millones", "d)100 Millones", "a"},
                {"Cual es el alimento que más se consume en Madagascar", "a) Pollo", "b) Arroz", "c) Lechuga", "d) Zanahoria", "b"},
                {"¿Cuál de las siguientes especies endémicas es emblemática de Madagascar?", "a) Lemur cola anillada", "b) Oso perezoso", "c) Elefante africano", "d) Tigre de bengala", "a"}
        };

        String pregunta, opcionA, opcionB, opcionC, opcionD, respuestaCorrecta, respuestaUsu;
        int respuestasCo = 0, respuestasIn = 0, puntuacion = 0;

        System.out.println("Bienvenido al test de opción múltiple. ¡Comencemos!");
        for (int i = 0; i < preguntasRespuestas.length; i++) {
            pregunta = preguntasRespuestas[i][0];
            opcionA = preguntasRespuestas[i][1];
            opcionB = preguntasRespuestas[i][2];
            opcionC = preguntasRespuestas[i][3];
            opcionD = preguntasRespuestas[i][4];
            respuestaCorrecta = preguntasRespuestas[i][5];

            System.out.println(pregunta);
            System.out.println(opcionA);
            System.out.println(opcionB);
            System.out.println(opcionC);
            System.out.println(opcionD);

            do {
                System.out.println("Introduce tu respuesta: ");
                respuestaUsu = sc.nextLine();
            } while (!respuestaUsu.equals("a") && !respuestaUsu.equals("b") && !respuestaUsu.equals("c") && !respuestaUsu.equals("d"));

            if (respuestaUsu.equalsIgnoreCase(respuestaCorrecta)) {
                System.out.println("¡Respuesta correcta!");
                respuestasCo++;
                puntuacion += 10;
            } else {
                System.out.println("Respuesta incorrecta. La respuesta correcta es: " + respuestaCorrecta);
                respuestasIn++;
            }
            System.out.println();
        }
        System.out.println("Resultados:");
        System.out.println("Respuestas correctas: " + respuestasCo);
        System.out.println("Respuestas incorrectas: " + respuestasIn);
        System.out.println("Tu puntuacion es de: "+puntuacion);

        return puntuacion;
    }
}
