package Clases;

public class ExisteAlumno extends Exception {
    private String descripcion;

    public ExisteAlumno(String descripcion) {
        setDescripcion(descripcion);
    }

    @Override
    public String getMessage() {
        return getDescripcion();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
