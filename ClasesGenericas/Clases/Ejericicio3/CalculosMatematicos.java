package Clases.Ejericicio3;

public class CalculosMatematicos<T> {


    public Number suma(Number a, Number b) {
        Number resultado = a.doubleValue() + b.doubleValue();
        return resultado;
    }

    public Number resta(Number a, Number b) {
        Number resultado = a.doubleValue() - b.doubleValue();
        return resultado;
    }

    public Number dividir(Number a, Number b) {
        if (a.doubleValue() == 0 || b.doubleValue() == 0){
            throw new ArithmeticException();
        }
        else {
            Number resultado = a.doubleValue() / b.doubleValue();
            return resultado;
        }
    }

    public Number multiplicar(Number a, Number b) {
        Number resultado = a.doubleValue() * b.doubleValue();
        return resultado;
    }

}
