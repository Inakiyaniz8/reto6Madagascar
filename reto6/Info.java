import java.util.*;

/**
 * Clase que controla el menu principal con las secciones de informacion.
 */
public class Info {

    /**
     * Metodo principal de la clase Info, que controla la ejecucion del menu.
     */
    public static void InfoMain(Scanner sc) {
        int input;

        do {
            System.out.println("Selecciona la sección que quieres consultar:");
            System.out.println("[1]Historia [2]Sitios de interés [3]Fauna [4]Datos de interés [5]Volver");

            // Validación de la opción elegida por el usuario.
            do {
                input = 0;
                try {
                    input = sc.nextInt(); // El jugador selecciona un input del 1 al 5
                    if (input < 1 || input > 5) {
                        System.out.print(input+" no es una opción.");
                    }
                } catch (InputMismatchException e) { // Con el try-catch nos aseguramos de que el jugador introduzca un int
                    System.out.print("Por favor, introduce una de esas cinco opciones: ");
                    sc.next();
                }
            } while (input < 1 || input > 5);

            switch (input) {
                case 1:
                    Historia.historiaMain(sc);
                    break;
                case 2:
                    SitiosDeInteres.sitiosDeInteresMain(sc);
                    break;
                case 3:
                    Fauna.faunaMain(sc);
                    break;
                case 4:
                    DatosDeInteres.datosMain(sc);
                    break;
                case 5:
                    System.out.println("Gracias por tu tiempo.");
                    break;
            }
        } while (input != 5);
    }
}