import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class OperacionesLectoEscritura {

    /// es una clase con metodos ESTATICOS para leer y escribir en un archivo JSON

    public OperacionesLectoEscritura() {
    }

    public static void grabar(String nombreArchivo, JSONObject jsonObject) {
        try {
            FileWriter fileWriter = new FileWriter(nombreArchivo);
            fileWriter.write(jsonObject.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void grabar(String nombreArchivo, JSONArray jsonArray) {
        try {
            FileWriter fileWriter = new FileWriter(nombreArchivo);
            fileWriter.write(jsonArray.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // hago que retorne un tokener para que sea util para todos los casos,
    // si no tengo que retornar JSONObject o JSONArray
    public static JSONTokener leer(String nombreArchivo) {
        JSONTokener jsonTokener = null;

        try {
            jsonTokener = new JSONTokener(new FileReader(nombreArchivo));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return jsonTokener;
    }


}
