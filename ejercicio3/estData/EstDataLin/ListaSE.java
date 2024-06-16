package EstDataLin;

import java.util.ArrayList;

public class ListaSE<T> implements Lista<T> {
    private T ini;
    private ListaSE<T> sig;

    public ListaSE() {
        ini = null;
        sig = null;

    }

    public boolean esVacia() {
        return ini == null;
    }

    public void insertar(T dato) {
        if (esVacia()) {
            ini = dato;
            sig = new ListaSE<T>();
        } else {
            sig.insertar(dato);
        }
    }

    public void insertar(T dato, int pos) {
        if (esVacia()) {
            if (pos == 0) {
                ini = dato;
                sig = new ListaSE<T>();
            }
        } else {
            if (pos == 0) {
                sig.insertar(ini, 0);
                ini = dato;
            } else {
                sig.insertar(dato, pos - 1);
            }
        }
    }

    public void insertarListas(Lista<T> list) {
        if (!list.esVacia()) {
            T dato = list.acceder(0);
            list.eliminar(0);
            insertar(dato);
            sig.insertarListas(list);
        }
    }

    public void eliminar(int pos) {
        if (!esVacia()) {
            if (pos == 0) {
                ini = sig.ini;
                sig = sig.sig;
            } else {
                sig.eliminar(pos - 1);
            }
        }
    }

    public void eliminar(T dato) {
        if (!esVacia()) {
            if (ini == dato) {
                ini = sig.ini;
                sig = sig.sig;
            } else {
                sig.eliminar(dato);
            }
        }
    }

    public T acceder(int pos) {
        T res;
        if (esVacia()) {
            res = null;
        } else {
            if (pos == 0) {
                res = ini;
            } else {
                res = sig.acceder(pos - 1);
            }
        }
        return res;
    }

    public T acceder(T dato) {
        T res;
        if (esVacia()) {
            res = null;
        } else {
            if (ini.equals(dato)) {
                res = ini;
            } else {
                res = sig.acceder(dato);
            }
        }
        return res;
    }

    public Lista<T> invertir() {
        Lista<T> res;
        res = new ListaSE<>();
        if (!esVacia()) {
            res = sig.invertir();
            res.insertar(ini);
        }
        return res;
    }

    public int longitud() {
        int res;
        if (esVacia()) {
            res = 0;
        } else {
            res = 1 + sig.longitud();
        }
        return res;
    }

    public boolean buscar(T dato) {
        boolean res;
        if (esVacia()) {
            res = false;
        } else {
            if (ini.equals(dato)) {
                res = true;
            } else {
                res = sig.buscar(dato);
            }
        }
        return res;
    }

    public void vaciar() {
        ini = null;
        sig = null;
    }

    public T antecesor(T dato) {
        T res;
        if (esVacia()) {
            res = null;
        } else {
            if (sig.esVacia()) {
                res = null;
            } else {
                if (sig.ini.equals(dato)) {
                    res = ini;
                } else {
                    res = sig.antecesor(dato);
                }
            }
        }
        return res;
    }

    public T sucesor(T dato) {
        T res;
        if (esVacia()) {
            res = null;
        } else {
            if (ini.equals(dato)) {
                res = sig.ini;
            } else {
                res = sig.sucesor(dato);
            }
        }
        return res;
    }

    public void reemplazar(int pos, T dato) {
        if (!esVacia()) {
            if (pos == 0) {
                ini = dato;
            } else {
                sig.reemplazar(pos - 1, dato);
            }
        }
    }

    public int indiceDe(T dato) {
        int pos;
        if (esVacia()) {
            pos = -1;
        } else {
            if (ini.equals(dato)) {
                pos = 0;
            } else {
                pos = sig.indiceDe(dato);
                if (pos != -1) {
                    pos++;
                }
            }
        }
        return pos;
    }

    public ListaSE<T> delRepes() {
        ListaSE<T> list = new ListaSE<>();
        return delRepes(list);
    }

    private ListaSE<T> delRepes(ListaSE<T> list) {
        T dato = ini;
        this.eliminar(ini);
        list.insertar(dato);
        if (!esVacia()) {
            if (this.acceder(dato) == null) {
                this.delRepes(list);
            } else {
                this.eliminar(dato);
                this.delRepes(list);
            }
        }

        return list;
    }

    public String toString() {
        String res;
        if (esVacia()) {
            res = "";
        } else {
            res = ini + "," + sig.toString();
        }
        return res;
    }

    public void sumar(ListaSE<Integer> izq, ListaSE<T> izqD, ListaSE<Integer> med, ListaSE<T> medD,
            ListaSE<Integer> der,
            ListaSE<T> derD) {
        if (izq.esVacia()) {
            int dato = med.acceder(0);
            if (der.acceder(dato) == null) {
                med.insertarListas(der);
                medD.insertarListas(derD);
            } else {
                med = der;
                medD = derD;
            }
        } else {
            int dato = med.acceder(0);
            if (der.acceder(dato) == null) {
                med.insertarListas(der);
                medD.insertarListas(derD);
            } else {
                med = der;
                medD = derD;
            }

            if (izq.acceder(dato) == null) {
                izq.insertarListas(med);
                izqD.insertarListas(medD);
            } else {
                med = izq;
                medD = izqD;
            }

        }
    }
}
