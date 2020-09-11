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
	
	public static  void initiateArray ( Scanner in, int size, String[] materialsArr, Double[] quantityArr, Double[] priceArr, Usage[] usageArr) {
			for (int i = 0; i < size; i++) {
				System.out.println("Ingresa un material");
				materialsArr[i] = in.nextLine();
				System.out.println("Ingresa la cantidad");
				quantityArr[i] = in.nextDouble();
				System.out.println("Ingrese el precio por unidad");
				priceArr[i] = in.nextDouble();
				System.out.println("Ingrese el uso del material: 1 Para Obra negra, 2 Para Obra Blanca y 3 para Pintura");
				int opt = in.nextInt();
				in.nextLine();
				usageArr[i] = chooseUsage(opt);
				System.out.println(usageArr[i]);
			}
		
		}
	
	public static void main(String args[]) {
	
	System.out.println("Tarea Integradora, nosape");
	
	// ------------- Entradas
	Scanner in = new Scanner(System.in);
	int MAX;
	
	String [] materials;
	Double [] quantity;
	Double [] price;
	Usage [] usage;
	Ubication [] ubication; // Doesn't needs to be an Array, he's just in one place!
	
	
	
	// ------------- Creación y asignación de los arreglos
	
	System.out.println("Ingresa la cantidad de materiales");
	MAX = in.nextInt();
	in.nextLine();
	// -----------
	
	materials = new String[MAX];
	quantity= new Double[MAX];
	price = new Double[MAX];
	usage = new Usage[MAX];
	initiateArray(in, MAX, materials, quantity, price, usage);
	
	System.out.println("");
	
	
	// ------------- Procesos
	
	for (int i = 0; i < materials.length; i++) {
		System.out.println(materials[i]);
		System.out.println(quantity[i]);
		System.out.println(price[i]);
		System.out.println(usage[i]);
		System.out.println("-------------");
	}
	
	// ------------- Precios por ferreteria
	
	
	
	// ------------- Mejor precio comprando en cada ferreteria
	
	
	
	// ------------- Salidas
	
	
	
	}
}