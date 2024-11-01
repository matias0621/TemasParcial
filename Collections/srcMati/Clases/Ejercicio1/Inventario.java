package Clases.Ejercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Inventario {
    ArrayList<Libro> lista = new ArrayList<Libro>();

    public void agregarLibro(Libro libro) {
        lista.add(libro);
    }

    public void mostrarInventarioDeLibros(){
        if (!lista.isEmpty()){
            int i = 0;
            for(Libro libro : lista){

                System.out.println(i +"- "+libro.toString());
                i++;
            }
        }
        else {
            System.out.println("No hay libros");
        }
    }

    public void eliminarLibros(){
        mostrarInventarioDeLibros();

        if (!lista.isEmpty()){
            System.out.println("Seleccione el numero de la cancion que quiere eliminar");

            Scanner sc = new Scanner(System.in);
            int seleccion = sc.nextInt();
            lista.remove(seleccion);
        }
    }

    public Libro buscarLibros(Libro libro){
        if (!lista.isEmpty()){
            boolean encontrado = false;
            for (Libro lib : lista) {
                if (lib.getTitulo().equals(libro.getTitulo())) {
                    lib.toString();
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("No existe el libro con ese titulo");
            }
        }
        else {
            System.out.println("No hay libros cargados");
        }
        return libro;
    }

    public void modificarPrecioDeLibro(){
        if (!lista.isEmpty()){
            mostrarInventarioDeLibros();
            System.out.println("Seleccione el numero del libro que quiere editar");

            Scanner sc = new Scanner(System.in);
            int seleccion = sc.nextInt();

            if (seleccion < 0){
                System.out.println("Ingrese un numero valido");
            }
            else {
                System.out.println("Ingrese el nuevo precio");
                double precio = sc.nextDouble();
                sc.nextLine();
                if (precio < 0) {
                    System.out.println("Ingrese un precio valido");
                }
                else {
                    lista.get(seleccion).setPrecio(precio);
                }
            }
        }
    }

    public double calcularPrecioTotal(){
        int precioTotal = 0;
        for (Libro libro : lista) {
            precioTotal += libro.getPrecio();
        }
        System.out.println("El precio total es de: " + precioTotal);
        return precioTotal;
    }

    public int cantidadDeLibrosEnElInventario(){
        System.out.println("La cantidad de libros en el inventario es de: " + lista.size());
        return lista.size();
    }

    public Libro libroMasCaro(){
        Libro libroMasCaro = Collections.max(lista);
        System.out.println(libroMasCaro.toString());
        return libroMasCaro;
    }

    public Libro libroMasBarato(){
        Libro libroMasBarato = Collections.min(lista);
        System.out.println(libroMasBarato.toString());
        return libroMasBarato;
    }





}
