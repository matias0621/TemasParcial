import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Libro {
    private String nombre;
    private String genero;
    private String autor;
    private String ISBN;

    public Libro() {
    }

    public Libro(JSONObject jsonLibro){
        try{
            nombre = jsonLibro.getString("nombre");
            autor = jsonLibro.getString("autor");
            genero = jsonLibro.getString("genero");
            ISBN = jsonLibro.getString("ISBN");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Libro(String nombre, String autor, String genero, String ISBN) {
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.ISBN = ISBN;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public JSONObject toJSON (){
        JSONObject jsonObject = null;

        try{
            jsonObject = new JSONObject();

            jsonObject.put("nombre", nombre);
            jsonObject.put("genero", genero);
            jsonObject.put("autor", autor);
            jsonObject.put("ISBN", ISBN);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    @Override
    public String toString() {
        return "Libro {" +
                "nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", autor='" + autor + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(ISBN, libro.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN);
    }
}
