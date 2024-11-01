package Clases.Ejericicio5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListaOrdenada<T extends Comparable<T>> {
    private List<T> listaOrdenada;

    public ListaOrdenada() {
        listaOrdenada = new ArrayList<T>();
    }

    public void agregar(T elemento) {
        listaOrdenada.add(elemento);

        Scanner sc = new Scanner(System.in);
        System.out.println("¿De que forma quieres que se ordene?");
        System.out.println("1-Ascendente");
        System.out.println("2-Descendente");
        int numero = sc.nextInt();

        if (numero == 1) {
            ordenarAsc();
        } else if (numero == 2) {
            ordenarDesc();
        }
        else {
            System.out.println("Ingrese un dato valido");
        }
    }

    public void eliminar(T elemento) {
        listaOrdenada.remove(elemento);
    }

    public Boolean buscar(T elemento) {
        return listaOrdenada.contains(elemento);
    }

    public void ordenarAsc() {
        Collections.sort(listaOrdenada);
    }

    public void ordenarDesc() {
        Collections.sort(listaOrdenada, Collections.reverseOrder());
    }
}
