package EstDataLin;

/**
 * Write a description of class Cola here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cola<T> {
    NodoDE<T> ini;
    NodoDE<T> fin;

    public Cola() {
        ini = null;
        fin = null;
    }

    public boolean esVacia() {
        return ini == null;
    }

    public void encolar(T dato) {
        NodoDE<T> p = new NodoDE<T>(dato);
        if (esVacia()) {
            ini = fin = p;
        } else {
            fin.setSuc(p);
            p.setAnt(fin);
            fin = fin.getSuc();
        }
    }

    public T verFrente() {
        return ini.getDato();
    }


    public void decolar() {
        NodoDE<T> sig = ini.getSuc();
        if (!esVacia()) {
            if (sig == null) {
                ini = fin = null;
            } else {
                ini = sig;
                sig.setAnt(null);
                sig.setSuc(sig.getSuc());
            }
        }
    }
 

}
