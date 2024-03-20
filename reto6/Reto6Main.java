import java.util.*;

/**
 * Clase Main del programa MADAGASC-APP
 */
public class Reto6Main {
    public static int[] listaPuntos = new int[4];

    /**
     * Metodo que segun el nombre del juego aniade puntuacion a dicho juego
     * @param puntosJuego Contiene los puntos obtenidos en el juego
     * @param nombreJuego Contiene el nombre del juego con puntos para aniadir
     */
    public static void contadorPuntos(int puntosJuego, String nombreJuego) {

        listaPuntos = new int[4];
        switch (nombreJuego) {
            case "ahorcado":
                listaPuntos[0] = puntosJuego;
                break;
            case "wordle":
                listaPuntos[1] = puntosJuego;
                break;
            case "verFal":
                listaPuntos[2] = puntosJuego;
                break;
            case "puntosMulti":
                listaPuntos[3] = puntosJuego;
                break;
        }
    }

    /**
     * Metodo que verifica la cantidad de puntos para poder jugar al juego secreto
     * @return Devuelve el boolean que permitira, o no, jugar al juego secreto
     */
    public static boolean verificaPuntos() {
        boolean validador = false;
        float mediaPuntos = 0;

        for (int i = 0; i < 4; i++) {
            mediaPuntos = mediaPuntos + listaPuntos[i];
        }
        mediaPuntos = mediaPuntos / 4;
        if (mediaPuntos >= 70) {
            validador = true;
        } else {
            validador = false;
        }

        return validador;
    }

    /**
     * Metodo que muestra los puntos obtenidos en los juegos
     * @param winner Contiene el boolean que determina si has ganado o no
     */
    public static void mostrarPuntos(boolean winner) {
        float mediaPuntos = 0;
        for (int i = 0; i < 4; i++) {
            mediaPuntos = mediaPuntos + listaPuntos[i];
        }
        mediaPuntos = mediaPuntos / 4;
        if (winner == true) {
            mediaPuntos = mediaPuntos + (mediaPuntos * 0.5f);
        }

        System.out.println("Tu puntuacion media es: " + mediaPuntos);
    }

    /**
     * Metodo que se usa para confirmar una seleccion
     * @param sc Contiene el objeto Scanner
     * @return Devuelve el boolean que confirma la respuesta de si o no
     */
    public static boolean confirmar(Scanner sc) {
        String confS;
        boolean conf = false;
        do {
            System.out.println("¿Estás seguro de que deseas continuar? S/N");
            confS = sc.next().toLowerCase();
            if (!confS.equals("s") && !confS.equals("n")) {
                System.out.println("Opción no válida. Debe responder 'S'(Sí) o 'N'(No)");
            }
        } while (!confS.equals("s") && !confS.equals("n"));

        if (confS.equals("s")) {
            conf = true;
        }

        return conf;
    }

    /**
     * Metodo que maneja el desarrollo del "menu principal" del proyecto
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int puntosWordle, puntosAhorcado, opcion, puntosVF, puntosMulti;
        boolean infoVewd = false, confirm, validadorPunt, puntExtra = false;
        listaPuntos[0] = -1;
        listaPuntos[1] = -1;
        listaPuntos[2] = -1;
        listaPuntos[3] = -1;

        System.out.println("BIENVENIDO A MADAGASC-APP");
        System.out.println("Pulsa ENTER para continuar.");
        do {
            do {
                opcion = 0;
                try {
                    sc.nextLine();
                    System.out.println("Elige una opción:");
                    System.out.println("[1]Info [2]Ahorcado [3]Wordle [4]Test-V/F [5]Test opción múltiple [6]Salir");

                    opcion = sc.nextInt();

                    if (opcion < 1 || opcion > 6) {
                        System.out.println("\nPor favor, elige una de las opciones de arriba.");
                    }

                } catch (InputMismatchException ex) {
                    System.out.println("\nPor favor, elige una de las opciones de arriba.");
                }
            } while (opcion < 1 || opcion > 6);

            // Si no se elige la opcion de salir como primera
            if (opcion != 6) {
                // Mostramos un aviso si no se visita la sección de información antes que los
                // juegos
                // El infoVewd es para comprobar si se ha visto la info.
                if (opcion != 1 && infoVewd == false) {
                    System.out.println("Es recomendable visitar la sección de información antes de jugar.");
                }
                confirm = confirmar(sc);

                if (confirm == true) {
                    switch (opcion) {
                        case 1:
                            infoVewd = true;
                            Info.InfoMain(sc);
                            break;
                        case 2:
                            puntosAhorcado = Ahorcado.ahorcadoMain(sc);
                            contadorPuntos(puntosAhorcado, "ahorcado");
                            break;
                        case 3:
                            puntosWordle = Wordle.wordleMain(sc);
                            contadorPuntos(puntosWordle, "wordle");
                            break;
                        case 4:
                            puntosVF = testVerdadero_Falso.VFMain(sc);
                            contadorPuntos(puntosVF, "verFal");
                            break;
                        case 5:
                            puntosMulti = opcionMultiple.multiMain(sc);
                            contadorPuntos(puntosMulti, "puntosMulti");
                            break;
                        default:
                            System.out.println("Introduce un número válido");
                            break;
                    }
                }
            }

        } while (opcion != 6);
        validadorPunt = verificaPuntos();
        if (validadorPunt == true) {
            puntExtra = Reversi.mainReversi(sc);
        }
        mostrarPuntos(puntExtra);
        // System.out.println("Puntos: "+puntosWordle);
        
        System.out.println("¡MUCHAS GRACIAS POR JUGAR!");
        sc.nextLine();
        sc.close();
    }
}