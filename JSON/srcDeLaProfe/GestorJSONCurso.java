import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GestorJSONCurso {
    private String nomJSON = "curso.json";
    private GestorJSONPersonas gestorJSONPersona;


    public GestorJSONCurso (){
        gestorJSONPersona = new GestorJSONPersonas();
    }


    public void cursoAarchivo(Curso curso){
        OperacionesLectoEscritura.grabar(nomJSON, serializar(curso));
    }


    public JSONObject serializar (Curso curso)
    {
        JSONObject jsonObject = null;
        try{
            jsonObject = new JSONObject();
            jsonObject.put("nombreCurso", curso.getNombreCurso());
            jsonObject.put("codigo", curso.getCodigo());

            /// serializacion del arreglo de alumnos:
            JSONArray jsonArray = new JSONArray();
            for (Persona alumno: curso.getAlumnosInscriptos()){
                /// serializamos cada alumno y agregamos su JSONObject al JSONArray
                jsonArray.put(gestorJSONPersona.serializar(alumno));
            }

            /// se agrega el JSONArray de los alumnos al JSONObject
            jsonObject.put("alumnosInscriptos", jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }


    public Curso archivoAcurso(){
        JSONTokener jsonTokener = OperacionesLectoEscritura.leer(nomJSON);
        Curso cursoLeido= null;

        try{
            cursoLeido = deserializar(new JSONObject(jsonTokener));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cursoLeido;
    }


    public Curso deserializar (JSONObject jsonObject) {
        Curso curso = new Curso();

        try{
            curso.setNombreCurso(jsonObject.getString("nombreCurso"));
            curso.setCodigo(jsonObject.getInt("codigo"));

            // se instancia un JSONArray para deserializar los alumnos inscriptos
            JSONArray jsonArray = jsonObject.getJSONArray("alumnosInscriptos");

            // cada alumno es un JSONObject dentro del JSONArray de alumnos
            // por eso deserializamos uno por uno en el bucle for y los agregamos al Arraylist del curso
            for (int i = 0; i < jsonArray.length(); i++) {
                Persona persona = gestorJSONPersona.deserializar(jsonArray.getJSONObject(i));
                // el método deserializar del gestor recibe un JSONObject, crea la persona y carga los datos
                curso.agregarAlumno(persona);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return curso;
    }

}