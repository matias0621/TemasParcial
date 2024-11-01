package Ejercicio4;


public class AlumnoNoEncontradoException extends Exception{
    public AlumnoNoEncontradoException() {
        super("No se pudo encontrar el alumno");
    }
}

