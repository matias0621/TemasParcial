package Ejercicio1;

/* 1.	Supongamos que estás desarrollando un programa para gestionar una tienda de libros. Cada libro tiene un título, un autor, un precio, y el año de publicación. El programa debe permitir realizar las siguientes operaciones:
●	Agregar un nuevo libro al inventario.
●	Eliminar un libro del inventario.
●	Mostrar todos los libros en el inventario.
●	Buscar un libro por su título.
●	Actualizar el precio de un libro.
●	Calcular el precio total de todos los libros en el inventario.
●	Contar el número total de libros en el inventario.
●	Encontrar el libro más caro y el más barato en el inventario.
Pensar que estructuras de datos vista (ArrayList, LinkedList, Stack, HashMap, etc.) nos conviene para implementar las operaciones anteriores.
Consideraciones adicionales:
-	Crea una clase Libro que tenga atributos para el título, autor, precio y año de publicación.
-	Asegúrate de agregar validaciones de entrada para garantizar que los datos ingresados por el usuario sean válidos.
*/

public class Main {
    public static void main(String[] args) {

        //Crear la tienda
        Tienda miTienda = new Tienda();

        // Crear los libros
        Libro libro1 = new Libro(2020, "Gabriel García Márquez", 19.99, "Cien años de soledad");
        Libro libro2 = new Libro(2005, "J.K. Rowling", 25.50, "Harry Potter y el misterio del príncipe");
        Libro libro3 = new Libro(1984, "George Orwell", 15.75, "1984");

        // Agregar los libros a la tienda
        System.out.println(miTienda.agregarLibro(libro1));
        System.out.println(miTienda.agregarLibro(libro2));
        System.out.println(miTienda.agregarLibro(libro3));
        System.out.println("\n");

        // Eliminar un libro
        System.out.println(miTienda.eliminarLibro(libro1));
        System.out.println("\n");

        // Mostrar todos los libros
        String infoDeTodos = miTienda.mostrarTodos();
        System.out.println(infoDeTodos);
        System.out.println("\n");

        // Buscar un libro por su titulo
        Libro libroBuscado = new Libro();
        libroBuscado = miTienda.buscarPorTitulo("Harry Potter y el misterio del príncipe");


        // Actualizar el precio de un libro
        miTienda.actualizarPrecioDeLibro("1984", 20.50);
        System.out.println(miTienda.mostrarTodos());
        System.out.println("\n");


        // Calcular precio total de todos los libros
        double total = miTienda.precioTotal();
        System.out.println("El precio total de todos los libros es de: " + total);
        System.out.println("\n");


        // Contar el numero total de libros
        int cantTotal = miTienda.contarTotal();
        System.out.println("La cantidad total de libros es de: " + cantTotal);
        System.out.println("\n");


        // Obtener libro mas caro
        Libro masCaro = new Libro();
        masCaro = miTienda.obtenerMasCaro();
        System.out.println("El libro mas caro es: " + masCaro.toString());
        System.out.println("\n");


        // Obtener libro mas barato
        Libro masBarato = new Libro();
        masBarato = miTienda.obtenerMasBarato();
        System.out.println("El libro mas barato es: " + masBarato.toString());
        System.out.println("\n");



    }
}