package Clases;

import java.util.Random;
import java.util.Scanner;

public class JuegoDeAdivinanza {

    public void Adivinar() throws SoloNumeros {
        Random numero = new Random();
        int numero1 = numero.nextInt(500); // Número a adivinar
        int control = 1;
        Scanner sc = new Scanner(System.in);
        int numeroAdivinado = 0;

        System.out.println("Intenta adivinar el numero");

        while (control == 1) {
            try {
                // Captura la entrada del usuario como String
                String entrada = sc.nextLine();

                // Valida que solo se hayan introducido números
                validarNumero(entrada);

                // Convierte la entrada a entero si pasa la validación
                numeroAdivinado = Integer.parseInt(entrada);

            } catch (SoloNumeros s) {
                System.out.println(s.getMessage()); // Muestra el mensaje de la excepción
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingresa solo números.");
            }
            finally {
                if (numeroAdivinado == numero1) {
                    System.out.println("Felicidades, adivinaste el número");
                    control = 0; // Sal del ciclo al acertar
                } else if (numeroAdivinado > numero1) {
                    System.out.println("Es menor");
                } else if (numeroAdivinado < numero1) {
                    System.out.println("Es mayor");
                }
            }
        }
    }

    // Método para validar si la entrada contiene solo números
    public void validarNumero(String entrada) throws SoloNumeros {
        if (!entrada.matches("\\d+")) { // Verifica si la entrada no es solo números
            throw new SoloNumeros(" Solo se permiten números."); // Lanza la excepción
        }
    }
}
