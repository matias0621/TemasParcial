package Clases.Ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Almacenamiento<T> {
    private List<T> listaAlmacenamiento;

    public Almacenamiento() {
        listaAlmacenamiento = new ArrayList<T>();
    }

    public void agregar(T datoAlmacenar) {
        listaAlmacenamiento.add(datoAlmacenar);
    }

    public void eliminarDato(){
        mostrarLista();

        System.out.println("Elija el numero del elemento que desea eliminar");
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
        if (numero > listaAlmacenamiento.size() || numero < 0) {
            System.out.println("Ingrese un numero valido");
        }
        else {
            listaAlmacenamiento.remove(numero);
            System.out.println("Elemento numero " + numero + " eliminado");
        }
    }

    public void mostrarLista(){
        for (int i = 0; i < listaAlmacenamiento.size(); i++) {
            System.out.println( i + "-" + listaAlmacenamiento.get(i));
        }
    }

    public boolean buscarObjeto(T obj){
        return listaAlmacenamiento.contains(obj);
    }
}
