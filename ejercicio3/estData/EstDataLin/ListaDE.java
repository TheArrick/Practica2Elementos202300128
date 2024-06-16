package EstDataLin;

/**
 * Write a description of class ListaDE here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ListaDE<T> implements Lista<T> {
    private NodoDE<T> ini;
    private NodoDE<T> fin;

    public ListaDE() {
        ini = fin = null;
    }

    public boolean esVacia() {
        return ini == null;
    }

    public void insertar(T dato) {
        NodoDE<T> aux = new NodoDE<T>(dato);
        if (esVacia()) {
            ini = fin = aux;
        } else {
            fin.setSuc(aux);
            aux.setAnt(fin);
            fin = aux;
        }
    }

    public void insertar(T dato, int pos) {
        NodoDE<T> p = new NodoDE<T>(dato);
        NodoDE<T> aux;
        aux = ini;
        if (esVacia()) {
            ini = fin = p;
        } else {
            while (pos > 0) {
                aux = aux.getSuc();
                pos--;
            }
            aux.getAnt().setSuc(p);
            p.setAnt(aux.getAnt());
            p.setSuc(aux);
            aux.setAnt(p);
        }
    }

    public void eliminar(int pos) {
        NodoDE<T> aux;
        aux = ini;

        if (!esVacia()) {
            while (pos > 0) {
                aux = aux.getSuc();
                pos--;
            }
            NodoDE<T> an = aux.getAnt();
            NodoDE<T> su = aux.getSuc();
            an.setSuc(su);
            su.setAnt(an);
        }
    }

    public void eliminar(T dato) {
        NodoDE<T> aux = new NodoDE<T>(dato);
        if (!esVacia()) {
            while (!aux.getDato().equals(dato)) {
                aux = aux.getSuc();
            }
            NodoDE<T> an = aux.getAnt();
            NodoDE<T> su = aux.getSuc();
            an.setSuc(su);
            su.setAnt(an);
        }
    }

    public T acceder(int pos) {
        NodoDE<T> aux = ini;
        while (pos != 0) {
            aux = aux.getSuc();
            pos --;
        }

        return aux.getDato();
    }

    public T acceder(T dato) {
        NodoDE<T> aux = ini;
        while (!aux.getDato().equals(dato)) {
            aux = aux.getSuc();
        }
        return aux.getDato();
    }

    public Lista<T> invertir() {
        ListaDE<T> aux = new ListaDE<T>();
        return aux;

    }

    public int longitud() {
        int res = 0;;
        NodoDE<T> aux = ini;
        if (esVacia()) {
            res = 0;
        }
        while (aux.getSuc() != null) {
            aux = aux.getSuc();
            res++;
        }
        return res;
    }

    public boolean buscar(T dato) {
        boolean res = false;
        NodoDE<T> aux = ini;
        if (!esVacia()) {
            while (aux.getSuc() != null && !aux.getDato().equals(dato)) {
                aux = aux.getSuc();
            }
            if (aux.getDato().equals(dato)) {
                res = true;
            }
        }

        return res;
    }

    public void vaciar() {
        ini = null;
        fin = null;
    }

    public T antecesor(T dato) {
        T res;
        NodoDE<T> aux = ini;
        if (buscar(dato)) {
            while (!aux.getDato().equals(dato)) {
                aux = aux.getSuc();
            }
            res = aux.getAnt().getDato();
        } else {
            res = null;
        }
        return res;

    }

    public T sucesor(T dato) {
        T res;
        NodoDE<T> aux = ini;
        if (buscar(dato)) {
            while (!aux.getDato().equals(dato)) {
                aux = aux.getSuc();
            }
            res = aux.getSuc().getDato();
        } else {
            res = null;
        }
        return res;
    }

    public void reemplazar(int pos, T dato) {
        NodoDE<T> aux = ini;
        if (!esVacia()) {
            if (pos < longitud()) {
                while (pos !=0) {
                    aux = aux.getSuc();
                    pos--;
                }
            }
        }
    }

    public int indiceDe(T dato) {
        return 0;
    }
}
