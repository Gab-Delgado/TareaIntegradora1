import java.util.Scanner;
public class TareaIntegradora1 {
	
	// ------------- Creación de las constantes
	
	final static int BLACK_WORK = 1300000;
	final static int WHITE_WORK = 2600000;
	final static int PAINT = 980000;
	// ------------- Creación de metodos
	
	/**
	* Calcula el tipo de utilizacion para cada material<br>
	* <b> pre: </b> La opcion tiene que estar entre 1, 2 o 3. <br>
	* <b> pos: </b> <br>
	* @param opt, opcion elegida por el usuario
	* @return mock, es de tipo usage
	*/
	
	public static Usage chooseUsage(int opt) {
		Usage mock = null;
		switch (opt) {
			case 1:
				mock = Usage.Black_Work;
				break;
			case 2:
				mock = Usage.White_Work;
				break;
			case 3:
				mock = Usage.Paint;
				break;
		}
		return mock;
	}
	/**
	* Asigna la ubicacion del usuario dependiendo de su eleccion <br>
	* <b> pre: </b> La opcion tiene que estar entre 1, 2 o 3. <br>
	* <b> pos: </b> <br>
	* @param opt, opcion elegida por el usuario
	* @param ubication, variable de tipo Ubication
	* @return ubication, es de tipo Ubication
	*/
	
	public static Ubication chooseUbication (int opt, Ubication ubication) {
		switch (opt) {
			case 1:
				ubication = Ubication.NORTH;
				break;
			case 2:
				ubication = Ubication.CENTER;
				break;
			case 3:
				ubication = Ubication.SOUTH;
				break;
		}
		return ubication;
	}
	
	/**
	* Llena los arreglos con los datos pertinentes <br>
	* <b> pre: </b> El escaner y los arreglos tienen que estar inicializados. <br>
	* <b> pos: </b> Recorre los arreglos y le añade los datos a cada uno. <br>
	* @param in, hace referencia al scanner
	* @param size, es la longitud asignada a los arrays
	* @param materialsArr, es el arreglo de materiales a llenar
	* @param quantityArr, es el arreglo de las cantidades de cada material
	* @param homeCenterArr, es el arreglo de los precios en homecenter para cada material
	* @param ferreteriaCentroArr, es el arreglo de los precios en la ferreteria del centro para cada material
	* @param ferreteriaBarrioArr, es el arreglo de los precios en la ferreteria del barrio para cada material
	* @param usageArr, es el arreglo en el que se pone la utilizacion de cada material
	*/
	
	public static  void initiateArray ( Scanner in, int size, String[] materialsArr, Double[] quantityArr, Double[] homeCenterArr, Double[] ferreteriaCentroArr, Double[] ferreteriaBarrioArr, Usage[] usageArr) {
		
			for (int i = 0; i < size; i++) {
				System.out.println("Ingresa un material");
				materialsArr[i] = in.nextLine();
				System.out.println("Ingresa la cantidad");
				quantityArr[i] = in.nextDouble();
				System.out.println("Ingrese el precio por unidad en HomeCenter");
				homeCenterArr[i] = in.nextDouble();
				System.out.println("Ingrese el precio por unidad en la Ferreteria del Centro");
				ferreteriaCentroArr[i] = in.nextDouble();
				System.out.println("Ingrese el precio por unidad en la Ferreteria del Barrio");
				ferreteriaBarrioArr[i] = in.nextDouble();
				System.out.println("Ingrese el uso del material: 1 Para Obra negra, 2 Para Obra Blanca y 3 para Pintura");
				int opt = in.nextInt();
				in.nextLine();
				usageArr[i] = chooseUsage(opt);
				System.out.println(usageArr[i]);
			}
		
		}
		
	/**
	* Selecciona el precio del domicilio dependiendo de los parametros <br>
	* <b> pre: </b> Tiene que estar inicializada la variable order, la ubicacion ya tiene que estar definida, y tenemos que tener algun precio (HomeCenter, Ferreteria del Barrio, F del Centro, o la Mejor Cotizacion). <br>
	* <b> pos: </b>
	* @param order, Se le pasa la variable order para no declararla adentro del metodo.
	* @param ubication,ayuda a definir el domicilio.
	* @param totalPrice, ayuda a definir el domicilio.
	* @return order, tras hacer las verificaciones, devuelve el precio a pagar del domicilio.
	*/
	public static int orderingPrice(int order, Ubication ubication, double totalPrice) {
		if (totalPrice < 80000) {
			if (ubication == Ubication.NORTH || ubication == Ubication.SOUTH) {
				order = 120000;
			} else if (ubication == Ubication.CENTER) {
				order = 50000;
			}
		} else if (totalPrice >= 80000 && totalPrice < 300000) {
			if (ubication == Ubication.NORTH) {
				order = 28000;
			} else if (ubication == Ubication.SOUTH) {
				order = 55000;
			} else if (ubication == Ubication.CENTER) {
				order = 0;
			}
		} else {
			order = 0;
		}
		return order;
	}
	
	/**
	* Calcula la mano de obra dependiendo de la utilidad<br>
	* <b> pre: </b> El arreglo usage tiene que estar definido, la cantidad MAX tiene que ser mayor a 0 y workForce tiene que estar inicializado.<br>
	* <b> pos: </b>
	* @param usage, arreglo de utilidades para definir la mano de obra
	* @param workForce, variable de mano de obra, se pasa como parametro para no inicializarla en el metodo.
	* @param MAX, indica el limite de los arreglos.
	* @return workForce, retorna el valor de la mano de obra dependiendo de que utilidades habían.
	*/
	public static int initiateWorkForce (Usage[] usage, int workForce, int MAX) {
		int ON = 0;
		int OB = 0;
		int PN = 0;
		
		for (int i = 0; i < MAX; i++) {
			if (usage[i] == Usage.Black_Work) {
				ON = 1;
			} else if (usage[i] == Usage.White_Work) {
				OB = 1;
			} else {
				PN = 1;
			}
		}
		
		switch(ON) {
			case 1:
				workForce += BLACK_WORK;
		}
		switch (OB) {
			case 1:
				workForce += WHITE_WORK;
		}
		switch (PN) {
			case 1:
				workForce += PAINT;
		}
		
		return workForce;
	}
	
	/**
	* Desplega los materiales por utilidad dependiendo de la seleccion del usuario. <br>
	* <b> pre: </b> El scanner tiene que estar definido, los arreglos inicializados y la variable MAX, mayor a 0. <br>
	* <b> pos: </b>
	* @param in, Se usa para ingresar que tipo de utilidad queremos desplegar.
	* @param usage, Arreglo con las utilidades
	* @param materials, Arreglo con los materiales
	* @param MAX, se utiliza para recorrer los arreglos y concatenar unos Strings.
	*/
	public static void displayByUsage( Scanner in ,Usage[] usage, String[] materials, int MAX) {
		
		String BlackWork = "";
		String WhiteWork = "";
		String Paint = "";
		int i = 0;
		while (i < MAX) {
			if (usage[i] == Usage.Black_Work) {
				BlackWork+= materials[i] + ", ";
			} else if (usage[i] == Usage.White_Work) {
				WhiteWork+= materials[i] + ", ";
			} else {
				Paint+= materials[i] + ", ";
			}
			i++;
		}
		System.out.println("------------------------------");
		System.out.println("Que quieres listar? 1: Obra Negra. 2: Obra Blanca. 3: Pintura. 4: Salir");
		int opt = in.nextInt();
		while(opt >= 1 && opt <= 3) {
			if (opt == 1) {
				System.out.println("Materiales para Obra Negra: ");
				System.out.println("[" + BlackWork + "]");
				System.out.println("-----------------------");
				System.out.println("Que quieres listar ahora? 1: Obra Negra. 2: Obra Blanca. 3: Pintura. 4: Salir");
				opt = in.nextInt();
			} else if (opt == 2) {
				System.out.println("Materiales para Obra Blanca: ");
				System.out.println("[" + WhiteWork + "]");
				System.out.println("-----------------------");
				System.out.println("Que quieres listar ahora? 1: Obra Negra. 2: Obra Blanca. 3: Pintura. 4: Salir");
				opt = in.nextInt();
			} else {
				System.out.println("Materiales para Pintura: ");
				System.out.println("[" + Paint + "]");
				System.out.println("Que quieres listar ahora? 1: Obra Negra. 2: Obra Blanca. 3: Pintura. 4: Salir");
				opt = in.nextInt();
			}
			
		}
	}
	
	/**
	* Este metodo despliega los mejores precios de cada material e indica en cual establecimiento se encuentra. <br>
	* <b> pre: </b> Los arreglos tienen que tener datos y MAX tiene que ser mayor a 0. <br>
	* <b> pre: </b> <br>
	* @param MAX, es la longitud de los arrays, se usa para los ciclos.
	* @param cont4, Se va sumando con cada uno de los mejores precios por material.
	* @param materials, array de tipo String. Se usa para pasar el nombre del material y definir con cual se esta trabajando.
	* @param quantity, array de tipo Double. Se usa para ver la cantidad que hay de ese material y asi obtener el precio
	* @param homeCenterPrice, array de tipo Double. Es la cantidad individual de cada material, se multiplica con la cantidad y asi obtenemos el total por material de Homecenter
	* @param ferreteriaCentroPrice, array de tipo Double. Es la cantidad individual de cada material, se multiplica con la cantidad y asi obtenemos el total por material de la Ferreteria del Centro
	* @param ferreteriaBarrioPrice array de tipo Double. Es la cantidad individual de cada material, se multiplica con la cantidad y asi obtenemos el total por material de la Ferreteria del Barrio
	* @return cont4, devuelve el valor de la suma de todos los mejores precios.
	*/
	public static double priceByEstablishment(int MAX, double cont4, String [] materials, Double [] quantity,Double [] homeCenterPrice, Double [] ferreteriaCentroPrice, Double [] ferreteriaBarrioPrice ) {
		for (int j = 0; j < MAX ; j++) {
		Double homePrice = quantity[j] * homeCenterPrice[j];
		Double centroPrice = quantity[j] * ferreteriaCentroPrice[j];
		Double barrioPrice = quantity[j] * ferreteriaBarrioPrice[j];

		if (homePrice <= centroPrice && homePrice <= barrioPrice) {
			System.out.println("El mejor precio para el material : " + materials[j] + " es:");
			System.out.println(homePrice + " de: " + "HomeCenter");
			cont4+= homePrice;
		} else if (centroPrice <= homePrice && centroPrice <= barrioPrice) {
			System.out.println("El mejor precio para el material : " + materials[j] + " es:");
			System.out.println(centroPrice + " de: " + " La Ferreteria Del Centro");
			cont4+=centroPrice;
		} else if (barrioPrice <= homePrice && barrioPrice <= centroPrice){
			System.out.println("El mejor precio para el material : " + materials[j] + " es:");
			System.out.println(barrioPrice + " de: " + " La Ferreteria Del Barrio");
			cont4+=barrioPrice;
			}
		}
		return cont4;
		
	}
	
	/**
	* Despliega la informacion existente de cada material y muestra el total de todos los materiales por cada establecimiento (El cual se obtiene con 3 contadores). <br>
	* <b> pre: </b> Todos los arreglos deben de tener los datos llenos, MAX debe de ser mayor a 0, ubication debe de estar definido y la mano de obra ya tuvo que haberse calculado. <br>
	* <b> pos: </b> <br>
	* @param MAX, Se usa como referencia al recorrer los arrays con ciclos.
	* @param materials, de tipo String. Se usa al desplegar todos los datos por material.
	* @param quantity, de tipo Double. Se utiliza para multiplicar los precios por establecimiento con la cantidad del mismo material.
	* @param homeCenterPrice, de tipo Double. Se utiliza para obtener el precio total por material de este establecimiento.
	* @param ferreteriaCentroPrice, de tipo Double. Se utiliza para obtener el precio total por material de este establecimiento.
	* @param ferreteriaBarrioPrice, de tipo Double. Se utiliza para obtener el precio total por material de este establecimiento.
	* @param usage, de tipo Usage. Se utiliza al desplegar todos los datos por material.
	* @param orderPrice, se pasa como parametro para no volver a definirlo.
	* @param ubication, de tipo Ubication. Es la ubicacion y se utiliza para poder obtener el valor del domicilio.
	* @param workForce, Es el precio de la mano de obra, se utiliza para sumarlo con el valor final.
	*/
	public static void materialsAndTotalPrices(int MAX, String [] materials, Double [] quantity, Double [] homeCenterPrice, Double [] ferreteriaCentroPrice, Double [] ferreteriaBarrioPrice, Usage [] usage, int orderPrice, Ubication ubication, int workForce) {
		double cont1 = 0;
		double cont2 = 0;
		double cont3 = 0;
		for (int i = 0; i < MAX; i++) { 
			Double homePrice = quantity[i] * homeCenterPrice[i];
			Double centroPrice = quantity[i] * ferreteriaCentroPrice[i];
			Double barrioPrice = quantity[i] * ferreteriaBarrioPrice[i];
		
			cont1+= homePrice;
			cont2+=centroPrice;
			cont3+=barrioPrice;
			
			System.out.println("-------------");
			System.out.println("Material: " + materials[i]);
			System.out.println("Cantidad: " + quantity[i]);
			System.out.println("Precio en HomeCenter: " + homeCenterPrice[i]);
			System.out.println("Precio en La Ferreteria del Centro: " + ferreteriaCentroPrice[i]);
			System.out.println("Precio en La Ferreteria del Barrio: " + ferreteriaBarrioPrice[i]);
			System.out.println("Utilizacion: " + usage[i]);
			System.out.println("-------------");
		}
		orderPrice = orderingPrice(orderPrice, ubication, cont1);
		System.out.println("El domicilio es: " + orderPrice);
		System.out.println("El precio de todos los materiales en HomeCenter es: " + (cont1 + orderPrice + workForce)); 
		orderPrice = orderingPrice(orderPrice, ubication, cont2);
		System.out.println("El domicilio es: " + orderPrice);
		System.out.println("El precio de todos los materiales en La Ferreteria Del Centro es: " + (cont2 + orderPrice + workForce));
		orderPrice = orderingPrice(orderPrice, ubication, cont3);
		System.out.println("El domicilio es: " + orderPrice);
		System.out.println("El precio de todos los materiales en La Ferreteria Del Barrio es: " + (cont3 + orderPrice + workForce));
		System.out.println("-----------------------");
	}
	
	public static void main(String args[]) {
	// ------------- Entradas ----------------------------------//
		Scanner in = new Scanner(System.in);
		int MAX;
		
		String [] materials;
		Double [] quantity;
		Double [] homeCenterPrice;
		Double [] ferreteriaCentroPrice;
		Double [] ferreteriaBarrioPrice;
		Usage [] usage;
		int orderPrice = 0;
		int workForce = 0;
		Ubication ubication = null;
	
	// ------------- Creación y asignación de los arreglos --------------------//
	
		System.out.println("Ingresa la cantidad de materiales");
		MAX = in.nextInt();
		in.nextLine();
		
		System.out.println("Cual es tu ubicacion? (1:Norte, 2:CENTRO o 3:SUR)");
		int opt = in.nextInt();
		in.nextLine();
		ubication = chooseUbication(opt, ubication);
		System.out.println("Ubicacion: " + ubication);
		
		materials = new String[MAX];
		quantity= new Double[MAX];
		homeCenterPrice = new Double[MAX];
		ferreteriaCentroPrice = new Double[MAX];;
		ferreteriaBarrioPrice = new Double[MAX];;
		usage = new Usage[MAX];
		initiateArray(in, MAX, materials, quantity, homeCenterPrice, ferreteriaCentroPrice, ferreteriaBarrioPrice, usage);
		workForce = initiateWorkForce(usage, workForce, MAX);
		System.out.println("El precio es: " + workForce);

	// ------------- Impresion de Materiales y Precios totales en las ferreterias
	
		materialsAndTotalPrices(MAX, materials, quantity, homeCenterPrice, ferreteriaCentroPrice, ferreteriaBarrioPrice, usage, orderPrice, ubication, workForce);	
	
	// ------------- Precios por ferreteria
	
		double cont4 = 0;
		cont4 = priceByEstablishment(MAX, cont4, materials, quantity, homeCenterPrice, ferreteriaCentroPrice, ferreteriaBarrioPrice);
	
	// ------------- Mejor precio comprando en cada ferreteria
	
		orderPrice = orderingPrice(orderPrice, ubication, cont4);
		System.out.println("El domicilio es " + orderPrice );
		System.out.println("El mejor precio tras comprar en las diferentes ferreterias es: " + (cont4 + orderPrice + workForce));
		System.out.println("--------------------------------");
	
	// ------------- Desplegar los productos por tipo de utilizacion
	
		displayByUsage(in, usage, materials, MAX);
	}
}