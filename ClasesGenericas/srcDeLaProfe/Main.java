import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /* 1. Crear una clase genérica llamada "Almacenamiento" que pueda almacenar
        cualquier tipo de objeto. Debe tener métodos para agregar, eliminar, y buscar
        objetos en el almacenamiento. Haz pruebas de tu clase con diferentes tipos
        de objetos.*/
//
//        int num1 = 1;
//        int num2 = 2;
//        int num3 = 3;
//
//        String palabra1 = "Hola";
//        String palabra2 = "Mundo";
//        String palabra3 = "Chau";
//
//        Almacenamiento<Integer> almacenaNumeros = new Almacenamiento<>();
//        Almacenamiento<String> almacenaPalabras = new Almacenamiento<>();
//
//        almacenaNumeros.Agregar(num1);
//        almacenaNumeros.Agregar(num2);
//        almacenaNumeros.Agregar(num3);
//
//        System.out.println("Contenedor de numeros: " + almacenaNumeros);
//
//        System.out.println("¿El nro 1 está en el contenedor de numeros?: " + almacenaNumeros.Buscar(num1));
//
//        almacenaNumeros.Eliminar(num3);
//
//        System.out.println("Contenedor de numeros luego de eliminar Nro 3: " + almacenaNumeros);
//
//        // almacenaNumeros.Agregar(palabra3); /// lanza ERROR si agregamos tipo de dato distinto
//
//        almacenaPalabras.Agregar(palabra1);
//        almacenaPalabras.Agregar(palabra2);
//        almacenaPalabras.Agregar(palabra3);
//
//        System.out.println("Contenedor de palabras: " + almacenaPalabras);
//
//        almacenaPalabras.Eliminar(palabra3);
//
//        System.out.println("Contenedor de palabras luego de eliminar palabra 3: " + almacenaPalabras);
//
//        /*  2. Crear una clase genérica llamada "Pila" que funcione como una pila de objetos.
//        Debe tener métodos para agregar y quitar elementos de la pila,
//        para verificar si está vacía, y para obtener el número de elementos en la Pila.
//        Haz pruebas de tu clase con diferentes tipos de objetos.*/
//
//        Pila<String> pila = new Pila<>();
//
//        pila.Agregar(palabra1);
//        pila.Agregar(palabra2);
//        pila.Agregar(palabra3);
//        System.out.println(pila);
//
//        System.out.println("Tope extraido de la Pila:" + pila.Eliminar());
//        System.out.println("Pila luego de eliminar un dato: " + pila);
//
//        /* 3. Crear una clase genérica llamada "OperacionMatematica"
//        que pueda realizar operaciones matemáticas simples (suma, resta, multiplicación, división)
//        con cualquier tipo de número (enteros, decimales, etc.).
//        Debe tener métodos para cada operación y para establecer los números de entrada.
//        Haz pruebas de tu clase con diferentes tipos de números.*/
//
//        float f1 = 0.2f; // o (float) 0.2
//        double d1 = 1.5;
//
//        // son todos métodos estáticos, para isar desde la clase, sin crear instancias
//        System.out.println("1.5 + 1 = " + OperacionMatematica.sumar(d1, num1));
//        System.out.println("1 - 2 = " + OperacionMatematica.restar(num1,num2));
//        System.out.println("0.2 * 1.5 = " + OperacionMatematica.multiplicar(f1,d1));
//        System.out.println("0.2 * 3 = " + OperacionMatematica.multiplicar(f1,num3));
//        try{
//            System.out.println("3 / 1.5 = " + OperacionMatematica.dividir(num3,d1));
//        }catch (ArithmeticException ex){
//            System.err.println(ex.getMessage());
//            ex.printStackTrace();
//        }
//
//        /* 4. Crear una clase genérica llamada "Conjunto"
//        que pueda almacenar elementos únicos de cualquier tipo.
//        Debe tener métodos para agregar y eliminar elementos,
//        y para verificar si un elemento está en el conjunto.
//        Haz pruebas de tu clase con diferentes tipos de elementos.*/
//
//        Conjunto<Integer>  conjunto = new Conjunto();
//        conjunto.Agregar(1);
//        conjunto.Agregar(2);
//        System.out.println(conjunto.Agregar(3)? "Agregado Correctamente" : "Elemento Duplicado");
//        System.out.println(conjunto.Agregar(3)? "Agregado Correctamente" : "Elemento Duplicado");
//
//        System.out.println("¿El numero 1 está en el conjunto?: " + conjunto.buscar(1) );
//
//        System.out.println("Conjunto de numeros: " + conjunto);
//
//        conjunto.Eliminar(1);
//        System.out.println("Conjunto de numeros eliminando el 1: " + conjunto);

        /* 5. Crear una clase genérica llamada "ListaOrdenada"
        que pueda almacenar elementos en orden ascendente o descendente.
        Debe tener métodos para agregar y eliminar elementos,
        y para obtener el elemento en una posición específica.
        Haz pruebas de tu clase con diferentes tipos de elementos y diferentes órdenes de clasificación. */

        ListaOrdenada<String> lista = new ListaOrdenada<>(false);
        lista.Agregar("Hola");
        lista.Agregar("Estas");
        lista.Agregar("Como");
        System.out.println(lista);
        try{
            System.out.println("Elemento en la posicion 2: " + lista.buscarPorPosicion(2));
        }catch (IndexOutOfBoundsException ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }


        System.out.println("Posicion en la cual está la palabra Hola: " + lista.buscarYretornarPosicion("Hola"));
    }
}