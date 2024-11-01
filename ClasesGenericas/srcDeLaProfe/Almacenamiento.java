import java.util.ArrayList;
import java.util.List;

public class Almacenamiento<E> {
    private List<E> lista;

    public Almacenamiento() {
        this.lista = new ArrayList<>();
    }

    public void Agregar(E elemento){
        lista.add(elemento);
    }

    public boolean Eliminar(E elemento){
        return lista.remove(elemento);
    }

    public boolean Buscar(E elemento){
        return lista.contains(elemento);
    }

    @Override
    public String toString() {
        StringBuilder msj = new StringBuilder();
        for (E elemento : lista) {
            msj.append(elemento).append(" \n");
        }
        return msj.toString();
    }


}
