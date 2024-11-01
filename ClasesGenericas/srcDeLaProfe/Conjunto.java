import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Conjunto <E> {
    private Set<E> set;

    public Conjunto() {
        this.set = new HashSet<>();
    }

    public boolean Agregar(E elemento){
        return set.add(elemento);
    }

    public boolean Eliminar(E elemento){
        return set.remove(elemento);
    }

    public boolean buscar(E elemento){
       return set.contains(elemento);
    }

    @Override
    public String toString() {
        StringBuilder msj = new StringBuilder();

        for (E elemento : set) {
            msj.append(elemento).append(" \n");
        }
        return msj.toString();
    }
}
