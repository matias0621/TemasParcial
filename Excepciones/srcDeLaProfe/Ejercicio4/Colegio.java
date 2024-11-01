package Ejercicio4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class Colegio {

    private String nombre;
    private List<Alumno> alumnos;

    public Colegio(String nombre) {
        this.nombre= nombre;
        this.alumnos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para agregar un alumno
    public String agregarAlumno(Alumno alumno) {
        if (alumno == null) {
            throw new IllegalArgumentException("El alumno no puede ser nulo.");
        }
        alumnos.add(alumno);
        return "Agregado el alumno: " + alumno;
    }

    // Método para ver cuántos alumnos hay de una nacionalidad elegida por el usuario
    public int contarAlumnosNacionalidadElegida(String nacionalidad) throws SinAlumnosException{
        if (alumnos.isEmpty())        {
            throw new SinAlumnosException();
        }
        if (nacionalidad == null || nacionalidad.isEmpty()) {
            throw new IllegalArgumentException("La nacionalidad no puede ser nula ni estar vacía."); // esta es runtime, no necesita estar en el throws
        }

        int contador = 0;
        for (Alumno alumno : alumnos) {
            if (alumno.getNacionalidad().equalsIgnoreCase(nacionalidad)) {
                contador++;
            }
        }
        return contador;
    }


    // Método para contar cuántas nacionalidades diferentes existen en el colegio
    public int cuantasNacionalidades() throws SinAlumnosException {
        if (alumnos.isEmpty()) {
            throw new SinAlumnosException();
        }

        Set<String> nacionalidades = new HashSet<>();
        for (Alumno alumno : alumnos) {
            nacionalidades.add(alumno.getNacionalidad()); //si estan repetidas no las agregara
        }

        return nacionalidades.size();
    }


    // Método para borrar un alumno específico
    public String borrar(Alumno alumno) throws SinAlumnosException, AlumnoNoEncontradoException {
        String mensaje = "";
        if (alumnos.isEmpty()) {
            throw new SinAlumnosException();
        }
        if (alumno == null) {
            throw new IllegalArgumentException("El alumno no puede ser nulo.");
        }
        if(!(alumnos.contains(alumno))){
            throw new AlumnoNoEncontradoException();
        }

        alumnos.remove(alumno); // si llegó hasta aca es porque el alumno sí está en el colegio
        mensaje = "Eliminado alumno " + alumno;

        return mensaje;
    }


    // Método para ver todas las nacionalidades presentes
    public Set<String> retornarNacionalidadesPresentes() throws SinAlumnosException{
        if (alumnos.isEmpty()) {
            throw new SinAlumnosException();
        }

        Set<String> nacionalidades = new HashSet<>();

        for (Alumno alumno : alumnos) {
            nacionalidades.add(alumno.getNacionalidad()); //si estan repetidas no las agregara
        }

        return nacionalidades;
    }


    public String verColegio() {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Colegio: ").append(nombre).append("\n").append("Alumnos: ").append("\n");

        for(Alumno aux : alumnos){
            mensaje.append(aux.toString()).append(" - ");
        }

        return mensaje.toString();
    }

    // muestra todas las nacionalidades y el Nro de alumnos por nacionalidad
    public String verTodos() throws SinAlumnosException {
        if (alumnos.isEmpty()){
            throw new SinAlumnosException();
        }

        Set<String> nacionalidades = retornarNacionalidadesPresentes();

        StringBuilder mensaje = new StringBuilder();

        for(String nacionalidad : nacionalidades){
            mensaje.append(nacionalidad).append(" tiene ").append(contarAlumnosNacionalidadElegida(nacionalidad)).append(" estudiantes. \n");
        }
        return mensaje.toString();
    }
}


