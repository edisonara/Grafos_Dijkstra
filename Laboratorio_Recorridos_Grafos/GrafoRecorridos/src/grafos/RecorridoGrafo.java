package grafos;
import grafos.*;

public class RecorridoGrafo {
	static String CLAVE = null;

	public static Integer[] RecorridoAnc(GrafoMatriz g, String org) throws Exception {
	    int w, v;
	    Integer[] m; // Cambiado a Integer[]
	    v = g.numVertice(org);
	    if (v < 0) throw new Exception("Vertice origen no existe");

	    ColaLista cola = new ColaLista();
	    m = new Integer[g.numVerts];
	    for (int i = 0; i < g.numVerts; i++)
	        m[i] = null; // Inicializar con null

	    m[v] = 0; // V�rtice origen con distancia 0
	    cola.insertar(new Integer(v));

	    while (!cola.colaVacia()) {
	        Integer cw = (Integer) cola.quitar();
	        w = cw.intValue();
	        System.out.println("Vertice " + g.verts[w] + " visitado");

	        for (int u = 0; u < g.numVerts; u++) {
	            if ((g.matAd[w][u] == 1) && (m[u] == null)) { // Cambiado a null
	                m[u] = m[w] + 1;
	                cola.insertar(new Integer(u));
	            }
	        }
	    }
	    return m;
	}
	public static String[] recorrerProf(GrafoMatriz grafo, String org) throws Exception {
	    int v, w;
	    PilaLista pila = new PilaLista();
	    String[] m;
	    m = new String[grafo.numVerts];

	    // Inicializa los v�rtices como no marcados
	    v = grafo.numVertice(org);
	    if (v < 0) throw new Exception("V�rtice origen no existe");

	    for (int i = 0; i < grafo.numVerts; i++)
	        m[i] = CLAVE;
	    m[v] = null; // V�rtice origen queda marcado

	    pila.insertar(new Integer(v));

	    while (!pila.pilaVacia()) {
	        Integer cw = (Integer) pila.quitar();
	        w = cw.intValue();
	        System.out.println("V�rtice " + w + " visitado");

	        // Inserta en la pila los adyacentes de w no marcados
	        for (int u = 0; u < grafo.numVerts; u++) {
	            if (grafo.matAd[w][u] == 1 && m[u] == CLAVE) {
	                pila.insertar(new Integer(u));
	                m[u] = "marcado"; // V�rtice queda marcado
	            }
	        }
	    }
	    return m;
	}


}
