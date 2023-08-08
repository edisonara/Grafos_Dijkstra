package grafos;

public class CaminoMinimo {
    private int[][] pesos;
    private int[] ultimo;
    int[] D;
    private boolean[] F;
    private int s, n; // vértice origen y número de vértices

    public CaminoMinimo(GrafoMatriz grafo, int origen) {
        n = grafo.numeroDeVertices();
        s = origen;
        pesos = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pesos[i][j] = grafo.pesoArco(i, j);
            }
        }
        ultimo = new int[n];
        D = new int[n];
        F = new boolean[n];
    }

    public void caminoMinimos() {
        // valores iniciales
        for (int i = 0; i < n; i++) {
            F[i] = false;
            D[i] = pesos[s][i];
            ultimo[i] = s;
        }
        F[s] = true;
        D[s] = 0;

        // Pasos para marcar los n-1 vértices
        for (int i = 1; i < n; i++) {
            int v = minimo(); /* selecciona vértice no marcado de menor distancia */
            F[v] = true;

            // actualiza distancia de vértices no marcados
            for (int w = 0; w < n; w++) {
                if (!F[w]) {
                    if ((D[v] + pesos[v][w]) < D[w]) {
                        D[w] = D[v] + pesos[v][w];
                        ultimo[w] = v;
                    }
                }
            }
        }
    }

    private int minimo() {
        int mx = Integer.MAX_VALUE;
        int v = -1;
        for (int j = 0; j < n; j++) {
            if (!F[j] && (D[j] <= mx)) {
                mx = D[j];
                v = j;
            }
        }
        return v;
    }
    public void recuperaCamino(int v){
	    int anterior = ultimo[v];
	    if (v != s){
	     recuperaCamino(anterior); // vuelve al último del último
	     System.out.print(" -> V" + v);
	    }else 
	    	System.out.print("V" + s);
    }
    public int getSumaPesos(int destino) {
        return D[destino];
    }
}
