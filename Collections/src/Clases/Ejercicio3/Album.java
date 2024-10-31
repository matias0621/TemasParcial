package Clases.Ejercicio3;

public class Album {
    private String titulo;
    private String fecha;
    private Artista artista;

    public Album(String titulo, String fecha, Artista artista) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.artista = artista;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }


}
