package Ejercicio3;

import java.util.LinkedList;

public class ListaPremium extends ListaDeCanciones implements Reproduccion{

    private LinkedList<Cancion> miLista;

    public ListaPremium(String nombre) {
        super(nombre);
        this.miLista = new LinkedList<Cancion>();
    }

    public ListaPremium() {
        super("");
        this.miLista = new LinkedList<Cancion>();
    }

    public LinkedList<Cancion> getMiLista() {
        return miLista;
    }


    @Override
    public void añadirCancion(Cancion cancion) {
        miLista.add(cancion);
    }


    @Override
    public String eliminarCancion(int index) {

        String mensaje = "";

        if (miLista.isEmpty()) {
            mensaje = "La lista de reproducción está vacía.";
        } else {
            if (index >= 0 && index < miLista.size()) {
                miLista.remove(index);
                mensaje = "Canción eliminada.";
            } else {
                mensaje = "Selección inválida.";
            }
        }
        return mensaje;
    }


    @Override
    public String reproducir(int indiceCancion) {

        String mensaje = "";

        if (miLista.isEmpty()) {
            mensaje = "La lista de reproducción está vacía.";
        }
        else {
            if (indiceCancion >= 0 && indiceCancion < miLista.size()) {
                Cancion cancion = miLista.get(indiceCancion);
                mensaje= "Reproduciendo: " + cancion.toString();
            } else {
                mensaje = "Selección inválida.";
            }
        }
        return mensaje;
    }


    @Override
    public String verMiLista() {
        String mensaje = "";

        if (miLista.isEmpty()) {
            mensaje = "La lista de reproducción está vacía.";
        } else {
            for (int i = 0; i < miLista.size(); i++) {
                mensaje += i+1 + ". " + miLista.get(i).getNombre() + " \n";
            }
        }
        return mensaje;
    }



}
