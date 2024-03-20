import java.util.Scanner;

/**
 * Clase con la seccion de la informacion sobre los datos de interes de Madagascar.
 */
public class DatosDeInteres {

	/**
	 * Metodo que devuelve la lista con las opciones para elegir un dato de interes.
	 * @return Array con la lista de datos de interes.
	 */
	public static String[] numInteres() {
		String [] numEleccion= {"1. Tamaño","2. Gentilicio","3. Grupos Etnicos","4. Arroz","5. Idioma Oficial","6. Poblacion","7. Lambas"};
		return numEleccion;
	}

	/**
	 * Metodo que devuelve la informacion sobre los datos de interes.
	 * @return Array con las informaciones.
	 */
	public static String[] infoInteres() {
		String[] interesInfo= {"Madagascar tiene más de 587.000 kilómetros cuadrados, lo que la convierte en la isla más grande de África."
				+ " A nivel mundial se posiciona como la \ncuarta, por detrás de Groenlandia, Nueva Guinea y Borneo."

							,"El gentilicio del país es el malgache, palabra que procede del francés tomada del término «malagasy»."
									+ " El idioma oficial del país también \nse llama malgache, a pesar de que también se utiliza el francés."

							,"En Madagascar se considera que hay 18 tribus o grupos étnicos diferentes. Gran parte de esta diferenciación "
									+"se debe a criterios culturales y \npolíticos, pero también existe una agrupación territorial de diferentes "
									+ "grupos étnicos dentro del país."

							,"Madagascar es uno de los principales productores de arroz del mundo. A su vez, uno de los mayores consumidores. "
									+ "Prácticamente todas las comidas \nllevan arroz como acompañamiento."

							,"Una de las preguntas más habituales entre los que quieren viajar a este país es: ¿cuál es su idioma? Pues el "
									+ "malgache es, además de su \ngentilicio, su lengua oficial y tiene origen malayo-polinesio. También se habla "
									+ "francés, especialmente en grandes ciudades, ya que el país fue \ncolonia francesa hasta bien entrado el siglo "
									+ "XX. El inglés no está muy extendido, aunque se pueden encontrar hablantes. "

							,"Cerca de 25 millones de personas viven aquí y aproximadamente el 60 % tiene menos de 25 años. Su esperanza "
									+ "de vida al nacer es muy baja: está \nen los 66,6 años, según datos de 2018. Por otra parte, cabe señalar que "
									+ "la isla tiene uno de los índices de fecundidad más elevados del mundo: \nel número de hijos por mujer en el "
									+ "país es de 4,5. No obstante, este índice ha descendido, ya que hace varios años la media superaba los 5 "
									+ "hijos \npor madre. "

							,"La vestimenta tradicional es la lamba, que usan hombres y mujeres, aunque estas últimas con más frecuencia. "
									+ "Ellas utilizan dos piezas de tela a \njuego que, generalmente, se colocan alrededor de la cintura o el pecho y "
									+ "también en la cabeza o los hombros. "};

		return interesInfo;
	}

	/**
	 * Metodo para imprimir las elecciones posibles
	 * @param numInteres Array con la lista de opciones.
	 */
	public static void imprimirInteres(String [] numInteres) {
		for(int i=0;i<numInteres.length;i++) {
			System.out.println(numInteres[i]);
			System.out.println(" ");
		}
	}

	/**
	 * Metodo que imprimie la informacion de los datos de interes.
	 * @param info Array con la lista de opciones de la seccion.
	 */
	public static void elegirInfoInteres(String [] info, Scanner sc) {
		int num;
		String sn;

		do {
			System.out.println(" ");
			System.out.println("Escribe el número del dato del que quieras saber más.");
			num = sc.nextInt();
			do {
				if(num <=0 || num>7) {
					System.out.println("Escribe un número entre 1 y 7.");
					num=sc.nextInt();
				}else {
					System.out.println(" ");
					System.out.println(info[num-1]);
				}
			}while(num<=0 || num>10);
			System.out.println(" ");
			do {
				System.out.println("Quieres seguir viendo datos interesantes de Madagascar? S/N");
				System.out.println("");
				sn=sc.next();
				if(!sn.equalsIgnoreCase("S") && !sn.equalsIgnoreCase("N")){
					System.out.println("Introduzca S para continuar o N para parar");
				}
			}while(!sn.equalsIgnoreCase("S") && !sn.equalsIgnoreCase("N"));
		}while(!sn.equalsIgnoreCase("N"));
	}

	/**
	 * Metodo que controla la ejecucion de la clase Datos de Interes.
	 */
	public static void datosMain(Scanner sc) {
		String [] numInter;
		String [] infoInter;

		numInter=numInteres();
		imprimirInteres(numInter);
		infoInter=infoInteres();
		elegirInfoInteres(infoInter, sc);

	}

}
