import org.json.JSONException;
import org.json.JSONTokener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

            GestorJSONPersonas gestorJSONPersona = new GestorJSONPersonas();
            GestorJSONCurso gestorJSONCurso = new GestorJSONCurso();
            GestorJSONBiblioteca gestorJSONBiblioteca = new GestorJSONBiblioteca();
            GestorJSONEmpleados gestorJSONEmpleado = new GestorJSONEmpleados();


            /// EJERCICIO 1 - Crea una clase Persona con los siguientes atributos:
            // nombre, edad, dni, y sexo. Implementa un constructor, getters y setters.
            // Implementa un método que convierta un objeto Persona a una representación JSON
            // y luego guarda la representación JSON en un archivo llamado persona.json.
            // Elige y utiliza una biblioteca de tu elección para la
            //serialización de objetos a JSON y la escritura en archivos
            // Objetivos: Convertir un objeto Java a JSON y Escribir datos JSON en un archivo.

            Persona persona = new Persona("Pepe", 15, "43223223", "masculino");
            gestorJSONPersona.personaAarchivo(persona);
            // gestorPersona.serializar() convierte el objeto a JSONObject
            // y el metodo estatico grabar() guarda el JSONObject en un archivo con extension .json



            /// EJERCICIO 2 - Lee el archivo persona.json que creaste en el ejerc anterior
            // y convierte el JSON leído de nuevo a un objeto Persona.
            // Objetivos: Leer datos JSON desde un archivo y Convertir JSON a un objeto Java.

            Persona personaLeida= gestorJSONPersona.archivoAPersona();
            // gestorPersona.deserializar() recibe el JSONTokener generado al leer el archivo JSON,
            // para poder convertir el JSONObject a un objeto Java
            System.out.println("Persona leida del JSON: " + personaLeida.toString());



            /// EJERCICIO 3: Crea una clase Curso con atributos como nombreCurso, código,
            // y una lista de Personas inscritas en el curso.
            // Implementa métodos para agregar y eliminar personas del curso.
            //Luego crea un método que convierta un objeto Curso a JSON y guárdalo en un archivo curso.json.
            //Implementa otro método que lea el archivo curso.json y convierta el JSON a un objeto Curso.
            //Objetivos: - Guardar en JSON una lista de objetos y luego poder leerla del JSON

            // carga del curso:
            Curso curso = new Curso("Programacion 2", 112323);
            curso.agregarAlumno(new Persona("Maria", 12, "47848983", "femenino"));
            curso.agregarAlumno(new Persona("Marcos", 14, "46343243", "masculino"));
            curso.agregarAlumno(new Persona("Julia", 17, "45434343", "femenino"));

            /// escritura
            gestorJSONCurso.cursoAarchivo(curso);

            /// lectura
            Curso cursoArchivo = gestorJSONCurso.archivoAcurso();
            System.out.println("Curso leído del JSON: " + cursoArchivo.toString());



            /// EJERCICIO 4: Crea una clase Biblioteca con atributos como nombreBiblioteca
            // y una lista de libros e implementa métodos para agregar y eliminar libros.
            // Guarda el estado actual de la biblioteca en un archivo biblioteca.json.
            // Lee el archivo biblioteca.json, realiza cambios en la lista de libros (añade o
            // elimina algunos) y guarda los cambios de nuevo en el archivo.
            // Objetivos: - Manipular datos en JSON para actualizar información existente.
            // y - Leer y escribir JSON con modificaciones.

            // carga inicial de datos
            Biblioteca biblioteca = new Biblioteca("Ateneo");
            biblioteca.agregarLibro(new Libro("El hombre que fue Jueves", "GK Chesterton", "Policial", "233-345-32332-2-1"));
            biblioteca.agregarLibro(new Libro("Rebelion en la granja", "George Orwell", "Satira", "212-341-36677-1-4"));
            biblioteca.agregarLibro(new Libro("Un mundo feliz", "Huxley", "Ciencia Ficción", "132-151-38671-3-1"));

            // guardar estado actual
            gestorJSONBiblioteca.bibliotecaAarchivo(biblioteca);
            Biblioteca bibliotecaArchivo = gestorJSONBiblioteca.archivoAbiblioteca();
            System.out.println("Biblioteca leída del JSON: \n " + bibliotecaArchivo.toString());


            // agregar un libro (El Principito)
            gestorJSONBiblioteca.agregarLibroAarchivo(new Libro("El principito", "Saint-Exupery", "Fantasia", "233-442-64545-3-6"));

            // borrar un libro (Un Mundo feliz)
            gestorJSONBiblioteca.borrarLibroDeArchivo("132-151-38671-3-1");

            // vuelvo a leer el archivo, deserializar y mostrar la biblioteca
            bibliotecaArchivo = gestorJSONBiblioteca.archivoAbiblioteca();
            System.out.println("Biblioteca leída del JSON eliminando Un Mundo Feliz y agregando El Principito: \n " + bibliotecaArchivo.toString());



            /// EJERCICIO 5: Crea una clase Empleado con los atributos id, nombre, salario, y departamento.
            // Implementa métodos para convertir un objeto Empleado a JSON y viceversa.
            // Agrega validaciones para asegurarte de que el JSON que se lee
            // tiene el formato correcto y contiene todos los campos necesarios.
            // Maneja los posibles errores que puedan ocurrir durante la lectura y escritura
            // de archivos JSON, como archivos no encontrados o datos mal formateados.
            // Objetivos: - Implementar validación de datos JSON.
            // y - Manejar errores y excepciones durante el procesamiento de archivos JSON.
        try{
            // creo y guardo uno bien
            Empleado empleado = new Empleado(1, "Carlos Alvarado", 1200000, "Sistemas");
            gestorJSONEmpleado.guardarEnJSON(empleado);
            Empleado empleadoLeido = gestorJSONEmpleado.leerJSON();
            System.out.println(empleadoLeido.toString());

            System.out.println("\n\nCreo y guardo uno incompleto para que arroje la excepcion\n");
            Empleado empleado2 = new Empleado();
            gestorJSONEmpleado.guardarEnJSON(empleado2);
            Empleado empleadoLeido2 = gestorJSONEmpleado.leerJSON();
            System.out.println(empleadoLeido2.toString());

        } catch (FormatoIncorrectoException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }


    }
}