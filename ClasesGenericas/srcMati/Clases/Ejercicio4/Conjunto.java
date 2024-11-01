package Clases.Ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class Conjunto<T> {
    private List<T> lista;

    public Conjunto() {
        lista = new ArrayList<T>();
    }

    public void agregar(T elemento) {
        lista.add(elemento);
    }

    public void eliminar(T elemento) {
        lista.remove(elemento);
    }

    public boolean buscar(T elemento) {
        return lista.contains(elemento);
    }
}
