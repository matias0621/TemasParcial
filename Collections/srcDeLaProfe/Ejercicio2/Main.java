package Ejercicio2;

import java.util.*;

/*  2.	Haz una clase llamada Persona que siga las siguientes condiciones:
  -	Sus atributos son: nombre, edad, DNI, sexo (H hombre, M mujer), peso y altura.
  No queremos que se accedan directamente a ellos. Piensa que modificador de acceso es el más adecuado,
  también su tipo. Si quieres añadir algún atributo puedes hacerlo.
  -	Por defecto, todos los atributos menos el DNI serán valores por defecto según su tipo (0 números, cadena vacía para String, etc.).
  - Sexo será hombre por defecto, usa una constante para ello.
  -	Se implementarán varios constructores:
        ■ Un constructor por defecto.
        ■ Un constructor con el nombre, edad y sexo, el resto por defecto.
        ■ Un constructor con todos los atributos como parámetro.
        -	Los métodos que se implementarán son:
➢	calcularIMC(): calculará si la persona está en su peso ideal (peso en kg/(altura^2 en m)),
        - Si la fórmula devuelve un valor menor que 20, significa que está por debajo de su peso ideal, y la función devuelve un -1,
        - si devuelve un número entre 20 y 25 (incluidos), significa que está en su peso ideal, y la función devuelve un 0
        - y si devuelve un valor mayor que 25 significa que tiene sobrepeso, la función devuelve un 1.
        Te recomiendo que uses constantes para devolver estos valores.
➢	esMayorDeEdad(): indica si es mayor de edad, devuelve un booleano.
➢	comprobarSexo(char sexo): comprueba que el sexo introducido es correcto. Si no es correcto, será H. No será visible al exterior.
➢	toString(): devuelve toda la información del objeto.
➢	generaDNI(): genera un número aleatorio de 8 cifras, genera a partir de este su número
su letra correspondiente. Este método será invocado cuando se construya el objeto.
Puedes dividir el método para que te sea más fácil. No será visible al exterior.
➢ Métodos set de cada parámetro, excepto de DNI.
        Ahora, crea una clase ejecutable que haga lo siguiente:
        -	Pide por teclado el nombre, la edad, sexo, peso y altura.
        -	Crea 3 objetos de la clase anterior, el primer objeto obtendrá las anteriores variables pedidas por teclado,
        el segundo objeto obtendrá todos los anteriores menos el peso y la altura
        y el último por defecto, para este último utiliza los métodos set para darle a los atributos un valor.
        -	Crea una Collection donde se guardarán los objetos anteriormente creados.
        Dichos objetos deben estar asociados a su DNI. Pensar que Collection es la más adecuada. (Map)
        -	Para cada objeto, se deberá comprobar si está en su peso ideal, tiene sobrepeso o está por debajo
        de su peso ideal con un mensaje.
*/

public class Main {
    public static void main(String[] args) {

        Map<Integer, Persona> personas = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        // Pedir los datos
        System.out.println("Ingrese el nombre de la persona: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la edad de la persona: ");
        int edad = scanner.nextInt();

        System.out.println("Ingrese el sexo de la persona: ");
        char sexo = scanner.next().charAt(0);

        System.out.println("Ingrese el peso de la persona: ");
        double peso = scanner.nextDouble();

        System.out.println("Ingrese la altura de la persona: ");
        double altura = scanner.nextDouble();

        // Crear los objetos
        Persona persona1 = new Persona(altura, edad, nombre, peso, sexo);
        Persona persona2 = new Persona(edad, nombre, sexo);
        Persona persona3 = new Persona();

        // usar los set para guardarle datos al ultimo objeto
        persona3.setNombre("Lautaro");
        persona3.setEdad(25);
        persona3.setAltura(1.80);
        persona3.setSexo('m');
        persona3.setPeso(75.3);

        //Agregar objetos a la collection
        personas.put(persona1.getDni(), persona1);
        personas.put(persona2.getDni(), persona2);
        personas.put(persona3.getDni(), persona3);

        persona3.setPeso(50);

        personas.put(persona3.getDni(), persona3);

        // Mostrar y verificar el IMC de cada persona
        for (Persona p : personas.values()) {

            int imc = p.calcularIMC();

            switch (imc) {
                case -1:
                    System.out.println(p.getNombre() + " está por debajo de su peso ideal.");
                    break;
                case 0:
                    System.out.println(p.getNombre() + " está en su peso ideal.");
                    break;
                case 1:
                    System.out.println(p.getNombre() + " tiene sobrepeso.");
                    break;
            }

        }

    }
}
