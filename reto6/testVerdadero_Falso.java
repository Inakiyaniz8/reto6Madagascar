import java.util.Scanner;

public class testVerdadero_Falso {

	/**
	 * Metodo que maneja el desarrollo de la ejecucion del test
	 * @return Devuelve la puntuacion obtenida en el test
	 */
	public static int VFMain(Scanner sc) {
		int puntos;

 		// Arrays que contienen las preguntas, respuestas correctas y mensajes de explicación
		String[] preguntas = { "Toamasina es la capital de Madagascar. V/F",
				"Hay 28 millones de habitantes en Madagascar. V/F", "Malgache es el idioma oficial. V/F",
				"El afro es la moneda del país. V/F", "Madagascar es un continente. V/F",
				"Madagascar es conocido por sus animales. V/F", "El lémur es uno de los animales más emblemáticos. V/F",
				"Hay más de 100 especies de lémures en Madagascar. V/F",
				"El camaleón pantera de Madagascar es conocido por su capacidad para cambiar de color rápidamente. V/F",
				"El fosa es un tipo de lémur. V/F" };

		char[] rCorrectas = { 'F', 'V', 'V', 'F', 'F', 'V', 'V', 'V', 'V', 'F' };

		String[] mensaje = { "Antananarivo es la capital de Madagascar", "Población: 28.812.195",
				"El idioma del país es el malgache.",
				"La moneda utilizada en Madagascar es el Ariary (abreviado como MGA o AR).",
				"Aunque por su tamaño podría considerarse todo un continente ya que es la isla más grande de África, Madagascar es un país",
				"Madagascar es conocido por ser hogar de una gran diversidad de especies animales únicas y endémicas.",
				"Los lémures, el camaleón pantera, el fosa y diversas especies de geckos son algunos de los animales más emblemáticos de Madagascar.",
				"Se estima que hay alrededor de 100 especies de lémures en Madagascar, y todas son endémicas de la isla.",
				"El camaleón pantera es famoso por su habilidad para cambiar de color según su entorno y estado de ánimo.",
				"El fosa es un carnívoro que se asemeja a un gato y es el depredador más grande de Madagascar, pero no es un lémur." };

		System.out.println("Bienvenido al test verdadero o falso. ¡Comencemos!");

		// Llamada al método test para llevar a cabo el test y calcular los puntos
		puntos=test(preguntas, rCorrectas, mensaje, sc);

		// Devuelve los puntos obtenidos
		return puntos;
	}

	/**
	 * Metodo para realizar el test y calcular los puntos
	 * @param preguntas Contiene el array con las preguntas
	 * @param rCorrectas Contiene el array con las respuestas correctas
	 * @param mensaje Contiene un array con informacion extra despues de responder
	 * @param sc Contiene el objeto Scanner
	 * @return Devuelve la puntuacion obtenida en el test
	 */
	private static int test(String[] preguntas, char[] rCorrectas, String[] mensaje, Scanner sc) {
		char respuesta;
		int respuestasCo = 0, respuestasIn = 0, puntuacion = 0;

		// Bucle para iterar a través de todas las preguntas
		for (int i = 0; i < preguntas.length; i++) {
			// Bucle para solicitar una respuesta válida del usuario
			do {
				System.out.println((i + 1) + ". " + preguntas[i]);
				respuesta = sc.next().toUpperCase().charAt(0);
				if (respuesta != 'V' && respuesta != 'F') {
					System.out.println("Caracter no válido");
				}
			} while (respuesta != 'V' && respuesta != 'F');

			// Verifica si la respuesta del usuario es correcta
			if (respuesta == rCorrectas[i]) {
				System.out.println("Correcto 👍");
				System.out.println(mensaje[i]);
				System.out.println();
				respuestasCo++;
				puntuacion += 10; // Suma 10 puntos por respuesta correcta
			} else {
				System.out.println("Incorrecto 👎");
				System.out.println(mensaje[i]);
				System.out.println();
				respuestasIn++;
			}
		}
		// Imprime los resultados del test
		System.out.println("Resultados:");
		System.out.println("Respuestas correctas: " + respuestasCo);
		System.out.println("Respuestas incorrectas: " + respuestasIn);
		System.out.println("Tu puntuación total es: " + puntuacion);

		return puntuacion; // Devuelve los puntos obtenidos en el test
	}
}