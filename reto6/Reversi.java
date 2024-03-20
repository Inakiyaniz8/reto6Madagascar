import java.util.Scanner;

public class Reversi {

	private static final int BOARD_SIZE = 8;
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static boolean turnoJugador = true;
	public static int[][] validarPosicion = new int[BOARD_SIZE][BOARD_SIZE];
	public static int casillasLibre = 64;
	public static int casillasOcupadas = 0;
	public static String[][] tablero = new String[BOARD_SIZE][BOARD_SIZE];
	public static boolean ganador=false;

	/**
	 * Este metodo se encarga de colocar el tablero en blanco al inicio de la partida. 
	 * Parametros: No recibe ningun parametro.
	 */
	public static void rellenarPrimera() {
		for (int x = 0; x < tablero.length; x++) {
			for (int y = 0; y < tablero[x].length; y++) {
				tablero[x][y] = "-";
			}
		}
	}

	/**
	 * Metodo que se encarga de solicitar al jugador las coordenadas donde desea colocar su ficha en el tablero.
	 * @return Arreglo de enteros que representa las coordenadas [columna, fila] seleccionadas por el jugador.
	 */
	public static int[] pedirMovimiento(Scanner sc) {
		String result, aux;
		int[] coordenada;
		int aux2=0, columna, fila;
		result = null;
		boolean casillaEstaLibre = true;

		// Bucle principal que se ejecuta hasta que se selecciona una casilla válida y
		// libre
		do {
			// Bucle para solicitar la coordenada en el eje x
			do {
				if (result == null || !casillaEstaLibre) {
					System.out.println("Dime la coordenada en el eje x donde quieres poner la ficha");
				} else {
					System.out.println("Error, esa coordenada x no existe. Por favor, escríbela de nuevo.");
				}
				aux = sc.nextLine();
				result = aux.toLowerCase();
			} while (!(result.equals("a") || result.equals("b") || result.equals("c") || result.equals("d")
					|| result.equals("e") || result.equals("f") || result.equals("g") || result.equals("h")));

			// Solicitar la coordenada en el eje y
			System.out.println("Dime la coordenada en el eje y donde quieres poner la ficha");
			
			  // Manejar entrada no numérica con try-catch
        try {
            aux2 = sc.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error, no has introducido un valor numérico válido.");
            sc.next(); // Limpiar el buffer de entrada
			System.out.println("introduce un numero de entre 1-8");
			aux2 = sc.nextInt();
        }


			// Validar la coordenada en el eje y
			while (aux2 < 1 || aux2 > 8) {
				System.out.println("Error, esa coordenada y no existe. Por favor, escríbela de nuevo.");
				aux2 = sc.nextInt();
			}

			// Combinar las coordenadas x e y y convertirlas a formato [columna, fila]
			result = result + aux2;
			coordenada = conversionMovimientoCoordenada(result);
			columna = coordenada[0];
			fila = coordenada[1];

			// Validar si la casilla seleccionada está ocupada
			if (validarPosicion[fila][columna] != 0) {
				casillaEstaLibre = false;
				System.out.println("Error, la casilla está ocupada. No puedes poner otra ficha encima.");
				result = null;
			} else {
				casillaEstaLibre = true;
			}
			sc.nextLine(); // Limpiar el buffer del scanner
		} while (!casillaEstaLibre);

		return coordenada;
	}

	/**
	 * Metodo que genera una posicion aleatoria donde la maquina colocara su ficha en el tablero.
	 * @return Arreglo de enteros que representa las coordenadas [columna, fila] seleccionadas aleatoriamente.
	 */
	public static int[] randomMovimiento() {
		String result, aux3 = "";
		int[] coordenada;
		int aux2, columna, fila, aux;
		result = null;
		boolean casillaEstaLibre = true;

		// Bucle principal que se ejecuta hasta que se selecciona una casilla válida y
		// libre aleatoriamente
		do {
			aux = (int) (Math.random() * 7);

			// Convertir el número aleatorio a una letra representando la coordenada en el
			// eje x
			switch (aux) {
			case 0:
				aux3 = "a";
				break;
			case 1:
				aux3 = "b";
				break;
			case 2:
				aux3 = "c";
				break;
			case 3:
				aux3 = "d";
				break;
			case 4:
				aux3 = "e";
				break;
			case 5:
				aux3 = "f";
				break;
			case 6:
				aux3 = "g";
				break;
			case 7:
				aux3 = "h";
				break;
			}

			result = aux3.toLowerCase();

			// Generar un número aleatorio para la coordenada en el eje y
			aux2 = (int) (Math.random() * 7);

			result = result + aux2;

			// Convertir las coordenadas a formato [columna, fila]
			coordenada = conversionMovimientoCoordenada(result);
			columna = coordenada[0];
			fila = coordenada[1];

			// Validar si la casilla seleccionada aleatoriamente está ocupada
			if (validarPosicion[fila][columna] != 0) {
				casillaEstaLibre = false;
				result = null;
			} else {
				casillaEstaLibre = true;
			}
		} while (!casillaEstaLibre);

		return coordenada;
	}

	/**
	 * Metodo que convierte una cadena de texto que representa un movimiento en el tablero en un arreglo de enteros de dos posiciones [columna, fila].
	 * @param result Cadena de texto que representa un movimiento en el tablero.
	 * @return Arreglo de enteros de dos posiciones [columna, fila].
	 */
	public static int[] conversionMovimientoCoordenada(String result) {
		if (result.length() != 2) {
			// Manejar el caso de una longitud incorrecta de la cadena
			System.out.println("Error: Longitud incorrecta de la cadena");
			return null; // o manejarlo de otra manera según tus necesidades
		}

		int fila = 0, columna = 0;
		char filaAux, columnaAux;
		int[] coordenada = new int[2];

		columnaAux = result.charAt(0);

		// Convertir la coordenada en el eje x a un número entero
		switch (columnaAux) {
		case 'a':
			columna = 0;
			break;
		case 'b':
			columna = 1;
			break;
		case 'c':
			columna = 2;
			break;
		case 'd':
			columna = 3;
			break;
		case 'e':
			columna = 4;
			break;
		case 'f':
			columna = 5;
			break;
		case 'g':
			columna = 6;
			break;
		case 'h':
			columna = 7;
			break;
		default:
			System.out.println("Error: Coordenada x no válida");
		}

		filaAux = result.charAt(1);

		// Convertir la coordenada en el eje y a un número entero
		fila = Character.getNumericValue(filaAux) - 1;

		coordenada[0] = columna;
		coordenada[1] = fila;

		return coordenada;
	}

	/**
	 * Metodo que dibuja la ficha en el tablero segun las coordenadas proporcionadas. Modifica el tablero con el simbolo
	 * correspondiente ("O" para el jugador y "X" para la maquina). Tambien actualiza el turno del jugador. Despues de pintar la ficha, la funcion llama
	 * a validarPosiciones() y chequearCambios() para realizar las validaciones necesarias en el tablero.
	 * @param coordenada Un arreglo de enteros de dos posiciones [columna, fila] que representa la posicion en el tablero.
	 */
	public static void pintar(int[] coordenada) {
		int fila, columna;

		// Obtener las coordenadas
		columna = coordenada[0];
		fila = coordenada[1];

		// Bucle para recorrer las filas del tablero
		for (int x = 0; x < tablero.length; x++) {
			// Bucle para recorrer las columnas del tablero
			for (int y = 0; y < tablero[x].length; y++) {
				// Verificar si es el turno del jugador y la posición actual coincide con las
				// coordenadas
				if (turnoJugador && fila == x && columna == y) {
					tablero[x][y] = "O"; // Dibujar ficha del jugador
					turnoJugador = false; // Cambiar el turno al jugador contrario
				}
				// Verificar si es el turno de la máquina y la posición actual coincide con las
				// coordenadas
				else if (!turnoJugador && fila == x && columna == y) {
					tablero[x][y] = "X"; // Dibujar ficha de la máquina
					turnoJugador = true; // Cambiar el turno al jugador contrario
				}
			}
		}

		// Realizar validaciones en el tablero después de pintar la ficha
		validarPosiciones();

		// Chequear si hay cambios en el tablero después de pintar la ficha
		chequearCambios(coordenada);
	}

	/**
	 * Metodo que pinta la ficha en forma de cruz del mismo bando que la coordenada introducida. Modifica el tablero con el simbolo
	 * correspondiente ("O" o "X") segun el valor proporcionado. Despues de pintar la ficha, la funcion llama a validarPosiciones() para realizar las
	 * validaciones necesarias en el tablero.
	 * @param Cambio Un arreglo de enteros de dos posiciones [columna, fila] que representa la posicion en el tablero.
	 * @param valor Un entero que indica el bando de la ficha a pintar (1 para "O", 2 para "X").
	 */
	public static void pintar(int[] Cambio, int valor) {
		int fila, columna;

		// Obtener las coordenadas
		columna = Cambio[0];
		fila = Cambio[1];

		// Bucle para recorrer las filas del tablero
		for (int x = 0; x < tablero.length; x++) {
			// Bucle para recorrer las columnas del tablero
			for (int y = 0; y < tablero[x].length; y++) {
				// Verificar el valor proporcionado y pintar la ficha correspondiente
				if (valor == 1 && fila == x && columna == y) {
					tablero[x][y] = "O"; // Pintar ficha "O"
				} else if (valor == 2 && fila == x && columna == y) {
					tablero[x][y] = "X"; // Pintar ficha "X"
				}
			}
		}

		// Realizar validaciones en el tablero después de pintar la ficha
		validarPosiciones();
	}

	/**
	 * Metodo que contabiliza en el tablero el estado de cada casilla, la cantidad de casillas ocupadas y la cantidad de casillas libres. Modifica las matrices validarPosicion,
	 * casillasLibre y casillasOcupadas segun el estado de cada casilla en el tablero. Si todas las casillas estan ocupadas, llama a la funcion  escogerGanado() para determinar al ganador.
	 */
	public static void validarPosiciones() {
		casillasLibre = 64; // Inicializar la cantidad de casillas libres
		casillasOcupadas = 0; // Inicializar la cantidad de casillas ocupadas

		// Bucle para recorrer las filas del tablero
		for (int x = 0; x < tablero.length; x++) {
			// Bucle para recorrer las columnas del tablero
			for (int y = 0; y < tablero[x].length; y++) {
				// Verificar el estado de la casilla y actualizar las matrices correspondientes
				if (tablero[x][y].equals("-")) {
					validarPosicion[x][y] = 0; // Casilla libre
				} else if (tablero[x][y].equals("O")) {
					validarPosicion[x][y] = 1; // Casilla ocupada por ficha "O"
					casillasLibre--; // Decrementar la cantidad de casillas libres
					casillasOcupadas++; // Incrementar la cantidad de casillas ocupadas
				} else {
					validarPosicion[x][y] = 2; // Casilla ocupada por ficha "X"
					casillasLibre--; // Decrementar la cantidad de casillas libres
					casillasOcupadas++; // Incrementar la cantidad de casillas ocupadas
				}
			}
		}

		// Verificar si todas las casillas están ocupadas y llamar a escogerGanado() en
		// ese caso
		if (casillasLibre <= 0) {
			escogerGanado();
		}
	}

	/**
	 * Metodo que comprueba si en la posicion en cruz donde se ha colocado la ficha hay una ficha enemiga para transformarla. Si encuentra fichas enemigas en alguna direccion (izquierda,
	 * arriba, abajo, derecha), llama a la funcion pintar() para transformarlas.
	 * @param coordenada Un arreglo de enteros de dos posiciones [columna, fila] que representa la posicion en el tablero.
	 */
	public static void chequearCambios(int[] coordenada) {
		int izquierda, arriba, abajo, derecha;
		int fila, columna, valor;
		int[] nuevaCoordenada = new int[2];
		columna = coordenada[0];
		fila = coordenada[1];
		valor = validarPosicion[fila][columna];

		// Comprobar en la dirección izquierda
		izquierda = (columna <= 0) ? 0 : validarPosicion[fila][columna - 1];

		// Comprobar en la dirección arriba
		arriba = (fila <= 0) ? 0 : validarPosicion[fila - 1][columna];

		// Comprobar en la dirección abajo
		abajo = (fila >= 7) ? 0 : validarPosicion[fila + 1][columna];

		// Comprobar en la dirección derecha
		derecha = (columna >= 7) ? 0 : validarPosicion[fila][columna + 1];

		// Transformar fichas enemigas si las hay en alguna dirección
		if (izquierda != 0 && izquierda != valor) {
			nuevaCoordenada[0] = columna - 1;
			nuevaCoordenada[1] = fila;
			pintar(nuevaCoordenada, valor);
		}
		if (arriba != 0 && arriba != valor) {
			nuevaCoordenada[0] = columna;
			nuevaCoordenada[1] = fila - 1;
			pintar(nuevaCoordenada, valor);
		}
		if (abajo != 0 && abajo != valor) {
			nuevaCoordenada[0] = columna;
			nuevaCoordenada[1] = fila + 1;
			pintar(nuevaCoordenada, valor);
		}
		if (derecha != 0 && derecha != valor) {
			nuevaCoordenada[0] = columna + 1;
			nuevaCoordenada[1] = fila;
			pintar(nuevaCoordenada, valor);
		}
	}

	/**
	 * Metodo que determina al ganador del juego y muestra el resultado en la consola. Compara la cantidad de fichas del
	 * jugador y de la maquina en el tablero para determinar el ganador o si hay un empate. Imprime un mensaje en la consola indicando el resultado.
	 */
	public static void escogerGanado() {
		int contJugador = 0, contMaquina = 0;
		String result;

		// Contar la cantidad de fichas del jugador y de la máquina en el tablero
		for (int x = 0; x < tablero.length; x++) {
			for (int y = 0; y < tablero[x].length; y++) {
				if (tablero[x][y].equals("O")) {
					contJugador++;
				} else {
					contMaquina++;
				}
			}
		}

		// Determinar al ganador o si hay un empate
		if (contJugador > contMaquina) {
			result = "¡Enhorabuena por haber ganado, jugador!";
			ganador=true;
		} else if (contJugador < contMaquina) {
			result = "¡Mala suerte esta vez... quizás la próxima lo logres!";
		} else {
			result = "Es un empate";
		}

		// Mostrar el resultado en la consola
		System.out.println(result);
	}

	/**
	 * Metodo que muestra al jugador el estado actual del tablero en la consola. Utiliza colores ANSI para resaltar las
	 * fichas del jugador ("O" en verde) y de la maquina ("X" en amarillo). Ademas, muestra las coordenadas del tablero.
	 */
	public static void printTablero() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		for (int x = 0; x < tablero.length; x++) {
			System.out.println("_________________________________________________");
			System.out.println("|     |     |     |     |     |     |     |     |");
			for (int y = 0; y < tablero[x].length; y++) {
				// Mostrar fichas del jugador en verde
				if (tablero[x][y].equals("O") && y < tablero[x].length - 1) {
					System.out.print("|  " + ANSI_GREEN + tablero[x][y] + ANSI_RESET + "  ");
				}
				// Mostrar fichas de la máquina en amarillo
				else if (tablero[x][y].equals("X") && y < tablero[x].length - 1) {
					System.out.print("|  " + ANSI_YELLOW + tablero[x][y] + ANSI_RESET + "  ");
				}
				// Mostrar casillas vacías o con "-" en blanco
				else if (y < tablero[x].length - 1) {
					System.out.print("|  " + tablero[x][y] + "  ");
				}

				// Mostrar fichas del jugador en verde con la coordenada en rojo
				else if (tablero[x][y].equals("O")) {
					System.out.println(
							"|  " + ANSI_GREEN + tablero[x][y] + ANSI_RESET + "  | " + ANSI_RED + (x + 1) + ANSI_RESET);
				}
				// Mostrar fichas de la máquina en amarillo con la coordenada en rojo
				else if (tablero[x][y].equals("X")) {
					System.out.println("|  " + ANSI_YELLOW + tablero[x][y] + ANSI_RESET + "  | " + ANSI_RED + (x + 1)
							+ ANSI_RESET);
				}
				// Mostrar casillas vacías o con "-" en blanco con la coordenada en rojo
				else {
					System.out.println("|  " + tablero[x][y] + "  | " + ANSI_RED + (x + 1) + ANSI_RESET);
				}

			}
			System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|");
		}
		System.out.println();
		System.out.println(ANSI_CYAN + "   a     b     c     d     e     f     g     h" + ANSI_RESET);
		System.out.println();
	}

	/**
	 * Metodo principal de la clase Reversi que controla la ejecucion del programa
	 * @return Puntuacion conseguida con el juego.
	 */
	public static boolean mainReversi(Scanner sc) {
		int[] coordenada, maquina;

		tablero = new String[BOARD_SIZE][BOARD_SIZE];
		rellenarPrimera();
		System.out.println("Buenas, jugador.");
		System.out.println("Te explico las reglas de este juego.");
		System.out.println("Iréis por turnos conquistando casillas;");
		System.out.println("Una vez que una ficha se coloca en una casilla,no podrá ser ocupada por otra ficha.");
		System.out.println("Sin embargo, al colocar una ficha en las casillas en cruz donde haya una ficha enemiga ");
		System.out.println(ANSI_GREEN + "la trasformaras en tuya." + ANSI_RESET);
		System.out.println("Coloca primero en el eje x donde quieres la ficha");
		System.out.println(ANSI_CYAN + "   a     b     c     d     e     f     g     h" + ANSI_RESET);
		System.out.println("A continuación coloque en el eje y donde quieres la ficha");
		System.out.println(ANSI_RED + "   1     2     3     4     5     6     7     8" + ANSI_RESET);
		System.out.println("Al final el que mas fichas sullas tenga cuando todas las casillas esten ocupadas, gana.");
		System.out.println("¡Buena suerte!");
		System.out.println();
		while (casillasLibre >= 0) {
			if (turnoJugador == true) {
				System.out.println("Escriba la coordenada jugador");
				coordenada = pedirMovimiento(sc);
				System.out.println();
				pintar(coordenada);
				printTablero();
			} else {
				maquina = randomMovimiento();
				System.out.println();
				pintar(maquina);
				printTablero();
			}

			System.out.println("Estas son las casillas libres que quedan: " + casillasLibre);
			System.out.println("Estos son el numero de casillas ocupadas: " + casillasOcupadas);
		}
		return ganador;
	}

}