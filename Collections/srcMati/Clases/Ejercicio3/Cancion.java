package Clases.Ejercicio3;

import Enums.Genero;

public class Cancion {
    private String nombre;
    private double duracion;
    private Genero genero;
    private Album album;
    private Artista artistaInvitado;

    public Cancion(String nombre, double duracion, Genero genero, Album album, Artista artistaInvitado) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.genero = genero;
        this.album = album;
        this.artistaInvitado = artistaInvitado;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDuracion() {
        return duracion;
    }

    public Genero getGenero() {
        return genero;
    }

    public Album getAlbum() {
        return album;
    }

    public Artista getArtistaInvitado() {
        return artistaInvitado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setArtistaInvitado(Artista artistaInvitado) {
        this.artistaInvitado = artistaInvitado;
    }

    @Override
    public String toString() {
        String infoInvitado = (artistaInvitado != null) ? " (con " + artistaInvitado + ")" : "";
        return nombre + " - " + album.getTitulo() + " [" + genero + "]" + infoInvitado;
    }
}
