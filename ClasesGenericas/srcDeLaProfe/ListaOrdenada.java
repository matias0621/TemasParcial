import java.util.*;


public class ListaOrdenada<E extends Comparable> {

    private List<E> lista;
    private boolean ordenAscendente; // true si es ascendente, false si no (sería descendente)

    // Sólo usamos LIST porque la consigna decia "hacer una LISTA ordenada",
    // y porque no sabemos si necesitamos permitir repetidos,
    // Pero si no, podriamos usar un TreeSet, que ya es una colección ordenada,
    // y no necesitaríamos ordenar por cada dato que se agrega
    // El TreeSet también usaria un tipo de dato E que extienda de Comparable,
    // para poder insertar los datos de forma ordenada:
    // private Set<E> lista;


    public ListaOrdenada(boolean ordenAscendente) {
        this.lista = new ArrayList<>();
        this.ordenAscendente= ordenAscendente;
    }


    public void Agregar(E elemento){
        lista.add(elemento);

        // los tengo que ordenar por cada dato que agrego
        // porque List no es una colección ordenada
        // Si se usaba un TreeSet no se necesita ordenar, pero la consigna
        // decia "LISTA ordenada", y si uso TreeSet no admite repetidos, y
        // capaz que aca los habia

        // PARA ORDENAR HAY VARIAS FORMAS:

        // A) LA MEJOR: USANDO SORT CON EL COMPARATOR REVERSE ORDER
        if(ordenAscendente) Collections.sort(lista);
        else Collections.sort(lista, Comparator.reverseOrder());

        // B) NO TANTO: USANDO SORT y REVERSE:
        // como SORT ordena en forma ascendente y aca se pidio ascendente o descendente,
        // lo que puedo hacer es luego evaluar el atributo ordenAscendente, y si es false,
        // llamo al método reverse que invierte los elementos:
//        Collections.sort(lista);
//        if(!ordenAscendente) Collections.reverse(lista);
    }


    public boolean Eliminar(E elemento){
        return lista.remove(elemento);
    }

    public E Eliminar(int indice){
        return lista.remove(indice);
    }

    public E buscarPorPosicion(int index){
        if (index >= 0 && index < lista.size()) {
            return lista.get(index);
        }
        throw new IndexOutOfBoundsException("Índice fuera de los límites");
    }

    public int buscarYretornarPosicion(E elemento){
        int i = 0;
        while(i<lista.size() && !lista.get(i).equals(elemento)){
            i++;
        }
        return i<lista.size()? i : -1;
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
