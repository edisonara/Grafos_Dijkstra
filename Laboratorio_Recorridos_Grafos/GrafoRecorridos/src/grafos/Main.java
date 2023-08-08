package grafos;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	private static int contadorVertices = 0;
	public static void main(String[] args) throws Exception {
		// Crear una matriz para almacenar los pesos de los arcos
	    int[][] pesos = new int[20][20]; // Ajustar el tamaño según tus necesidades
	 // Crear el objeto GrafMatPeso con la matriz de pesos y un arreglo de vértices vacío
	    GrafMatPeso grafo = new GrafMatPeso(contadorVertices);
		// Agregar v rtices
		Scanner tc = new Scanner(System.in);

		List<String> arista = new ArrayList<String>();
		while (true) {
			
			Scanner ts = new Scanner(System.in);
			System.out.println("---------------------------------");
			System.out.println("   MENU-GUEVARA-ARAMBULO");
			System.out.println("---------------------------------");
			System.out.println("1. Insertar vertices");
			System.out.println("2. Conectar vertices");
			System.out.println("3. Verificar si dos vertices son adyacentes");
			System.out.println("4. Mostrar nodos conectados a un vertice");
			System.out.println("5. Recorrido en anchura");
			System.out.println("6. Recorrido en profundidad");
			System.out.println("7. Recorrido Dijkstra");
			System.out.println("8. Salir");
			System.out.println("---------------------------------");
			System.out.print("Seleccione una opcion: ");
			int opc = tc.nextInt();
			tc.nextLine(); // Salto de linea
			switch (opc) {
			case 1:
				System.out.print("Ingrese cantidad de VERTICES (mínimo 2): ");
				int nVertices = ts.nextInt();
				
				if (nVertices >= 2 && nVertices <= 20) {
					for (int i = 0; i < nVertices; i++) {
						System.out.print("Ingrese el vértice " + (i + 1) + ": ");
						String vertice = tc.nextLine();
						grafo.nuevoVertice(vertice);
						arista.add(vertice);
					}
					grafo = new GrafMatPeso(nVertices); // Crear el objeto con el nuevo número de vértices
				} else {
					System.out.println("La cantidad de vértices debe ser entre 2 y 20.");
				}
				contadorVertices = nVertices; // Actualizar el contador de vértices
				break;

			case 2:

				System.out.print("Ingrese el primer vértice a conectar: ");
				String vertice1 = tc.nextLine();
				System.out.print("Ingrese el segundo vértice a conectar: ");
				String vertice2 = tc.nextLine();
				System.out.print("Ingrese el peso del arco (int): ");
				int peso = tc.nextInt();

				// Verificar que ambos vértices existen en la lista de vértices
				if (arista.contains(vertice1) && arista.contains(vertice2)) {
				    // Obtenemos los índices numéricos de los vértices para agregar el arco
				    int origen = arista.indexOf(vertice1);
				    int destino = arista.indexOf(vertice2);

				    try {
				        grafo.agregarArco(origen, destino, peso);
				    } catch (Exception e) {
				        e.printStackTrace();
				    }
				} else {
				    System.out.println("Uno o ambos vértices ingresados no existen en el grafo.");
				}

				break;

			case 3:
				System.out.print("Ingrese el primer vértice: ");
				vertice1 = tc.nextLine();
				System.out.print("Ingrese el segundo vértice: ");
				vertice2 = tc.nextLine();
				try {
					System.out.println(grafo.adyacente(vertice1, vertice2));
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 4:
				System.out.print("Ingrese el vértice del que desea conocer los nodos conectados: ");
				String vertice = tc.nextLine();
				try {
					List<Vertice> nodosConectados = grafo.nodosConectados(vertice);
					System.out.println("Nodos conectados a " + vertice + ":");
					for (Vertice v : nodosConectados) {
						System.out.println(v.nomVertice());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 5:
				System.out.print("Ingrese el vértice a recorrer: ");
				String vertice3 = tc.nextLine();
				Integer[] recorrido = RecorridoGrafo.RecorridoAnc(grafo, vertice3);
				try {
					System.out.println("Recorrido en anchura con Cola desde el vértice A:");
					for (int i = 0; i < recorrido.length; i++) {
						if (recorrido[i] != null) {
							System.out.println("Distancia a vértice " + grafo.verts[i] + ": " + recorrido[i++]);
							break;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			case 6:
				System.out.print("Ingrese el vértice de origen para el recorrido en profundidad: ");
				String verticeOrigen = tc.nextLine();
				try {
					String[] recorridoProf = RecorridoGrafo.recorrerProf(grafo, verticeOrigen);
					System.out.println("Recorrido en profundidad con Pila desde el vértice " + verticeOrigen + ":");
					for (int i = 0; i < recorridoProf.length; i++) {
						if (recorridoProf[i] != RecorridoGrafo.CLAVE) {
							System.out.println("Vértice " + grafo.verts[i] + ": " + recorridoProf[i]);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 7:
				int origen1 = 0;
			    if (origen1 >= 0 && origen1 < grafo.numeroDeVertices()) {
			        CaminoMinimo caminoMinimo = new CaminoMinimo(grafo, origen1);
			        caminoMinimo.caminoMinimos();

			        // Mostramos los caminos mínimos desde el vértice origen a todos los demás vértices
			        for (int i = 0; i < grafo.numeroDeVertices(); i++) {
			            if (i != origen1) {
			                System.out.print("Camino mínimo desde " + arista.get(origen1) + " hacia " + arista.get(i) + " es: ");
			                caminoMinimo.recuperaCamino(i);

			             // Calculamos la suma de los pesos del camino mínimo usando el nuevo método
			                int sumaPesos = caminoMinimo.getSumaPesos(i);
			                System.out.println(" - Suma de pesos: " + sumaPesos);
			            }
			        }
			    } else {
			        System.out.println("El vértice de origen no es válido.");
			    }
				
			
			break;

		case 8:
			System.out.println("Gracias");
			return;

		default:
			System.out.println("Opción inválida. Intente nuevamente.");
			break;
		}
	}

}
}
