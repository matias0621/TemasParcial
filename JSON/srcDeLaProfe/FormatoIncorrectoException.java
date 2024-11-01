public class FormatoIncorrectoException extends Exception{
    public FormatoIncorrectoException()
    {
        super("El JSON leido no cumple con el formato que se necesita.");
    }
}
