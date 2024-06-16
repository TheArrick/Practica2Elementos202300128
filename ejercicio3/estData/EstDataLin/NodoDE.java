package EstDataLin;

public class NodoDE<T> {
    
    private T dato;
    private NodoDE<T> suc;
    private NodoDE<T> ant;

    public NodoDE(T dato) {
        ant = suc = null;
        this.dato = dato;
    }

    public NodoDE<T> getSuc() {
        return suc;
    }

    public NodoDE<T> getAnt() {
        return ant;
    }

    public T getDato() {
        return dato;
    }

    public void setAnt(NodoDE<T> ant) {
        this.ant = ant;
    }

    public void setSuc(NodoDE<T> suc) {
        this.suc = suc;
    }
}
