import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GestorJSONBiblioteca {

    private String nomJSON = "biblioteca.json";

    public GestorJSONBiblioteca(){}

    public void bibliotecaAarchivo(Biblioteca biblioteca){
        OperacionesLectoEscritura.grabar(nomJSON, serializar(biblioteca));
    }


    public JSONObject serializar(Biblioteca biblioteca)
    {
        JSONObject jsonObject = null;
        try{
            jsonObject = new JSONObject();
            jsonObject.put("nombreBiblioteca", biblioteca.getNombreBiblioteca());

            // serializo la lista de libros:
            JSONArray jsonArray = new JSONArray();
            for (Libro libro: biblioteca.getLibros()) {
                JSONObject jsonLibro = libro.toJSON();
                jsonArray.put(jsonLibro);
            }

            // agrego el JSONArray de libros al objeto JSON biblioteca
            jsonObject.put("libros", jsonArray);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }


    public Biblioteca archivoAbiblioteca(){
        JSONTokener jsonTokener = OperacionesLectoEscritura.leer(nomJSON);
        Biblioteca bibliotecaLeida = null;

        try{
            bibliotecaLeida = deserializar(new JSONObject(jsonTokener));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return bibliotecaLeida;
    }


    public Biblioteca deserializar (JSONObject jsonObject) {
        Biblioteca biblioteca = new Biblioteca();

        try{
            biblioteca.setNombreBiblioteca(jsonObject.getString("nombreBiblioteca"));

            // deserializo la lista de libros del JSON
            JSONArray jsonArray = jsonObject.getJSONArray("libros");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonLibro = jsonArray.getJSONObject(i);
                /// usamos el constructor de libro que recibe un JSON y crea el libro
                Libro libro = new Libro(jsonLibro);
                // agrego el libro ya deserializado a la lista de la biblioteca deserializada
                biblioteca.agregarLibro(libro);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return biblioteca;
    }


    public void agregarLibroAarchivo(Libro libro) {
        JSONTokener jsonTokener = OperacionesLectoEscritura.leer(nomJSON);

        try{
            JSONObject jsonBiblioteca = new JSONObject(jsonTokener);

            /// leemos el JSONArray de libros dentro del JSONObject de biblioteca
            JSONArray jsonArray = jsonBiblioteca.getJSONArray("libros");

            /// transformamos el libro que queremos agregar a un JSONObject, para poder agregarlo al JSONArray
            JSONObject jsonLibro = libro.toJSON();

            /// agregamos el JSONObject de libro al JSONArray
            jsonArray.put(jsonLibro);

            /// guardamos el JSON de nuevo
            OperacionesLectoEscritura.grabar(nomJSON, jsonBiblioteca);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void borrarLibroDeArchivo (String ISBN)
    {
        JSONTokener jsonTokener = OperacionesLectoEscritura.leer(nomJSON);

        try {
            JSONObject jsonBiblioteca = new JSONObject(jsonTokener);

            /// leemos el JSONArray de libros dentro del JSONObject de biblioteca
            JSONArray jsonArray = jsonBiblioteca.getJSONArray("libros");

            /// buscamos la posicion del JSONObject del libro y lo borramos
            // usando un método que tiene JSONArray para eliminar: JSONArray.remove(i)
            // si no tendríamos que deserializar el array JSon completo para luego eliminar y
            // volver a serializar
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonLibro = jsonArray.getJSONObject(i);
                if (jsonLibro.getString("ISBN").equals(ISBN)){
                    jsonArray.remove(i);
                    break;
                }
            }

            /// guardamos el JSON de nuevo
            OperacionesLectoEscritura.grabar(nomJSON, jsonBiblioteca);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
