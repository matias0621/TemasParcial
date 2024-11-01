package Clases;

import java.util.ArrayList;
import java.util.HashMap;

public class Colegio {
    ArrayList<Alumno> alumnos = new ArrayList<>();

    public void agregarAlumno(Alumno a){
        alumnos.add(a);
    }

    public int verNacionalidad(String nacionalidad) throws ExisteAlumno{
        if (alumnos.size() == 0){
            throw new ExisteAlumno("No existe alumno");
        }
        int cantidadDeAlumnos = 0;
        for (int i = 0; i < alumnos.size(); i++){
            Alumno al = alumnos.get(i);
            if (al.getNacionalidad() == nacionalidad){
                cantidadDeAlumnos++;
                System.out.println(al.toString());
            }
        }
        return cantidadDeAlumnos;
    }

    public int cantidadDeNacionalidadesDiferentes(){
        HashMap<String, ArrayList<Alumno>> alumnosDiferentes = new HashMap<>();
        for (int i = 0; i < alumnos.size(); i++){
            Alumno a = alumnos.get(i);
            if (!alumnosDiferentes.containsKey(a.getNacionalidad())){
                ArrayList<Alumno> alumnosDiferente = new ArrayList<>();
                alumnosDiferente.add(a);
                alumnosDiferentes.put(a.getNacionalidad(), alumnosDiferente);
            }
            else if (alumnosDiferentes.containsKey(a.getNacionalidad())){
                alumnosDiferentes.get(a.getNacionalidad()).add(a);
            }
        }
        return alumnos.size();
    }

    public void borrarAlumno(int index) throws ExisteAlumno{
        if (index > alumnos.size() || index < 0){
            throw new ExisteAlumno("Ese alumno no existe, ingrese un numero valido");
        }
        else if (alumnos.size() == 0){
            throw new ExisteAlumno("No existe el alumno");
        }
        else {
            alumnos.remove(index);
        }
    }

    public void verTodos(){
        for (int i = 0; i < alumnos.size(); i++){
            System.out.println(alumnos.get(i).toString());
        }
    }
}
