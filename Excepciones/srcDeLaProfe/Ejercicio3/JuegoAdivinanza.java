package Ejercicio3;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class JuegoAdivinanza {
    private final int numeroAdivinar;
    private int intentos;

    // Constructor
    public JuegoAdivinanza() {
        Random random = new Random();
        this.numeroAdivinar = random.nextInt(3) + 1; // La consigna dice Genera número entre 1 y 500
                                                       // puse del 1 al 3 para poder probarlo mejor
        this.intentos = 0;
    }

    // Método que inicia la lógica del juego
    public void iniciarJuego() {
        System.out.println("Bienvenido al juego 'Adivine el número!!' ");

        boolean adivinado = false;
        Scanner scanner = new Scanner(System.in);

            while (!adivinado) {
                try {
                    System.out.print("Introduzca un número entre 1 y 3: ");
                    intentos++; // lo sumo acá porque si se lanza la excepcion no va a pasar por esa linea
                    int numeroUsuario = scanner.nextInt(); // si es del tipo incorrecto arrojarà la excepciòn InputMismatchException
                    adivinado = verificarNumero(numeroUsuario);
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debes introducir un número válido.");
                    scanner.next(); // Limpiar la entrada incorrecta
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                    scanner.next(); // Limpiar la entrada incorrecta
                }
            }

            System.out.println("¡Has adivinado el número en " + intentos + " intentos!");
            scanner.close();
    }


    // Método que verifica si el número ingresado es correcto y da pistas

    private boolean verificarNumero(int numeroUsuario) {
        if (numeroUsuario == numeroAdivinar) {
            return true; // El número es correcto
        } else if (numeroUsuario > numeroAdivinar) {
            System.out.println("El número que buscas es menor.");
        } else {
            System.out.println("El número que buscas es mayor.");
        }
        return false;
    }
}
