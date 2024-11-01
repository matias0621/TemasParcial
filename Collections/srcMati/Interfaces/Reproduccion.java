package Interfaces;

import Clases.Ejercicio3.Cancion;

public interface Reproduccion {
    public void reproducir();
    public void añadirCancion(Cancion cancionNueva);
    public void eliminarCancion();
    public void verMiLista();
}
