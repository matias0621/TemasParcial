package Clases.Ejercicio3;

import Interfaces.Reproduccion;

import java.util.ArrayList;
import java.util.Scanner;

public class Reproductor implements Reproduccion {
    ArrayList<Cancion> listaCanciones = new ArrayList();


    @Override
    public void reproducir() {
        if (listaCanciones.isEmpty()){
            System.out.println("No hay Canciones");
        }
        else {
            for (int i = 0; i < listaCanciones.size(); i++) {
                Cancion c = listaCanciones.get(i);
                c.toString();
            }
        }
    }

    @Override
    public void añadirCancion(Cancion c) {
        listaCanciones.add(c);
    }

    @Override
    public void eliminarCancion(){
        Scanner sc = new Scanner(System.in);
        if (listaCanciones.isEmpty()){
            System.out.println("No hay Canciones");
        }
        else {
            for (int i = 0; i < listaCanciones.size(); i++) {
                Cancion c = listaCanciones.get(i);
                System.out.println(i + "- " + c.toString());
            }

            System.out.println("elija el numero de la cancion que quiere borrar");

            listaCanciones.remove(sc.nextInt());
        }
    }

    @Override
    public void verMiLista(){
        if (listaCanciones.isEmpty()){
            System.out.println("No hay Canciones");
        }
        else {
            for (int i = 0; i < listaCanciones.size(); i++) {
                Cancion c = listaCanciones.get(i);
                System.out.println(i + "- " + c.toString());
            }
        }
    }
}
