package Clases.Ejercicio3;

import Clases.Ejercicio1.Persona;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombreBiblioteca;
    private ArrayList<Libro> listaLibros;

    public Biblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
        this.listaLibros = new ArrayList<>();
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void addLibro(Libro libro) {
        this.listaLibros.add(libro);
    }

    public void deleteLibro(Libro libro) {
        this.listaLibros.remove(libro);
    }

    public void deleteLibro(int index) {
        this.listaLibros.remove(index);
    }

    public JSONArray crearArrayJson(){
        JSONArray jsonArray = new JSONArray();
        for (Libro libro : listaLibros) {
            jsonArray.put(libro.LibroToJSObject());
        }

        return jsonArray;
    }

    public void guardarBibliotecaToFile(String fileName) {
        JSONArray jsonArray = crearArrayJson();

        try (FileWriter fileWriter = new FileWriter(fileName)){
            fileWriter.write(jsonArray.toString(2));
            System.out.println("Tareas guardadas en el archivo " + fileName);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static JSONTokener leerArchivo(String fileName) {
        JSONTokener jsonTokener = null;

        try {
            jsonTokener = new JSONTokener(new FileReader(fileName));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return jsonTokener;
    }

    public void LibroJSONArrayToList(JSONArray jsonArray) {
        listaLibros.clear();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject libroJson = jsonArray.getJSONObject(i);
            Libro libro = Libro.JSObjectToLibro(libroJson);
            listaLibros.add(libro);
        }
    }

    public void loadLibrosFromFile(String fileName) {
        try {
            JSONArray libroArray = new JSONArray(leerArchivo(fileName));
            LibroJSONArrayToList(libroArray);
            System.out.println("Tareas cargadas en el archivo " + fileName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
