import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;

public class GestorJSONPersonas{
    private String nomJSON = "persona.json";

    public GestorJSONPersonas(){}

    public void personaAarchivo(Persona p){
        OperacionesLectoEscritura.grabar(nomJSON, serializar(p));
    }

    public JSONObject serializar(Persona p) {
        JSONObject jsonObject = null;
        try{
            jsonObject = new JSONObject();
            jsonObject.put("nombre", p.getNombre());
            jsonObject.put("edad", p.getEdad());
            jsonObject.put("sexo", p.getSexo());
            jsonObject.put("dni", p.getDni());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }


    public Persona archivoAPersona(){
        JSONTokener jsonTokener = OperacionesLectoEscritura.leer(nomJSON);
        Persona personaLeida= null;

        try{
            personaLeida = deserializar(new JSONObject(jsonTokener));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return personaLeida;
    }


    public Persona deserializar(JSONObject jsonObject){
        Persona persona = new Persona();
        try{
            persona.setNombre(jsonObject.getString("nombre"));
            persona.setDni(jsonObject.getString("dni"));
            persona.setEdad(jsonObject.getInt("edad"));
            persona.setSexo(jsonObject.getString("sexo"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return persona;
    }

}
