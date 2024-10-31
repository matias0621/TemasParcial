package Clases.Ejercicio2;

import Clases.Ejercicio1.Persona;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Curso {
    private String nombreCurso;
    private String codigo;
    private ArrayList<Persona> personas;

    public Curso(String nombreCurso, String codigo) {
        this.nombreCurso = nombreCurso;
        this.codigo = codigo;
        this.personas = new ArrayList<>();
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Persona persona, int index) {
        this.personas.add(index, persona);
    }

    public void addPersona(Persona persona) {
        this.personas.add(persona);
    }

    public JSONArray crearArrayJson(){
        JSONArray jsonArray = new JSONArray();
        for (Persona persona : personas) {
            jsonArray.put(persona.PersonaToJSObject());
        }

        return jsonArray;
    }

    public void guardarPersonasToFile(String fileName) {
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

    public void PersonaJSONArrayToList(JSONArray jsonArray) {
        personas.clear();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject personaJson = jsonArray.getJSONObject(i);
            Persona perso = Persona.JSObjectToPersona(personaJson);
            personas.add(perso);
        }
    }

    public void loadPersonasFromFile(String fileName) {
        try {
            JSONArray personaArray = new JSONArray(leerArchivo(fileName));
            PersonaJSONArrayToList(personaArray);
            System.out.println("Tareas cargadas en el archivo " + fileName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
