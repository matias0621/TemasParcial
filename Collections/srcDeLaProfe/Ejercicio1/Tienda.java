package Ejercicio1;

import java.util.LinkedList;

public class Tienda {

    private LinkedList<Libro> libros; // elegi LinkedList porque hay muchas eliminaciones
                                   // y agregaciones de datos por cada libro que se vende y compra

    // Constructor
    public Tienda() {
        this.libros = new LinkedList<>();
    }

    // Metodos propios
    public String agregarLibro(Libro nuevo){
        String mensaje= "";
        if(nuevo != null){
            libros.add(nuevo);
            mensaje = "Libro cargado con exito";
        }else{
            mensaje = "Error";
        }
        return mensaje;
    }

    public String eliminarLibro(Libro libro){
        String mensaje = "";
        if(libro != null){
            libros.remove(libro);
            mensaje = "Libro eliminado con exito";
        }else{
            mensaje = "Libro no encontrado";
        }
        return mensaje;
    }

    public  String mostrarTodos(){
        String mensaje = "";

        for(Libro libroL : libros){
            mensaje += libroL.toString() + "   \n";
        }
        return mensaje;
    }

    public int obtenerPos(String titulo){
        Libro libroAux = new Libro();
        libroAux.setTitulo(titulo);
        int pos = libros.indexOf(libroAux); //ojo: aca funciona bien porque el equals esta implementado para comparar por titulo
        return pos;
    }

    public Libro buscarPorTitulo (String titulo ){
        int pos = obtenerPos(titulo);
        return libros.get(pos);
    }

    public void actualizarPrecioDeLibro(String titulo, double precio){
        int pos = obtenerPos(titulo);
        Libro libroAux = new Libro();
        libroAux = libros.get(pos);
        libroAux.setPrecio(precio);
        libros.set(pos, libroAux);
    }

    public double precioTotal(){
        double total = 0;
        for(Libro librito : libros){
            total += librito.getPrecio();
        }
        return total;
    }

    public int contarTotal(){
        return libros.size();
    }

    public Libro obtenerMasCaro(){
        Libro masCaro = new Libro();
        masCaro = libros.get(0);

        for(Libro librito : libros){
            if(librito.getPrecio() > masCaro.getPrecio()){
                masCaro = librito;
            }
        }
        return masCaro;

    }

    public Libro obtenerMasBarato(){
        Libro masBarato = new Libro();
        masBarato = libros.get(0);

        for(Libro librito : libros){
            if(librito.getPrecio() < masBarato.getPrecio()){
                masBarato = librito;
            }
        }
        return masBarato;

    }

}
