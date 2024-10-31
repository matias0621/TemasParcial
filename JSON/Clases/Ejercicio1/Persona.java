package Clases.Ejercicio1;

import netscape.javascript.JSObject;
import org.json.JSONObject;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private String sexo;

    public JSONObject PersonaToJSObject() {
        JSONObject json = new JSONObject();
        json.put("nombre", getNombre());
        json.put("edad", getEdad());
        json.put("dni", getDni());
        json.put("sexo", getSexo());
        return json;
    }

    public static Persona JSObjectToPersona(JSONObject json) {
        String nombre = json.getString("nombre");
        int edad = json.getInt("edad");
        String dni = json.getString("dni");
        String sexo = json.getString("sexo");

        return new Persona(nombre, edad, dni, sexo);
    }

    public Persona(String nombre, int edad, String dni, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
