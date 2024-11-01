import Ejercicio4.Alumno;
import Ejercicio4.Colegio;
import Ejercicio4.AlumnoNoEncontradoException;
import Ejercicio4.SinAlumnosException;
import Ejercicio3.JuegoAdivinanza;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /* PUNTO 1)
        ¿Qué está mal en el siguiente bloque de código?

        try {
            Persona p = baseDeDatos.buscar(datos);
            System.out.println(“Los datos pertenecen a: ”+p);
        } catch (Exception e) {
        // Maneja cualquiera de las excepciones comprobadas
        } catch (RuntimeException e) {
        // Maneja cualquiera de las excepciones no comprobadas
        }

         RESPUESTA PUNTO 1) :
         El primer bloque catch captura excepciones del tipo Exception, que es
        la clase padre de todas las excepciones comprobadas y no comprobadas. Como es tan
        genérico, cualquier excepción que ocurra será atrapada por este bloque, y nunca se
        llegará al segundo catch que maneja las excepciones de tipo RuntimeException.

        Para corregir esto, el orden de los bloques catch debe invertirse. Primero se debe
        capturar la excepción más específica (RuntimeException), y luego la más general (Exception).
        Esto asegura que el código capture las excepciones de manera adecuada, desde las más
        particulares hasta las más generales.
        */

        /*PUNTO 2) Explique lo que sucede en el siguiente código y por qué.

        public static class EjemploExcepciones {
            public static int devuelveNumero(int num) {
                try {
                    if (num % 2 == 0) {
                        throw new Exception("Lanzando excepcion");
                    }
                    return 1;
                } catch (Exception ex) {
                    ex.getMessage().concat("Rompi tode y pase por Catch");
                    return 2;
                } finally {
                    return 3;
                }
            }
         }*/

        /* RESPUESTA Punto 2:
        El bloque finally siempre se ejecuta, sin importar lo que ocurra en los bloques
        try o catch. En este código, tanto en el try como en el catch, se intenta devolver un
        valor (1 o 2, respectivamente), pero el bloque finally tiene un return 3, y como el finally
        tiene prioridad sobre el try y el catch en cuanto a la ejecución de código, el valor de
        retorno final siempre será 3. Esto sucede porque el finally sobrescribe cualquier valor de
        retorno previo en el try o el catch. Por lo tanto, el método siempre devolverá 3.
         */

        /* PUNTO 3) Escribe un programa que juegue con el usuario a adivinar un número.
        El ordenador debe generar un número entre 1 y 500, y el usuario tiene que intentar adivinarlo.
        Para ello, cada vez que el usuario introduce un valor, el ordenador debe
        decirle al usuario si el número que tiene que adivinar es mayor o menor que el
        que ha introducido el usuario. Cuando consiga adivinarlo, debe indicarlo e
        imprimir en pantalla el número de veces que el usuario ha intentado adivinar el número  */

//        JuegoAdivinanza juego = new JuegoAdivinanza();
//        juego.iniciarJuego();

        /* PUNTO 4) Crea una clase colegio que almacene el listado de los alumnos
        (compuestos por su nombre y nacionalidad).La clase tendrá los siguientes métodos:
        - agregarAlumno(Alumno alumno):añade el alumno recibido por parámetro al listado.
        - verNacionalidad(String nacionalidad):Muestra la nacionalidad y el
            número de alumnos de esa nacionalidad
        - cuantos():Muestra cuántas nacionalidades diferentes existen en el colegio.
        - borrar(Alumno alumno):Elimina a un alumno específico del listado.
        - verTodos():Muestra las distintas nacionalidades y el número de
            alumnos que existen por nacionalidad.
                Para todos estos métodos se deben generar distintas validaciones para
        prevenir errores en la ejecución.Por ej:Que todos los alumnos tengan una
        nacionalidad, que exista el alumno que se quiere borrar, etc.  */

        Colegio colegio = new Colegio("Colegio para los que les gusta programar");

        Alumno alumno1 = new Alumno("Anacleto", "Argentina");
        Alumno alumno2 = new Alumno("Anastasia", "Uruguay");
        Alumno alumno3 = new Alumno("Aniceto", "Argentina");
        Alumno alumno4 = new Alumno("Adalberta", "Peru");
        Alumno alumno5 = new Alumno("Adalberta", "Paraguay");
        Alumno alumno6 = new Alumno("No soy alumno del cole", "mi pais no existe");

        /// PROBAMOS METODOS QUE INVOCAN SINALUMNOSEXCEPTION
        try{
            System.out.println("COLEGIO ANTES DE CARGAR ALUMNOS: " + colegio.verColegio());
            // PARA PROBAR SinAlumnosException:
            System.out.println("Cantidad de nacionalidades presentes en el Colegio ANTES DE CARGAR ALUMNOS: " + colegio.cuantasNacionalidades());
        }
        catch (SinAlumnosException e){
            System.out.println(e.getMessage());
            Scanner sc= new Scanner(System.in);
            sc.nextLine();
            e.printStackTrace();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            Scanner sc= new Scanner(System.in);
            sc.nextLine();
            e.printStackTrace();
        }

        /// PROBAMOS METODOS QUE INVOCAN SINALUMNOSEXCEPTION Y IllegalArgumentException
        try{
            colegio.agregarAlumno(alumno1);
            colegio.agregarAlumno(alumno2);
            colegio.agregarAlumno(alumno3);
            colegio.agregarAlumno(alumno4);
            colegio.agregarAlumno(alumno5);

            System.out.println(colegio.verColegio());

            System.out.println("Cantidad de nacionalidades presentes en el Colegio: " + colegio.cuantasNacionalidades());

            System.out.println("Nacionalidades presentes en el Colegio: " + colegio.retornarNacionalidadesPresentes());

            // PARA PROBAR IllegalArgumentException:
            //System.out.println("Cantidad de alumnos de nacionalidad vacia: " + colegio.contarAlumnosNacionalidadElegida(""));

            System.out.println("Cantidad de alumnos de nacionalidad Argentina: " + colegio.contarAlumnosNacionalidadElegida("Argentina"));

            System.out.println("Nacionalidades y cantidad de alumnos: " + colegio.verTodos());
        }
        catch (SinAlumnosException e){
            System.out.println(e.getMessage());
            Scanner sc= new Scanner(System.in);
            sc.nextLine();
            e.printStackTrace();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            Scanner sc= new Scanner(System.in);
            sc.nextLine();
            e.printStackTrace();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            Scanner sc= new Scanner(System.in);
            sc.nextLine();
            e.printStackTrace();
        }

        /// PROBAMOS METODOS QUE INVOCAN AlumnoNoEncontradoException
        try{
            // PARA PROBAR AlumnoNoEncontradoException:
            System.out.println("Borrar un alumno inexistente: " + colegio.borrar(alumno6));

            // PARA PROBAR IllegalArgumentException:
            System.out.println("Borrar un alumno null: " + colegio.borrar(null));

            System.out.println("Borrar al alumno 1 que sí existe: " + colegio.borrar(alumno1));
            System.out.println("Colegio luego de borrar alumno 1: " + colegio.verColegio());
        }
        catch (SinAlumnosException e){
            System.out.println(e.getMessage());
            Scanner sc= new Scanner(System.in);
            sc.nextLine();
            e.printStackTrace();
        }
        catch (AlumnoNoEncontradoException e){
            System.out.println(e.getMessage());
            Scanner sc= new Scanner(System.in);
            sc.nextLine();
            e.printStackTrace();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            Scanner sc= new Scanner(System.in);
            sc.nextLine();
            e.printStackTrace();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            Scanner sc= new Scanner(System.in);
            sc.nextLine();
            e.printStackTrace();
        }


    }
}