import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GestorJSONEmpleados {

    private String nomJSON = "empleados.json";

    public GestorJSONEmpleados(){}


    public void guardarEnJSON (Empleado empleado){
        try{
            OperacionesLectoEscritura.grabar(nomJSON, empleado.toJSON());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public Empleado leerJSON() throws FormatoIncorrectoException {

        JSONTokener jsonTokener = OperacionesLectoEscritura.leer(nomJSON);
        Empleado empleado= null;

        try{
            JSONObject jsonEmpleado = new JSONObject(jsonTokener);

            if (jsonEmpleado.has("id") && jsonEmpleado.has("nombre") && jsonEmpleado.has("salario") && jsonEmpleado.has("departamento")){
                // SI ESTAN BIEN LOS DATOS CREA EL EMPLEADO
                // uso el constructor de empleado que recibe por parametro un JSObject y crea el empleado
                empleado = new Empleado(jsonEmpleado);
            }
            else {
                throw new FormatoIncorrectoException();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return empleado;
    }
}
