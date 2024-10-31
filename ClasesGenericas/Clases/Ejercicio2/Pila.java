package Clases.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Pila<T> {
    private List<T> pila;

    public Pila() {
        pila = new ArrayList<T>();
    }

    public void agregar(T elemento) {
        pila.addFirst(elemento);
    }

    public void eliminar(T elemento) {
        pila.remove(elemento);
    }

    public void mostrar(){
        for (T elemento : pila) {
            System.out.println(elemento);
        }
    }

    public boolean pilaVacia(){
        if (!pila.isEmpty()) {
            return false;
        }
        else {
            return true;
        }
    }

    public int tamanio(){
        return pila.size();
    }
}
