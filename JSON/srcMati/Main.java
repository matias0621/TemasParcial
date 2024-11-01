import Clases.Ejercicio1.Persona;
import Clases.Ejercicio2.Curso;
import Clases.Ejercicio3.Biblioteca;
import Clases.Ejercicio3.Libro;
import org.json.JSONObject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Elija un ejercicio 1-6");
        int ejercicio = sc.nextInt();

        switch (ejercicio) {
            case 1:
                String file = "src/Resource/persona.json";

                try {
                    String content = new String(Files.readAllBytes(Paths.get(file)));
                    JSONObject json = new JSONObject(content);

                    Persona persona = Persona.JSObjectToPersona(json);

                    System.out.println("Nombre: " + persona.getNombre());
                    System.out.println("Edad: " + persona.getEdad());
                    System.out.println("DNI: " + persona.getDni());
                    System.out.println("Sexo: " + persona.getSexo());

                }catch (Exception e) {
                    System.out.println("Error al leer o procesar el archivo JSON: " + e.getMessage());
                }
                break;
            case 2:
                // Crear un curso y agregar personas
                Curso curso = new Curso("Programación Java", "JAVA101");

                Persona persona1 = new Persona("Juan", 25, "12345678", "M");
                Persona persona2 = new Persona("Ana", 22, "87654321", "F");

                curso.addPersona(persona1);
                curso.addPersona(persona2);

                // Guardar el curso en un archivo JSON
                String fileName = "curso.json";
                curso.guardarPersonasToFile(fileName);

                // Crear otro objeto Curso y cargar los datos desde el archivo JSON
                Curso cursoCargado = new Curso("Temporal", "TEMP");
                cursoCargado.loadPersonasFromFile(fileName);

                // Verificar los datos cargados
                System.out.println("Curso: " + cursoCargado.getNombreCurso());
                System.out.println("Código: " + cursoCargado.getCodigo());
                System.out.println("Personas inscritas:");
                for (Persona p : cursoCargado.getPersonas()) {
                    System.out.println("- " + p.getNombre() + ", " + p.getEdad() + " años, DNI: " + p.getDni());
                }
                break;
            case 3:
                String fileRoute = "src/Resource/biblioteca.json";
                // Crear instancia de Biblioteca
                Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

                // Cargar los libros existentes desde el archivo JSON
                biblioteca.loadLibrosFromFile(fileRoute);

                // Añadir un nuevo libro a la biblioteca
                Libro nuevoLibro = new Libro("Nuevo Título", "Nuevo Autor", 2024);
                biblioteca.addLibro(nuevoLibro);    

                // Guardar los cambios en el archivo JSON
                biblioteca.guardarBibliotecaToFile(fileRoute);
                break;
        }
    }
}