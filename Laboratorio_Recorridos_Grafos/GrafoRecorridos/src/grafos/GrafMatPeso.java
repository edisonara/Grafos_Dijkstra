package grafos;

import java.util.List;

public class GrafMatPeso extends GrafoMatriz {
	private static final int INFINITO = Integer.MAX_VALUE;
    private int[][] matrizPesos;
    private Object[] vertices;
    private int numVertices;

    public GrafMatPeso(int pesos) {
        this.numVertices = pesos;
        matrizPesos = new int[pesos][pesos];
        vertices = new Object[pesos];
        for (int i = 0; i < pesos; i++) {
            for (int j = 0; j < pesos; j++) {
                matrizPesos[i][j] = INFINITO;
            }
        }
    }

    public void agregarVertice(Object vertice) {
        vertices[numVertices++] = vertice;
    }

    public void agregarArco(int origen, int destino, int peso) {
        matrizPesos[origen][destino] = peso;
    }

    public int pesoArco(int origen, int destino) {
        return matrizPesos[origen][destino];
    }

    public int numeroDeVertices() {
        return numVertices;
    }
	
}
