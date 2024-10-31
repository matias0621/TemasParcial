import Clases.Ejercicio1.Inventario;
import Clases.Ejercicio1.Libro;
import Clases.Ejercicio3.*;
import Enums.Genero;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int control = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Que ejercicio quieres ejecutar?");

        control = sc.nextInt();
        switch (control) {
            case 1:
                Libro libro1 = new Libro("Valle de la calma", "Dross", 500, "2019");
                Libro libro2 = new Libro("Luna de Pluton", "Dross", 800, "2016");
                Libro libro3 = new Libro("Deadpool mata al universo marvel", "Un chango", 1000, "2012");

                Inventario inventario = new Inventario();
                inventario.agregarLibro(libro1);
                inventario.agregarLibro(libro2);
                inventario.agregarLibro(libro3);

                /*inventario.mostrarInventarioDeLibros();

                inventario.cantidadDeLibrosEnElInventario();

                inventario.buscarLibros(libro3);

                inventario.modificarPrecioDeLibro();

                inventario.calcularPrecioTotal();*/

                inventario.libroMasCaro();

                inventario.libroMasBarato();

                break;
            case 2:

                break;
            case 3:
                Artista artista1 = new Artista("Queen", 50, "UK");
                Artista artista2 = new Artista("David Bowie", 69, "UK");

                Album album1 = new Album("A Night at the Opera", "1975", artista1);

                Cancion cancion1 = new Cancion("Bohemian Rhapsody", 5.55, Genero.ROCK, album1, null);
                Cancion cancion2 = new Cancion("Under Pressure", 4.08, Genero.ROCK, album1, artista2);

                /*
                Reproductor miLista = new Reproductor();
                miLista.añadirCancion(cancion1);
                miLista.añadirCancion(cancion2);

                miLista.verMiLista();
                miLista.reproducir();
                miLista.eliminarCancion();
                miLista.verMiLista();


                ListaBasica listaBasica = new ListaBasica("La super lista");

                listaBasica.añadirCancion(cancion1);
                listaBasica.añadirCancion(cancion2);
                listaBasica.verMiLista();
                listaBasica.reproducir();
                 */

                ListaPremium listaPremium = new ListaPremium("Lista de chetooooooo");

                listaPremium.añadirCancion(cancion1);
                listaPremium.añadirCancion(cancion2);
                listaPremium.reproducir();
                listaPremium.verMiLista();


                break;
            default:
                System.out.println("Ese ejercicio no existe");
                break;
        }

    }
}