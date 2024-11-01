import java.util.ArrayList;

public class Curso {
    private String nombreCurso;
    private int codigo;
    private ArrayList<Persona> alumnosInscriptos;

    public Curso()
    {
        this.alumnosInscriptos = new ArrayList<Persona>();
    }

    public Curso(String nombreCurso, int codigo) {
        this.alumnosInscriptos = new ArrayList<Persona>();
        this.nombreCurso = nombreCurso;
        this.codigo = codigo;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Persona> getAlumnosInscriptos() {
        return alumnosInscriptos;
    }

    public void setAlumnosInscriptos(ArrayList<Persona> alumnosInscriptos) {
        this.alumnosInscriptos = alumnosInscriptos;
    }

    public boolean agregarAlumno(Persona alumno)
    {
        return alumnosInscriptos.add(alumno);
    }

    public boolean eliminarAlumno (Persona alumno)
    {
        return alumnosInscriptos.remove(alumno);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombreCurso='" + nombreCurso + '\'' +
                ", codigo=" + codigo +
                ", \n alumnosInscriptos=" + alumnosInscriptos +
                '}';
    }
}
