package Ejercicio4;

public class SinAlumnosException extends Exception{
    public SinAlumnosException() {
        super("No hay alumnos cargados en el colegio.");
    }
}
