import java.util.Scanner;

/**
 * Clase con la seccion de la informacion sobre la historia de Madagascar.
 */
public class Historia {

	/**
	 * Metodo que devuelve un array de strings con las diferentes epocas .
	 * @return Array de strings con las diferentes epocas .
	 */
	public static String[] numHistoria() {
		String [] epocas= {"1. Colonización","2. Europa","3. Piratas","4. Rey Radama","5. Colonia Francesa","6. Dictador Didier"};
		return epocas;
	}

	/**
	 * Metodo que devuelve un array de strings con la informacion historica de Madagascar.
	 * @return Un array de strings con la informacion historica de Madagascar.
	 */
	public static String[] infoHistoria() {
		String [] historiaInfo= {"Madagascar fue inicialmente colonizada por los humanos hace aproximadamente 2000 años. Los colonizadores de Madagascar fueron tanto Indoneses como \ndescendientes de mezclas "
				+"indonesas y africanas. Los comerciantes árabes llegaron a la escena alrededor de los años 800 a 900 antes de Cristo. \nCuando los mercaderes comenzaron a vender a lo largo de las costas del Norte."

								,"El primer europeo que se conoce que vio Madagascar fue un portugués marino, el Capitán Diogo Días, quien divisó la isla en Agosto 10 del año 1.500, \ndespués de rendirse en su camino a India. "
										+"El nombró la isla como St. Lewrence. Más tarde en los años 1500 los portugueses, alemanes e ingleses, \ntodos intentaron establecer negocios en Madagascar. "
										+"Todos ellos fracasaron debido a las condiciones hostiles y a la fiereza de las peleas de \nlos guerreros Malagasy."

								,"Los europeos consiguieron apoyo de Madagascar en los últimos años de 1600 cuando los piratas establecieron reinos en las costas del este de la \nisla. "
										+"Estos piratas utilizaron a Madagascar como una base para atacar los barcos que transportaban mercancías de regreso a Europa desde India. \nEn los años 1700, "
										+"Los franceses intentaron establecer posiciones militares en la costa Este, pero otra vez fracasaron. Cerca al 19° Centenario, \nel único asentamiento que los franceses pudieron reclamar fue la Isla de Sainte Marie."

								,"Mientras tanto, durante los años 1700, los Sakalava de la Costa Occidental establecieron el primer reino de Madagascar. En 1980, sus rivales, \nlos Merina, establecieron un reino para el resto de la isla. "
										+"Su rey Radama I, estableció relaciones con los ingleses y abrió el país a los \nmisionarios ingleses quienes expandieron el cristianismo a través de la isla y trascribieron el Malagasy al idioma escrito. "
										+"\nBajo el reino Radama, una pequeña revolución industrial trajo industria a la isla. Después de la muerte de Radama, fue sucedido por su viuda \nRanavalona I, quien aterrorizó el país por 33 años al perseguir cristianos, "
										+"victimizando extranjeros, ejecutando rivales políticos y reviviendo \nla costumbre de matar los niños nacidos en días no afortunados. Después de su muerte, las relaciones con Europa se restablecieron."

								,"En 1983, Francia invadió Madagascar y para 1896 había establecido un reino para la isla, la cual comenzó a ser colonia francesa. \nFrancia utilizó Madagascar como recurso maderero y de especies exóticas, como la vainilla. "
										+"Los Malagasy tuvieron dos levantamientos contra los \nfranceses, en 1918 y 1947, pero el país no se independizó nuevamente sino hasta Junio 26 de 1960."

								,"En 1975, Didier Ratsiraka tomó el control del país. El gobernó Madagascar como un dictador desde que fue derrocado en 1991, en un colapso \neconómico. El recuperó la presidencia un poquito después y gobernó hasta que perdió las elecciones en el 2001."
										+" El nuevo Presidente, \nMarc Ravalomanana, prometió traer la democracia al país. Habiendo alcanzado su éxito al comenzar vendiendo yogurt en las calle, en la parte \ntrasera de su bicicleta, ravalomanana construyó un imperio comercial y comenzó a ser el hombre más rico de Madagascar. "
										+"Para el año 2005, el \ntodavía es Presidente y la economía continúa mejorando."};
		return historiaInfo;
	}

	/**	
	 * Metodo que imprime la informacion historica de Madagascar segun la eleccion del usuario.
	 * @param info Array de strings con la informacion historica.
	 */
	public static void elegirNum(String [] info, Scanner sc) {
		int num;
		String sn;
		do {
			System.out.println(" ");
			System.out.println("Escribe el número de la época de la que quieras saber más.");
			num = sc.nextInt();	//El jugador selecciona la epoca de la que quiera obtener informacion

			do {	//Validamos que el numero introducido sea mayor a 0 y menor que 6
				if (num <= 0 || num >6) {
					System.out.println("Escribe un número entre 1 y 6.");
					num=sc.nextInt();
				} else {
					System.out.println(" ");
					System.out.println(info[num - 1]);	//Imprimimos la informacion del numero seleccionado
				}
			}while(num <= 0 || num >6);

			System.out.println(" ");

			do {	//Preguntamos al usuario si quiere seguir viendo informacion
				System.out.println("Quieres seguir viendo la historia de Madagascar? S/N");
				System.out.println("");
				sn=sc.next();	
				if(!sn.equalsIgnoreCase("S") && !sn.equalsIgnoreCase("N")){
					System.out.println("Introduzca S para continuar o N para parar");
				}
			}while(!sn.equalsIgnoreCase("S") && !sn.equalsIgnoreCase("N"));	//Validamos que el usuario introduzca S para seguir o N para parar 

		} while (!sn.equalsIgnoreCase("N"));
	}

	/**
	 * Metodo para imprimir la lista de opciones de la seccion.
	 * @param historia Array con la lista de opciones.
	 */
	public static void imprimirInfoHistoria(String [] historia) {

		for(int i=0;i<historia.length;i++) {	//Utilizamos el for para recorrer el array e imprimir las diferentes opciones a elegir
			System.out.println(historia[i]);
			System.out.println(" ");
		}
	}

	/**
	 * Metodo principal que controla la ejecucion de la clase Historia.
	 */
	public static void historiaMain(Scanner sc) {
		String [] epoca;
		String [] info;

		epoca=numHistoria();
		imprimirInfoHistoria(epoca);
		info=infoHistoria();
		elegirNum(info, sc);
	}
}