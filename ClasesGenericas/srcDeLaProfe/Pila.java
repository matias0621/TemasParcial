import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pila<E> {
    private Stack<E> pilita;

    public Pila() {
        this.pilita = new Stack<>();
    }

    public void Agregar(E elemento){
        pilita.push(elemento);
    }

    public E Eliminar(){
        if (!pilita.isEmpty()) {
            return pilita.pop();
        }
        return null; // Manejar vacío
    }

    public boolean pilaVacia(){
        return pilita.isEmpty();
    }

    public int tamaño(){
        return pilita.size();
    }

    @Override
    public String toString() {
        return "Pila: Base " + pilita + " Tope";
    }

}
