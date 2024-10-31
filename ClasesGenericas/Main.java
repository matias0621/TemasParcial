import Clases.Ejercicio1.Almacenamiento;
import Clases.Ejercicio1.Persona;
import Clases.Ejercicio2.Pila;
import Clases.Ejercicio4.Conjunto;
import Clases.Ejericicio3.CalculosMatematicos;
import Clases.Ejericicio5.ListaOrdenada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de ejericicio que quiere ejecutar 1-6");
        int num = sc.nextInt();

        switch (num) {
            case 1:
                // Prueba con Strings
                Almacenamiento<String> almacenamientoStrings = new Almacenamiento<>();
                almacenamientoStrings.agregar("Hola");
                almacenamientoStrings.agregar("Mundo");
                almacenamientoStrings.mostrarLista();
                System.out.println("¿Contiene 'Hola'? " + almacenamientoStrings.buscarObjeto("Hola"));
                almacenamientoStrings.eliminarDato();
                almacenamientoStrings.mostrarLista();

                // Prueba con Integer
                Almacenamiento<Integer> almacenamientoEnteros = new Almacenamiento<>();
                almacenamientoEnteros.agregar(1);
                almacenamientoEnteros.agregar(2);
                almacenamientoEnteros.mostrarLista();
                System.out.println("¿Contiene 2? " + almacenamientoEnteros.buscarObjeto(2));
                almacenamientoEnteros.eliminarDato();
                almacenamientoEnteros.mostrarLista();

                // Prueba con objetos personalizados
                Almacenamiento<Persona> almacenamientoPersonas = new Almacenamiento<>();
                Persona persona1 = new Persona("Juan", 25);
                Persona persona2 = new Persona("Maria", 30);
                almacenamientoPersonas.agregar(persona1);
                almacenamientoPersonas.agregar(persona2);
                almacenamientoPersonas.mostrarLista();
                System.out.println("¿Contiene a Juan? " + almacenamientoPersonas.buscarObjeto(persona1));
                almacenamientoPersonas.eliminarDato();
                almacenamientoPersonas.mostrarLista();
                break;
            case 2:
                // Prueba con Strings
                System.out.println("Prueba con Strings:");
                Pila<String> pilaStrings = new Pila<>();
                pilaStrings.agregar("Primero");
                pilaStrings.agregar("Segundo");
                pilaStrings.agregar("Tercero");
                pilaStrings.mostrar();
                System.out.println("¿La pila está vacía? " + pilaStrings.pilaVacia());
                System.out.println("Tamaño de la pila: " + pilaStrings.tamanio());
                pilaStrings.eliminar("Segundo");
                pilaStrings.mostrar();
                System.out.println();

                // Prueba con Integer
                System.out.println("Prueba con Integer:");
                Pila<Integer> pilaEnteros = new Pila<>();
                pilaEnteros.agregar(1);
                pilaEnteros.agregar(2);
                pilaEnteros.agregar(3);
                pilaEnteros.mostrar();
                System.out.println("¿La pila está vacía? " + pilaEnteros.pilaVacia());
                System.out.println("Tamaño de la pila: " + pilaEnteros.tamanio());
                pilaEnteros.eliminar(2);
                pilaEnteros.mostrar();
                System.out.println();

                // Prueba con objetos personalizados (Persona)
                System.out.println("Prueba con objetos Persona:");
                Pila<Persona> pilaPersonas = new Pila<>();
                Persona persona3 = new Persona("Juan", 25);
                Persona persona4 = new Persona("Maria", 30);
                Persona persona5 = new Persona("Pedro", 40);
                pilaPersonas.agregar(persona3);
                pilaPersonas.agregar(persona4);
                pilaPersonas.agregar(persona5);
                pilaPersonas.mostrar();
                System.out.println("¿La pila está vacía? " + pilaPersonas.pilaVacia());
                System.out.println("Tamaño de la pila: " + pilaPersonas.tamanio());
                pilaPersonas.eliminar(persona4); // Eliminar a Maria
                pilaPersonas.mostrar();
                break;
            case 3:
                // Crear una instancia de la clase genérica
                CalculosMatematicos<Number> calculos = new CalculosMatematicos<>();

                // Pruebas con enteros
                Number entero1 = 10;
                Number entero2 = 5;
                System.out.println("Pruebas con enteros:");
                System.out.println("Suma: " + calculos.suma(entero1, entero2));
                System.out.println("Resta: " + calculos.resta(entero1, entero2));
                System.out.println("Multiplicación: " + calculos.multiplicar(entero1, entero2));
                System.out.println("División: " + calculos.dividir(entero1, entero2));
                System.out.println();

                // Pruebas con números decimales (Double)
                Number decimal1 = 10.5;
                Number decimal2 = 2.5;
                System.out.println("Pruebas con decimales:");
                System.out.println("Suma: " + calculos.suma(decimal1, decimal2));
                System.out.println("Resta: " + calculos.resta(decimal1, decimal2));
                System.out.println("Multiplicación: " + calculos.multiplicar(decimal1, decimal2));
                System.out.println("División: " + calculos.dividir(decimal1, decimal2));
                System.out.println();

                // Prueba con mezcla de tipos (Integer y Double)
                System.out.println("Prueba con mezcla de tipos (Integer y Double):");
                Number mezcla1 = 15;
                Number mezcla2 = 2.7;
                System.out.println("Suma: " + calculos.suma(mezcla1, mezcla2));
                System.out.println("Resta: " + calculos.resta(mezcla1, mezcla2));
                System.out.println("Multiplicación: " + calculos.multiplicar(mezcla1, mezcla2));
                System.out.println("División: " + calculos.dividir(mezcla1, mezcla2));
                break;
            case 4:
                // Crear un conjunto de enteros
                Conjunto<Integer> conjuntoEnteros = new Conjunto<>();
                conjuntoEnteros.agregar(1);
                conjuntoEnteros.agregar(2);
                conjuntoEnteros.agregar(3);
                System.out.println("Conjunto de enteros:");
                System.out.println("Contiene el 2: " + conjuntoEnteros.buscar(2));
                System.out.println("Contiene el 4: " + conjuntoEnteros.buscar(4));
                conjuntoEnteros.eliminar(2);
                System.out.println("Después de eliminar el 2, contiene el 2: " + conjuntoEnteros.buscar(2));
                System.out.println();

                // Crear un conjunto de cadenas (Strings)
                Conjunto<String> conjuntoCadenas = new Conjunto<>();
                conjuntoCadenas.agregar("Hola");
                conjuntoCadenas.agregar("Mundo");
                conjuntoCadenas.agregar("Java");
                System.out.println("Conjunto de cadenas:");
                System.out.println("Contiene 'Mundo': " + conjuntoCadenas.buscar("Mundo"));
                System.out.println("Contiene 'Python': " + conjuntoCadenas.buscar("Python"));
                conjuntoCadenas.eliminar("Mundo");
                System.out.println("Después de eliminar 'Mundo', contiene 'Mundo': " + conjuntoCadenas.buscar("Mundo"));
                System.out.println();

                // Crear un conjunto de números decimales (Doubles)
                Conjunto<Double> conjuntoDecimales = new Conjunto<>();
                conjuntoDecimales.agregar(1.5);
                conjuntoDecimales.agregar(2.5);
                conjuntoDecimales.agregar(3.5);
                System.out.println("Conjunto de decimales:");
                System.out.println("Contiene 2.5: " + conjuntoDecimales.buscar(2.5));
                System.out.println("Contiene 4.5: " + conjuntoDecimales.buscar(4.5));
                conjuntoDecimales.eliminar(2.5);
                break;
            case 5:
                // Crear una lista ordenada de enteros
                ListaOrdenada<Integer> listaEnteros = new ListaOrdenada<>();
                System.out.println("Prueba con enteros:");
                listaEnteros.agregar(5);
                listaEnteros.agregar(2);
                listaEnteros.agregar(8);
                listaEnteros.agregar(1);
                System.out.println("Lista de enteros después de agregar elementos:");
                System.out.println(listaEnteros);

                // Eliminar un elemento
                listaEnteros.eliminar(2);
                System.out.println("Lista de enteros después de eliminar el 2:");
                System.out.println(listaEnteros);

                // Buscar un elemento
                System.out.println("¿Contiene el número 5? " + listaEnteros.buscar(5));
                System.out.println("¿Contiene el número 2? " + listaEnteros.buscar(2));
                System.out.println();

                // Crear una lista ordenada de cadenas
                ListaOrdenada<String> listaCadenas = new ListaOrdenada<>();
                System.out.println("Prueba con cadenas:");
                listaCadenas.agregar("banana");
                listaCadenas.agregar("manzana");
                listaCadenas.agregar("naranja");
                listaCadenas.agregar("pera");
                System.out.println("Lista de cadenas después de agregar elementos:");
                System.out.println(listaCadenas);

                // Eliminar un elemento
                listaCadenas.eliminar("manzana");
                System.out.println("Lista de cadenas después de eliminar 'manzana':");
                System.out.println(listaCadenas);

                // Buscar un elemento
                System.out.println("¿Contiene 'banana'? " + listaCadenas.buscar("banana"));
                System.out.println("¿Contiene 'manzana'? " + listaCadenas.buscar("manzana"));
                break;
            case 6:

        }
    }
}