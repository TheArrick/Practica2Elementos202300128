
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main {

    public ListaCSE<Integer> pruebaSwap() {
        ListaCSE<Integer> lista = new ListaCSE<>();

        lista.insertar(7);
        lista.insertar(3);
        lista.insertar(4);
        lista.insertar(5);
        lista.insertar(0);
        lista.insertar(2);
        lista.insertar(8);

        lista.swap(1, 6);
        return lista;
    }

    public String[] pruebaPrint() {
        ListaCSE<Integer> lista = new ListaCSE<>();

        lista.insertar(7);
        lista.insertar(3);
        lista.insertar(4);
        lista.insertar(5);
        lista.insertar(0);
        lista.insertar(2);
        lista.insertar(8);

        return lista.print();
    }

}
