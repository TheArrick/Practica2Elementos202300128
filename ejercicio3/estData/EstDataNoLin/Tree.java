package EstDataNoLin;

import java.util.ArrayList;
import EstDataLin.*;

/**
 * Write a description of class Tree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tree<T> {

    public T data;
    public ArrayList<Tree<T>> childs;

    public Tree() {
        childs = new ArrayList<Tree<T>>();
        data = null;
    }

    private Tree(T dato) {
        data = dato;
        childs = new ArrayList<>();
    }

    public boolean esVacio() {
        return data == null;
    }

    public void insertar(ListaSE<Integer> ruta, T data) {
        if (esVacio()) {
            this.data = data;
            this.childs = new ArrayList<>();
        } else {
            if (ruta.esVacia()) {
                Tree<T> tree = new Tree<>(data);
                childs.add(tree);
            } else {
                int rut = ruta.acceder(0);
                ruta.eliminar(0);
                if (childs.size() > rut) {
                    childs.get(rut).insertar(ruta, data);
                } else {
                    Tree<T> tree2 = new Tree<>(data);
                    childs.add(tree2);
                }
            }
        }
    }

    
    public void mirarArriba(){
        ListaSE<ListaSE<T>> resp = recogerNivel(); 

        
        for (int i = 0; i < resp.longitud(); i++) {
            System.out.println(resp.acceder(i).toString());
        }
    }
    
    public ListaSE<ListaSE<T>> recogerNivel() {
        ListaSE<ListaSE<T>> lista = new ListaSE<>();
        if (!esVacio()) {
            Cola<Tree<T>> cola = new Cola<>();
            cola.encolar(this);
            recogerNivel(lista, cola, new Cola<Tree<T>>(), new ListaSE<T>(), 0);
        }
        return lista;
    }

    private void recogerNivel(Lista<ListaSE<T>> lista, Cola<Tree<T>> cola, Cola<Tree<T>> espera, ListaSE<T> datos,
            int pos) {
        if (!cola.esVacia()) {
            Tree<T> arb = cola.verFrente();
            if (!arb.esVacio()) {
                cola.decolar();
                datos.insertar(arb.data);
                for (int i = 0; i < arb.childs.size(); i++) {

                    espera.encolar(arb.childs.get(i));
                }

                if (cola.esVacia()) {
                    lista.insertar(datos, pos);
                    cola = espera;
                    espera = new Cola<Tree<T>>();
                    datos = new ListaSE<T>();
                    pos++;
                }
            } else {
                cola.decolar();
            }

            recogerNivel(lista, cola, espera, datos, pos);
        } else {
            lista.insertar(datos, pos);
        }

    }
}
