import java.util.ArrayList;

public class Biblioteca {
    private String nombreBiblioteca;
    private ArrayList<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public Biblioteca(String nombreBibliote) {
        this.nombreBiblioteca = nombreBibliote;
        this.libros = new ArrayList<>();
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBibliote) {
        this.nombreBiblioteca = nombreBibliote;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public boolean agregarLibro(Libro libro)
    {
        return libros.add(libro);
    }

    public boolean borrarLibro(Libro libro)
    {
        return libros.remove(libro);
    }

    public void borrarLibroPorIsbn(String isbn) {
        Libro libro = new Libro();
        libro.setISBN(isbn);
        libros.remove(libro);
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombreBibliote='" + nombreBiblioteca + '\'' +
                ", libros=" + libros +
                '}';
    }
}
