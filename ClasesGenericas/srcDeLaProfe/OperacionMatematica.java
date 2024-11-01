public class OperacionMatematica {

    public static  <N1 extends Number,N2 extends Number> double sumar(N1 a,N2 b){
        return a.doubleValue() + b.doubleValue();
    }

    public static  <N1 extends Number,N2 extends Number> double restar(N1 a,N2 b){
        return a.doubleValue() - b.doubleValue();
    }

    public static  <N1 extends Number,N2 extends Number> double multiplicar(N1 a,N2 b){
        return a.doubleValue() * b.doubleValue();
    }

    public static  <N1 extends Number,N2 extends Number> double dividir(N1 a,N2 b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return a.doubleValue() / b.doubleValue();
    }

}
