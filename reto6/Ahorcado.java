
import java.util.*;

/**
 * Esta clase sirve para ejecutar el juego del Ahoracado con todos los metodos necesarios para ello.
 */
public class Ahorcado {

	/**
	 * Metodo que maneja el desarrollo de la clase
	 * @param sc Contiene el objeto Scanner
	 * @return Devuelve la puntuacion obtenida jugando a Ahorcado
	 */
	public static int ahorcadoMain(Scanner sc) {
		int dificultad, puntos, puntMax;
		boolean repetir;

		puntos = puntMax = 0;

		System.out.println("\n¡Bienvenido al Ahorcado!");

		do {
			// El método introduccion devolverá la dificultad con la que vamos a jugar
			dificultad = introduccion(sc);

			switch (dificultad) {
				case 1:
					puntos = nivelFacil(sc); // Cada nivel devolverá un máximo de 7 puntos (vidas)
					puntos = (puntos * 100 / 7); // Hacemos que la puntuación sea sobre 100
					System.out.println("\nHas conseguido " + puntos + " puntos.");
					break;
				case 2:
					puntos = nivelMedio(sc);
					puntos = (int) ((puntos * 100 / 7) * 1.5); // El nivel medio otorgará un 50% más de puntos por
																// acierto
					System.out.println("\nHas conseguido " + puntos + " puntos.");
					break;
				case 3:
					puntos = nivelDificil(sc);
					puntos = (puntos * 100 / 7) * 2; // El nivel dificil otorgará el doble de puntos por acierto
					System.out.println("\nHas conseguido " + puntos + " puntos.");
					break;
			}

			// Comprobar si la puntuación obtenida recientemente es mayor que la puntuación
			// máxima, y si es así, guardarlo en la variable puntMax
			if (puntos != 0) {
				if (puntos > puntMax) {
					System.out.println("\n¡Nueva puntuación máxima!");
					puntMax = puntos;
				} else {
					System.out.println("Puntuación máxima: " + puntos);
				}
			}

			// En éste método se pregunta al jugador si quiere jugar otra vez
			repetir = jugarNuevo(sc);

		} while (repetir == true);

		return puntMax;
	}

	/**
	 * Introducir el juego, pidiendo elegir el nivel de dificultad, y la posterior
	 * confirmacion.
	 * 
	 * @param sc Contiene el objeto Scanner
	 * @return Devuelve el nivel de dificultad (1, 2 o 3)
	 */
	public static int introduccion(Scanner sc) {
		int dificultad;
		char confirm = 'N';

		do {
			if (confirm == 'N') {
				System.out.println("\nEscoje el nivel de dificultad:");
				System.out.println("[1]Fácil");
				System.out.println("[2]Medio");
				System.out.println("[3]Difícil");
			}

			do {
				dificultad = 0;
				try {
					dificultad = sc.nextInt(); // El jugador selecciona una dificultad del 1 al 3
					if (dificultad < 1 || dificultad > 3) {
						System.out.print("Por favor, escoge uno de esos tres números: ");
					}
				} catch (InputMismatchException e) { // Con el try-catch nos aseguramos de que el jugador introduzca un
														// int
					System.out.print("Por favor, introduce uno de esos tres números: ");
					sc.next();
				}
			} while (dificultad != 1 && dificultad != 2 && dificultad != 3);

			do {
				switch (dificultad) { // Pedimos al jugador que confirme su selección, por si se ha equivocado
					case 1:
						System.out.println("\nHas elegido el nivel fácil. ¿Deseas continuar? S/N");
						break;
					case 2:
						System.out.println("\nHas elegido el nivel medio. ¿Deseas continuar? S/N");
						break;
					case 3:
						System.out.println("\nHas elegido el nivel difícil. ¿Deseas continuar? S/N");
						break;
				}

				confirm = sc.next().toUpperCase().charAt(0); // Nos aseguramos de que el jugador responda correctamente
				if (confirm != 'S' && confirm != 'N') {
					System.out.println("\nDebes introducir 'S'(Sí) o 'N'(No).");
				}

			} while (confirm != 'S' && confirm != 'N');

		} while (confirm == 'N');

		return dificultad;
	}

	/**
	 * El metodo crea y rellena el contenido del array del nivel facil.
	 * 
	 * @param sc Contiene el objeto Scanner
	 * @return Devuelve la cantidad de puntos obtenidos (cantidad de vidas
	 *         restantes)
	 */
	public static int nivelFacil(Scanner sc) {
		int puntos;
		String[] arrayRespuestas = { "Antananarivo", "Malgache", "Arroz", "Lemur", "Julien" };
		String[] arrayPreguntas = { "Nombre de la capital de Madagascar:", "Gentilicio de Madagascar:",
				"Este conocido alimento, es el más comun y utilizado del país:",
				"Animal primate nativo de la gran isla, responsable de gran parte del turismo: ",
				"Hablando de Lémures, nombre del conocido personaje animado de los Pingüinos de Madagascar: El Rey ..." };
		boolean ganador = true;

		// En éste método se ejecuta el desarrollo del nivel, y devuelve los puntos
		// obtenidos
		puntos = desarrNivel(arrayPreguntas, arrayRespuestas, ganador, sc);

		return puntos;
	}

	/**
	 * El metodo crea y rellena el contenido del array del nivel medio.
	 * 
	 * @param sc Contiene el objeto Scanner
	 * @return Devuelve la cantidad de puntos obtenidos (cantidad de vidas
	 *         restantes)
	 */
	public static int nivelMedio(Scanner sc) {
		int puntos;
		String[] arrayRespuestas = { "Ariary", "Darwin", "Vary", "Merina", "Aye Aye" };
		String[] arrayPreguntas = { "Moneda oficial de Madagascar: ",
				"Apellido del científico naturalista más famoso de la historia, que le da nombre a la araña más emblemática de Madagascar: La araña de corteza de ...",
				"\"Arroz\" en el idioma local:", "Nombre de la tribu más predominante del país:",
				"Primate emparentado con los lémures, cuya estrafalaria apariencia hace que se le considere el principal responsable del origen de la palabra \"lémur\", que quiere decir en latín \"espíritu nocturno\":" };
		boolean ganador = true;

		// En éste método se ejecuta el desarrollo del nivel, y devuelve los puntos
		// obtenidos
		puntos = desarrNivel(arrayPreguntas, arrayRespuestas, ganador, sc);

		return puntos;
	}

	/**
	 * El metodo crea y rellena el contenido del array del nivel dificil.
	 * 
	 * @param sc Contiene el objeto Scanner
	 * @return Devuelve la cantidad de puntos obtenidos (cantidad de vidas
	 *         restantes)
	 */
	public static int nivelDificil(Scanner sc) {
		int puntos;
		String[] arrayRespuestas = { "Lambda", "Ranovola", "Famadihana", "Moraingy", "Masonjoany" };
		String[] arrayPreguntas = { "Vestimenta tradicional de los nativos malgaches:",
				"Bebida tradicional muy popular en Madagascar, a menudo llamada bebida nacional. Es como un jugo hecho de arroz seco:",
				"Tradición funeraria de la tribu de los Merina. También conocido como el regreso de la muerte:",
				"Lucha tradicional del pueblo \"Sakalava\" entre miembros de aldeas vecinas:",
				"Pasta cosmética y protector solar hecha de madera molida. Las mujeres y niñas de Madagascar la usan como máscara protectora y decorativa:" };
		boolean ganador = true;

		// En éste método se ejecuta el desarrollo del nivel, y devuelve los puntos
		// obtenidos
		puntos = desarrNivel(arrayPreguntas, arrayRespuestas, ganador, sc);

		return puntos;
	}

	/**
	 * Este metodo efectua el avance cuando logras acertar la pregunta, y la
	 * detencion del juego cuando no lo logras.
	 * 
	 * @param preguntas Contiene el array con las preguntas
	 * @param respuestas Contiene el array con las respuestas
	 * @param ganador Contiene el boolean que determina si avanzas o pierdes
	 */
	public static int desarrNivel(String[] preguntas, String[] respuestas, boolean ganador, Scanner sc) {
		// Este array de una única casilla contiene las vidas del jugador, para
		// emplearlo a través de los métodos por referencia
		int[] derrota = new int[1];
		derrota[0] = 7; // El 7 son las vidas máximas (partes del cuerpo del monigote del ahorcado)
		int puntos;

		for (int i = 0; i < respuestas.length && ganador == true; i++) {
			System.out.println("\n" + preguntas[i]);
			// En el siguiente método se ejecuta el juego por cada palabra, y devuelve un
			// boolean que dice si has pasado de palabra o has perdido
			ganador = juego(respuestas[i], ganador, derrota, sc);

			if (i < respuestas.length - 1 && ganador == true) {
				// Aquí damos un bonus de vidas por acertar cada palabra, según cuántas
				// vidas tenga el jugador
				if (derrota[0] <= 5) {
					derrota[0] += 2;
					System.out.println("\n¡Genial! Siguiente palabra.");
					System.out.println("Bonus: +2 partes del cuerpo."); // Sumamos 2 vidas por palabra superada
				} else if (derrota[0] == 6) {
					derrota[0] += 1;
					System.out.println("\n¡Genial! Siguiente palabra.");
					System.out.println("Bonus: +1 parte del cuerpo."); // Sumamos sólo 1 para no superar las 7 vidas
				} else {
					System.out.println("\n¡Genial! Siguiente palabra.");
				}

			} else {
				if (i < respuestas.length && ganador == true) {
					System.out.println("\n¡HAS GANADO!");
				} else {
					ahorcado(derrota[0]); // Mostramos el monigote entero
					System.out.println("\nHas perdido.");
				}
			}
		}
		puntos = derrota[0]; // Los puntos serán las vidas con las que se haya quedado el jugador

		return puntos;
	}

	/**
	 * En este metodo se ejecuta lo que es el juego interactivo en si, por cada
	 * palabra.
	 * 
	 * @param respuesta Contiene la respuesta a acertar
	 * @param winner Contiene el boolean que te permite avanzar de nivel o no
	 * @param derrota Contiene el array de un unico elemento, que contiene la
	 *                  cantidad de vidas del jugador
	 * @param sc Contiene el objeto Scanner
	 * @return Devuelve el boolean que te permitira avanzar en el nivel o no
	 */
	public static boolean juego(String respuesta, boolean winner, int[] derrota, Scanner sc) {
		char[] palabra, huecos;
		char letra = ' ';
		int letrRestant = 0;
		boolean letraMala;

		// Convertimos la palabra que toque en un array con el .toCharArray
		palabra = respuesta.toUpperCase().toCharArray();

		// Éste método crea un nuevo array con la longitud de la palabra
		// correspondiente, y devuelve el mismo sustituyendo el contenido de cada
		// casilla por un "_" (que representa un hueco)
		huecos = arrayHuecos(palabra);

		for (int i = 0; i < huecos.length; i++) {
			System.out.print(huecos[i] + " ");
		}
		System.out.println();

		// Contemplar el problema de los espacios en las palabras compuestas
		for (int i = 0; i < huecos.length; i++) {
			if (huecos[i] != ' ') {
				letrRestant++; // Ésta variable cuenta las letras restantes por cada palabra
			}
		}

		do {
			letraMala = true; // Si éste boolean sale del for siendo true, restará una vida

			// Imprimimos el monigote en el estado que se encuentre según las vidas
			// restantes
			ahorcado(derrota[0]);

			System.out.print("\nIntroduce una letra: ");
			letra = sc.next().toUpperCase().charAt(0);
			System.out.println();

			for (int i = 0; i < palabra.length && derrota[0] > 0; i++) {
				// Si la letra introducida es distinta todas las de la respuesta o es igual a
				// alguna de "huecos", entra en el if e imprime el array "huecos" sin cambios
				if (letra != palabra[i] || letra == huecos[i]) {
					System.out.print(huecos[i] + " ");
					// Si la letra introducida es igual a alguna de la respuesta y no ha sido
					// introducida previamente, sustituye esa casilla del array "huecos" por la
					// letra introducida
				} else {
					huecos[i] = palabra[i];
					System.out.print(huecos[i] + " ");
					letrRestant--; // Resta 1 a las letras restantes
					letraMala = false; // Cambia el boolean a false para no restar vidas en este intento
				}
			}

			// Si la letra introducida no existe en la respuesta correcta, resta una vida
			if (letraMala == true) {
				derrota[0]--;
			}
			System.out.println();

			// Si las vidas llegan a 0, cambia el boolean de victoria a false
			if (derrota[0] <= 0) {
				winner = false;
			}

		} while (winner == true && letrRestant != 0);

		return winner;
	}

	/**
	 * Este metodo crea el array con la cantidad de huecos "_" que contiene la
	 * respuesta
	 * 
	 * @param palabra Contiene el .toCharArray, de la respuesta
	 * @return Devuelve un array con la cantidad de huevos de la respuesta
	 */
	public static char[] arrayHuecos(char[] palabra) {
		char[] hueco = new char[palabra.length];
		for (int i = 0; i < palabra.length; i++) {
			// A continuación hacemos que las palabras compuestas no tomen el espacio o el
			// guión como un hueco a rellenar
			if (palabra[i] != ' ' && palabra[i] != '-') {
				hueco[i] = '_';
			} else {
				hueco[i] = ' ';
			}
		}
		return hueco;
	}

	/**
	 * Este metodo imprime las diferentes formas del monigote del ahorcado
	 * 
	 * @param vidas Contiene la cantidad de vidas que tiene el jugador
	 */
	public static void ahorcado(int vidas) {
		System.out.println();
		// Según las vidas que tenga el jugador, el monigote irá generando partes del
		// cuerpo
		switch (vidas) {
			case 7:
				System.out.println(" |---|  ");
				System.out.println(" |      ");
				System.out.println(" |      ");
				System.out.println(" |      ");
				System.out.println(" |      ");
				System.out.println(" |      ");
				System.out.println(" -      ");
				break;

			case 6:
				System.out.println(" |---|  ");
				System.out.println(" |   O  ");
				System.out.println(" |      ");
				System.out.println(" |      ");
				System.out.println(" |      ");
				System.out.println(" |      ");
				System.out.println(" -      ");
				break;
			case 5:
				System.out.println(" |---|  ");
				System.out.println(" |   O  ");
				System.out.println(" |   |  ");
				System.out.println(" |      ");
				System.out.println(" |      ");
				System.out.println(" |      ");
				System.out.println(" -      ");
				break;
			case 4:
				System.out.println(" |---|  ");
				System.out.println(" |   O  ");
				System.out.println(" |  /|  ");
				System.out.println(" |      ");
				System.out.println(" |      ");
				System.out.println(" |      ");
				System.out.println(" -      ");
				break;
			case 3:
				System.out.println(" |---|  ");
				System.out.println(" |   O  ");
				System.out.println(" |  /|\\");
				System.out.println(" |      ");
				System.out.println(" |      ");
				System.out.println(" |      ");
				System.out.println(" -      ");
				break;
			case 2:
				System.out.println(" |---|  ");
				System.out.println(" |   O  ");
				System.out.println(" |  /|\\");
				System.out.println(" |   |  ");
				System.out.println(" |      ");
				System.out.println(" |      ");
				System.out.println(" -      ");
				break;

			case 1:
				System.out.println(" |---|  ");
				System.out.println(" |   O  ");
				System.out.println(" |  /|\\");
				System.out.println(" |   |  ");
				System.out.println(" |  /   ");
				System.out.println(" |      ");
				System.out.println(" -      ");
				break;

			case 0:
				System.out.println(" |---|  ");
				System.out.println(" |   O  ");
				System.out.println(" |  /|\\");
				System.out.println(" |   |  ");
				System.out.println(" |  / \\");
				System.out.println(" |      ");
				System.out.println(" -      ");
				break;

			default:
				System.out.println();
				break;
		}
	}

	/**
	 * Este metodo es el que permite al jugador empezar una nueva partida si lo
	 * desea, tras acabar la anterior
	 * 
	 * @param sc Contiene el objeto Scanner
	 * @return Devuelve el boolean que en el main te permitira jugar de nuevo si
	 *         lo deseas
	 */
	public static boolean jugarNuevo(Scanner sc) {
		char respuesta;
		boolean repetir = true;

		do {
			System.out.println("\n¿Deseas jugar de nuevo? S/N");
			respuesta = sc.next().toUpperCase().charAt(0);

			if (respuesta == 'S') {
				repetir = true;

			} else if (respuesta == 'N') {
				repetir = false;

			} else {
				System.out.println("Por favor, introduce 'S'(Sí) o 'N'(No).");
			}

		} while (respuesta != 'S' && respuesta != 'N');

		return repetir;
	}
}