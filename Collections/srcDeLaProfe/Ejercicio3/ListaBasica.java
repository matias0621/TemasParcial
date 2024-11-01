package Ejercicio3;

import java.util.ArrayDeque;
import java.util.Queue;


public class ListaBasica extends ListaDeCanciones implements Reproduccion{

    private ArrayDeque<Cancion> miLista; // porque la lista basica posee comportamiento FIFO
                // los datos se insertan al final con offer() y se eliminan del principio con poll()


    public ListaBasica(String nombre) {
        super(nombre);
        this.miLista = new ArrayDeque<Cancion>();
    }

    public ListaBasica() {
        super("");
        this.miLista = new ArrayDeque<Cancion>();
    }


    // Sobreescrituras
    @Override
    public String reproducir(int index) {
        String mensaje = "";

        if (!miLista.isEmpty()) {
            Cancion cancion = miLista.poll(); // elimina y retorna la primera canción en la fila
            miLista.offer(cancion); // Envía la canción al final
            mensaje = "Reproduciendo: " + cancion.toString();
        } else {
            mensaje = "No hay canciones en la lista.";
        }
        return mensaje;
    }


    @Override
    public void añadirCancion(Cancion cancion) {
        miLista.offer(cancion);
    }

    @Override
    public String eliminarCancion(int index) {
        return "Para acceder a estas opciones, compre el paquete PREMIUM.";
    }

    @Override
    public String verMiLista() {
        StringBuilder mensaje = new StringBuilder();

        if (miLista.isEmpty()) {
           mensaje = new StringBuilder("La lista está vacía.");
        } else {
            mensaje.append("Lista de reproducción: \n");
            for (Cancion c : miLista) {
                mensaje.append(c.getNombre()).append(" - ");
            }
        }
        return mensaje.toString();
    }


    // Metodos propios
    public String cambiarCancion() {
        return "Para acceder a estas opciones, compre el paquete PREMIUM.";
    }

}
