import java.util.*;

/**
 * Clase con la seccion de la informacion sobre los sitios de interes de Madagascar.
 */
public class SitiosDeInteres {

	/**
	 * Metodo que devuelve una lista de opciones de sitios de interes de Madagascar.
	 * @return Array con la lista de opciones.
	 */
	public static String[] numTuristic () {
		String [] numLugar= {"1. Palmeraie de l'Ivondro","2. Parque Zoológico de Ivaloina","3. Nosy Boraha","4. Parque Nacional de Isalo","5. Avenida de los Baobabs","6. Antananarivo","7. Tsingy de Bemaraha","8. Parque Nacional de Andringitra","9. Río Manambolo","10. Manakara",};
		return numLugar;
	}

	/**
	 * Metodo que devuelve una lista de informacion sobre los sitios de interes de Madagascar.
	 * @return Array con la informacion sobre los sitios de interes.
	 */
	public static String [] infoTuristic() {
		String [] info= {"La Palmeraie de l'Ivondro, el palmeral de Ivondro, es una vasta plantación de palmeras, de la que se obtiene el "
				+"famoso aceite de palma con un \nprocesamiento orgánico certificado siempre con especial atención a la reducción de la "
				+"forestación, para preservar la biodiversidad y respetar los \nmedios de vida de las comunidades rurales."

		   		,"A unos diez kilómetros al norte de la ciudad de Toamasina se puede llegar al Parque zoológico de Ivoloina donde se pueden "
		   				+ "contemplar 10 especies \nde lémures, reptiles y batracios, pero no sólo eso. Creado en 1898 como un jardín experimental "
		   				+ "en la orilla este del río Ivoloina, del que toma su \nnombre, en el parque gracias a una estación de observación se pueden "
		   				+ "observar también muchos pájaros y plantas autóctonas. Otro lugar que te dará \nfantásticas sorpresas."

				,"Nosy Boraha (Île Sainte-Marie) es una estrecha isla de granito frente a la costa este de Madagascar. En la exuberante "
						+ "vegetación viven muchas \npequeñas aldeas, las playas son kilométricas y están llenas de cocoteros y tienen bahías y "
						+ "calas protegidas por arrecifes de coral. Un fuerte \nsentimiento de paz, tranquilidad y belleza prevalece en la isla."

				,"El Parque Nacional de Isalo (Isalo National Park), que algunos lo llamaron el Colorado de Madagascar, es un macizo de "
						+"roca natural que recuerda \nal gran oeste americano. Caminar por este paisaje jurásico, entre paisajes desérticos y verdes "
						+ "cañones es maravilloso: desde las zonas áridas \nhasta los colores y las formas deslumbrantes, todo en absoluto silencio."

				,"La Avenida de los Baobabs (Route Nationale 8) es una carretera principal de 200 kilómetros de largo en Madagascar a través"
						+" de la cual podrás \nobservar 300 baobabs centenarios, majestuosos gigantes de 30 metros de altura y 3 metros de diámetro, "
						+ "unos 40 de los cuales se alinean como \nguardianes de un paisaje que parece aislado y hostil pero al mismo tiempo único y "
						+ "fascinante. Fue declarado Monumento Nacional en 2007, pueden \nvivir más de 500 años y cada uno puede contener hasta 300 "
						+ "litros de agua"

				,"Antananarivo, la capital de Madagascar, puede satisfacer todas tus necesidades: historia, fauna, flora o aventura. "
						+"El nombre Antananarivo tiene \nraíces históricas y significa \"ciudad de los mil soldados\": fue fundada en 1625 por el "
						+ "rey Andrianjaka. Tiene dos catedrales, una anglicana y \notra católica. Imponente es el Palacio de Andafiavaratra, cubierto "
						+ "por una cúpula de cristal en la que se encuentra un museo y que fue en su día \nel lugar donde residieron los gobernadores"
						+ "de Madagascar. Si se sube más se encuentra la Rova de Antananarivo, comúnmente llamado \"el Palacio de \nla Reina\" un "
						+ "conjunto de edificios reales, hogar de los reyes Merina que tuvieron su reinado en Madagascar hasta 1700. También podrás "
						+ "visitar la \nhistórica Ciudad Alta y el Analakely Market, un mercado malgache lleno de arquitectura atípica en el que se "
						+ "puede pasar varias horas de relax \nbuscando souvenirs y otras cosas. "

				,"La Reserva natural integral de Tsingy de Bemaraha es Patrimonio de la Humanidad de la UNESCO desde 1990 y ofrecen uno de "
						+"los paisajes más \nespectaculares de Madagascar con su red de púas, grietas y bloques de piedra caliza tallados en cuchillas"
						+"afiladas. Estas regiones estuvieron una \nvez ocultas bajo el mar, por lo que los corales y conchas se apilaron y "
						+"solidificaron para formar una enorme placa de unos 200 metros de espesor \ncon cañones de piedra caliza. El paisaje es "
						+"extraordinario, aquí viven 400 especies animales y más de 900 plantas nativas de la isla."

				,"Andringitra (Andrintch) es una majestuosa cordillera con un hermoso valle a cada lado, el Namoly y el Tsaranoro "
						+"(a veces llamado Sahanambo por el \nrío que lo atraviesa), que forman un paraíso para senderistas y escaladores. Hay vistas "
						+ "espectaculares en todas las direcciones, rutas de \nsenderismo bien desarrolladas, excelentes alojamientos, aldeas "
						+ "interesantes y tres picos extraordinarios: Pic Boby (Imarivolanitra) con 2658 m, \nTsaranoro que alcanza los 1910 m, Pic Dondy de 2195 m."

				,"El Río Manambolo es uno de los más grandes que se pueden ver en Madagascar, en la zona oriente. Este río es perfecto para realizar"
						+" cualquier \nactividad de Kayaking, navegación por el río y apreciar los cañones que han formado erosión del agua a través "
						+ "de los años."

				,"Manakara es la ciudad más oriental que ver en Madagascar. Desde este lugar es posible hacer actividades como avistamiento "
						+"de ballenas o visitar \nalgunos de los parques nacionales como Isalo o la Reserva de Anja."};

		return info;
	}

	/**
	 * Metodo que imprime la lista de opciones de la seccion.
	 * @param numTuristic Array con la lista de opciones.
	 */
	public static void imprimirTuristic(String [] numTuristic) {

		for(int i=0;i<numTuristic.length;i++) {
			System.out.println(numTuristic[i]);
			System.out.println(" ");
		}
	}

	/**
	 * Metodo que imprime la informacion correspondiente a la opcion elegida por el usuario.
	 * @param info Array con el contenido de la informacion.
	 */
	public static void elegirInfoTurist(String [] info, Scanner sc) {
		int num;
		String sn;
		do {
			System.out.println(" ");
			System.out.println("Escribe el número del sitio turístico del que quieras saber más.");
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
				System.out.println("Quieres seguir viendo los sitios turísticos de Madagascar? S/N");
				System.out.println("");
				sn=sc.next();	
				if(!sn.equalsIgnoreCase("S") && !sn.equalsIgnoreCase("N")){
					System.out.println("Introduzca S para continuar o N para parar");
				}
			}while(!sn.equalsIgnoreCase("S") && !sn.equalsIgnoreCase("N"));
		} while (!sn.equalsIgnoreCase("N"));

	}

	/**
	 * Metodo que controla la ejecucion de la clase Sitios de interes.
	 */
	public static void sitiosDeInteresMain(Scanner sc) {
		String [] numTuristico;
		String [] infoTurist;

		numTuristico=numTuristic();
		imprimirTuristic(numTuristico);
		infoTurist=infoTuristic();
		elegirInfoTurist(infoTurist, sc);


	}

}
