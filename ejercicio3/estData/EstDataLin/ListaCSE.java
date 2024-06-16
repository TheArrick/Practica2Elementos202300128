package EstDataLin;

/**
 * Write a description of class ListaCSE here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ListaCSE<T> {
    private NodoSE<T> ini;

    public ListaCSE() {
        ini = new NodoSE<T>(null);
        ini.setSuc(ini);
    }

    public boolean esVacia() {
        return ini.getDato() == null;
    }

    public void insertar(T dato) {
        NodoSE<T> aux = ini;
        NodoSE<T> p = new NodoSE<T>(dato);
        if (esVacia()) {
            ini.setDato(dato);
        } else {
            while (aux.getSuc() != ini) {
                aux = aux.getSuc();
            }
            aux.setSuc(p);
            p.setSuc(ini);

        }
    }

    public void insertar(T dato, int pos) {
        NodoSE<T> aux = ini;
        NodoSE<T> p = new NodoSE<T>(dato);
        if (!esVacia()) {
            while (pos > 0) {
                aux = aux.getSuc();
                pos--;
            }
            p.setSuc(aux.getSuc());
            aux.setSuc(p);

        }
    }

    public void eliminar(int pos) {
        NodoSE<T> aux = ini;
        if (!esVacia()) {
            while (pos > 0) {
                aux = aux.getSuc();
                pos--;
            }
            aux.setSuc(aux.getSuc().getSuc());
        }
    }

    public void setIni(int pos) {
        ini = accederNodo(pos);
    }

    public void eliminar(T dato) {
        NodoSE<T> aux = ini;
        if (!esVacia()) {
            while (!aux.getSuc().getDato().equals(dato)) {
                aux = aux.getSuc();
            }
            aux.setSuc(aux.getSuc().getSuc());
        }
    }

    public T acceder(int pos) {
        T res;
        NodoSE<T> aux = ini;
        if (esVacia()) {
            res = null;
        } else {
            while (pos != 0) {
                aux = aux.getSuc();
                pos--;
            }
            res = aux.getDato();
        }

        return res;
    }

    public boolean buscar(T dato) {
        boolean res = true;

        return res;
    }

    public void swap(int i, int j) {
        T datoJ = this.acceder(j);
        T datoI = this.acceder(i);
        if (!esVacia()) {
            reemplazar(i, datoJ);
            reemplazar(j, datoI);
        }
    }

    public void reemplazar(int pos, T dato) {
        NodoSE<T> aux = ini;
        if (!esVacia()) {
            while (pos != 0) {
                aux = aux.getSuc();
                pos--;
            }
            aux.setDato(dato);
        }
    }

    public NodoSE<T> accederNodo(int pos) {
        NodoSE<T> aux = ini;
        if (esVacia()) {
            aux = null;
        } else {
            while (pos != 0) {
                aux = aux.getSuc();
                pos--;
            }

        }

        return aux;
    }

}
