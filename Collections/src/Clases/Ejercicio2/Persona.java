package Clases.Ejercicio2;

import java.util.Random;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private char sexo;
    private double peso;
    private double altura;

    public Persona(){
        this.nombre = "";
        this.edad = 0;
        this.dni = "";
        this.sexo = 'H';
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(char sexo, int edad, String nombre) {
        this.sexo = sexo;
        this.edad = edad;
        this.nombre = nombre;
        this.peso = 0;
        this.altura = 0;
        this.dni = "";
    }

    public Persona(String nombre, int edad, String dni, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc = getPeso() / (getAltura() * getAltura());
        int pesoIdeal = 0;

        if (imc < 20){
            pesoIdeal = -1;
        } else if (imc >= 20 && imc < 25) {
            pesoIdeal =0;
        } else if (imc >= 25) {
            pesoIdeal = 1;
        }
        return 1;
    }

    public boolean esMayorDeEdad(){
        if (getEdad() >= 18){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean compararSexo(char sexo){
        if (sexo == getSexo()){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", sexo=" + sexo +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }

    public String generarDNI(){
        Random random = new Random();
        int numeroAleatorio = 10000000 + random.nextInt(90000000);
        StringBuilder dni = new StringBuilder(numeroAleatorio);
        for (int i = 0; i < dni.length(); i++){
            int num = dni.charAt(i);

            dni.setCharAt(i, (char) num);
        }
        String dniCasteado = dni.toString();
        return dniCasteado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
