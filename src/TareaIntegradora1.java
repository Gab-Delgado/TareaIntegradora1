import java.util.Scanner;
public class TareaIntegradora1 {
	
	// ------------- Creación de las constantes
	
	final static int OBRA_NEGRA = 1300000;
	final static int OBRA_BLANCA = 2600000;
	final static int PINTURA = 980000;
	// ------------- Creación de metodos
	public static Usage chooseUsage(int opt) {
		Usage mock = null;
		switch (opt) {
			case 1:
				mock = Usage.Obra_Negra;
				break;
			case 2:
				mock = Usage.Obra_Blanca;
				break;
			case 3:
				mock = Usage.Pintura;
				break;
		}
		return mock;
	}
	public static Ubication chooseUbication (int opt, Ubication ubication) {
		switch (opt) {
			case 1:
				ubication = Ubication.NORTE;
				break;
			case 2:
				ubication = Ubication.CENTRO;
				break;
			case 3:
				ubication = Ubication.SUR;
				break;
		}
		return ubication;
	}
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
	public static int orderingPrice(int order, Ubication ubication, double totalPrice) {
		if (totalPrice < 80000) {
			if (ubication == Ubication.NORTE || ubication == Ubication.SUR) {
				order = 120000;
			} else if (ubication == Ubication.CENTRO) {
				order = 50000;
			}
		} else if (totalPrice >= 80000 && totalPrice < 300000) {
			if (ubication == Ubication.NORTE) {
				order = 28000;
			} else if (ubication == Ubication.SUR) {
				order = 55000;
			} else if (ubication == Ubication.CENTRO) {
				order = 0;
			}
		} else {
			order = 0;
		}
		return order;
	}
	public static int initiateWorkForce (Usage[] usage, int workForce, int MAX) {
		int ON = 0;
		int OB = 0;
		int PN = 0;
		
		for (int i = 0; i < MAX; i++) {
			if (usage[i] == Usage.Obra_Negra) {
				ON = 1;
			} else if (usage[i] == Usage.Obra_Blanca) {
				OB = 1;
			} else {
				PN = 1;
			}
		}
		
		switch(ON) {
			case 1:
				workForce += OBRA_NEGRA;
		}
		switch (OB) {
			case 1:
				workForce += OBRA_BLANCA;
		}
		switch (PN) {
			case 1:
				workForce += PINTURA;
		}
		
		return workForce;
	}
	
	public static void main(String args[]) {
	
	System.out.println("Tarea Integradora, nosape");
	
	// ------------- Entradas
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
	
	// ------------- Creación y asignación de los arreglos
	
	System.out.println("Ingresa la cantidad de materiales");
	MAX = in.nextInt();
	in.nextLine();
	
	System.out.println("Cual es tu ubicacion? (1:Norte, 2:CENTRO o 3:SUR)");
	int opt = in.nextInt();
	in.nextLine();
	ubication = chooseUbication(opt, ubication);
	System.out.println(ubication + " -------------------- "); // NOT NECCESARY
	
	
	// -----------
	
	materials = new String[MAX];
	quantity= new Double[MAX];
	homeCenterPrice = new Double[MAX];
	ferreteriaCentroPrice = new Double[MAX];;
	ferreteriaBarrioPrice = new Double[MAX];;
	usage = new Usage[MAX];
	initiateArray(in, MAX, materials, quantity, homeCenterPrice, ferreteriaCentroPrice, ferreteriaBarrioPrice, usage);
	workForce = initiateWorkForce(usage, workForce, MAX);
	System.out.println("El precio es: " + workForce);
	System.out.println(""); // NOT NECCESARY
	
	// ------------- Procesos
	
	for (int i = 0; i < materials.length; i++) { // NOT NECCESARY
		System.out.println("-------------");
		System.out.println(materials[i]);
		System.out.println(quantity[i]);
		System.out.println(homeCenterPrice[i]);
		System.out.println(ferreteriaCentroPrice[i]);
		System.out.println(ferreteriaBarrioPrice[i]);
		System.out.println(usage[i]);
		System.out.println("-------------");
	}
	
	// ------------- Precios por ferreteria
	
	for (int j = 0; j < MAX ; j++) {
		Double homePrice = quantity[j] * homeCenterPrice[j];
		Double centroPrice = quantity[j] * ferreteriaCentroPrice[j];
		Double barrioPrice = quantity[j] * ferreteriaBarrioPrice[j];
		
		System.out.println("-----------------------"); // Deberia poder saltarme esto.
		System.out.println("Para el material " + materials[j] + " hay estos precios:");
		System.out.println("En HomeCenter: " + homePrice);
		System.out.println("En la Ferreteria del Centro: " + centroPrice);
		System.out.println("En la Ferreteria del Barrio: " + barrioPrice);
		System.out.println("-----------------------");
	}
	double cont1 = 0;
	double cont2 = 0;
	double cont3 = 0;
	for (int i = 0; i < MAX; i++) { // OPCIONAL
		Double homePrice = quantity[i] * homeCenterPrice[i];
		Double centroPrice = quantity[i] * ferreteriaCentroPrice[i];
		Double barrioPrice = quantity[i] * ferreteriaBarrioPrice[i];
		
		cont1+= homePrice;
		cont2+=centroPrice;
		cont3+=barrioPrice;
	}
	orderPrice = orderingPrice(orderPrice, ubication, cont1);
	System.out.println("El domicilio es: " + orderPrice);
	System.out.println("El precio de todos los materiales en HomeCenter es: " + (cont1 + orderPrice + workForce)); // RECORDAR VALORES DE MANO DE OBRA Y DE DOMICILIO
	orderPrice = orderingPrice(orderPrice, ubication, cont2);
	System.out.println("El domicilio es: " + orderPrice);
	System.out.println("El precio de todos los materiales en La Ferreteria Del Centro es: " + (cont2 + orderPrice + workForce));
	orderPrice = orderingPrice(orderPrice, ubication, cont3);
	System.out.println("El domicilio es: " + orderPrice);
	System.out.println("El precio de todos los materiales en La Ferreteria Del Barrio es: " + (cont3 + orderPrice + workForce));
	System.out.println("-----------------------");
	
	
	// ------------- Mejor precio comprando en cada ferreteria
	
	
	double cont4 = 0;
	for (int k = 0; k < MAX; k++) {
		Double homePrice = quantity[k] * homeCenterPrice[k];
		Double centroPrice = quantity[k] * ferreteriaCentroPrice[k];
		Double barrioPrice = quantity[k] * ferreteriaBarrioPrice[k];
		
		if (homePrice < centroPrice && homePrice < barrioPrice) {
			System.out.println("El mejor precio para el material : " + materials[k] + " es:");
			System.out.println(homePrice + " de: " + "HomeCenter");
			cont4+= homePrice;
		} else if (centroPrice < homePrice && centroPrice < barrioPrice) {
			System.out.println("El mejor precio para el material : " + materials[k] + " es:");
			System.out.println(centroPrice + " de: " + " La Ferreteria Del Centro");
			cont4+=centroPrice;
		} else {
			System.out.println("El mejor precio para el material : " + materials[k] + " es:");
			System.out.println(barrioPrice + " de: " + " La Ferreteria Del Barrio");
			cont4+=barrioPrice;
		}
		System.out.println("--------------------------------");
	}
	orderPrice = orderingPrice(orderPrice, ubication, cont4);
	System.out.println("El domicilio es " + orderPrice );
	System.out.println("El mejor precio tras comprar en las diferentes ferreterias es: " + (cont4 + orderPrice + workForce));
	System.out.println("--------------------------------");
	
	// ------------- Desplegar los productos por tipo de utilizacion
	
	String ObraNegra = "";
	String ObraBlanca = "";
	String Pintura = "";
	int i = 0;
	while (i < MAX) {
		if (usage[i] == Usage.Obra_Negra) {
			ObraNegra+= materials[i] + ", ";
		} else if (usage[i] == Usage.Obra_Blanca) {
			ObraBlanca+= materials[i] + ", ";
		} else {
			Pintura+= materials[i] + ", ";
		}
		i++;
	}
	
	System.out.println("Materiales para Obra Negra: ");
	System.out.println("[" + ObraNegra + "]");
	System.out.println("-----------------------");
	System.out.println("Materiales para Obra Blanca: ");
	System.out.println("[" + ObraBlanca + "]");
	System.out.println("-----------------------");
	System.out.println("Materiales para Pintura: ");
	System.out.println("[" + Pintura + "]");
	
	
	
	
	// !!!!! RECORDAR QUE SI HAY ALGUN TIPO DE UTILIDAD QUE NO ES LLAMADA NUNCA, ENTONCES NO SE PONE SU IMPUESTO
	// ------------- Salidas
	
	
	
	}
}