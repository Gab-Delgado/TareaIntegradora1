import java.util.Scanner;
public class TareaIntegradora1 {
	
	// ------------- Creación de las constantes
	
	final static int BLACK_WORK = 1300000; // Constant used for the workForce, represents the price of the black_work.
	final static int WHITE_WORK = 2600000; // Constant used for the workForce, represents the price of the white_work.
	final static int PAINT = 980000; // Constant used for the workForce, represents the price of the paint.
	// ------------- Creación de metodos
	
	/**
	* Calculates the type of usage for each material.<br>
	* <b> pre: </b>The opt must be between 1, 2 or 3. <br>
	* <b> pos: </b> <br>
	* @param opt, option chosen by the user
	* @return mock, it is of type Usage
	*/
	
	public static Usage chooseUsage(int opt) { //Calculates the type of usage for each material
		Usage mock = null; // Used to return the value of the usage.
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
	* Asigns the Ubication of the user depending on his choice.<br>
	* <b> pre: </b> The option must be between 1, 2 or 3. <br>
	* <b> pos: </b> <br>
	* @param opt, Option chosen by the user.
	* @param ubication, var of type Ubication
	* @return ubication, it is of type Ubication. (Used to asign and return the ubication of the user).
	*/
	
	public static Ubication chooseUbication (int opt, Ubication ubication) { // Asigns the Ubication of the user depending on his choice.
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
	* Fills the arrays with the necessary data <br>
	* <b> pre: </b> The scaner must be defined and all the arrays must be initialized. <br>
	* <b> pos: </b> Iterates through the arrays and adds data to each one of them. <br>
	* @param in, it is a reference to the scanner
	* @param size, is the asigned length for the arrays
	* @param materialsArr, Material's array to fill.
	* @param quantityArr, Quantity array of each material
	* @param homeCenterArr, Array of HomeCenter's prices for each material
	* @param ferreteriaCentroArr, Array of Ferreteria del Centro's prices for each material
	* @param ferreteriaBarrioArr, Array of Ferreteria del Barrio's prices for each material
	* @param usageArr, It is the array that contains the usage of each material.
	*/
	
	public static  void initiateArray ( Scanner in, int size, String[] materialsArr, Double[] quantityArr, Double[] homeCenterArr, Double[] ferreteriaCentroArr, Double[] ferreteriaBarrioArr, Usage[] usageArr) { // Fills the arrays with the necessary data 
		
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
	* Selects the orderPrice depending on the parameters <br>
	* <b> pre: </b> order must be initialized, ubication must be defined and we must add a totalPrice(HomeCenter, Ferreteria del Barrio, Ferreteria del Centro or the best total price). <br>
	* <b> pos: </b>
	* @param order, We pass this var through the parameters so we don't have to define it inside the method.
	* @param ubication, It is required to find the value for the orderPrice.
	* @param totalPrice, It is required to find the value for the orderPrice.
	* @return order, After the verifications and assigning a value to the var, we return the price of the order.
	*/
	public static int orderingPrice(int order, Ubication ubication, double totalPrice) { // Selects the orderPrice depending on the parameters
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
	* Calculates the workForce depending on the usage of all materials.<br>
	* <b> pre: </b> The array usage must be defined, MAX must be greater than 0 and workForce must be initialized.<br>
	* <b> pos: </b>
	* @param usage, array of usages to define the workForce.
	* @param workForce, We pass this var through the parameters so we don't have to define it inside the method.
	* @param MAX, indicates the length of all the arrays.
	* @return workForce, returns the price of the workForce depending on the usages there were for all the materials.
	*/
	public static int initiateWorkForce (Usage[] usage, int workForce, int MAX) { // Calculates the workForce depending on the usage of all materials.
		int ON = 0; // Counter, remains in 0 if there are not materials used in this part (Black Work)
		int OB = 0; // Counter, remains in 0 if there are not materials used in this part (White Work)
		int PN = 0; // Counter, remains in 0 if there are not materials used in this part (Paint)
		
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
	* Displays the materials by utility depending on the user's selection <br>
	* <b> pre: </b> The scanner must be defined, the arrays filled and the var MAX, greater than 0. <br>
	* <b> pos: </b>
	* @param in, Used in the input to find out which type of usage the method will display.
	* @param usage, Array with usages
	* @param materials, Arreglo with materials
	* @param MAX, Used to iterate through the arrays and concatenate the strings inside the method.
	*/
	public static void displayByUsage( Scanner in ,Usage[] usage, String[] materials, int MAX) { // Displays the materials by utility depending on the user's selection
		
		String BlackWork = ""; // Used to save the materials that are used in the Black Work
		String WhiteWork = ""; // Used to save the materials that are used in the White Work
		String Paint = ""; // Used to save the materials that are used in the Paint.
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
	* This method displays the best prices for each material and the establishment with that price. <br>
	* <b> pre: </b> The arrays must be filled and MAX has to be greater than 0. <br>
	* <b> pre: </b> <br>
	* @param MAX, used to iterate through the arrays.
	* @param cont4, used as a counter to add each of the best prices.
	* @param materials, used to display the material name and define display its price.
	* @param quantity, used to find the quantity of each material and therefore, find its price.
	* @param homeCenterPrice, individual price for each material, used to multiply itself with the quantity to obtain HomeCenter's price for that material
	* @param ferreteriaCentroPrice,individual price for each material, used to multiply itself with the quantity to obtain Ferreteria del Centro's price for that material
	* @param ferreteriaBarrioPrice individual price for each material, used to multiply itself with the quantity to obtain Ferreteria del Barrio's price for that material
	* @return cont4, returns the sum of each one of the best prices per material.
	*/
	public static double priceByEstablishment(int MAX, double cont4, String [] materials, Double [] quantity,Double [] homeCenterPrice, Double [] ferreteriaCentroPrice, Double [] ferreteriaBarrioPrice ) { // This method displays the best prices for each material and the establishment with that price.
		for (int j = 0; j < MAX ; j++) {
		Double homePrice = quantity[j] * homeCenterPrice[j]; // HomeCenter's price for each material depending on the quantity
		Double centroPrice = quantity[j] * ferreteriaCentroPrice[j]; // Ferreteria del Centro's price for each material depending on the quantity
		Double barrioPrice = quantity[j] * ferreteriaBarrioPrice[j]; // Ferreteria del Barrio's price for each material depending on the quantity

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
	* Displays the existing data for each material and shows the total price in each establishment (which is obtained with three counters). <br>
	* <b> pre: </b> The arrays must be filled, MAX must be greater than 0, ubication must be defined and the workForce must have been calculated. <br>
	* <b> pos: </b> <br>
	* @param MAX, used to iterate through the arrays.
	* @param materials, used to display the data for each material
	* @param quantity, used to multiply the price of each material per establishment with the quantity of each material
	* @param homeCenterPrice, used to obtain the total per establishment
	* @param ferreteriaCentroPrice, used to obtain the total per establishment
	* @param ferreteriaBarrioPrice, used to obtain the total per establishment
	* @param usage, used to display the data for each material
	* @param orderPrice, used as a paramater so we don't have to initialize it again.
	* @param ubication, ubication used to defined de orderPrice.
	* @param workForce, added to the total price for each establishment.
	*/
	public static void materialsAndTotalPrices(int MAX, String [] materials, Double [] quantity, Double [] homeCenterPrice, Double [] ferreteriaCentroPrice, Double [] ferreteriaBarrioPrice, Usage [] usage, int orderPrice, Ubication ubication, int workForce) { // Displays the existing data for each material and shows the total price in each establishment (which is obtained with three counters).
		double cont1 = 0; // Counter to save HomeCenter's total price.
		double cont2 = 0; // Counter to save Ferreteria del Centro's total price
		double cont3 = 0; // Counter to save Ferreteria del Barrio's total price
		for (int i = 0; i < MAX; i++) { 
			Double homePrice = quantity[i] * homeCenterPrice[i]; // HomeCenter's price for each material depending on the quantity
			Double centroPrice = quantity[i] * ferreteriaCentroPrice[i]; // Ferreteria del Centro's price for each material depending on the quantity
			Double barrioPrice = quantity[i] * ferreteriaBarrioPrice[i]; // Ferreteria del Barrio's price for each material depending on the quantity
		
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
		int MAX; // Var that will represent the length of each array.
		
		String [] materials; // Array of all the materials
		Double [] quantity; // Array that contains the quantity of each material
		Double [] homeCenterPrice; // Array with the price of HomeCenter for each material
		Double [] ferreteriaCentroPrice; // Array with the price of Ferreteria del Centro for each material
		Double [] ferreteriaBarrioPrice; // Array with the price of Ferreteria del Barrio for each material
		Usage [] usage; // Array with the kind of usage for each material.
		int orderPrice = 0; // Var that will eventually contain the orderPrice
		int workForce = 0; // Var that will eventually contain the workForce
		Ubication ubication = null; // Var that will contain the Ubication of the client.
	
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
		workForce = initiateWorkForce(usage, workForce, MAX); // We initiate all the arrays, and with their info we also initiate the workForce
		System.out.println("El precio es: " + workForce);

	// ------------- Impresion de Materiales y Precios totales en las ferreterias
	
		materialsAndTotalPrices(MAX, materials, quantity, homeCenterPrice, ferreteriaCentroPrice, ferreteriaBarrioPrice, usage, orderPrice, ubication, workForce);	
		// We print on screen the existing info for each material and prints the total for each establishment. 
		
	// ------------- Precios por ferreteria
	
		double cont4 = 0;
		cont4 = priceByEstablishment(MAX, cont4, materials, quantity, homeCenterPrice, ferreteriaCentroPrice, ferreteriaBarrioPrice);
		// It prints the total of each material for each establishment (the price contains the workForce, usage and orderPrice).
	// ------------- Mejor precio comprando en cada ferreteria
	
		orderPrice = orderingPrice(orderPrice, ubication, cont4); // Method used to get the order price depending on how much the client will buy.
		System.out.println("El domicilio es " + orderPrice );
		System.out.println("El mejor precio tras comprar en las diferentes ferreterias es: " + (cont4 + orderPrice + workForce));
		System.out.println("--------------------------------");
	
	// ------------- Desplegar los productos por tipo de utilizacion
	
		displayByUsage(in, usage, materials, MAX);
		// This method displays all the materials by usage, the materials listed by usage is dependant of the user's choice.
	}
}