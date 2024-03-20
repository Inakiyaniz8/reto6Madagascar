import java.util.*;

/**
 * Esta clase sirve para ejecutar el juego WORDLE con todos los metodos
 * necesarios para ello.
 */
public class Wordle {

    /**
     * Metodo para realizar la confirmacion de algunas peticiones al usuario.
     * @param scanner Objeto escaner para la peticion de datos al usuario.
     * @return La confirmacion de la peticion: Verdaero si cumple las condiciones.
     *         Falso si no las cumple.
     */
    public static boolean confirmacion(Scanner scanner) {
        String conf;
        boolean confirmacion;

        confirmacion = false;

        do {
            System.out.print("Introduce S/N para continuar: ");
            conf = scanner.next().toLowerCase();
            if (!conf.equals("s") && !conf.equals("n")) {
                System.out.println("Opción no válida.");
            }
        } while (!conf.equals("s") && !conf.equals("n"));

        if (conf.equals("s")) {
            confirmacion = true;
        }

        return confirmacion;
    }

    /**
     * Metodo para imprimir la explicacion en caso de que el usuario lo decida.
     */
    public static void imprimirExplicacion() {
        System.out.println("El WORDLE consiste en averiguar una palabra en un total de 5 intentos.");
        System.out.println(
                "Después de cada intento se mostrará la palabra introducida aplicando un código de colores:");
        System.out.println(
                "-VERDE: La letra de la palabra coincide con la letra del resultado y está en la posición correcta.");
        System.out.println(
                "-AMARILLO: La letra de la palabra coincide con alguna letra del resultado pero no está en la posición correcta.");
        System.out.println("-BLANCO: La letra no se encuentra en el resultado.");
    }

    /**
     * Metodo para elegir una palabra aleatoria entre todas las palabras guardades
     * en un array de palabras.
     * 
     * @return Palabra aleatoria elegida.
     */
    public static char[] elegirPalabra() {
        char[] palabraCh;
        String palabra = "";
        String[] palabras = { "isla", "madagascar", "portugal", "marino", "lewrence", "malagasy", "pirata", "sakalava",
                "merina", "radama", "ranavalona", "colonia", "vainilla", "dictadura", "yogurt", "ivondro", "palmera",
                "aceite", "palma", "toamasina", "ivoloina", "lemur", "reptil", "batracio", "cala", "isalo", "baobab",
                "antananarivo", "malgache", "tsingy", "valle", "boby", "ballena", "fosa", "ayeaye", "polilla",
                "serpiente",
                "girafa", "tortuga" };
        int limSup = palabras.length - 1;

        palabra = palabras[(int) ((limSup + 1) * Math.random())];

        palabraCh = palabra.toCharArray();

        return palabraCh;
    }

    /**
     * Metodo para comprobar las posiciones de las letras de la palabra introducidas
     * por el usuario con las letras de la palabra correcta.
     * 
     * @param wordle Array de caracteres con las letras de la palaba correcta.
     * @param sc     Objeto escaner para la peticion de los datos.
     * @return Numero de intentos que ha utilizado el usuario.
     */
    public static int comprobarLetra(char[] wordle, Scanner sc) {
        int intentos;
        int longitudWordle = wordle.length;
        boolean correcto;
        String inputUser;
        char[] wordleTemp = new char[longitudWordle];
        char[] wordleUser;
        int[] codigoColor = new int[longitudWordle];

        // INICIALIZACIONES
        intentos = 1;
        correcto = true;

        // EJECUCIÓN
        do {
            // Reiniciar el array nombreTemp y la variable 'correcto' para las sucesivas
            // comprobaciones
            for (int i = 0; i < longitudWordle; i++) {
                wordleTemp[i] = wordle[i];
            }

            // Mostramos el número del intento
            System.out.println("Intento " + (intentos) + ":");

            // Petición para la palabra introducida por el usuario y paso a un array de
            // caracteres
            do {
                inputUser = sc.next().toLowerCase();
                wordleUser = inputUser.toCharArray();
                if (wordleUser.length != longitudWordle) {
                    System.out.println("La palabra tiene que tener " + longitudWordle + " letras.");
                }
            } while (wordleUser.length != longitudWordle);

            // Comprobamos si hay casillas del array que coinciden tanto en posición como en
            // contenido y si coinciden las quitamos del array
            // temporal.
            for (int i = 0; i < longitudWordle; i++) {
                if (wordleUser[i] == wordleTemp[i]) {
                    // System.out.print(GREEN+nombre[i]+RESET);
                    // Si 2 : imprimiremos GREEN
                    codigoColor[i] = 2;
                    wordleTemp[i] = '-';
                } else {
                    codigoColor[i] = 0;
                }
            }

            // Comprobamos si alguna de las letras restantes coincide con alguna de las
            // letras
            for (int i = 0; i < longitudWordle; i++) {
                for (int j = 0; j < longitudWordle; j++) {
                    if (wordleUser[i] == wordleTemp[j] && codigoColor[i] != 2) {
                        // System.out.print(ORANGE+nombre[i]+RESET);
                        // Si 1 : imprimiremos ORANGE
                        codigoColor[i] = 1;
                    }
                }
            }

            // Dependiendo del código de color imprimimos un color u otro
            imprimirColor(longitudWordle, wordleUser, codigoColor);

            // Comprobamos si la palabra introducida es correcta
            correcto = comprobarPalabra(codigoColor);

            // Aumentamos el contador de intentos
            if (!correcto) {
                intentos++;
            }

            System.out.println();

        } while (!correcto && intentos <= 5);

        return intentos;
    }

    /**
     * Metodo para imprimir la palabra introducida por el usuario con el codigo de
     * colores establecido.
     * 
     * @param longi Longitud de los arrays, comun para todos los arrays utilizados.
     * @param user  Array de caracteres con la palabra introducida por el usuario.
     * @param cod   Array con lo numeros del codigo de colores.
     */
    public static void imprimirColor(int longi, char[] user, int[] cod) {
        final String GREEN = "\u001B[32m";
        final String RESET = "\u001B[0m";
        final String ORANGE = "\u001B[33m";
        for (int i = 0; i < longi; i++) {
            if (cod[i] == 2) {
                System.out.print(GREEN + user[i] + RESET);
            }
            if (cod[i] == 1) {
                System.out.print(ORANGE + user[i] + RESET);
            }
            if (cod[i] == 0) {
                System.out.print(user[i]);
            }
        }
    }

    /**
     * Metodo para comprobar si la palabra introducida por el usuario es la
     * correcta, dependiendo de un array con un codigo de colores.
     * 
     * @param cod Array con el codigo de colores. 2 = Correcto. 1 = Acierto. 0 =
     *            Error.
     * @return Verdadero si todo el array son 2. Falso si algun elemento del array
     *         es distinto a 2.
     */
    public static boolean comprobarPalabra(int[] cod) {
        boolean resultado;

        resultado = true;

        for (int i = 0; i < cod.length; i++) {
            if (cod[i] != 2) {
                resultado = false;
            }
        }

        return resultado;
    }

    /**
     * Metodo para imprimir el mensaje con el resultado de cada intento de la
     * partida.
     * 
     * @param intentos Cantidad de intentos que ha utilizado el usuario
     * @param palabra  La palabra que el usuario ha intentado acertar/acertado.
     */
    public static void imprimirResultado(int intentos, char[] palabra) {
        if (intentos == 6) {
            System.out.println("Lo siento, puedes volver a intentarlo...");
            System.out.print("La palabra a acertar era: ");
            for (int i = 0; i < palabra.length; i++) {
                System.out.print(palabra[i]);
            }
            System.out.println();
        } else if (intentos == 1) {
            System.out.println("¡INCREIBLE, HAS ACERTADO EN " + intentos + " INTENTO!");
        } else {
            System.out.println("¡BUEN TRABAJO, HAS ACERTADO EN " + intentos + " INTENTOS!");
        }
    }

    /**
     * Metodo para calcular la cantidad de puntos conseguidos, dependiendo de la
     * cantidad de intentos realizados.
     * Se comparan los intentos de la partida actual con los intentos de la partida
     * anterior.
     * 
     * @param intentos        Los intentos de la partida actual.
     * @param intentosPrevios Los intentos de la partida previa.
     * @param puntosPrev      Variable para el control de los puntos de partidas
     *                        previas.
     * @return Cantidad de puntos calculado: Si los puntos son menores que la
     *         puntuacion maxima: Puntuación maxima, si no: Nueva puntuacion.
     */
    public static int calcularPuntos(int intentos, int intentosPrevios, int puntosPrev) {

        if (intentosPrevios > intentos) {
            // Dependiendo de cuantos intentos haya llevado el juego llevamos más o menos
            // puntos como resultado.
            switch (intentos) {
                case 1:
                    puntosPrev = 100;
                    break;
                case 2:
                    puntosPrev = 80;
                    break;
                case 3:
                    puntosPrev = 60;
                    break;
                case 4:
                    puntosPrev = 40;
                    break;
                case 5:
                    puntosPrev = 20;
                    break;
                default:
                    puntosPrev = 0;
                    break;
            }
        }

        return puntosPrev;
    }

    /**
     * Metodo que ejecuta el juego del Wordle llamado desde la clase principal.
     * 
     * @return Cantidad de la puntuación maxima obtenida en el juego.
     */
    public static int wordleMain(Scanner sc) {
        char[] wordle;
        int intentosPunt, puntos, intentosPuntPrevios;
        boolean confirm, continuar;

        // INICIALIZACIONES
        intentosPunt = 5;
        continuar = false;
        puntos = 0;

        // EJECUCIÓN
        // Mensaje de bienvenida al juego
        System.out.println("BIENVENIDO al wordle edición MADAGASC-APP");

        // Mostramos una pequeña explicación si el usuario quiere
        System.out.println("Deseas ver una pequeña explicación de como jugar?");

        confirm = confirmacion(sc);

        // Imprimimos la explicación dependiendo de la elección del usuario
        if (confirm) {
            imprimirExplicacion();
        }

        do {
            // Sacamos la palabra de la colección
            wordle = elegirPalabra();

            // Mostramos un mensaje indicativo cada vez que iniciamos el juego
            System.out.println("Introduce una palabra de " + wordle.length + " letras, tienes 5 intentos: ");

            // Guardamos los intentos de la partida anterior para luego comprobar la
            // puntuación máxima
            // En caso de que sea la primera partida, la variable intentosPunt se considera
            // como una puntuación máxima.
            intentosPuntPrevios = intentosPunt;
            // Ejecutamos la comprobación de la palabra
            intentosPunt = comprobarLetra(wordle, sc);

            // Mostramos la palabra a acertar si el usuario no consigue acertar
            // O un mensaje de enhorabuena si es que lo consigue.
            imprimirResultado(intentosPunt, wordle);

            // Calculamos la cantidad de puntos que le corresponde a los intentos utilizados
            puntos = calcularPuntos(intentosPunt, intentosPuntPrevios, puntos);

            // Preguntamos si el usuario desea continuar jugando
            System.out.println("¿Quieres volver a intentarlo?");
            continuar = confirmacion(sc);

        } while (continuar);

        return puntos;
    }
}
