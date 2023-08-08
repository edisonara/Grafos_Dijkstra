package grafos;

import java.util.LinkedList;
public class ColaLista {
    private LinkedList<Integer> lista;

    public ColaLista() {
        lista = new LinkedList<Integer>();
    }

    public boolean colaVacia() {
        return lista.isEmpty();
    }

    public void insertar(Integer elemento) {
        lista.add(elemento);
    }

    public Integer quitar() {
        return lista.poll();
    }
}
