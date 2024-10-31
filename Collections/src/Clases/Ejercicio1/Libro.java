package Clases.Ejercicio1;

import java.util.Objects;

public class Libro implements Comparable<Libro> {
    private String titulo;
    private String autor;
    private double precio;
    private String anio;

    public Libro(String titulo, String autor, double precio, String anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Libro libro)) return false;
        return Objects.equals(titulo, libro.titulo);
    }

    @Override
    public String toString() {
        return ("Titulo: " + getTitulo() + "\nAutor: " + getAutor() + "\nPrecio: " + getPrecio() + "\nAnio: " + getAnio());
    }

    @Override
    public int compareTo(Libro libro) {
        return Double.compare(getPrecio(), libro.getPrecio());
    }
}
