package grafos;

import java.util.LinkedList;
public class PilaLista {
    private LinkedList<Integer> lista;

    public PilaLista() {
        lista = new LinkedList<Integer>();
    }

    public boolean pilaVacia() {
        return lista.isEmpty();
    }

    public void insertar(Integer elemento) {
        lista.add(elemento);
    }

    public Integer quitar() {
        return lista.poll();
    }
}