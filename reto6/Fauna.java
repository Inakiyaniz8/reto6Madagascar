import java.util.Scanner;

/**
 * Clase con la seccion de la informacion sobre la fauna de Madagascar.
 */
public class Fauna {

	/**
	 * Metodo que devuelve una lista de nombres de animales.
	 * @return Nombre del animal
	 */
	public static String[] nombresAnimales() {
		String [] animales= {"1. Lémur","2. Gecko Cola De Hoja Satánico","3. Fosa","4. Aye-Aye","5. Tenrec","6. Polilla Cometa","7. Serpiente Cabeza De Hoja","8. Gorgojo Girafa","9. Porrón Malgache","10. Tortuga Radiada"};
		return animales;
	}

	/**
	 * Metodo que devuelve informacion sobre un animal.
	 * @return Informacion sobre animal elegido.
	 */
	public static String[] animalesMadagascar() {
		String [] animalesInfo= {	"El Lemur (Lemur catta) es un mamífero que pertenece al orden de los primates, entre los cuales se considera uno de los más "
				+ "pequeños del mundo. \nSe caracteriza por tener un cuerpo similar al de una ardilla, y destaca por "
				+ "sus capacidades atléticas y su comportamiento altamente social."

							   		, "El Gecko Cola De Hoja Satánico(Uroplatus phantasticus) Es una especie hábil a la hora de camuflarse con las hojas de su hábitat. "
							   				+ "\nPosee un cuerpo arqueado con franjas que cubren su piel, su cola es similar a una hoja doblada, lo cual le ayuda a ocultarse entre el follaje."

							   		, "El Fosa (Cryptoprocta ferox) es el mamífero carnívoro más grande de Madagascar, siendo el lémur su presa principal. "
							   				+ "\nPosee un cuerpo ágil y muy fuerte, lo que le permite desplazarse con gran habilidad a través de su hábitat."

							   		, "El Aye-Aye (Daubentonia madagascariensis) a pesar de parecer un roedor, es el primate nocturno más grande del mundo. "
							   				+ "\nSe caracteriza por presentar dedos alargados y curvos, los cuales utiliza para conseguir insectos en lugares profundos y "
							   				+ "difíciles de alcanzar, \ncomo el tronco de los árboles."

							   		, "El Tenrec (Hemicentetes semispinosus) es un mamífero de hocico largo y cuerpo recubierto de pequeñas púas que utiliza para defenderse. "
							   				+ "\nTiene la habilidad de comunicarse a través de un sonido que realiza frotando distintas partes de su cuerpo, lo que le sirve incluso para \nconseguir pareja."

							   		, "La Polilla Cometa (Argema Mittrei) es una mariposa de la selva tropical de Madagascar con una envergadura impresionante: "
							   				+ "\n20 centímetros y 15 centímetros de cola. Es una de las mariposas más grandes del mundo. Presenta una figura muy particular que le otorga gran \nbelleza. "
							   				+ "Son insectos nocturnos que no pasan desapercibidos ni de día ni de noche."

							   		, "La Serpiente Cabeza de Hoja (Langaha Madagascariensis) son de fácil identificación gracias, precisamente, a sus cabezas planas en forma de hoja."
							   				+ "\nPueden crecer hasta casi un metro de largo."

							   		, "El Gorgojo Jirafa (Trachelophorus giraffa) de apenas 2,5 centímetros es uno de los escarabajos más raros del mundo. Aunque ambos sexos presentan \neste extraño cuello articulado,"
							   				+ "el de los machos es tres veces más grande que el de las hembras"

							   		, "Porron Malgache (Aythya innotata) es una especie de ave que mide 50 centímetros. Posee un plumaje abundante de tonos oscuros, más \nopacos en los machos."

							   		, "La Tortuga Radiada (Astrochelys radiata) habita los bosques al sur de Madagascar. Vive hasta 100 años. Se caracteriza por presentar un caparazón \nalto cruzado con líneas amarillas, "
							   				+ "una cabeza chata y patas de tamaño mediano. La tortuga radiada es un animal herbívoro, \nque se alimenta de plantas y frutas."};

		return animalesInfo;
	}

	/**
	 * Metodo para continuar o no la ejecucion del programa de los animales.
	 * @param info Array con la informacion del animal, utilizado para controlar la entrada del usuario.
	 */
	public static void elegirNum(String [] info, Scanner sc) {
		int num;
		String sn;
		do {
			System.out.println(" ");
			System.out.println("Escribe el número del animal del que quieras saber más.");
			num = sc.nextInt();
			do {
				if (num <= 0 || num >10) {
					System.out.println("Escribe un número entre 1 y 10.");
					num=sc.nextInt();
				} else {
					System.out.println(" ");
					System.out.println(info[num - 1]);
				}
			}while(num <= 0 || num >10);
			System.out.println(" ");
			do {
				System.out.println("Quieres seguir viendo la fauna de Madagascar? S/N");
				System.out.println("");
				sn=sc.next();	
				if(!sn.equalsIgnoreCase("S") && !sn.equalsIgnoreCase("N")){
					System.out.println("Introduzca S para continuar o N para parar");
				}
			}while(!sn.equalsIgnoreCase("S") && !sn.equalsIgnoreCase("N"));
		} while (!sn.equalsIgnoreCase("N"));
	}

	/**
	 * Metodo para imprimir la lista con los nombre de los animales.
	 * @param nombresAni Array con los nombres.
	 */
	public static void imprimirNomAnimales(String [] nombresAni) {

		for(int i=0;i<nombresAni.length;i++) {
			System.out.println(nombresAni[i]);
			System.out.println(" ");
		}
	}

	/**
	 * Metodo que controla la ejecucion de la clase Fauna
	 */
	public static void faunaMain(Scanner sc) {
		String [] nombres;
		String [] info;

		nombres=nombresAnimales();
		imprimirNomAnimales(nombres);
		info=animalesMadagascar();
		elegirNum(info, sc);
	}
}