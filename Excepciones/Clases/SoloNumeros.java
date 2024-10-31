package Clases;

public class SoloNumeros extends Exception {
    public SoloNumeros(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Ocurrio un error horroroso" + super.getMessage();
    }
}
