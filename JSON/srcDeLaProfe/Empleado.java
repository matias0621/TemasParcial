import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Empleado {
    private int id;
    private String nombre;
    private int salario;
    private String departamento;

    public Empleado(){}

    public Empleado(JSONObject jsonEmpleado) {
        try{
            id = jsonEmpleado.getInt("id");
            nombre = jsonEmpleado.getString("nombre");
            salario = jsonEmpleado.getInt("salario");
            departamento = jsonEmpleado.getString("departamento");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Empleado(int id, String nombre, int salario, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public JSONObject toJSON(){
        JSONObject jsonObject = null;
        try{
            jsonObject = new JSONObject();

            jsonObject.put("id", id);
            jsonObject.put("nombre", nombre);
            jsonObject.put("salario", salario);
            jsonObject.put("departamento", departamento);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", salario=" + salario +
                ", departamento='" + departamento + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return id == empleado.id && salario == empleado.salario && Objects.equals(nombre, empleado.nombre) && Objects.equals(departamento, empleado.departamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, salario, departamento);
    }
}