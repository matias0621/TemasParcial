package Ejercicio4;

import java.util.Objects;

public class Alumno {

    private String nombre;
    private String nacionalidad;

    public Alumno(String nombre, String nacionalidad) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (nacionalidad == null || nacionalidad.isEmpty()) {
            throw new IllegalArgumentException("La nacionalidad no puede estar vacía.");
        }
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Alumno alumno = (Alumno) obj;
        return nombre.equals(alumno.nombre) && nacionalidad.equals(alumno.nacionalidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nacionalidad);
    }

    @Override
    public String toString() {
        return nombre + " (" + nacionalidad + ")";
    }
}
