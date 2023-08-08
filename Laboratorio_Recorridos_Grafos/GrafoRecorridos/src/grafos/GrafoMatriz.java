package grafos;
import java.util.*;
public class GrafoMatriz {
	int numVerts;
	static int MaxVerts = 20;
	Vertice[] verts;
	int[][] matAd;
	private static final int INFINITO = Integer.MAX_VALUE;
    private int[][] matrizPesos;

	public GrafoMatriz() {
		this(MaxVerts);
	}
	public GrafoMatriz(int mx) {
		matAd = new int[mx][mx];
		verts = new Vertice[mx];
		for (int i = 0; i < mx; i++)
			for (int j = 0; j < mx; j++) // Correcci�n: j en lugar de i
			matAd[i][j] = 0;
		numVerts = 0;
	}

	// Agregar un nuevo v�rtice al grafo
	public void nuevoVertice(String nom) {
		boolean esta = numVertice(nom) >= 0;
		if (!esta) {
			Vertice v = new Vertice(nom);
			v.asigVert(numVerts);
			verts[numVerts++] = v;
		}
	}

	// Obtener el �ndice de un v�rtice en el arreglo "verts" seg�n su nombre
	int numVertice(String vs) {
		Vertice v = new Vertice(vs);
		boolean encontrado = false;
		int i = 0;
		for (; (i < numVerts) && !encontrado;) {
			encontrado = verts[i].equals(v);
			if (!encontrado)
				i++;
		}
		return (i < numVerts) ? i : -1;
	}

	// Agregar una nueva arista entre dos v�rtices por su nombre
	public void nuevoArco(String a, String b) throws Exception {
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		if (va < 0 || vb < 0)
			throw new Exception("V�rtice no existe");
		matAd[va][vb] = 1;
	}

	// Agregar una nueva arista entre dos v�rtices por su �ndice
	public void nuevoArco(int va, int vb) throws Exception {
		if (va < 0 || vb < 0)
			throw new Exception("V�rtice no existe");
		matAd[va][vb] = 1;
	}

	// Verificar si dos v�rtices por su nombre son adyacentes
	public boolean adyacente(String a, String b) throws Exception {
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		if (va < 0 || vb < 0)
			throw new Exception("V�rtice no existe");
		return matAd[va][vb] == 1;
	}

	// Verificar si dos v�rtices por su �ndice son adyacentes
	public boolean adyacente(int va, int vb) throws Exception {
		if (va < 0 || vb < 0)
			throw new Exception("V�rtice no existe");
		return matAd[va][vb] == 1;
	}

	// Obtener la lista de v�rtices conectados a un v�rtice por su nombre
	public List<Vertice> nodosConectados(String a) throws Exception {
		int va = numVertice(a);
		if (va < 0) {
			throw new Exception("V�rtice no existe");
		}

		List<Vertice> nodosConectados = new ArrayList<Vertice>();
		for (int i = 0; i < numVerts; i++) {
			if (matAd[va][i] == 1) {
				nodosConectados.add(verts[i]);
			}
		}

		return nodosConectados;
	}
	public void GrafMatPeso(int numVertices) {
		matrizPesos = new int[numVertices][numVertices];
		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				matrizPesos[i][j] = INFINITO;
			}
			
		}
	}

	public void agregarArco(int origen, int destino, int peso) {
		matrizPesos[origen][destino] = peso;
	}

	public int pesoArco(int origen, int destino) {
		return matrizPesos[origen][destino];
	}

	public int numeroDeVertices() {
		return matrizPesos.length;
	}
}

