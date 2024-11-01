package Clases.Ejercicio3;

import Clases.Ejercicio1.Persona;
import org.json.JSONObject;

public class Libro {
    private String titulo;
    private String autor;
    private int anio;

    public Libro(String titulo, String autor, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public JSONObject LibroToJSObject() {
        JSONObject json = new JSONObject();
        json.put("Titulo: ", getTitulo());
        json.put("Autor", getAutor());
        json.put("Año", getAnio());
        return json;
    }

    public static Libro JSObjectToLibro(JSONObject json) {
        String titulo = json.getString("Titulo");
        String autor = json.getString("Autor");
        int anio = json.getInt("Anio");
        return new Libro(titulo, autor, anio);
    }
}
