package Clases.Ejercicio3;

import Interfaces.Reproduccion;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ListaPremium implements Reproduccion {
    private String nombre;
    private LinkedList miLista;

    public ListaPremium() {}
    public ListaPremium(String nombre) {
        this.nombre = nombre;
        this.miLista = new LinkedList();
    }

    public void reproducir() {
        if (miLista.isEmpty()){
            System.out.println("No hay canciones en la lista");
        }
        else {
            Iterator it = miLista.iterator();
            while (it.hasNext()) {
                System.out.println(it.next().toString());
            }
        }
    }

    public void añadirCancion(Cancion cancion) {
        miLista.add(cancion);
    }

    public void eliminarCancion() {
        if (miLista.isEmpty()){
            System.out.println("No hay canciones en la lista");
        }
        else {
            Iterator it = miLista.iterator();
            while (it.hasNext()) {
                System.out.println(it.next().toString());
            }
            System.out.println("Cual quieres eliminar");
            Scanner sc = new Scanner(System.in);
            miLista.remove(sc.nextInt());
        }
    }

    public void verMiLista() {
        Iterator it = miLista.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }


}
