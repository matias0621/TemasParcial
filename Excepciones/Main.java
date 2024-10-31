import Clases.Colegio;
import Clases.ExisteAlumno;
import Clases.JuegoDeAdivinanza;
import Clases.SoloNumeros;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int ejercicio = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero de ejercicio: ");
        ejercicio = sc.nextInt();
        sc.nextLine();

        switch (ejercicio) {
            case 1:
                JuegoDeAdivinanza j1 = new JuegoDeAdivinanza();
                try {
                    j1.Adivinar(); // Aquí llamas al método que lanza la excepción
                } catch (SoloNumeros e) {
                    System.out.println("Error: " + e.getMessage()); // Maneja la excepción
                }
                break;
            case 2:
                Colegio colegio = new Colegio();
                try {
                    colegio.borrarAlumno(1);
                }
                catch (ExisteAlumno e){
                    System.out.println("Error: " + e.getMessage());
                }
                finally {
                    System.out.println("Se termino loco");
                }
            default:
                System.out.println("Ingrese un ejercicio valido pendejo");
                break;
        }
    }
}